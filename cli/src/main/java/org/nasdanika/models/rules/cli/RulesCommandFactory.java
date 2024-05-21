package org.nasdanika.models.rules.cli;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.BiFunction;

import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.cli.RootCommand;
import org.nasdanika.cli.SubCommandCapabilityFactory;
import org.nasdanika.common.ProgressMonitor;

import picocli.CommandLine;

public class RulesCommandFactory extends SubCommandCapabilityFactory<RulesCommand> {

	@Override
	protected CompletionStage<RulesCommand> createCommand(
			List<CommandLine> parentPath, 
			BiFunction<Object, ProgressMonitor, CompletionStage<Iterable<CapabilityProvider<Object>>>> resolver,
			ProgressMonitor progressMonitor) {
		if (parentPath != null && parentPath.size() == 1 && parentPath.get(0).getCommandSpec().userObject() instanceof RootCommand) {			
			return CompletableFuture.completedStage(new RulesCommand());			
		}
		return null;
	}

	@Override
	protected Class<RulesCommand> getCommandType() {
		return RulesCommand.class;
	}

}
