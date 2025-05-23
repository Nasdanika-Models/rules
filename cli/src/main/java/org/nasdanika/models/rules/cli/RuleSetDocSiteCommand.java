package org.nasdanika.models.rules.cli;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.common.Context;
import org.nasdanika.common.Diagnostic;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.AppFactory;
import org.nasdanika.models.app.Label;
import org.nasdanika.models.app.cli.AbstractSiteCommand;
import org.nasdanika.models.app.graph.emf.HtmlAppGenerator;
import org.nasdanika.models.rules.RuleSet;

import picocli.CommandLine.Command;
import picocli.CommandLine.Mixin;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
		description = "Generates rule set documentation site",
//		versionProvider = ModuleVersionProvider.class,		
		mixinStandardHelpOptions = true,
		name = "site")
public class RuleSetDocSiteCommand extends AbstractSiteCommand {
	
	public RuleSetDocSiteCommand() {
		
	}
	
	public RuleSetDocSiteCommand(CapabilityLoader capabilityLoader) {
		super(capabilityLoader);
	}
	
	@Mixin
	private RuleSetMixIn ruleSetMixIn;
		
	@Parameters(
		index =  "0",	
		description = {  
			"Model URI, resolved relative",
			"to the current directory",
			"or looked up in registered rule sets",
			"if -R option is provided"
		})
	private String model;
			
	@Parameters(index =  "1", description = "Output directory")
	private String output;
	
	@Override
	protected String getOutput() {
		return output;
	}
	
	private URI modelURI;
	
	@Override
	protected URI getModelURI(URI contextURI) {
		return modelURI;
	}
		
	@Option(names = "--root-action-icon", description = "Root action icon")
	private String rootActionIcon;
	
	@Option(names = "--root-action-text", description = "Root action text")
	private String rootActionText;
	
	@Option(names = "--root-action-location", description = "Root action location")
	private String rootActionLocation;

	@Override
	protected int generate(Context context, ProgressMonitor progressMonitor) throws IOException, DiagnosticException {
		try (ProgressMonitor gpm = progressMonitor.scale(4)) {
			RuleSet ruleSet = ruleSetMixIn.getRuleSet(model, progressMonitor.split("Loading rule set", 1));
			
			Consumer<Diagnostic> diagnosticConsumer = d -> d.dump(progressMonitor.split("Diagnostic", 1));		
			try (ProgressMonitor actionGeneratorProgressMonitor = progressMonitor.split("Generating action model", 1)) {
				Action rootAction = AppFactory.eINSTANCE.createAction();
				rootAction.setIcon(rootActionIcon);
				rootAction.setText(rootActionText);
				rootAction.setLocation(rootActionLocation);
				
				HtmlAppGenerator htmlAppGenerator = HtmlAppGenerator.load(
						Collections.singleton(ruleSet), 
						context, 
						null, 
						null, 
						null, 
						diagnosticConsumer, 
						actionGeneratorProgressMonitor);
				
				Map<EObject, Collection<Label>> labelMap = htmlAppGenerator.generateHtmlAppModel(diagnosticConsumer, progressMonitor);
				labelMap
					.values()
					.stream()
					.flatMap(Collection::stream)
					.forEach(principal -> {
						rootAction.getChildren().add(principal);
						((Action) principal).setLocation("${base-uri}index.html");
					});
				
				URI actionModelResourceURI = URI.createFileURI(File.createTempFile("resource-set-action-model-", ".xml").getAbsolutePath());		
				HtmlAppGenerator.saveLabels(Collections.singleton(rootAction), actionModelResourceURI);
				modelURI = actionModelResourceURI.appendFragment("/");
			}			
			return super.generate(context, gpm.split("Generating site", 1));
		}
	}

}
