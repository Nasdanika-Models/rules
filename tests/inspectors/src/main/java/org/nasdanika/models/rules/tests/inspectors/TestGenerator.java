package org.nasdanika.models.rules.tests.inspectors;

import java.util.Collection;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.java.Code;
import org.nasdanika.models.java.CompilationUnit;

/**
 * Service interface to be implemented by test generators
 */
public interface TestGenerator {
	
	/**
	 * Generate JUnit test for {@link Code}
	 * @param code Code to generate test for
	 * @param prompt Additional instructions
	 * @return A list of compilation units.  
	 */
	Collection<CompilationUnit> generateTest(Code code, String prompt, ProgressMonitor progressMonitor);

}
