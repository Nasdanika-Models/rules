package org.nasdanika.models.rules.cli;

import org.nasdanika.cli.CommandGroup;
import org.nasdanika.cli.ParentCommands;
import org.nasdanika.cli.RootCommand;

import picocli.CommandLine.Command;

@Command(
		description = "Rules commands",
		name = "rules",
		versionProvider = ModuleVersionProvider.class,
		subcommands = {
			ActionModelCommand.class,	
			SiteCommand.class
		},		
		mixinStandardHelpOptions = true)
@ParentCommands(RootCommand.class)
public class RulesCommand extends CommandGroup {
	

}
