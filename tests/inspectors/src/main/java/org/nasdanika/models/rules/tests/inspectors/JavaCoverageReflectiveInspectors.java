package org.nasdanika.models.rules.tests.inspectors;

import org.nasdanika.models.java.Method;
import org.nasdanika.models.rules.Violation;
import org.nasdanika.models.rules.reflection.Inspector;
import org.nasdanika.models.rules.reflection.RuleSet;

/**
 * Testing implicit rule set first
 */

@RuleSet("""		
		name: Java Code Coverage Rules
		severities:
		  error:
		    name: Error
		    description: Artifacts with this severity are not allowed to be further processed (e.g. deployed, published to a repository) 
		""")
public class JavaCoverageReflectiveInspectors {
	
//	/**
//	 * Inspector with single parameter returning string.
//	 * The string is to be wrapped into a violation and associated with the inline rule. 
//	 * @param type
//	 * @return
//	 */
//	@Inspector("""
//			name: Undocumented type
//			documentation:
//			  exec.content.Markdown:
//			    source:
//			      exec.content.Text: |
//			        Types should be documented.
//			        TODO:
//			        
//			          * Exclude private types (optionally) and anonymous
//			          * Fully qualified name
//			          * Marked/Markers 
//			""")
//	public String undocumentedTypeInspector(Type type) {
//		if (type.getComment() == null) {
//			return "Undocumented type: " + type.getName();
//		}
//		return null;
//	}
	
	@Inspector("""
			name: Metod with no test coverage
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
		System.out.println(">>> Here we are: " + method + " " + method.getName() + " " + method.getSource());
		return null;
	}
	
}
