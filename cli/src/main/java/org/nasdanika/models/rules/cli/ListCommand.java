package org.nasdanika.models.rules.cli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.cli.ProgressMonitorMixIn;
import org.nasdanika.common.NasdanikaException;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.ncore.util.NcoreUtil;

import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;
import picocli.CommandLine.Option;

@Command(
		description = "Lists available rule sets and rules",
		name = "list",
//		versionProvider = ModuleVersionProvider.class,
		mixinStandardHelpOptions = true)
public class ListCommand extends AbstractRuleCommand {
		
	@Option(names = {"-o", "--output"}, description = "Output file")
	private File output;
	
	@Option(names = {"-r", "--rules"}, description = "Output rules", negatable = true)
	private boolean outputRules = true;
	
	@Mixin
	private ProgressMonitorMixIn progressMonitorMixIn;

	@Override
	public Integer call() throws Exception {
		CapabilityLoader capabilityLoader = new CapabilityLoader();
		try (ProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(1)) {
			Iterable<CapabilityProvider<Object>> ruleSetProviders = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(RuleSet.class), progressMonitor);
			Collection<RuleSet> ruleSets = Collections.synchronizedCollection(new ArrayList<>());
			for (CapabilityProvider<Object> provider: ruleSetProviders) {
				provider.getPublisher().subscribe(rs -> ruleSets.add((RuleSet) rs), error -> error.printStackTrace());
			}
			
			if (output == null) {
				generateReport(ruleSets, System.out);
			} else {
				try (PrintStream out = new PrintStream(output)) {
					generateReport(ruleSets, out);
				} catch (FileNotFoundException e) {
					throw new NasdanikaException(e);
				}
			}
		}
		return 0;
	}

	protected void generateReport(
			Collection<RuleSet> ruleSets, 
			PrintStream out) {
		
		for (RuleSet ruleSet: ruleSets) {
			out.println(ruleSet.getId() + NcoreUtil.getIdentifiers(ruleSet) + ": " + ruleSet.getName());
			if (outputRules) {
				for (Rule rule: ruleSet.getRules()) {
					out.println("\t" + rule.getId() + NcoreUtil.getIdentifiers(rule) + ": " + rule.getName());
				}
			}
		}				
	}

}
