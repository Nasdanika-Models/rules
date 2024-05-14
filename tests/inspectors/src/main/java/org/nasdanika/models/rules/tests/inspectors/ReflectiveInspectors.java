package org.nasdanika.models.rules.tests.inspectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.nasdanika.models.java.Method;
import org.nasdanika.models.java.Type;
import org.nasdanika.models.rules.CreateTextResourceAction;
import org.nasdanika.models.rules.Failure;
import org.nasdanika.models.rules.RulesFactory;
import org.nasdanika.models.rules.Violation;
import org.nasdanika.models.rules.reflection.Inspector;
import org.nasdanika.models.rules.reflection.RuleSet;
import org.nasdanika.ncore.util.YamlResource;

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
 * Testing implicit rule set first
 */

@RuleSet("""		
		name: Sample Java Rules
		severities:
		  error:
		    name: Error
		    description: Artifacts with this severity are not allowed to be further processed (e.g. deployed, published to a repository) 
		documentation:
		  exec.content.Markdown:
		    source:
		      exec.content.Text: |
		        TODO:
		        
		        * specRef attribute to RuleSet and Rule - support of loading from classloader resources 
		        * Generation of HTML documentation
		""")
public class ReflectiveInspectors {
	
	/**
	 * Inspector with single parameter returning string.
	 * The string is to be wrapped into a violation and associated with the inline rule. 
	 * @param type
	 * @return
	 */
	@Inspector("""
			name: Undocumented type
			documentation:
			  exec.content.Markdown:
			    source:
			      exec.content.Text: |
			        Types should be documented.
			        TODO:
			        
			          * Exclude private types (optionally) and anonymous
			          * Fully qualified name
			          * Marked/Markers 
			""")
	public String undocumentedTypeInspector(Type type) {
		if (type.getComment() == null) {
			return "Undocumented type: " + type.getName();
		}
		return null;
	}
	
	@Inspector(value = """
			name: Untested metod
			documentation:
			  exec.content.Markdown:
			    source:
			      exec.content.Text: |
			        This method is not referenced from test cases
			        
			        This inspector is a demo implementation of a code generating inspector - an automated developer assistant
			        It generates a JUnit test case based on the method body using OpenAI
			          
			        TODO:
			        
			          * Exclude private types (optionally) and anonymous
			          * Fully qualified name
			          * Marked/Markers 
			          * Appending test case to a test class instead of overwriting like in this demo - aggregation of violations. 
			          * Merging using JMerge - adding @generated tag to generated methods and then adding NOT (dirtying) upon manual changes			          
			""",
			condition = "name == 'buildTheory'") // For demo purposes generating a test case only for the buildTheory() method	
	public Violation untestedMethodInspector(Method method) {
        String deploymentOrModelId = "gpt-3.5-turbo";

    	String key = System.getenv("OPENAI_API_KEY");
    	OpenAIClient client = new OpenAIClientBuilder()
    		    .credential(new KeyCredential(key))
    		    .endpoint("https://api.openai.com/v1/chat/completions")
    		    .buildClient();

        List<ChatRequestMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatRequestSystemMessage("Generate a JUnit test method for the following code"));
        chatMessages.add(new ChatRequestUserMessage(method.getSource()));
        
		Violation violation = RulesFactory.eINSTANCE.createViolation();
		violation.setName("Method " + method.getName() + " is not referenced from test cases, generating a test case");

        ChatCompletions chatCompletions = client.getChatCompletions(deploymentOrModelId, new ChatCompletionsOptions(chatMessages));
        for (ChatChoice choice : chatCompletions.getChoices()) {
            ChatResponseMessage message = choice.getMessage();
            String generatedTestCase = message.getContent();
            
            StringBuilder testCaseBuilder = new StringBuilder("import org.junit.jupiter.api.Test;");
            
            String testClassName = "Test" + ((Type) method.eContainer()).getName();
			testCaseBuilder
            	.append(System.lineSeparator())
            	.append(System.lineSeparator())
            	.append("public class " + testClassName + " { ")
            	.append(System.lineSeparator())
            	.append(System.lineSeparator());
            
            testCaseBuilder.append(generatedTestCase);
            
            testCaseBuilder
            	.append(System.lineSeparator())
            	.append(System.lineSeparator())
            	.append("}")
            	.append(System.lineSeparator());
            
            CreateTextResourceAction createTestCaseAction = RulesFactory.eINSTANCE.createCreateTextResourceAction();
            createTestCaseAction.setContent(testCaseBuilder.toString());
            createTestCaseAction.setResourceIdentifier("src/test/java/com/cronopista/ai/builders/tests/" + testClassName + ".java"); // Hardcoding for a demo
            violation.getActions().add(createTestCaseAction);
        }
		
		return violation;
	}
	
	@Inspector(value = """
			name: Invalid YAML
			documentation:
			  exec.content.Markdown:
			    source:
			      exec.content.Text: |
			        YAML with syntax errors, e.g. duplicate keys.
			""",
			severity = "error",
			condition = "!errors.isEmpty()") 	
	public Collection<String> yamlInspector(YamlResource yamlResource) {
		return yamlResource.getErrors().stream().map(Diagnostic::getMessage).toList();
	}
	
	@Inspector("""
			name: Faulty inspector
			documentation:
			  exec.content.Markdown:
			    source:
			      exec.content.Text: |
			        Throws an exception to test wrapping into a failure.
			""") 	
	public void faultyInspector(YamlResource yamlResource) {
		throw new IllegalArgumentException("Something is wrong about " + yamlResource.getURI());
	}
	
	@Inspector("""
			name: Explicitly faulty inspector 
			documentation:
			  exec.content.Markdown:
			    source:
			      exec.content.Text: |
			        Explicitly returns failure because, say, some conditions for inspection are not met - some API is down, configuration cannot be read, ...
			""") 	
	public Failure explicitlyFaultyInspector(YamlResource yamlResource) {
		Failure ret = RulesFactory.eINSTANCE.createFailure();
		ret.setName("Unable to inspect");
		ret.setDescription("Unable to retrieve reference data from XYZ API");
		return ret;
	}
	
	@Inspector(value = """
			#name: Unexpected result inspector 
			documentation:
			  exec.content.Markdown:
			    source:
			      exec.content.Text: |
			        Returns a result of unexpected type (Long). Tests wrapping of unexpected results into failures.
			""",
			severity = "warning") 	
	public long unexpectedResultInspector(YamlResource yamlResource) {
		return System.currentTimeMillis();
	}
	
}
