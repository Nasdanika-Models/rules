package org.nasdanika.models.rules.cli;

import java.util.Collection;

import org.nasdanika.cli.ProgressMonitorMixIn;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.Rule;

import picocli.CommandLine.Mixin;

/**
 * Base abstract class for commands loading inspectors - to perform inspections, to generate reports/documentation, ...
 */
public abstract class AbstractInspectorCommand extends AbstractRuleCommand {
	
	@Mixin
	protected ProgressMonitorMixIn progressMonitorMixIn;
	
	protected boolean testInspector(Inspector<Object> inspector) {
		Collection<Rule> rules = inspector.getRules();

		for (Rule rule: rules) {
			if (matchRule(rule)) {
				return true;
			}
		}
		
		return false;
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
