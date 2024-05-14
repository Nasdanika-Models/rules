package org.nasdanika.models.rules.tests.analyzer.tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gitlab4j.api.CommitsApi;
import org.gitlab4j.api.Constants.Encoding;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.MergeRequestApi;
import org.gitlab4j.api.models.CommitAction;
import org.gitlab4j.api.models.CommitAction.Action;
import org.gitlab4j.api.models.MergeRequestParams;
import org.junit.jupiter.api.Test;
import org.nasdanika.capability.CapabilityLoader;
import org.nasdanika.capability.CapabilityProvider;
import org.nasdanika.capability.ServiceCapabilityFactory;
import org.nasdanika.common.Context;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.models.gitlab.util.GitLabApiProvider;
import org.nasdanika.models.gitlab.util.GitLabURIHandler;
import org.nasdanika.models.java.util.JavaParserResourceFactory;
import org.nasdanika.models.maven.Project;
import org.nasdanika.models.maven.util.MavenResourceFactory;
import org.nasdanika.models.rules.CreateTextResourceAction;
import org.nasdanika.models.rules.InspectionResult;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.NotifierInspector;
import org.nasdanika.models.rules.ResourceAction;
import org.nasdanika.models.rules.Rule;
import org.nasdanika.models.rules.RuleSet;
import org.nasdanika.models.rules.Severity;
import org.nasdanika.ncore.Tree;
import org.nasdanika.ncore.TreeItem;
import org.nasdanika.ncore.util.DirectoryContentFileURIHandler;
import org.nasdanika.ncore.util.NcoreYamlHandler;
import org.nasdanika.ncore.util.YamlResourceFactory;

/**
 * Tests of analyzers
 */
public class TestAnalyzers {
	
	@Test
	public void testInspectorFactory() {
		CapabilityLoader capabilitLoader = new CapabilityLoader();
		Iterable<CapabilityProvider<Object>> providers = capabilitLoader.load(ServiceCapabilityFactory.createRequirement(Inspector.class),  new PrintStreamProgressMonitor());
		for (CapabilityProvider<Object> provider: providers) {
			provider.getPublisher().subscribe(System.out::println);
		}
	}
		
	@Test
	public void testLoadPomXmlFromGitLab() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new MavenResourceFactory());
		
		String accessToken = System.getenv("GITLAB_ACCESS_TOKEN");
		if (!Util.isBlank(accessToken)) {	
			try (GitLabApiProvider gitLabApiProvider = new GitLabApiProvider("https://gitlab.com/", accessToken)) {
				GitLabURIHandler gitLabURIHandler = new GitLabURIHandler(gitLabApiProvider.getGitLabApi());				
				URI pomURI = URI.createHierarchicalURI(
						GitLabURIHandler.GITLAB_URI_SCHEME, 
						"48523784", 
						null, 
						new String[] { "main", "pom.xml" }, 
						null, 
						"/");
				
				resourceSet.getURIConverter().getURIHandlers().add(0, gitLabURIHandler);
				
				Resource pomXmlResource = resourceSet.getResource(pomURI, true);
				for (EObject root: pomXmlResource.getContents()) {
					Project project = (Project) root;
					System.out.println(project.getGroupId());
					System.out.println(project.getArtifactId());
					System.out.println(project.getVersion());
					System.out.println(project.getName());			
					System.out.println(project.getDescription());			
				}		
			}
		}		
	}	
		
	@Test
	public void testLoadTreeResource() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xml", new MavenResourceFactory());
		
		String accessToken = System.getenv("GITLAB_ACCESS_TOKEN");
		if (!Util.isBlank(accessToken)) {	
			try (GitLabApiProvider gitLabApiProvider = new GitLabApiProvider("https://gitlab.com/", accessToken)) {
				GitLabURIHandler gitLabURIHandler = new GitLabURIHandler(gitLabApiProvider.getGitLabApi());				
				URI resourceURI = URI.createHierarchicalURI(
						GitLabURIHandler.GITLAB_URI_SCHEME, 
						"48523784", 
						null, 
						new String[] { "main", "" }, 
						null, 
						null);
				
				resourceSet.getURIConverter().getURIHandlers().add(0, gitLabURIHandler);
				
				Resource resource = resourceSet.getResource(resourceURI, true);
				resource.save(System.out, null);
				
				NotifierInspector inspector = new NotifierInspector() {

					@Override
					public void inspect(
							Notifier target, 
							BiConsumer<? super Notifier, ? super InspectionResult> inspectionResultConsumer,
							Context context, 
							ProgressMonitor progressMonitor) {
						
						if (target instanceof TreeItem) {
							System.out.println("*** " + target.getClass() + " " + ((TreeItem) target).getName() + " " + ((TreeItem) target).eResource().getURI());
						}
					}
					
				};
				
				// Not visiting blobs
				Predicate<Notifier> predicate = obj -> {
					if (obj instanceof TreeItem) {
						System.out.println(((TreeItem) obj).getName());
						return obj instanceof Tree;
					}
					return true;
				};
				inspector.asContentsInspector(false, predicate).inspect(resource, null, null, null);				
			}
		}
	}
		
	@Test
	public void testInspectJava() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("java", new JavaParserResourceFactory());
		URIHandler fileDirectoryURIHandler = new DirectoryContentFileURIHandler();
		resourceSet.getURIConverter().getURIHandlers().add(0, fileDirectoryURIHandler);
		
		String currentDir = new File(".").getCanonicalPath();
		URI currentDirURI = URI.createFileURI(currentDir).appendSegment("");
		
		Resource dirResource = resourceSet.getResource(currentDirURI, true);
		
