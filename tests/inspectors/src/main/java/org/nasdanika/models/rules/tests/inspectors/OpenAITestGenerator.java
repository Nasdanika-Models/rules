package org.nasdanika.models.rules.tests.inspectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.java.Code;
import org.nasdanika.models.java.CompilationUnit;
import org.nasdanika.models.java.JavaFactory;
import org.nasdanika.models.java.Type;
import org.nasdanika.models.rules.CreateTextResourceAction;
import org.nasdanika.models.rules.RulesFactory;
import org.nasdanika.models.rules.Violation;

import com.azure.ai.openai.OpenAIClient;
import com.azure.ai.openai.models.ChatChoice;
import com.azure.ai.openai.models.ChatCompletions;
import com.azure.ai.openai.models.ChatCompletionsOptions;
import com.azure.ai.openai.models.ChatRequestMessage;
import com.azure.ai.openai.models.ChatRequestSystemMessage;
import com.azure.ai.openai.models.ChatRequestUserMessage;
import com.azure.ai.openai.models.ChatResponseMessage;

public class OpenAITestGenerator implements TestGenerator {
	
    private static String DEPLOYMENT_OR_MODEL_ID = "gpt-3.5-turbo";	
	
	private OpenAIClient client;
	private JUnitTestRequirement serviceRequirement;

	public OpenAITestGenerator(OpenAIClient client, JUnitTestRequirement serviceRequirement) {
		this.client = client;
		this.serviceRequirement = serviceRequirement;
	}

	@Override
	public Collection<CompilationUnit> generateTest(Code code, String prompt, ProgressMonitor progressMonitor) {
		CompilationUnit cu = JavaFactory.eINSTANCE.createCompilationUnit();
		// Package name
		
		// CU name
		
		// Generate test
        List<ChatRequestMessage> chatMessages = new ArrayList<>();
        chatMessages.add(new ChatRequestSystemMessage("Generate a JUnit " + serviceRequirement.jUnitVersion()  + " test method for the following code"));
        chatMessages.add(new ChatRequestUserMessage(code.getSource()));
        
        ChatCompletions chatCompletions = client.getChatCompletions(DEPLOYMENT_OR_MODEL_ID, new ChatCompletionsOptions(chatMessages));
        for (ChatChoice choice : chatCompletions.getChoices()) {
            ChatResponseMessage message = choice.getMessage();
            String generatedTestCase = message.getContent();
            
            cu.getImports().add("import org.junit.jupiter.api.Test");
            // TODO - set package name
            // TODO - set class name
            
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
		
		return Collections.singleton(cu);
	}

}
