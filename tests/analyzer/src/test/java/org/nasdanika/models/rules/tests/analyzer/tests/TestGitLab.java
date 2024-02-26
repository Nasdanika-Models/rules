package org.nasdanika.models.rules.tests.analyzer.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gitlab4j.api.CommitsApi;
import org.gitlab4j.api.Constants.Encoding;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.MergeRequestApi;
import org.gitlab4j.api.models.CommitAction;
import org.gitlab4j.api.models.CommitAction.Action;
import org.gitlab4j.api.models.MergeRequestParams;
import org.junit.jupiter.api.Test;
import org.nasdanika.models.gitlab.util.GitLabApiProvider;
import org.nasdanika.models.gitlab.util.GitLabURIHandler;
import org.nasdanika.models.java.CompilationUnit;
import org.nasdanika.models.java.Member;
import org.nasdanika.models.java.Method;
import org.nasdanika.models.java.Type;
import org.nasdanika.models.java.util.JavaParserResourceFactory;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.OpenAIClientBuilder;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatRequestMessage;
import com.azure.ai.openai.models.ChatRequestSystemMessage;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.azure.ai.openai.models.ChatResponseMessage;
import com.azure.core.credential.KeyCredential;


/**
 * An end-to-end test of inspecting code on GitLab, generating a test case and creating a merge requests 
 */
public class TestGitLab {
	
	private static final String MAIN_BRANCH = "main";
	private static final String PROJECT = "54851996"; // "nasdanika-demo/inference-engine";
	private static final String THEORY_BUILDER_PATH = "src/main/java/com/cronopista/ai/builders/TheoryBuilder.java";
	private static final String TESTS_PATH = "src/test/java/com/cronopista/ai/builders/tests/";
	
	@Test
	public void testTheoryBuilder() throws GitLabApiException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("java", new JavaParserResourceFactory());		
		
		String accessToken = System.getenv("GITLAB_COMMITTER_TOKEN");
		try (GitLabApiProvider gitLabApiProvider = new GitLabApiProvider("https://gitlab.com/", accessToken)) {		
			GitLabURIHandler gitLabURIHandler = new GitLabURIHandler(gitLabApiProvider.getGitLabApi());				
			resourceSet.getURIConverter().getURIHandlers().add(0, gitLabURIHandler);

			// Loading Java resource
			URI mainBranchURI = URI.createURI(GitLabURIHandler.GITLAB_URI_SCHEME + "://" + PROJECT + "/main/");
			
			URI resourceURI = URI.createURI(THEORY_BUILDER_PATH).resolve(mainBranchURI);
			Resource resource = resourceSet.getResource(resourceURI, true);
			CompilationUnit cu = (CompilationUnit) resource.getContents().get(0);
			for (Type type: cu.getTypes()) {
				for (Member member: type.getMembers()) {
					if (member instanceof Method) {
						Method method = (Method) member;
						if ("buildTheory".equals(method.getName())) {
							// Generating test case
							
					        String deploymentOrModelId = "gpt-3.5-turbo";
					    	String key = System.getenv("OPENAI_API_KEY");
					    	OpenAIClient client = new OpenAIClientBuilder()
					    		    .credential(new KeyCredential(key))
					    		    .endpoint("https://api.openai.com/v1/chat/completions")
					    		    .buildClient();
	
					        List<ChatRequestMessage> chatMessages = new ArrayList<>();
					        chatMessages.add(new ChatRequestSystemMessage("Generate a JUnit test method for the following code"));
					        chatMessages.add(new ChatRequestUserMessage(method.getSource()));
					        
					        ChatCompletions chatCompletions = client.getChatCompletions(deploymentOrModelId, new ChatCompletionsOptions(chatMessages));
					        for (ChatChoice choice : chatCompletions.getChoices()) {
					            ChatResponseMessage message = choice.getMessage();
					            String generatedTestCase = message.getContent();
					            
					            StringBuilder testCaseBuilder = new StringBuilder("import org.junit.jupiter.api.Test;");
					            
					            testCaseBuilder
					            	.append(System.lineSeparator())
					            	.append(System.lineSeparator())
					            	.append("public class Test" + ((Type) method.eContainer()).getName() + " { ")
					            	.append(System.lineSeparator())
					            	.append(System.lineSeparator());
					            
					            testCaseBuilder.append(generatedTestCase);
					            
					            testCaseBuilder
					            	.append(System.lineSeparator())
					            	.append(System.lineSeparator())
					            	.append("}")
					            	.append(System.lineSeparator());
					            
								// Committing changes
								CommitsApi commitApi = gitLabApiProvider.getGitLabApi().getCommitsApi();
								CommitAction commitAction = new CommitAction()
										.withAction(Action.CREATE)
										.withContent(testCaseBuilder.toString())
										.withEncoding(Encoding.TEXT)
										.withFilePath(TESTS_PATH + "TheoryBuilderTests.java");
								
								String branchName = "theory-builder-test-3";
								commitApi.createCommit(
										PROJECT,
										branchName, 
										"Generated test case for TheoryBuilder", 
										MAIN_BRANCH,
							            "Pavel.Vlasov@nasdanika.org", 
							            "Pavel Vlasov", 
							            commitAction);					
								
								// Creating a merge request
								MergeRequestApi mergeRequestApi = gitLabApiProvider.getGitLabApi().getMergeRequestApi();
								MergeRequestParams params = new MergeRequestParams()
									    .withSourceBranch(branchName)
									    .withTargetBranch(MAIN_BRANCH)
									    .withTitle("Generated code")
									    .withDescription("Code automatically generated...");
								mergeRequestApi.createMergeRequest(PROJECT, params);
					        }
						}
					}
				}
			}
		}		
		
	}

}
