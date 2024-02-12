package org.nasdanika.models.rules.tests.inspectors;

import java.util.ArrayList;
import java.util.List;

import org.nasdanika.models.java.Method;
import org.nasdanika.models.java.Type;
import org.nasdanika.models.rules.RulesFactory;
import org.nasdanika.models.rules.Violation;
import org.nasdanika.models.rules.reflection.Inspector;
import org.nasdanika.models.rules.reflection.RuleSet;

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
	
	@Inspector("""
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
			""")
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
//		violation.getDocumentation()

        ChatCompletions chatCompletions = client.getChatCompletions(deploymentOrModelId, new ChatCompletionsOptions(chatMessages));
        for (ChatChoice choice : chatCompletions.getChoices()) {
            ChatResponseMessage message = choice.getMessage();
            String generatedTestCase = message.getContent();
            
            StringBuilder testCaseBuilder = new StringBuilder();
            
            testCaseBuilder
            	.append("public class Test" + ((Type) method.eContainer()).getName() + " { ")
            	.append(System.lineSeparator())
            	.append(System.lineSeparator());
            
            testCaseBuilder.append(generatedTestCase);
            
            testCaseBuilder
            	.append(System.lineSeparator())
            	.append(System.lineSeparator())
            	.append("}")
            	.append(System.lineSeparator());
            
            // TODO - violation actions - create action, path - src/test/java/(default package for this demo)
            System.out.println(testCaseBuilder);
        }
		
		return violation;
	}

}
