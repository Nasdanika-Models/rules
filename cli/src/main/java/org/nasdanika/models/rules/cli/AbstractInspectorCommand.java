package org.nasdanika.models.rules.cli;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.nasdanika.cli.CommandBase;
import org.nasdanika.cli.ProgressMonitorMixIn;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;

import picocli.CommandLine.Mixin;
import picocli.CommandLine.Option;

/**
 * Base abstract class for commands loading inspectors - to perform inspections, to generate reports/documentation, ...
 */
public abstract class AbstractInspectorCommand extends CommandBase {
	
	@Mixin
	protected ProgressMonitorMixIn progressMonitorMixIn;
	
	@Option(
			names = "--exclude-rules",
			arity = "*",
			description = "ID's of rules to exclude"
			)
	protected String[] ruleExcludes;
	
	@Option(
			names = "--include-rules",
			arity = "*",
			description = "ID's of rules to include"
			)
	protected String[] ruleIncludes;
	
	@Option(
			names = "--exclude-rule-sets",
			arity = "*",
			description = "ID's of rule sets to exclude"
			)
	protected String[] ruleSetExcludes;
	
	@Option(
			names = "--include-rule-sets",
			arity = "*",
			description = "ID's of rule sets to include"
			)
	protected String[] ruleSetIncludes;
	
	protected boolean testInspector(Inspector<Object> inspector) {
		Collection<Rule> rules = inspector.getRules();
		if (rules.isEmpty() && ruleIncludes == null && ruleSetIncludes == null) {
			// No rules, but no explicit includes either - match
			return true;
		}

		for (Rule rule: rules) {
			if (matchRule(rule)) {
				return true;
			}
		}
		
		return false;
	}
	
	protected boolean matchRule(Rule rule) {
		if (ruleIncludes != null) {
			boolean matched = false;
			for (String ri: ruleIncludes) {
				if (ri.equals(rule.getId())) {
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
				if (re.equals(rule.getId())) {
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
					if (rse.equals(ruleSet.getId())) {
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
					if (rse.equals(ruleSet.getId())) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	/**
	 * Uses Inspector.load
	 * @param progressMonitor
	 * @return
	 */
	protected Inspector<Object> loadInspector(ProgressMonitor progressMonitor) {
		return Inspector.load(this::testInspector, progressMonitor);
	}

}
