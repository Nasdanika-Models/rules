package org.nasdanika.models.rules.tests.inspectors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.models.java.Annotation;
import org.nasdanika.models.java.CompilationUnit;
import org.nasdanika.models.java.JavaFactory;
import org.nasdanika.models.java.Method;
import org.nasdanika.models.java.Operation;
import org.nasdanika.models.java.Source;
import org.nasdanika.models.java.Type;

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
	private JUnitTestRequirement requirement;

	public OpenAITestGenerator(OpenAIClient client, JUnitTestRequirement serviceRequirement) {
		this.client = client;
		this.requirement = serviceRequirement;
	}
	
	@Override
	public Collection<CompilationUnit> generateTest(Source source, String prompt, ProgressMonitor progressMonitor) {
		if (source instanceof Operation) {
			EObject operationContainer = source.eContainer();
			if (operationContainer instanceof Type) {
				Type type = (Type) operationContainer;
				if (type.getModifiers().contains("public")) {
					EObject typeContainer = operationContainer.eContainer();
					if (typeContainer instanceof CompilationUnit) {
						// Generating only for top-level types 
						CompilationUnit testCompilationUnit = JavaFactory.eINSTANCE.createCompilationUnit();
						
						// Package name
						CompilationUnit sourceCompilationUnit = (CompilationUnit) typeContainer;
						String sourcePackageName = sourceCompilationUnit.getPackageName();
						testCompilationUnit.setPackageName(sourcePackageName + ".tests");
						testCompilationUnit.setName(type.getName() + "Tests.java");
						
						org.nasdanika.models.java.Class testsClass = JavaFactory.eINSTANCE.createClass();
						testsClass.setName(type.getName() + "Tests");
						testCompilationUnit.getTypes().add(testsClass);
						
						Method testMethod = JavaFactory.eINSTANCE.createMethod();
						testMethod.setName("test" + StringUtils.capitalize(((Operation) source).getName()));
						testMethod.getModifiers().add("public");
						
						Annotation testAnnotation = Annotation.create("${import/org.junit.jupiter.api.Test}");
						testMethod.getAnnotations().add(testAnnotation);
						
						if (requirement.disabled()) {
							Annotation disabledAnnotation = Annotation.create("${import/org.junit.jupiter.api.Disabled}");
							testMethod.getAnnotations().add(disabledAnnotation);							
						}
						
						testsClass.getMembers().add(testMethod);
						
						Source methodBody = JavaFactory.eINSTANCE.createSource();
						testMethod.setBody(methodBody);
						
						StringBuilder bodyBuilder = new StringBuilder("{").append(System.lineSeparator());
						
						String indent = testMethod.getIndent();
						bodyBuilder
							.append(indent)
							.append(indent)
							.append("// *** Start generated test ***")
							.append(System.lineSeparator());

						if (requirement.generateExplanation()) {
							// TODO
		            		throw new UnsupportedOperationException();
		            	}

						if (requirement.generateReview()) {
							// TODO
		            		throw new UnsupportedOperationException();
		            	}
						
						if (requirement.useGenAI()) {
							// Generate test
					        List<ChatRequestMessage> chatMessages = new ArrayList<>();
					        chatMessages.add(new ChatRequestSystemMessage("Generate a JUnit " + requirement.jUnitVersion()  + " test method for the following Java method: "));
					        chatMessages.add(new ChatRequestUserMessage(source.getSource()));
					        
					        ChatCompletions chatCompletions = client.getChatCompletions(DEPLOYMENT_OR_MODEL_ID, new ChatCompletionsOptions(chatMessages));
					        for (ChatChoice choice : chatCompletions.getChoices()) {
					            ChatResponseMessage message = choice.getMessage();
					            String generatedTestCase = message.getContent();
					            if (!Util.isBlank(generatedTestCase)) {
					            	if (requirement.massageGenAIOutput()) {
					            		// TODO - parse, add imports, extract method code
					            		throw new UnsupportedOperationException();
					            	}
					            	
					            	String[] lines = generatedTestCase.split("\\R");					            	
					            	for (String line: lines) {
							            bodyBuilder
							            	.append(indent)
							            	.append(indent);
							            
							            if (requirement.commentGenAIOutput()) {
							            	bodyBuilder.append("// ");
							            }
							            
							            bodyBuilder.append(line);
							            bodyBuilder.append(System.lineSeparator());
					            	}
					            }
					            
					        }
						} else {
							methodBody.setInterpolate(true);
							bodyBuilder
								.append(indent)
								.append(indent)
								.append("${import/static org.junit.jupiter.api.Assertions.fail}(\"Implement me!\");")
								.append(System.lineSeparator());							
						}
				            
						bodyBuilder
							.append(indent)
							.append(indent)						
							.append("// *** End generated test ***")
							.append(System.lineSeparator());
						
						bodyBuilder
							.append(indent)
							.append("}")
							.append(System.lineSeparator());
						
						methodBody.setSource(bodyBuilder.toString());
						
						return Collections.singleton(testCompilationUnit);
					}
				}
			}
		}
		
		return Collections.emptyList();
	}

}
