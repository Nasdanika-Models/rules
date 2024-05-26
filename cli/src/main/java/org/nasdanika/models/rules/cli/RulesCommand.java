package org.nasdanika.models.rules.cli;

import org.nasdanika.cli.CommandGroup;
import org.nasdanika.cli.ParentCommands;
import org.nasdanika.cli.RootCommand;

import picocli.CommandLine.Command;

@Command(
		description = "HTML Application model commands",
		name = "app",
		versionProvider = ModuleVersionProvider.class,
//		subcommands = {
//			SiteCommand.class
//			// TODO - serve command to serve a site over HTTP instead of generating. Netty, caching, ...
//		},		
		mixinStandardHelpOptions = true)
@ParentCommands(RootCommand.class)
public class RulesCommand extends CommandGroup {
	

}
