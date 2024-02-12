package org.nasdanika.models.rules.tests.analyzer.tests;

import java.io.File;
import java.io.IOException;
import java.util.ServiceLoader;
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
import org.junit.jupiter.api.Test;
import org.nasdanika.common.Context;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Util;
import org.nasdanika.models.gitlab.util.GitLabApiProvider;
import org.nasdanika.models.gitlab.util.GitLabURIHandler;
import org.nasdanika.models.java.util.JavaParserResourceFactory;
import org.nasdanika.models.maven.Project;
import org.nasdanika.models.maven.util.MavenResourceFactory;
import org.nasdanika.models.rules.Inspector;
import org.nasdanika.models.rules.NotifierInspector;
import org.nasdanika.models.rules.Violation;
import org.nasdanika.ncore.Tree;
import org.nasdanika.ncore.TreeItem;
import org.nasdanika.ncore.util.DirectoryContentFileURIHandler;

/**
 * Tests of analyzers
 */
public class TestAnalyzers {
	
	@Test
	public void tesInspectorFactory() {
		Iterable<Inspector.Factory> inspectorFactories = ServiceLoader.load(Inspector.Factory.class);
		for (Inspector.Factory rsf: inspectorFactories) {
			System.out.println(rsf);
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
							BiConsumer<? super Notifier, Violation> violationConsumer,
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
		
		Inspector<Object> inspector = Inspector.load(progressMonitor);
		
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
					this::consumeViolation, 
					Context.EMPTY_CONTEXT, 
					progressMonitor);				
	}
	
	protected void consumeViolation(Notifier target, Violation violation) {
		System.out.println(target + " -> " + violation);
	}
				
}
