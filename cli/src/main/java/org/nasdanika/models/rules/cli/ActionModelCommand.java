package org.nasdanika.models.rules.cli;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.nasdanika.cli.CommandBase;
import org.nasdanika.cli.Description;
import org.nasdanika.cli.HelpCommand;
import org.nasdanika.cli.ParentCommands;
import org.nasdanika.common.DefaultConverter;
import org.nasdanika.common.MarkdownHelper;
import org.nasdanika.common.Util;
import org.nasdanika.exec.content.ContentFactory;
import org.nasdanika.exec.content.Text;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.AppFactory;

import picocli.CommandLine;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.cli.ParentCommands;
import org.nasdanika.cli.ProgressMonitorMixIn;
import org.nasdanika.cli.RootCommand;
import org.nasdanika.common.NasdanikaException;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.launcher.demo.ModuleVersionProvider;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.cli.AbstractRuleCommand;

import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;
import picocli.CommandLine.Option;


@Command(
		description = "Generates rule set documentation action model",
		versionProvider = ModuleVersionProvider.class,		
		mixinStandardHelpOptions = true,
		name = "action-model")
public class ActionModelCommand extends CommandBase {
		
	@Parameters(
		index =  "0",	
		description = {  
			"Model URI, resolved relative",
			"to the current directory",
			"or looked up in registered rule sets",
			"if -R option is provided"
		})
	private String model;
		
	@Option(
			names = {"-R", "--registered"},
			description = {
					"Use registered rule set ",
					"with provided URI"
				})
	private boolean registered;
	
	@Mixin
	private ProgressMonitorMixIn progressMonitorMixIn;	 
	

	@Parameters(index =  "1", description = "Output file")
	private File output;
		
	@Override
	public Integer call() throws Exception {
		CapabilityLoader capabilityLoader = new CapabilityLoader();
		ProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(1);
		Iterable<CapabilityProvider<Object>> ruleSetProviders = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(RuleSet.class), progressMonitor);
		Collection<RuleSet> ruleSets = Collections.synchronizedCollection(new ArrayList<>());
		for (CapabilityProvider<Object> provider: ruleSetProviders) {
			provider.getPublisher().subscribe(rs -> ruleSets.add((RuleSet) rs), error -> error.printStackTrace());
		}
		if (output == null) {
			generateReport(ruleSets, System.out, progressMonitor);
		} else {
			try (PrintStream out = new PrintStream(output)) {
				generateReport(ruleSets, out, progressMonitor);
			} catch (FileNotFoundException e) {
				throw new NasdanikaException(e);
			}
		}
		return 0;
	}

}
