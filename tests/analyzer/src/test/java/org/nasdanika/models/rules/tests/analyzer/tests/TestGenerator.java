package org.nasdanika.models.rules.tests.analyzer.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.jupiter.api.Test;
import org.nasdanika.common.Util;
import org.nasdanika.models.coverage.Counter;
import org.nasdanika.models.coverage.Coverage;
import org.nasdanika.models.coverage.ModuleCoverage;
import org.nasdanika.models.java.Annotation;
import org.nasdanika.models.java.CompilationUnit;
import org.nasdanika.models.java.Interface;
import org.nasdanika.models.java.JavaFactory;
import org.nasdanika.models.java.Member;
import org.nasdanika.models.java.Method;
import org.nasdanika.models.java.Source;
import org.nasdanika.models.java.Type;
import org.nasdanika.models.java.util.JavaParserResourceFactory;
import org.nasdanika.models.java.util.ModuleCoverageProvider;
import org.nasdanika.ncore.Tree;
import org.nasdanika.ncore.TreeItem;
import org.nasdanika.ncore.util.DirectoryContentFileURIHandler;

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
 * Generates unit tests for methods with low coverage
 */
public class TestGenerator {

	@Test
	public void testGenerateJUnitTestsForMethodsWithLowCoverage() throws IOException {
		// Maven module directory with sources, compiled classes, and jacoco.exec file.
		File projectDir = new File("../../../../git/spring-petclinic-test-generation").getCanonicalFile();

		ResourceSet resourceSet = new ResourceSetImpl();
		
		// Loading coverage data
		ModuleCoverage moduleCoverage = ModuleCoverage.loadJacoco(
				"spring-petclinic", 
				new File(projectDir, "target/jacoco.exec"),
				new File(projectDir, "target/classes"));
		
		Map<String, Object> extensionFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();

		// Registering Java factory for loading java sources
		extensionFactoryMap.put(CompilationUnit.JAVA_EXTENSION, new JavaParserResourceFactory(new ModuleCoverageProvider(moduleCoverage)));
		
		// Registering XMI factory & URI handler for loading directory contents
		extensionFactoryMap.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		resourceSet.getURIConverter().getURIHandlers().add(0, new DirectoryContentFileURIHandler());
		
		File outputDir = new File(projectDir, "generated-tests"); // Variation point
		
    	// Loading API key from an environment variable 
    	OpenAIClient openAIClient = new OpenAIClientBuilder()
    		    .credential(new KeyCredential(System.getenv("OPENAI_API_KEY")))
    		    .endpoint("https://api.openai.com/v1/chat/completions")
    		    .buildClient();
    	
    	URI sourceDirURI = URI.createFileURI(new File(projectDir, "src/main/java").getCanonicalPath());
    	Resource sourceDirResource = resourceSet.getResource(sourceDirURI, true);
    	for (EObject root: sourceDirResource.getContents()) {
    		 visit(root, outputDir, openAIClient);
    	}
	
	}
	
