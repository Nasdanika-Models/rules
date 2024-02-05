package org.nasdanika.models.rules.tests.inspectors;

import org.nasdanika.models.java.Type;
import org.nasdanika.models.rules.reflection.Inspector;
import org.nasdanika.models.rules.reflection.RuleSet;

/**
 * Testing implicit rule set first
 */

//@RuleSet("""
//			TODO - RuleSet spec
//		""")
public class ReflectiveInspectors {
	
	/**
	 * Inspector with single parameter returning string.
	 * The string is to be wrapped into a violation and associated with the inline rule. 
	 * @param type
	 * @return
	 */
	@Inspector
	public String undocumentedTypeInspector(Type type) {
		return type.getName();
	}

}
