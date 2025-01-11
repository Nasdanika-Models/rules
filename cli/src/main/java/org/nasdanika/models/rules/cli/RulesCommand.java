package org.nasdanika.models.rules.cli;

import org.nasdanika.cli.CommandGroup;
import org.nasdanika.cli.Description;
import org.nasdanika.cli.ParentCommands;
import org.nasdanika.cli.RootCommand;

import picocli.CommandLine.Command;

@Command(
		description = "Rules commands",
		name = "rules",
//		versionProvider = ModuleVersionProvider.class,
		subcommands = {
			ActionModelCommand.class,
			ListCommand.class,
			RuleSetDocSiteCommand.class
		},		
		mixinStandardHelpOptions = true)
@ParentCommands(RootCommand.class)
@Description(icon = "https://docs.nasdanika.org/images/rules.svg")
public class RulesCommand extends CommandGroup {
	

}
