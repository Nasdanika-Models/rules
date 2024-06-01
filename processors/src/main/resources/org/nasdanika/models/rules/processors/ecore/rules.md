Nasdanika Rules is a framework for building solutions which inspect data for compliance with a set of rules/standards/principles/guidelines.
For example:

* Inspecting [YAML](https://docs.nasdanika.org/nsd-demo-cli/nsd/inspect-yaml/index.html) configuration files for compliance with a specific semantic model and naming conventions.
* Inspecting [Java](https://java.models.nasdanika.org/) sources or bytecode for compliance with organization-specific guidelines.
* Inspecting [GitLab](https://gitlab.models.nasdanika.org/) repository structure or contents. For example, checking for compliance with branching strategies or for Maven dependencies similar to [Dependabot](https://github.com/dependabot), but for internal dependencies such shared libraries. Dependency violations may contain actions to update dependencies, create a merge request, and, say create an issue in the organization's issue tracker, add to backlog and assign to a [code owner](https://gitlab.models.nasdanika.org/references/eSubpackages/codeowners/index.html).
* Inspecting [PDF](https://pdf.models.nasdanika.org/index.html) or [Excel](https://excel.models.nasdanika.org/) files.  
* Inspecting an organization model for, say, span or control or team size and structure.

The below diagram shows the key concepts of the framework and their relationships:

```drawio-resource
rules.drawio
```

Green shapes represent Ecore model elements, blue shapes represent Java-only concepts.

* [Action](references/eClassifiers/Action/index.html) - rules and violations may define actions to be taken to comply with the rule or address a violation. Some actions may be automatically executable. There are many action flavors, see the [diagram](diagram.html) for more details.
* [Failure](references/eClassifiers/Failure/index.html) - inspection result which indicates that the inspection was not completed correctly. For example, inspection code could throw an exception. 
* [Inspectable](references/eClassifiers/Inspectable/index.html) - base class for things to be inspected. Container of waivers and inspection results. Inspectors can inspect any Java object, Inspectable is a way to store inspection result.
* [Inspection Result](references/eClassifiers/InspectionResult/index.html) - result of inspection. Failure or Violation.
* [Inspector](https://javadoc.io/doc/org.nasdanika.models.rules/model/latest/org.nasdanika.models.rules/org/nasdanika/models/rules/Inspector.html) - inspects a Java object and reports results. Multiple inspectors may be composed into a single inspector. An inspector can be associated with (enforce) zero or more Rules. 
* [Inspector Set](https://javadoc.io/doc/org.nasdanika.models.rules/model/latest/org.nasdanika.models.rules/org/nasdanika/models/rules/reflection/InspectorSet.html) - a collection of inspector created by reflective introspection of annotated Java classes and method. A composite Inspector.
* [Rule](references/eClassifiers/Rule/index.html) - defines the expected state of something, principle/standard. A rule may have zero or more inspectors enforcing the rule. 
* [Rule Set](references/eClassifiers/RuleSet/index.html) - a collection of rules. Rule Sets may form an inheritance hierarchy. E.g. a team rule set may inherit from organization rule sets for technologies used by the team. 
* [Severity](references/eClassifiers/Severity/index.html) - Rules may be assigned severity. E.g. "Error" or "Warning". 
* [Violation](references/eClassifiers/Violation/index.html) - a deviation from a rule reported by an inspector. E.g. a too large agile team, a misspelled key in YAML configuration or wrong value type for a given key.
* [Waiver](references/eClassifiers/Waiver/index.html) (a.k.a. Dispensation) - nullifies (suppresses) violations reported by a rule. Waivers can be permanent - issued for false positives, or temporary - giving a grace period to address a certain violation.

An important thing to note is that rules can be used without inspectors and inspectors can be used without rules.
One usage scenario is to define and publish a set of rules and then gradually introduce inspectors enforcing the rules.

* [Sources](https://github.com/Nasdanika-models/rules)
* [Javadoc](https://javadoc.io/doc/org.nasdanika.models.rules/model/)
* [Medium Story](https://medium.com/nasdanika/nasdanika-rules-1a16889a41c7)

----

[TOC levels=6]

## Rules

Rules and rule sets can be created programmatically, loaded from XMI or YAML, or defined in inspector and inspector set annotations.
This section explains how to define rule sets and rules in YAML and register rule set capability factories.

Below is an example of rule set YAML definition:

```yaml
rules-rule-set:
  uris: nasdanika://rules/demo-rule-set  
  id: demo-rule-set
  name: Demo Rule Set
  documentation:
    content-markdown:
      source:
        content-resource:
          location: demo-rule-set.md
          interpolate: true  
  severities:
    error:
      name: Error      
      documentation:
        content-markdown:
          source:
           content-text: |+2
             Inline markdown ``example``.
             
             * One
             * Two    
  rules:
    my-rule:
      rules-rule:
        name: My rule
        severity: nasdanika://rules/demo-rule-set/severities/error
```

Consult [rule set load specification](references/eClassifiers/RuleSet/load-specification.html) for supported configuration keys.
See [Markdown](https://exec.models.nasdanika.org/references/eSubpackages/content/references/eClassifiers/Markdown/index.html) for details regarding how to write markdown documentation.

Rule sets can be registered as capabilities to make them available to reflective inspectors.
To register a rule set create a class extending [RuleSetCapabilityFactory](https://javadoc.io/doc/org.nasdanika.models.rules/model/latest/org.nasdanika.models.rules/org/nasdanika/models/rules/util/RuleSetCapabilityFactory.html):

```java
public class DemoRuleSetCapabilityFactory extends RuleSetCapabilityFactory {

	@Override
	protected URI getResourceSetURI() {
		return URI.createURI("demo-rule-set.yml").resolve(Util.createClassURI(getClass()));
	}

}
```

The above factory loads rule set from a class loader resource.
Then open the package which contains rule set definition and add ``provides`` to ``module-info.java``:

```java
opens <rule set package>;

provides CapabilityFactory with DemoRuleSetCapabilityFactory;
```

After that rule set and its rules can be referenced from reflective inspectors, used by CLI commands to list available rule sets and generate documentation, and loaded programmatically as shown below:

```java
CapabilityLoader capabilityLoader = new CapabilityLoader();
ProgressMonitor progressMonitor = ...
Iterable<CapabilityProvider<Object>> ruleSetProviders = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(RuleSet.class), progressMonitor);
for (CapabilityProvider<Object> provider: ruleSetProviders) {
	provider.getPublisher().subscribe(ruleSetConsumer, errorConsumer);
}
``` 

## Inspectors

Inspectors implement [Inspector](https://javadoc.io/doc/org.nasdanika.models.rules/model/latest/org.nasdanika.models.rules/org/nasdanika/models/rules/Inspector.html) interface. 
They can be created by "traditional" means of implementing ``Inspector`` interfaces and by using [Inspector](https://javadoc.io/doc/org.nasdanika.models.rules/model/latest/org.nasdanika.models.rules/org/nasdanika/models/rules/reflection/Inspector.html) annotation. 
The "traditional" way is kinda obvious, so this section focuses on how to create inspectors using annotations and register then as capabilities.

```java
// Name is derived from the class name
@RuleSet("""		
		severities:
		  error:
		    name: Error
		    description: Artifacts with this severity are not allowed to be further processed (e.g. deployed, published to a repository) 
		documentation:
		  exec.content.Markdown:
		    source:
		      exec.content.Text: |
		        TODO:
		        
		        * specRef attribute to RuleSet and Rule - support of loading from classloader resources 
		        * Generation of HTML documentation
		""")
public class DemoInspectors {
	
	@Inspector(value = """
			name: Invalid YAML
			documentation:
			  exec.content.Markdown:
			    source:
			      exec.content.Text: |
			        YAML with syntax errors, e.g. duplicate keys.
			""",
			severity = "error",
			condition = "!errors.isEmpty()") 	
	public Collection<String> invalidYaml(YamlResource yamlResource) {
		return yamlResource.getErrors().stream().map(Diagnostic::getMessage).toList();
	}
	
	@Inspector(rule = "nasdanika://rules/demo-rule-set/rules/my-rule")
	public String myRuleInspector(YamlResource yamlResource) {
		return "My finding";
	}
	
}
```

In the above snippet the class is a collection of inspector methods.
It is annotated with [RuleSet](https://javadoc.io/doc/org.nasdanika.models.rules/model/latest/org.nasdanika.models.rules/org/nasdanika/models/rules/reflection/RuleSet.html) annotation which 
defines an in-line rule set. 
``invalidYaml`` is annotated with Inspector annotation which contains in-line rule definition.
``myRuleInspector`` is also annotated with Inspector annotation, but references an externally defined rule by its logical URI - ``nasdanika://rules/demo-rule-set/rules/my-rule``.

Type of the first parameter of inspector methods defines the inspection target type, ``YamlResource`` in the above example. 
Inspector set dispatches targets it inspects to compatible methods.
Inspector methods may have parameters compatible with the below types in any order:

* ``BiPredicate`` - takes inspected object and InspectionResult. Can be used if the inspector reports more than one finding or findings shall be associated an object other than the target.
* [Context](https://javadoc.io/doc/org.nasdanika.core/common/latest/org.nasdanika.common/org/nasdanika/common/Context.html) - can be used to configure inspector or provide helper objects. 
* [ProgressMonitor](https://javadoc.io/doc/org.nasdanika.core/common/latest/org.nasdanika.common/org/nasdanika/common/ProgressMonitor.html) - to report progress and check for cancellation.

Return values of non-void inspector methods are processed as follows:

* If the value is an ``Iterator``, ``Iterable``, ``Stream``, or array then it is iterated and each element is processed as explained here
* If the value is an instance of ``InspectionResult`` (``Violation`` or ``Failure``) then it is used AS-IS
* If the value is a ``String`` then it is wrapped into a ``Violation``. The string value is used as the violation name. The violation is associated with the inspector rule.

If an inspector method throws an exception, it is wrapped into a ``Failure``.

To register an inspector, create a subclass of [InspectorCapabilityFactory](https://javadoc.io/doc/org.nasdanika.models.rules/model/latest/org.nasdanika.models.rules/org/nasdanika/models/rules/InspectorCapabilityFactory.html):

```java
public class ReflectiveInspectorFactory extends InspectorCapabilityFactory<Object> {

	@Override
	protected CompletionStage<Iterable<CapabilityProvider<Inspector<Object>>>> createService(
			Class<Inspector<Object>> serviceType, 
			Predicate<Inspector<Object>> serviceRequirement,
			BiFunction<Object, ProgressMonitor, CompletionStage<Iterable<CapabilityProvider<Object>>>> resolver,
			ProgressMonitor progressMonitor) {

		Inspector<Object> inspector = new InspectorSet(
			RuleManager.LOADING_RULE_MANAGER, 
			serviceRequirement,
			false, 
			progressMonitor, 
			new DemoInspectors());
		
		return serviceRequirement == null || serviceRequirement.test(inspector) ? wrap(inspector) : empty();
	}

}
```

and add ``opens`` and ``provides`` to ``module-info.java``:

```java
opens <inspectors package> to org.nasdanika.common; // For inspector reflection
	
provides CapabilityFactory with <factory class>;
```

Registered inspectors can be loaded by calling ``Inspector.load()``. 
This method can load all registered inspectors or inspectors matching a predicate, e.g. enforcing rules from a specific  rule set.

Inspectors are responsible for traversing (visiting) their targets and shall be aware of the targets' internal structure. 
[NotifierInspector](https://javadoc.io/doc/org.nasdanika.models.rules/model/latest/org.nasdanika.models.rules/org/nasdanika/models/rules/NotifierInspector.html) is aware of internal structures
of [Notifiers](https://javadoc.io/static/org.eclipse.emf/org.eclipse.emf.common/2.28.0/org/eclipse/emf/common/notify/Notifier.html) - [ResourceSet](https://javadoc.io/static/org.eclipse.emf/org.eclipse.emf.ecore/2.33.0/org/eclipse/emf/ecore/resource/ResourceSet.html), [Resource](https://javadoc.io/static/org.eclipse.emf/org.eclipse.emf.ecore/2.33.0/org/eclipse/emf/ecore/resource/Resource.html), [EObject](https://javadoc.io/static/org.eclipse.emf/org.eclipse.emf.ecore/2.33.0/org/eclipse/emf/ecore/EObject.html).
To inspect notifiers:

* Create an inspector compatible with Notifier
* Adapt it to NotifierInspector with ``NotifierInspector.adapt()``
* Obtain content inspector by calling ``asContentInspector()``
* Call ``inspect``

```java
Inspector<Object> inspector = loadInspector(progressMonitor.split("Loading Inspector", 1));
NotifierInspector notifierInspector = NotifierInspector.adapt(inspector);
Resource inputResource = resourceSet.getResource(input, true); // Notifier to inspect
notifierInspector
	.asContentsInspector(parallel, createPredicate(input))
	.inspect(
		inputResource, 
		inspectionResultConsumer, 
		context, 
		inputProgressMonitor);					
```

## CLI

[``org.nasdanika.models.rules.cli``](https://javadoc.io/doc/org.nasdanika.models.rules/cli) module provides several concrete and abstract command classes and mix-ins for building commands which deal with rule sets, rules, and inspectors.

For concrete classes see [Nasdanika CLI rules documentation](https://docs.nasdanika.org/nsd-cli/nsd/rules/index.html). 
Some abstract classes are outlined below, consult JavaDoc for more details.

### AbstractRuleCommand

This command provides options to include and exclude rules and rule sets.
All options can be specified more than once.

* ``--exclude-rule`` - URI of a rule to exclude from, say, inspection. 
* ``--include-rule`` - URI of a rule to include to, say, inspection. 
* ``--exclude-rule-set`` - URI of a rule set to exclude from, say, inspection. 
* ``--include-rule-set`` - URI of a rule set to include to, say, inspection. 

If neither of ``--include-rule`` or ``--include-rule-set`` options are specified, then all rules and rule sets are included by default
unless they are excluded by one of exclude options. 
Include and exclude options can be used together. 
For example, you may include a rule set and then exclude some rules from it.

### AbstractInspectorCommand

This command extends AbstractRuleCommand. 
It loads registered inspectors using ``Inspector.load()`` and includes only inspectors for matching rules and rule sets.

This command can be used as a base for commands which generate documentation about available rules and rule sets.

Below is a fragment of the [list-rules](https://docs.nasdanika.org/nsd-demo-cli/nsd/list-rules/index.html) command which extends ``AbstractInspectorCommand``:

```java
@Command(
		description = "Lists available rules",
		name = "list-inspectable-rules",
		versionProvider = ModuleVersionProvider.class,
		mixinStandardHelpOptions = true)
@ParentCommands(RootCommand.class)
public class ListInspectableRulesCommand extends AbstractInspectorCommand {

	...	

	@Override
	public Integer call() throws Exception {
		ProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(1);
		Inspector<Object> inspector = loadInspector(progressMonitor);
		Map<EObject, List<Rule>> grouped = Util.groupBy(inspector.getRules(), EObject::eContainer);
		if (output == null) {
			generateReport(grouped, System.out, progressMonitor);
		} else {
			try (PrintStream out = new PrintStream(output)) {
				generateReport(grouped, out, progressMonitor);
			} catch (FileNotFoundException e) {
				throw new NasdanikaException(e);
			}
		}
		return 0;
	}
	
	...
	
}
```

### AbstractInspectionCommand

This command extends ``AbstractInspectorCommand`` and provides base functionality for inspecting resources loaded from URI's and their contents.

In addition to rule and rule set inclusion/exclusion provided by ``AbstractRuleCommand`` this class provides the following options: 

* ``-e``, ``--exclude-resource`` - An [Ant pattern](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/util/AntPathMatcher.html) of resources to exclude from inspection. The pattern is matched against the resource path computed relative to the root resource. For example, ``dev/*.yml`` - exclude YAML files in the ``dev`` folder. This option can be specified multiple times.
* ``-i``, ``--include-resource`` - An Ant pattern for resources to include. This option can be specified multiple times.
* ``--exclude-type`` - model type to exclude from inspection. For example, exclude constructors or field declarations from inspection of Java code. This option can be specified multiple times. Matching includes super types, i.e. excluding [Type](https://java.models.nasdanika.org/references/eClassifiers/Type/index.html) would exclude its sub-types as well - Class, Interface, ... Type can be specified in the following ways:
    * Class name, e.g. ``Type``
    * Qualified class name, e.g. ``java.Type``
    * URI - ``<EPackage NS URI>#//<Class name``, e.g. ``ecore://nasdanika.org/models/java#//Type``
* ``--include-type`` - model type to include. This option can be specified multiple times. Can be combined with type exclusion. For example, you may exclude a super-type, but include one of its sub-types. Say, exclude types, but include interfaces. Or, the opposite - include types, but exclude interfaces.
* ``-f``, ``--fail-on`` - Names of severities to fail on (return non-zero exit code). E.g. ``Error``. This option can be specified multiple times.
* ``--parallel`` - Perform inspection in multiple threads.
* ``--stop-on-first-fail`` - stop inspection on first failure - a ``Violation`` with severity specified in ``--fail-on`` or a ``Failure``. This option can be used in builds/pipelines to fail fast. 
* ``--limit`` - Maximum number of results to report. Stop inspection once the limit is reached. This option can be used, for example, to gradually address technical debt - collect a specified number of things to work on in the next iteration (e.g. sprint).

Subclasses must implement ``getInputs()`` method and may override ``createResourceSet()`` method to register resource factories, adapter factories, or URI handlers as shown below in a fragment of [inspect-yaml](https://docs.nasdanika.org/nsd-demo-cli/nsd/inspect-yaml/index.html) command:

```java
@Command(
		description = "Demo of YAML inspection",
		name = "inspect-yaml",
		versionProvider = ModuleVersionProvider.class,
		mixinStandardHelpOptions = true)
@ParentCommands(RootCommand.class)
public class InspectYamlCommand extends AbstractInspectionCommand {
	
	@Parameters(description = {
			"Files and directories",
			"to inspect"
			},
			arity = "1..*")
	File[] inputs;	

	@Override
	protected List<URI> getInputs() {
		List<URI> ret = new ArrayList<>();
		for (File input: inputs) {
			URI uri = URI.createFileURI(input.getAbsolutePath());
			if (input.isDirectory()) {
				uri = uri.appendSegment("");
			}
			ret.add(uri);
		}
		return ret;
	}

	...	
	
	@Override
	protected ResourceSet createResourceSet(ProgressMonitor progressMonitor) {
		ResourceSet resourceSet = super.createResourceSet(progressMonitor);
		// Basic YAML. Add semantic handlers for your problem domain as needed (you'd need to create them). 
		YamlResourceFactory yamlResourceFactory = new YamlResourceFactory(new NcoreYamlHandler());
		Map<String, Object> extensionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
		extensionToFactoryMap.put("yml", yamlResourceFactory);
		extensionToFactoryMap.put("yaml", yamlResourceFactory);
		
		// To load directories as resources in order to traverse them
		resourceSet.getURIConverter().getURIHandlers().add(0, new DirectoryContentFileURIHandler()); 
		return resourceSet;
	}

	@Override
	protected boolean isIncluded(String path) {
		String[] includes = getResourceIncludes();
		if (includes == null) {
			return path.endsWith(".yml") || path.endsWith(".yaml");
		}
		return super.isIncluded(path);
	}

	...
}
```

