package org.nasdanika.models.rules.cli;

import java.io.File;
import java.util.function.Consumer;

import org.nasdanika.cli.CommandBase;
import org.nasdanika.cli.ContextMixIn;
import org.nasdanika.cli.ProgressMonitorMixIn;
import org.nasdanika.common.Context;
import org.nasdanika.common.Diagnostic;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.html.model.app.graph.emf.ActionGenerator;
import org.nasdanika.models.rules.RuleSet;

import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;
import picocli.CommandLine.Parameters;


@Command(
		description = "Generates rule set documentation action model",
//		versionProvider = ModuleVersionProvider.class,		
		mixinStandardHelpOptions = true,
		name = "action-model")
public class ActionModelCommand extends CommandBase {
	
	@Mixin
	private RuleSetMixIn ruleSetMixIn;
	
	@Mixin
	private ProgressMonitorMixIn progressMonitorMixIn;
	
	@Parameters(
		index =  "0",	
		arity = "1",
		description = {  
			"Model URI or file path, resolved relative",
			"to the current directory",
			"or looked up in registered rule sets",
			"if -R option is provided"
		})
	private String model;

	@Parameters(index =  "1", description = "Output file")
	private File output;
	
	@Mixin
	private ContextMixIn contextMixIn;
		
	@Override
	public Integer call() throws Exception {
		try (ProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(3)) {
			RuleSet ruleSet = ruleSetMixIn.getRuleSet(model, progressMonitor.split("Loading rule set", 1));
			
			Consumer<Diagnostic> diagnosticConsumer = d -> d.dump(System.out, 0);		
			Context context = contextMixIn.createContext(progressMonitor.split("Creating context", 1));
			try (ProgressMonitor actionGeneratorProgressMonitor = progressMonitor.split("Generating action model", 1)) {
				ActionGenerator actionGenerator = ActionGenerator.load(ruleSet, context, null, null, null, actionGeneratorProgressMonitor); 
				actionGenerator.generateActionModel(
						diagnosticConsumer, 
						output,
						progressMonitor);
			}			
		}
		return 0;
	}

}
