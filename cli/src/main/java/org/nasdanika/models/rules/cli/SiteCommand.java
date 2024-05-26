package org.nasdanika.models.rules.cli;

import org.eclipse.emf.common.util.URI;
import org.nasdanika.html.model.app.gen.cli.AbstractSiteCommand;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
		description = "Generates rule set documentation site",
		versionProvider = ModuleVersionProvider.class,		
		mixinStandardHelpOptions = true,
		name = "site")
public class SiteCommand extends AbstractSiteCommand {
		
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
	
	@Override
	protected URI getModelURI(URI contextURI) {
		 return URI.createURI(model).resolve(contextURI);	
	}
	
	@Parameters(index =  "1", description = "Output directory")
	private String output;
	
	@Override
	protected String getOutput() {
		return output;
	}

}
