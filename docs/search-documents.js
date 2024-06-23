var searchDocuments = {"references/eClassifiers/CreateResourceAction/inheritance.html":{"path":"CreateResourceAction/Inheritance","action-uuid":"9c5b4ac7-bcce-4fe0-8f2b-595035cc43e4","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/Severity/inheritance.html":{"path":"Severity/Inheritance","action-uuid":"11cfa2f3-9f6d-4218-a91d-9534f258e061","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/BinaryResourceAction/inheritance.html":{"path":"BinaryResourceAction/Inheritance","action-uuid":"6cfdbd21-e6a1-4b65-822d-32a33274bab0","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/MoveResourceAction/references/eStructuralFeatures/newIdentifier/index.html":{"path":"MoveResourceAction/Attributes/newIdentifier","action-uuid":"f32d9f56-7c2c-4fe0-9a21-7956d54c3bea","title":"newIdentifier","content":"New identifier"},"references/eClassifiers/TextResourceAction/inheritance.html":{"path":"TextResourceAction/Inheritance","action-uuid":"b7642737-d1e4-4bb9-ade9-2ed7e7186fcd","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/Violation/references/eStructuralFeatures/actions/index.html":{"path":"Violation/References/actions","action-uuid":"801d2dbc-86c1-4fb2-9fd2-968fa9998ae4","title":"actions","content":"Actions to be taken to address the violation"},"references/eClassifiers/DeleteResourceAction/inheritance.html":{"path":"DeleteResourceAction/Inheritance","action-uuid":"6a930a90-67f5-4b4a-85d3-36a44ec1e5d3","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/InspectionResult/inheritance.html":{"path":"InspectionResult/Inheritance","action-uuid":"a46c3a28-e976-4d1e-8a22-8f2887338670","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eSubpackages/java/references/eClassifiers/CompilationUnitAction/inheritance.html":{"path":"java/CompilationUnitAction/Inheritance","action-uuid":"f48e4921-f6f0-4926-868a-30d3b7d53ad7","title":"Inheritance","content":"Supertypes Subtypes  "},"index.html":{"action-uuid":"10bca54d-3ace-4fcf-a241-a613aac429da","title":"Rules","content":"Nasdanika Rules is a framework for building solutions which inspect data for compliance with a set of rules/standards/principles/guidelines. For example: Inspecting YAML configuration files for compliance with a specific semantic model and naming conventions. Inspecting Java sources or bytecode for compliance with organization-specific guidelines. Inspecting GitLab repository structure or contents. For example, checking for compliance with branching strategies or for Maven dependencies similar to Dependabot, but for internal dependencies such shared libraries. Dependency violations may contain actions to update dependencies, create a merge request, and, say create an issue in the organization&rsquo;s issue tracker, add to backlog and assign to a code owner. Inspecting PDF or Excel files. Inspecting an organization model for, say, span or control or team size and structure. The below diagram shows the key concepts of the framework and their relationships: Green shapes represent Ecore model elements, blue shapes represent Java-only concepts. Action - rules and violations may define actions to be taken to comply with the rule or address a violation. Some actions may be automatically executable. There are many action flavors, see the diagram for more details. Failure - inspection result which indicates that the inspection was not completed correctly. For example, inspection code could throw an exception. Inspectable - base class for things to be inspected. Container of waivers and inspection results. Inspectors can inspect any Java object, Inspectable is a way to store inspection result. Inspection Result - result of inspection. Failure or Violation. Inspector - inspects a Java object and reports results. Multiple inspectors may be composed into a single inspector. An inspector can be associated with (enforce) zero or more Rules. Inspector Set - a collection of inspector created by reflective introspection of annotated Java classes and method. A composite Inspector. Rule - defines the expected state of something, principle/standard. A rule may have zero or more inspectors enforcing the rule. Rule Set - a collection of rules. Rule Sets may form an inheritance hierarchy. E.g. a team rule set may inherit from organization rule sets for technologies used by the team. Severity - Rules may be assigned severity. E.g. &ldquo;Error&rdquo; or &ldquo;Warning&rdquo;. Violation - a deviation from a rule reported by an inspector. E.g. a too large agile team, a misspelled key in YAML configuration or wrong value type for a given key. Waiver (a.k.a. Dispensation) - nullifies (suppresses) violations reported by a rule. Waivers can be permanent - issued for false positives, or temporary - giving a grace period to address a certain violation. An important thing to note is that rules can be used without inspectors and inspectors can be used without rules. One usage scenario is to define and publish a set of rules and then gradually introduce inspectors enforcing the rules. Sources Javadoc Medium Story Rules Inspectors CLI AbstractRuleCommand AbstractInspectorCommand AbstractInspectionCommand Rules Rules and rule sets can be created programmatically, loaded from XMI or YAML, or defined in inspector and inspector set annotations. This section explains how to define rule sets and rules in YAML and register rule set capability factories. Below is an example of rule set YAML definition: rules-rule-set:\n  uris: nasdanika://rules/demo-rule-set  \n  id: demo-rule-set\n  name: Demo Rule Set\n  documentation:\n    content-markdown:\n      source:\n        content-resource:\n          location: demo-rule-set.md\n          interpolate: true  \n  severities:\n    error:\n      name: Error      \n      documentation:\n        content-markdown:\n          source:\n           content-text: |+2\n             Inline markdown ``example``.\n             \n             * One\n             * Two    \n  rules:\n    my-rule:\n      rules-rule:\n        name: My rule\n        severity: nasdanika://rules/demo-rule-set/severities/error\n Consult rule set load specification for supported configuration keys. See Markdown for details regarding how to write markdown documentation. Rule sets can be registered as capabilities to make them available to reflective inspectors. To register a rule set create a class extending RuleSetCapabilityFactory: public class DemoRuleSetCapabilityFactory extends RuleSetCapabilityFactory {\n\n\t@Override\n\tprotected URI getResourceSetURI() {\n\t\treturn URI.createURI(&quot;demo-rule-set.yml&quot;).resolve(Util.createClassURI(getClass()));\n\t}\n\n}\n The above factory loads rule set from a class loader resource. Then open the package which contains rule set definition and add provides to module-info.java: opens &lt;rule set package&gt;;\n\nprovides CapabilityFactory with DemoRuleSetCapabilityFactory;\n After that rule set and its rules can be referenced from reflective inspectors, used by CLI commands to list available rule sets and generate documentation, and loaded programmatically as shown below: CapabilityLoader capabilityLoader = new CapabilityLoader();\nProgressMonitor progressMonitor = ...\nIterable&lt;CapabilityProvider&lt;Object&gt;&gt; ruleSetProviders = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(RuleSet.class), progressMonitor);\nfor (CapabilityProvider&lt;Object&gt; provider: ruleSetProviders) {\n\tprovider.getPublisher().subscribe(ruleSetConsumer, errorConsumer);\n}\n Inspectors Inspectors implement Inspector interface. They can be created by &ldquo;traditional&rdquo; means of implementing Inspector interfaces and by using Inspector annotation. The &ldquo;traditional&rdquo; way is kinda obvious, so this section focuses on how to create inspectors using annotations and register then as capabilities. // Name is derived from the class name\n@RuleSet(&quot;&quot;&quot;\t\t\n\t\tseverities:\n\t\t  error:\n\t\t    name: Error\n\t\t    description: Artifacts with this severity are not allowed to be further processed (e.g. deployed, published to a repository) \n\t\tdocumentation:\n\t\t  exec.content.Markdown:\n\t\t    source:\n\t\t      exec.content.Text: |\n\t\t        TODO:\n\t\t        \n\t\t        * specRef attribute to RuleSet and Rule - support of loading from classloader resources \n\t\t        * Generation of HTML documentation\n\t\t&quot;&quot;&quot;)\npublic class DemoInspectors {\n\t\n\t@Inspector(value = &quot;&quot;&quot;\n\t\t\tname: Invalid YAML\n\t\t\tdocumentation:\n\t\t\t  exec.content.Markdown:\n\t\t\t    source:\n\t\t\t      exec.content.Text: |\n\t\t\t        YAML with syntax errors, e.g. duplicate keys.\n\t\t\t&quot;&quot;&quot;,\n\t\t\tseverity = &quot;error&quot;,\n\t\t\tcondition = &quot;!errors.isEmpty()&quot;) \t\n\tpublic Collection&lt;String&gt; invalidYaml(YamlResource yamlResource) {\n\t\treturn yamlResource.getErrors().stream().map(Diagnostic::getMessage).toList();\n\t}\n\t\n\t@Inspector(rule = &quot;nasdanika://rules/demo-rule-set/rules/my-rule&quot;)\n\tpublic String myRuleInspector(YamlResource yamlResource) {\n\t\treturn &quot;My finding&quot;;\n\t}\n\t\n}\n In the above snippet the class is a collection of inspector methods. It is annotated with RuleSet annotation which defines an in-line rule set. invalidYaml is annotated with Inspector annotation which contains in-line rule definition. myRuleInspector is also annotated with Inspector annotation, but references an externally defined rule by its logical URI - nasdanika://rules/demo-rule-set/rules/my-rule. Type of the first parameter of inspector methods defines the inspection target type, YamlResource in the above example. Inspector set dispatches targets it inspects to compatible methods. Inspector methods may have parameters compatible with the below types in any order: BiPredicate - takes inspected object and InspectionResult. Can be used if the inspector reports more than one finding or findings shall be associated an object other than the target. Context - can be used to configure inspector or provide helper objects. ProgressMonitor - to report progress and check for cancellation. Return values of non-void inspector methods are processed as follows: If the value is an Iterator, Iterable, Stream, or array then it is iterated and each element is processed as explained here If the value is an instance of InspectionResult (Violation or Failure) then it is used AS-IS If the value is a String then it is wrapped into a Violation. The string value is used as the violation name. The violation is associated with the inspector rule. If an inspector method throws an exception, it is wrapped into a Failure. To register an inspector, create a subclass of InspectorCapabilityFactory: public class ReflectiveInspectorFactory extends InspectorCapabilityFactory&lt;Object&gt; {\n\n\t@Override\n\tprotected CompletionStage&lt;Iterable&lt;CapabilityProvider&lt;Inspector&lt;Object&gt;&gt;&gt;&gt; createService(\n\t\t\tClass&lt;Inspector&lt;Object&gt;&gt; serviceType, \n\t\t\tPredicate&lt;Inspector&lt;Object&gt;&gt; serviceRequirement,\n\t\t\tBiFunction&lt;Object, ProgressMonitor, CompletionStage&lt;Iterable&lt;CapabilityProvider&lt;Object&gt;&gt;&gt;&gt; resolver,\n\t\t\tProgressMonitor progressMonitor) {\n\n\t\tInspector&lt;Object&gt; inspector = new InspectorSet(\n\t\t\tRuleManager.LOADING_RULE_MANAGER, \n\t\t\tserviceRequirement,\n\t\t\tfalse, \n\t\t\tprogressMonitor, \n\t\t\tnew DemoInspectors());\n\t\t\n\t\treturn serviceRequirement == null || serviceRequirement.test(inspector) ? wrap(inspector) : empty();\n\t}\n\n}\n and add opens and provides to module-info.java: opens &lt;inspectors package&gt; to org.nasdanika.common; // For inspector reflection\n\t\nprovides CapabilityFactory with &lt;factory class&gt;;\n Registered inspectors can be loaded by calling Inspector.load(). This method can load all registered inspectors or inspectors matching a predicate, e.g. enforcing rules from a specific rule set. Inspectors are responsible for traversing (visiting) their targets and shall be aware of the targets&rsquo; internal structure. NotifierInspector is aware of internal structures of Notifiers - ResourceSet, Resource, EObject. To inspect notifiers: Create an inspector compatible with Notifier Adapt it to NotifierInspector with NotifierInspector.adapt() Obtain content inspector by calling asContentInspector() Call inspect Inspector&lt;Object&gt; inspector = loadInspector(progressMonitor.split(&quot;Loading Inspector&quot;, 1));\nNotifierInspector notifierInspector = NotifierInspector.adapt(inspector);\nResource inputResource = resourceSet.getResource(input, true); // Notifier to inspect\nnotifierInspector\n\t.asContentsInspector(parallel, createPredicate(input))\n\t.inspect(\n\t\tinputResource, \n\t\tinspectionResultConsumer, \n\t\tcontext, \n\t\tinputProgressMonitor);\t\t\t\t\t\n CLI org.nasdanika.models.rules.cli module provides several concrete and abstract command classes and mix-ins for building commands which deal with rule sets, rules, and inspectors. For concrete classes see Nasdanika CLI rules documentation. Some abstract classes are outlined below, consult JavaDoc for more details. AbstractRuleCommand This command provides options to include and exclude rules and rule sets. All options can be specified more than once. --exclude-rule - URI of a rule to exclude from, say, inspection. --include-rule - URI of a rule to include to, say, inspection. --exclude-rule-set - URI of a rule set to exclude from, say, inspection. --include-rule-set - URI of a rule set to include to, say, inspection. If neither of --include-rule or --include-rule-set options are specified, then all rules and rule sets are included by default unless they are excluded by one of exclude options. Include and exclude options can be used together. For example, you may include a rule set and then exclude some rules from it. AbstractInspectorCommand This command extends AbstractRuleCommand. It loads registered inspectors using Inspector.load() and includes only inspectors for matching rules and rule sets. This command can be used as a base for commands which generate documentation about available rules and rule sets. Below is a fragment of the list-rules command which extends AbstractInspectorCommand: @Command(\n\t\tdescription = &quot;Lists available rules&quot;,\n\t\tname = &quot;list-inspectable-rules&quot;,\n\t\tversionProvider = ModuleVersionProvider.class,\n\t\tmixinStandardHelpOptions = true)\n@ParentCommands(RootCommand.class)\npublic class ListInspectableRulesCommand extends AbstractInspectorCommand {\n\n\t...\t\n\n\t@Override\n\tpublic Integer call() throws Exception {\n\t\tProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(1);\n\t\tInspector&lt;Object&gt; inspector = loadInspector(progressMonitor);\n\t\tMap&lt;EObject, List&lt;Rule&gt;&gt; grouped = Util.groupBy(inspector.getRules(), EObject::eContainer);\n\t\tif (output == null) {\n\t\t\tgenerateReport(grouped, System.out, progressMonitor);\n\t\t} else {\n\t\t\ttry (PrintStream out = new PrintStream(output)) {\n\t\t\t\tgenerateReport(grouped, out, progressMonitor);\n\t\t\t} catch (FileNotFoundException e) {\n\t\t\t\tthrow new NasdanikaException(e);\n\t\t\t}\n\t\t}\n\t\treturn 0;\n\t}\n\t\n\t...\n\t\n}\n AbstractInspectionCommand This command extends AbstractInspectorCommand and provides base functionality for inspecting resources loaded from URI&rsquo;s and their contents. In addition to rule and rule set inclusion/exclusion provided by AbstractRuleCommand this class provides the following options: -e, --exclude-resource - An Ant pattern of resources to exclude from inspection. The pattern is matched against the resource path computed relative to the root resource. For example, dev/*.yml - exclude YAML files in the dev folder. This option can be specified multiple times. -i, --include-resource - An Ant pattern for resources to include. This option can be specified multiple times. --exclude-type - model type to exclude from inspection. For example, exclude constructors or field declarations from inspection of Java code. This option can be specified multiple times. Matching includes super types, i.e. excluding Type would exclude its sub-types as well - Class, Interface, &hellip; Type can be specified in the following ways: Class name, e.g. Type Qualified class name, e.g. java.Type URI - &lt;EPackage NS URI&gt;#//&lt;Class name, e.g. ecore://nasdanika.org/models/java#//Type --include-type - model type to include. This option can be specified multiple times. Can be combined with type exclusion. For example, you may exclude a super-type, but include one of its sub-types. Say, exclude types, but include interfaces. Or, the opposite - include types, but exclude interfaces. -f, --fail-on - Names of severities to fail on (return non-zero exit code). E.g. Error. This option can be specified multiple times. --parallel - Perform inspection in multiple threads. --stop-on-first-fail - stop inspection on first failure - a Violation with severity specified in --fail-on or a Failure. This option can be used in builds/pipelines to fail fast. --limit - Maximum number of results to report. Stop inspection once the limit is reached. This option can be used, for example, to gradually address technical debt - collect a specified number of things to work on in the next iteration (e.g. sprint). Subclasses must implement getInputs() method and may override createResourceSet() method to register resource factories, adapter factories, or URI handlers as shown below in a fragment of inspect-yaml command: @Command(\n\t\tdescription = &quot;Demo of YAML inspection&quot;,\n\t\tname = &quot;inspect-yaml&quot;,\n\t\tversionProvider = ModuleVersionProvider.class,\n\t\tmixinStandardHelpOptions = true)\n@ParentCommands(RootCommand.class)\npublic class InspectYamlCommand extends AbstractInspectionCommand {\n\t\n\t@Parameters(description = {\n\t\t\t&quot;Files and directories&quot;,\n\t\t\t&quot;to inspect&quot;\n\t\t\t},\n\t\t\tarity = &quot;1..*&quot;)\n\tFile[] inputs;\t\n\n\t@Override\n\tprotected List&lt;URI&gt; getInputs() {\n\t\tList&lt;URI&gt; ret = new ArrayList&lt;&gt;();\n\t\tfor (File input: inputs) {\n\t\t\tURI uri = URI.createFileURI(input.getAbsolutePath());\n\t\t\tif (input.isDirectory()) {\n\t\t\t\turi = uri.appendSegment(&quot;&quot;);\n\t\t\t}\n\t\t\tret.add(uri);\n\t\t}\n\t\treturn ret;\n\t}\n\n\t...\t\n\t\n\t@Override\n\tprotected ResourceSet createResourceSet(ProgressMonitor progressMonitor) {\n\t\tResourceSet resourceSet = super.createResourceSet(progressMonitor);\n\t\t// Basic YAML. Add semantic handlers for your problem domain as needed (you'd need to create them). \n\t\tYamlResourceFactory yamlResourceFactory = new YamlResourceFactory(new NcoreYamlHandler());\n\t\tMap&lt;String, Object&gt; extensionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();\n\t\textensionToFactoryMap.put(&quot;yml&quot;, yamlResourceFactory);\n\t\textensionToFactoryMap.put(&quot;yaml&quot;, yamlResourceFactory);\n\t\t\n\t\t// To load directories as resources in order to traverse them\n\t\tresourceSet.getURIConverter().getURIHandlers().add(0, new DirectoryContentFileURIHandler()); \n\t\treturn resourceSet;\n\t}\n\n\t@Override\n\tprotected boolean isIncluded(String path) {\n\t\tString[] includes = getResourceIncludes();\n\t\tif (includes == null) {\n\t\t\treturn path.endsWith(&quot;.yml&quot;) || path.endsWith(&quot;.yaml&quot;);\n\t\t}\n\t\treturn super.isIncluded(path);\n\t}\n\n\t...\n} Inspectable Severity Waiver Action Inspector Inspector Set Inspection Result Rule Rule Set Violation Failure Java Ecore Legend extensions/extends"},"references/eClassifiers/Action/index.html":{"action-uuid":"69ae5261-1460-4a96-b4f2-3593c02d78db","title":"Action","content":"An action to be taken to address a rule violation"},"references/eClassifiers/UpdateTextResourceAction/inheritance.html":{"path":"UpdateTextResourceAction/Inheritance","action-uuid":"f2f526f9-85d2-4841-bcd8-1ace51a2e515","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/ResourceAction/inheritance.html":{"path":"ResourceAction/Inheritance","action-uuid":"16e528f7-cf0a-4857-89ec-86395621e2f9","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/CreateBinaryResourceAction/inheritance.html":{"path":"CreateBinaryResourceAction/Inheritance","action-uuid":"13520ba2-f2cf-425a-bdda-93d84a73bafb","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/UpdateBinaryResourceAction/inheritance.html":{"path":"UpdateBinaryResourceAction/Inheritance","action-uuid":"c5f73bcf-b966-4c4d-a359-b453d82b4049","title":"Inheritance","content":"Supertypes "},"glossary.html":{"action-uuid":"48c8a64e-2704-425d-9065-20984101f6f3","title":"Glossary","content":"Clear Identifier(s) Hide UUID {{data.value.name}} {{data.value[0].value}} {{item.value}}"},"references/eClassifiers/Failure/inheritance.html":{"path":"Failure/Inheritance","action-uuid":"3b0c1fdc-f243-47ab-8f0a-156e1113ca70","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Waiver/inheritance.html":{"path":"Waiver/Inheritance","action-uuid":"6ecbb170-4c5c-4f63-9a7d-7f3731f4ad15","title":"Inheritance","content":"Supertypes "},"references/eSubpackages/java/references/eClassifiers/CompilationUnitAction/index.html":{"path":"java/CompilationUnitAction","action-uuid":"7128c15e-6b0a-4c28-8900-f11490953503","title":"CompilationUnitAction","content":"An action on a compilation unit"},"references/eClassifiers/Rule/references/eStructuralFeatures/actions/index.html":{"path":"Rule/References/actions","action-uuid":"faeed0b5-a597-4587-9f46-d4fb24da6901","title":"actions","content":"Actions to be taken to address rule violations. Rule actions serve as documentation and as templates/prototypes for violation actions."},"references/eClassifiers/UpdateResourceAction/inheritance.html":{"path":"UpdateResourceAction/Inheritance","action-uuid":"b9404fe4-4243-4703-b00f-825b5d5d815b","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eSubpackages/java/references/eClassifiers/CreateCompilationUnitAction/inheritance.html":{"path":"java/CreateCompilationUnitAction/Inheritance","action-uuid":"bbb51bab-e31c-4a7c-9b11-4b377a79d423","title":"Inheritance","content":"Supertypes "},"references/eSubpackages/java/references/eClassifiers/UpdateCompilationUnitAction/inheritance.html":{"path":"java/UpdateCompilationUnitAction/Inheritance","action-uuid":"65a4a48e-67e2-4e8f-8a62-fd23ee75708e","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Action/inheritance.html":{"path":"Action/Inheritance","action-uuid":"1c236cfc-4572-4172-a9dc-14e1eb322495","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/RuleSet/inheritance.html":{"path":"RuleSet/Inheritance","action-uuid":"3e030515-c050-4591-9c80-db02209c3920","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Rule/inheritance.html":{"path":"Rule/Inheritance","action-uuid":"e564ee78-06cb-41a7-9b72-32ca7f0b7893","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/MoveResourceAction/index.html":{"action-uuid":"e70f2a2c-fa51-4326-9f3b-8a8645a7bbb1","title":"MoveResourceAction","content":"Moves (renames) the resources - changes its identifier"},"references/eClassifiers/CreateTextResourceAction/inheritance.html":{"path":"CreateTextResourceAction/Inheritance","action-uuid":"e2ba0ae5-fbd7-4f85-8235-653248d34486","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/ResourceAction/index.html":{"action-uuid":"8fb6e6d6-e8e4-4414-97b6-6cf648bc5f86","title":"ResourceAction","content":"An action on a resource identified by a string identifier, e.g. a path or URI"},"references/eClassifiers/ResourceAction/references/eStructuralFeatures/resourceIdentifier/index.html":{"path":"ResourceAction/Attributes/resourceIdentifier","action-uuid":"07f788bd-f937-4637-9600-a5420ee0648b","title":"resourceIdentifier","content":"Resource identifier - path, URI, &hellip;"},"references/eSubpackages/java/references/eClassifiers/DeleteCompilationUnitAction/inheritance.html":{"path":"java/DeleteCompilationUnitAction/Inheritance","action-uuid":"ab103361-ff96-4a41-8886-16ff15ccb9f6","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/MoveResourceAction/inheritance.html":{"path":"MoveResourceAction/Inheritance","action-uuid":"78bdec86-d532-42df-8f63-1374779b7978","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Violation/inheritance.html":{"path":"Violation/Inheritance","action-uuid":"207ee755-0986-47f8-bcd5-93cf9524085f","title":"Inheritance","content":"Supertypes "}}