//		NotifierInspector inspector = new NotifierInspector() {
//
//			@Override
//			public void inspect(
//					Notifier target, 
//					BiConsumer<? super Notifier, Violation> violationConsumer,
//					Context context, 
//					ProgressMonitor progressMonitor) {
//				
//				if (target instanceof Method) {
//					Method method = (Method) target;
//					System.out.println(method.getName());
//					Comment comment = method.getComment();
//					if (comment != null) {
//						System.out.println(comment.getComment());
//					}
//				}
//			}
//			
//		};
		
		ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		Inspector<Object> inspector = Inspector.load(null, progressMonitor);
		
		// Visiting only Java 
		Predicate<Notifier> predicate = obj -> {
			if (obj instanceof TreeItem) {
				return obj instanceof Tree || ((TreeItem) obj).getName().endsWith(".java");
			}
			return true;
		};
		NotifierInspector notifierInspector = NotifierInspector.adapt(inspector);
		notifierInspector
			.asContentsInspector(false, predicate)
			.inspect(
					dirResource, 
					this::consumeInspectionResult, 
					Context.EMPTY_CONTEXT, 
					progressMonitor);				
	}
	
	protected void consumeInspectionResult(Notifier target, InspectionResult inspectionResult) {
		System.out.println("[" + inspectionResult.eClass().getName() +"] " + inspectionResult.getName());
		System.out.println("\tTarget: " + target);
		Rule rule = inspectionResult.getRule();
		System.out.println("\tRule: " + rule.getName());
		System.out.println("\tRule ID: " + rule.getId());
		Severity severity = inspectionResult.getRule().getSeverity();
		if (severity != null) {
			System.out.println("\tSeverity: " + severity.getId() + " " + severity.getDescription());
		}
		RuleSet ruleSet = (RuleSet) inspectionResult.getRule().eContainer();
		System.out.println("\tRule set: " + ruleSet.getName());
		System.out.println("\tRule set ID: " + ruleSet.getId());		
	}
	
	private static final String MAIN_BRANCH = "main";
	private static final String PROJECT = "54851996"; // "nasdanika-demo/inference-engine";
	private static final String THEORY_BUILDER_PATH = "src/main/java/com/cronopista/ai/builders/TheoryBuilder.java";

	@Test
	public void testTheoryBuilder() throws GitLabApiException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("java", new JavaParserResourceFactory());	
		
		ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		Inspector<Object> inspector = Inspector.load(null, progressMonitor);
		NotifierInspector notifierInspector = NotifierInspector.adapt(inspector);
		NotifierInspector contentsInspector = notifierInspector.asContentsInspector(false, null);
		
		Collection<ResourceAction> actions = new ArrayList<>();
		
		String accessToken = System.getenv("GITLAB_COMMITTER_TOKEN");
		try (GitLabApiProvider gitLabApiProvider = new GitLabApiProvider("https://gitlab.com/", accessToken)) {		
			GitLabURIHandler gitLabURIHandler = new GitLabURIHandler(gitLabApiProvider.getGitLabApi());				
			resourceSet.getURIConverter().getURIHandlers().add(0, gitLabURIHandler);

			// Loading Java resource
			URI mainBranchURI = URI.createURI(GitLabURIHandler.GITLAB_URI_SCHEME + "://" + PROJECT + "/main/");			
			URI resourceURI = URI.createURI(THEORY_BUILDER_PATH).resolve(mainBranchURI);
			Resource resource = resourceSet.getResource(resourceURI, true);
			
			contentsInspector.inspect(
					resource, 
					(notifier, violation) -> {
						violation.eAllContents().forEachRemaining(vc -> {
							if (vc instanceof ResourceAction) {
								actions.add((ResourceAction) vc);
							}
						});
					}, 
					null, 
					progressMonitor);
			
			if (!actions.isEmpty()) {
				// Committing changes
				List<CommitAction> commitActions = new ArrayList<>();
				
				for (ResourceAction action: actions) {
					if (action instanceof CreateTextResourceAction) {
						CreateTextResourceAction createAction = (CreateTextResourceAction) action;
						CommitAction commitAction = new CommitAction()
							.withAction(Action.CREATE)
							.withContent(createAction.getContent())
							.withEncoding(Encoding.TEXT)
							.withFilePath(createAction.getResourceIdentifier());
						
						commitActions.add(commitAction);
					} else {
						throw new UnsupportedOperationException("Unsupported action type: " + action);
					}
				}
				
				String branchName = "theory-builder-inspector-test-3";
				CommitsApi commitApi = gitLabApiProvider.getGitLabApi().getCommitsApi();
				commitApi.createCommit(
						PROJECT,
						branchName, 
						"Inspector-generated test case for TheoryBuilder", 
						MAIN_BRANCH,
			            "Pavel.Vlasov@nasdanika.org", 
			            "Pavel Vlasov", 
			            commitActions);					
				
				// Creating a merge request
				MergeRequestApi mergeRequestApi = gitLabApiProvider.getGitLabApi().getMergeRequestApi();
				MergeRequestParams params = new MergeRequestParams()
					    .withSourceBranch(branchName)
					    .withTargetBranch(MAIN_BRANCH)
					    .withTitle("Inspector-generated test cases")
					    .withDescription("Code automatically generated...");
				mergeRequestApi.createMergeRequest(PROJECT, params);				
			}			
		}				
	}
	
	@Test
	public void testInspectYAML() throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("yml", new YamlResourceFactory(new NcoreYamlHandler()));		
		URIHandler fileDirectoryURIHandler = new DirectoryContentFileURIHandler();
		resourceSet.getURIConverter().getURIHandlers().add(0, fileDirectoryURIHandler);
		
		String currentDir = new File("src/test/resources/org/nasdanika/models/rules/tests/analyzer/tests/yaml").getCanonicalPath();
		URI currentDirURI = URI.createFileURI(currentDir).appendSegment("");
		
		Resource dirResource = resourceSet.getResource(currentDirURI, true);
		
		ProgressMonitor progressMonitor = new PrintStreamProgressMonitor();
		Inspector<Object> inspector = Inspector.load(null, progressMonitor);
		
		// Visiting only YAML 
		Predicate<Notifier> predicate = obj -> {
			if (obj instanceof TreeItem) {
				return obj instanceof Tree || ((TreeItem) obj).getName().endsWith(".yml");
			}
			return true;
		};
		NotifierInspector notifierInspector = NotifierInspector.adapt(inspector);
		notifierInspector
			.asContentsInspector(false, predicate)
			.inspect(
					dirResource, 
					this::consumeInspectionResult, 
					Context.EMPTY_CONTEXT, 
					progressMonitor);				
	}
	
				
}
