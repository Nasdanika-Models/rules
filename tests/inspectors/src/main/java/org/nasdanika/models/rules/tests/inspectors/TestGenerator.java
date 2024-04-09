package org.nasdanika.models.rules.tests.inspectors;

import java.util.Collection;

import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.java.Code;
import org.nasdanika.models.java.CompilationUnit;
import org.nasdanika.models.java.Source;

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
	Collection<CompilationUnit> generateTest(Source source, String prompt, ProgressMonitor progressMonitor);

}
