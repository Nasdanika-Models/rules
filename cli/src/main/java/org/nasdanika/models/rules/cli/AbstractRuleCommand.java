package org.nasdanika.models.rules.cli;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cli.CommandBase;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.ncore.StringIdentity;
import org.nasdanika.ncore.util.NcoreUtil;

import picocli.CommandLine.Option;

/**
 * Base abstract class for commands loading inspectors - to perform inspections, to generate reports/documentation, ...
 */
public abstract class AbstractRuleCommand extends CommandBase {
	
	@Option(
			names = "--exclude-rule",
			arity = "*",
			description = "ID's of rules to exclude"
			)
	protected String[] ruleExcludes;
	
	@Option(
			names = "--include-rule",
			arity = "*",
			description = "ID's of rules to include"
			)
	protected String[] ruleIncludes;
	
	@Option(
			names = "--exclude-rule-set",
			arity = "*",
			description = "ID's of rule sets to exclude"
			)
	protected String[] ruleSetExcludes;
	
	@Option(
			names = "--include-rule-set",
			arity = "*",
			description = "ID's of rule sets to include"
			)
	protected String[] ruleSetIncludes;
	
	protected boolean matchRule(Rule rule) {
		if (ruleIncludes == null && ruleSetIncludes == null) {
			// explicit includes - match
			return true;
		}

		if (ruleIncludes != null) {
			boolean matched = false;
			for (String ri: ruleIncludes) {
				if (matchIdentity(rule, ri)) {
					matched = true;
					break;
				}
			}
			if (!matched) {
				return false;
			}
		}
		
		if (ruleExcludes != null) {
			for (String re: ruleExcludes) {
				if (matchIdentity(rule, re)) {
					return false;
				}
			}
		}
		
		if (ruleSetIncludes != null) {
			boolean matched = false;
			EObject rc = rule.eContainer();
			if (rc instanceof RuleSet) {
				RuleSet ruleSet = (RuleSet) rc;
				for (String rse: ruleSetIncludes) {
					if (matchIdentity(ruleSet, rse)) {
						matched = true;
						break;
					}
				}
			}
			if (!matched) {
				return false;
			}
		}
		
		if (ruleSetExcludes != null) {
			EObject rc = rule.eContainer();
			if (rc instanceof RuleSet) {
				RuleSet ruleSet = (RuleSet) rc;
				for (String rse: ruleSetExcludes) {
					if (matchIdentity(ruleSet, rse)) {
						return false;
					}
				}
			}
		}
		
		return true;
	}

	protected boolean matchIdentity(StringIdentity obj, String identity) {
		if (identity.equals(obj.getId())) {
			return true; // Match by ID
		}
		for (URI identifier: NcoreUtil.getIdentifiers(obj)) {
			if (identifier.toString().equals(identity)) {
				return true; // Match by URI
			}
		}
		return false;
	}

}
