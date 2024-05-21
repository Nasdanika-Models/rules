package org.nasdanika.models.rules.cli;

import picocli.CommandLine.Command;

@Command(
		description = "Executes rules and reports findings",
		name = "rules",
		versionProvider = ModuleVersionProvider.class,
		mixinStandardHelpOptions = true)
public class RulesCommand extends AbstractRulesCommand {

}
