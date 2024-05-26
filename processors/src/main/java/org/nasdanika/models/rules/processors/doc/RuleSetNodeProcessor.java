/**
 */
package org.nasdanika.models.rules.processors.doc;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.nasdanika.common.Context;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.graph.emf.EReferenceConnection;
import org.nasdanika.graph.processor.NodeProcessorConfig;
import org.nasdanika.html.model.app.Action;
import org.nasdanika.html.model.app.AppFactory;
import org.nasdanika.html.model.app.Label;
import org.nasdanika.html.model.app.gen.DynamicTableBuilder;
import org.nasdanika.html.model.app.graph.WidgetFactory;
import org.nasdanika.html.model.app.graph.emf.OutgoingReferenceBuilder;
import org.nasdanika.models.architecture.processors.doc.DomainNodeProcessor;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.RulesPackage;
import org.nasdanika.models.rules.Severity;
import org.nasdanika.ncore.NamedElement;

public class RuleSetNodeProcessor<T extends RuleSet> extends DomainNodeProcessor<T> {

	public RuleSetNodeProcessor(
		NodeProcessorConfig<WidgetFactory, WidgetFactory> config, 
		Context context,
		java.util.function.Function<ProgressMonitor, Action> prototypeProvider) {
		
		super(config, context, prototypeProvider);
	}
	
	@OutgoingReferenceBuilder(
			nsURI = RulesPackage.eNS_URI,
			classID = RulesPackage.RULE_SET,
			referenceID = RulesPackage.RULE_SET__RULES)
	public void buildRulesOutgoingReference(
			EReference eReference,
			List<Entry<EReferenceConnection, WidgetFactory>> referenceOutgoingEndpoints, 
			Collection<Label> labels,
			Map<EReferenceConnection, Collection<Label>> outgoingLabels, 
			ProgressMonitor progressMonitor) {
		
		for (Label label: labels) {
			if (label instanceof Action) {
				Action action = (Action) label;
				EList<Action> anonymous = action.getAnonymous();
				for (Collection<Label> re: outgoingLabels.values()) {
					for (Label ree: re) {
						if (ree instanceof Action)
						anonymous.add((Action) ree);
					}
				}
				Action rulesSection = getRulesSectionAction(action);
				DynamicTableBuilder<Entry<EReferenceConnection, WidgetFactory>> rulesTableBuilder = new DynamicTableBuilder<>("nsd-ecore-doc-table");
				rulesTableBuilder
					.addStringColumnBuilder("id", true, false, "ID", endpoint -> ((Rule) endpoint.getKey().getTarget().get()).getId()) 
					.addStringColumnBuilder("name", true, false, "Name", endpoint -> targetNameLink(endpoint.getKey(), endpoint.getValue(), progressMonitor)) 
					.addStringColumnBuilder("description", true, false, "Description", endpoint -> description(endpoint.getKey(), endpoint.getValue(), progressMonitor))
					.addStringColumnBuilder("severity", true, true, "Severity", endpoint -> severityLink(endpoint.getKey(), endpoint.getValue(), progressMonitor));
				
				org.nasdanika.html.model.html.Tag rulesTable = rulesTableBuilder.build(
						referenceOutgoingEndpoints,  
						"rule-set-rules", 
						"rules-table", 
						progressMonitor);
				rulesSection.getContent().add(rulesTable);				
			}
		}		
	}
	
	static String severityLink(EReferenceConnection connection, WidgetFactory widgetFactory, ProgressMonitor progressMonitor) {
		Severity severity = ((Rule) connection.getTarget().get()).getSeverity();
		if (severity == null) {
			return null;
		}
		
		String severityName = severity.getName();
		String linkStr = widgetFactory.selectString(RulesPackage.Literals.RULE__SEVERITY, progressMonitor);
		String severityNameComment = "<!-- " + severityName + "--> ";
		return severityNameComment + (Util.isBlank(linkStr) ? severityName : linkStr);
	}	
		
	protected String description(EReferenceConnection connection, WidgetFactory widgetFactory, ProgressMonitor progressMonitor) {
		Object label = widgetFactory.createLabel(progressMonitor);
		return label instanceof Label ? ((Label) label).getTooltip() : null;
	}	
	