	/**
	 * @param eObj
	 * @param outputDir
	 * @param openAIClient
	 * @throws IOException 
	 */
	private void visit(
			EObject eObj, 
			File outputDir, 
			OpenAIClient openAIClient) throws IOException {
		
		if (eObj instanceof Tree) {
			for (TreeItem treeItem: ((Tree) eObj).getTreeItems()) {
				URI itemURI = URI.createURI(treeItem.getName()).resolve(eObj.eResource().getURI().appendSegment(""));
				Resource itemResource = eObj.eResource().getResourceSet().getResource(itemURI, true);
		    	for (EObject root: itemResource.getContents()) {
		    		 visit(root, outputDir, openAIClient);
		    	}
			}
		} else if (eObj instanceof CompilationUnit) {
			CompilationUnit compilationUnit = (CompilationUnit) eObj;
			System.out.println(compilationUnit.getName());
			String sourcePackageName = compilationUnit.getPackageName();
			for (Type type: compilationUnit.getTypes()) {
				if ((type instanceof org.nasdanika.models.java.Class || type instanceof Interface)) {					
					System.out.println("\t" + type.getName());
					
					org.nasdanika.models.java.Class testClass = JavaFactory.eINSTANCE.createClass();
					testClass.setName(type.getName() + "Tests"); // Variation point
					
					CompilationUnit testCompilationUnit = JavaFactory.eINSTANCE.createCompilationUnit();
					testCompilationUnit.setPackageName(sourcePackageName + ".tests"); // Variation point
					testCompilationUnit.setName(testClass.getName() + "." + CompilationUnit.JAVA_EXTENSION);
					testCompilationUnit.getTypes().add(testClass);
					
					for (Member member: type.getMembers()) {
						// Just methods here, add constructors, static/instance/field initializers as needed  
						if (member instanceof Method && member.getModifiers().contains(type instanceof Interface ? "default" : "public")) {
							Method method = (Method) member;
							int covered = 0;
							int missed = 0;							
							for (Coverage coverage: method.getCoverage()) {
								// Using line coverage as more human-intuitive, change to other counter type as needed
								Counter lineCounter = coverage.getLineCounter();
								covered += lineCounter.getCovered();
								missed += lineCounter.getMissed();
							}
							
							System.out.printf("\t\t%s - %d / %d%n", method.getName(), covered, missed);
							int total = missed + covered;
							// Variation points: Minimum method length and minimum coverage.
							// For this demo - methods longer than 5  lines with less than 50% coverage
							if (total > 5 && covered * 2 < total) {  
								testClass.getMembers().add(generateTestMethod(method, openAIClient));
							}
						}
					}
					
					// Saving non-empty compilation units to file resources.
					if (!testClass.getMembers().isEmpty()) {
						File testCompilationUnitFile = new File(outputDir, testCompilationUnit.getPackageName().replace('.', '/') + "/" + testCompilationUnit.getName());
						testCompilationUnitFile.getParentFile().mkdirs();
						Resource testCompilationUnitResource = eObj.eResource().getResourceSet().createResource(URI.createFileURI(testCompilationUnitFile.getAbsolutePath()));
						testCompilationUnitResource.getContents().add(testCompilationUnit);
						testCompilationUnitResource.save(null);
					}
				}
			}
		}
		
	}

	/**
	 * Generates a test method for a given method
	 * @param method
	 * @param openAIClient
	 * @return
	 */
	private Member generateTestMethod(Method method, OpenAIClient openAIClient) {
		Method testMethod = JavaFactory.eINSTANCE.createMethod();
		testMethod.setName("test" + StringUtils.capitalize(method.getName())); // Variation point
		testMethod.getModifiers().add("public");
		
		Annotation testAnnotation = Annotation.create("${import/org.junit.jupiter.api.Test}");
		testMethod.getAnnotations().add(testAnnotation);
		
		// May generate methods as disabled
//		Annotation disabledAnnotation = Annotation.create("${import/org.junit.jupiter.api.Disabled}", "TODO: Review/adjust generated code");
//		testMethod.getAnnotations().add(disabledAnnotation);
				
		StringBuilder bodyBuilder = new StringBuilder("{").append(System.lineSeparator());
		String indent = testMethod.getIndent();
		bodyBuilder
			.append(indent)
			.append(indent)
			.append("// *** Start generated test ***")
			.append(System.lineSeparator());
		
		// Calling OpenAI to generate test code
        List<ChatRequestMessage> chatMessages = new ArrayList<>();
        // Prompt is a variation point. Can use context obtained from method container, resource, and resource set
        chatMessages.add(new ChatRequestSystemMessage("Generate a JUnit 5 test method leveraging Mockito for the following SpringBoot Java method: ")); 
        chatMessages.add(new ChatRequestUserMessage(method.getSource()));
        
        // Model name is a variation point
        ChatCompletions chatCompletions = openAIClient.getChatCompletions("gpt-4", new ChatCompletionsOptions(chatMessages));
        for (ChatChoice choice : chatCompletions.getChoices()) {
            ChatResponseMessage message = choice.getMessage();
            String generatedTestCase = message.getContent();
            if (!Util.isBlank(generatedTestCase)) {
            	// The output might be "massaged" - stripped of backticks, parsed, imports added to the compilation unit
            	
            	String[] lines = generatedTestCase.split("\\R");					            	
            	for (String line: lines) {
		            bodyBuilder
		            	.append(indent)
		            	.append(indent)
		            	.append("// ") // Commenting generated code - it might not compile
		            	.append(line)
		            	.append(System.lineSeparator());
            	}
            }
        }

		bodyBuilder
			.append(indent)
			.append(indent)
			.append("// *** End generated test ***")
			.append(System.lineSeparator())
			.append(indent)
			.append("}")
			.append(System.lineSeparator());

		Source methodBody = JavaFactory.eINSTANCE.createSource();
		methodBody.setSource(bodyBuilder.toString());
		testMethod.setBody(methodBody);
		
		return testMethod;
	}

}
