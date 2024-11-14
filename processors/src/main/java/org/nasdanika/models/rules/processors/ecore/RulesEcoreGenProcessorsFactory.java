package org.nasdanika.models.rules.processors.ecore;

import java.util.function.BiConsumer;

import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Reflector.Factory;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.models.app.Action;
import org.nasdanika.models.app.Label;
import org.nasdanika.models.app.graph.WidgetFactory;
import org.nasdanika.models.ecore.graph.processors.EPackageNodeProcessor;
import org.nasdanika.models.ecore.graph.processors.EPackageNodeProcessorFactory;
import org.nasdanika.models.rules.RulesPackage;

@EPackageNodeProcessorFactory(nsURI = RulesPackage.eNS_URI)
public class RulesEcoreGenProcessorsFactory {

	private Context context;
	
	@Factory
	public final ActionProcessorFactory actionProcessorFactory;
	
	@Factory
	public final BinaryResourceActionProcessorFactory binaryResourceActionProcessorFactory;
	
	@Factory
	public final CreateBinaryResourceActionProcessorFactory createBinaryResourceActionProcessorFactory;
	
	@Factory
	public final CreateResourceActionProcessorFactory createResourceActionProcessorFactory;
	
	@Factory
	public final CreateTextResourceActionProcessorFactory createTextResourceActionProcessorFactory;
	
	@Factory
	public final DeleteResourceActionProcessorFactory deleteResourceActionProcessorFactory;
	
	@Factory
	public final FailureProcessorFactory failureProcessorFactory;
	
	@Factory
	public final InspectableProcessorFactory inspectableProcessorFactory;
	
	@Factory
	public final InspectionResultProcessorFactory inspectionResultProcessorFactory;
	
	@Factory
	public final MoveResourceActionProcessorFactory moveResourceActionProcessorFactory;
	
	@Factory
	public final ResourceActionProcessorFactory resourceActionProcessorFactory;
	
	@Factory
	public final RuleProcessorFactory ruleProcessorFactory;
	
	@Factory
	public final RuleSetProcessorFactory ruleSetProcessorFactory;
	
	@Factory
	public final SeverityProcessorFactory severityProcessorFactory;
	
	@Factory
	public final TextResourceActionProcessorFactory textResourceActionProcessorFactory;
	
	@Factory
	public final UpdateBinaryResourceActionProcessorFactory updateBinaryResourceActionProcessorFactory;
	
	@Factory
	public final UpdateResourceActionProcessorFactory updateResourceActionProcessorFactory;
	
	@Factory
	public final UpdateTextResourceActionProcessorFactory updateTextResourceActionProcessorFactory;
	
	@Factory
	public final ViolationProcessorFactory violationProcessorFactory;
	
	@Factory
	public final WaiverProcessorFactory waiverProcessorFactory;
	
	public RulesEcoreGenProcessorsFactory(Context context) {
		this.context = context; 
		 actionProcessorFactory = new ActionProcessorFactory(context);
		 binaryResourceActionProcessorFactory = new BinaryResourceActionProcessorFactory(context);
		 createBinaryResourceActionProcessorFactory = new CreateBinaryResourceActionProcessorFactory(context);
		 createResourceActionProcessorFactory = new CreateResourceActionProcessorFactory(context);
		 createTextResourceActionProcessorFactory = new CreateTextResourceActionProcessorFactory(context);
		 deleteResourceActionProcessorFactory = new DeleteResourceActionProcessorFactory(context);
		 failureProcessorFactory = new FailureProcessorFactory(context);
		 inspectableProcessorFactory = new InspectableProcessorFactory(context);
		 inspectionResultProcessorFactory = new InspectionResultProcessorFactory(context);
		 moveResourceActionProcessorFactory = new MoveResourceActionProcessorFactory(context);
		 resourceActionProcessorFactory = new ResourceActionProcessorFactory(context);
		 ruleProcessorFactory = new RuleProcessorFactory(context);
		 ruleSetProcessorFactory = new RuleSetProcessorFactory(context);
		 severityProcessorFactory = new SeverityProcessorFactory(context);
		 textResourceActionProcessorFactory = new TextResourceActionProcessorFactory(context);
		 updateBinaryResourceActionProcessorFactory = new UpdateBinaryResourceActionProcessorFactory(context);
		 updateResourceActionProcessorFactory = new UpdateResourceActionProcessorFactory(context);
		 updateTextResourceActionProcessorFactory = new UpdateTextResourceActionProcessorFactory(context);
		 violationProcessorFactory = new ViolationProcessorFactory(context);
		 waiverProcessorFactory = new WaiverProcessorFactory(context);
	}
	
	
	@EPackageNodeProcessorFactory(
			label = "Rules",
			description = "TODO",
			actionPrototype = """
            app-action:
              content:
                content-markdown:
                  source:
                    content-resource:
                      location: rules.md
			"""
	)
	public EPackageNodeProcessor createEPackageProcessor(
			NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
			java.util.function.Function<ProgressMonitor, Action> prototypeProvider,
			BiConsumer<Label, ProgressMonitor> labelConfigurator,
			ProgressMonitor progressMonitor) {		
		return new EPackageNodeProcessor(config, context, prototypeProvider) {
			
			@Override
			public void configureLabel(Object source, Label label, ProgressMonitor progressMonitor) {
				super.configureLabel(source, label, progressMonitor);
				if (labelConfigurator != null) {
					labelConfigurator.accept(label, progressMonitor);
				}
			}
			
		};
	}	

}
