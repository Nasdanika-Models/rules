package org.nasdanika.models.rules.tests.analyzer.tests;

import java.util.ServiceLoader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.jupiter.api.Test;
import org.nasdanika.common.Util;
import org.nasdanika.models.gitlab.util.GitLabURIHandler;
import org.nasdanika.models.maven.Project;
import org.nasdanika.models.maven.util.MavenResourceFactory;
import org.nasdanika.models.rules.Inspector;

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
			try (GitLabURIHandler gitLabURIHandler = new GitLabURIHandler("https://gitlab.com/", accessToken)) {
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
				
}