	protected String targetNameLink(EReferenceConnection connection, WidgetFactory widgetFactory, ProgressMonitor progressMonitor) {
		String linkStr = widgetFactory.createLinkString(progressMonitor);
		return Util.isBlank(linkStr) ? ((NamedElement) connection.getTarget().get()).getName() : linkStr;
	}	
		
	/**
	 * Returns rules section action, creates if necessary. Matches by name.
	 * @param parent
	 * @return
	 */
	protected Action getRulesSectionAction(Action parent) {
		return parent.getSections()
			.stream()
			.filter(e -> "rules".equals(((Action) e).getName()))
			.findFirst()
			.map(Action.class::cast)
			.orElseGet(() -> {
				Action rulesAction = AppFactory.eINSTANCE.createAction();
				rulesAction.setText("Rules");
				rulesAction.setName("rules");
				parent.getSections().add(rulesAction);
				return rulesAction;
			});
	}	
	
	@OutgoingReferenceBuilder(
			nsURI = RulesPackage.eNS_URI,
			classID = RulesPackage.RULE_SET,
			referenceID = RulesPackage.RULE_SET__SEVERITIES)
	public void buildSeveritiesOutgoingReference(
			EReference eReference,
			List<Entry<EReferenceConnection, WidgetFactory>> referenceOutgoingEndpoints, 
			Collection<Label> labels,
			Map<EReferenceConnection, Collection<Label>> outgoingLabels, 
			ProgressMonitor progressMonitor) {
		
		for (Label label: labels) {
			if (label instanceof Action) {
				Action action = (Action) label;
				EList<Action> anonymous = action.getAnonymous();
				for (Collection<Label> re: outgoingLabels.values()) {
					for (Label ree: re) {
						if (ree instanceof Action)
						anonymous.add((Action) ree);
					}
				}
				Action severitiesSection = getSeveritiesSectionAction(action);
				DynamicTableBuilder<Entry<EReferenceConnection, WidgetFactory>> severitiesTableBuilder = new DynamicTableBuilder<>("nsd-ecore-doc-table");
				Function<Entry<EReferenceConnection, WidgetFactory>, String> idComputer = endpoint -> ((Severity) endpoint.getKey().getTarget().get()).getId();
//				Function<Entry<EReferenceConnection, WidgetFactory>, String> rulesNumberComputer = endpoint ->  String.valueOf(((Severity) endpoint.getKey().getTarget().get()).getRules().size());
				severitiesTableBuilder
					.addStringColumnBuilder("id", true, false, "ID", idComputer) 
					.addStringColumnBuilder("name", true, false, "Name", endpoint -> targetNameLink(endpoint.getKey(), endpoint.getValue(), progressMonitor)) 
					.addStringColumnBuilder("description", true, false, "Description", endpoint -> description(endpoint.getKey(), endpoint.getValue(), progressMonitor));
//					.addStringColumnBuilder("rules", true, false, "Rules", rulesNumberComputer); TODO - make severity.rules derived and compute opposite referrers.
				
				// 
				
				org.nasdanika.html.model.html.Tag severitiesTable = severitiesTableBuilder.build(
						referenceOutgoingEndpoints,  
						"rule-set-severities", 
						"severities-table", 
						progressMonitor);
				severitiesSection.getContent().add(severitiesTable);				
			}
		}		
	}
		
	/**
	 * Returns rules section action, creates if necessary. Matches by name.
	 * @param parent
	 * @return
	 */
	protected Action getSeveritiesSectionAction(Action parent) {
		return parent.getSections()
			.stream()
			.filter(e -> "severities".equals(((Action) e).getName()))
			.findFirst()
			.map(Action.class::cast)
			.orElseGet(() -> {
				Action severitiesAction = AppFactory.eINSTANCE.createAction();
				severitiesAction.setText("Severities");
				severitiesAction.setName("severities");
				parent.getSections().add(severitiesAction);
				return severitiesAction;
			});
	}	
	
//	EList<RuleSet> getExtends();
//	EList<RuleSet> getExtensions();
//	EList<Severity> getSeverities();

} // RuleSet
