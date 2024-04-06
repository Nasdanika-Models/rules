package org.nasdanika.models.rules.tests.inspectors;

import java.util.Collection;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.coverage.Counter;
import org.nasdanika.models.coverage.Coverage;
import org.nasdanika.models.java.CompilationUnit;
import org.nasdanika.models.java.Operation;
import org.nasdanika.models.rules.RulesFactory;
import org.nasdanika.models.rules.Violation;
import org.nasdanika.models.rules.java.CreateCompilationUnitAction;
import org.nasdanika.models.rules.java.JavaFactory;
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
	
	private Collection<TestGenerator> testGenerators;

	public JavaCoverageReflectiveInspectors(Collection<TestGenerator> testGenerators) {
		this.testGenerators = testGenerators;
	}
	
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
			name: Metod or constructor with low test coverage
			documentation:
			  exec.content.Markdown:
			    source:
			      exec.content.Text: |
			        Method or constructor with low test coverage.
			""") 	
	public Violation untestedMethodInspector(Operation operation, ProgressMonitor progressMonitor) {
		// TODO - only for top level or nested classes' constructors and methods
		
		// Using line coverage
		int covered = 0;
		int missed = 0;
		for (Coverage coverage:	operation.getCoverage()) {
			Counter lineCounter = coverage.getLineCounter();
			covered += lineCounter.getCovered();
			missed += lineCounter.getMissed();
		}
		
		int total = covered + missed;
		
		if (total > 0 && covered * 3 < total) { // For this demo using coverage below 33% as low
			Violation result = RulesFactory.eINSTANCE.createViolation();
			result.setDescription("Low test coverage for " + operation.getName()); // TODO - FQN			
			// Reporting a violation with low coverage and a compilation unit actions containing generated tests if test generators are present
			for (TestGenerator testGenerator: testGenerators) {
				for (CompilationUnit testCU: testGenerator.generateTest(operation, null, progressMonitor)) {
					CreateCompilationUnitAction cca = JavaFactory.eINSTANCE.createCreateCompilationUnitAction();
					cca.setCompilationUnit(testCU);
					result.getActions().add(cca);									
				}				
			}
			
			return result;
		}
		return null;
	}
	
}
