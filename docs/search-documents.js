var searchDocuments = {"references/eClassifiers/CreateResourceAction/inheritance.html":{"path":"CreateResourceAction/Inheritance","link-uuid":"32dcedd4-6b00-496d-9f68-e97be8e9fe57","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/Severity/inheritance.html":{"path":"Severity/Inheritance","link-uuid":"108bd5d5-7801-4946-ab68-8223d0350ec3","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/BinaryResourceAction/inheritance.html":{"path":"BinaryResourceAction/Inheritance","link-uuid":"3ecaec99-b014-4100-94d7-f825f625fa55","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/MoveResourceAction/references/eStructuralFeatures/newIdentifier/index.html":{"path":"MoveResourceAction/Attributes/newIdentifier","link-uuid":"4bf3b527-96b6-4ee0-b9ec-d8d884c4ac3d","title":"newIdentifier","content":"New identifier"},"references/eClassifiers/TextResourceAction/inheritance.html":{"path":"TextResourceAction/Inheritance","link-uuid":"228caafb-e07e-447d-8ba9-62c2da16ed59","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/Violation/references/eStructuralFeatures/actions/index.html":{"path":"Violation/References/actions","link-uuid":"30a7f0b7-c61f-46d2-9b2f-45447faed1e6","title":"actions","content":"Actions to be taken to address the violation"},"references/eClassifiers/DeleteResourceAction/inheritance.html":{"path":"DeleteResourceAction/Inheritance","link-uuid":"8e371634-6cdf-4d87-b7c2-87f4c99c8be2","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/InspectionResult/inheritance.html":{"path":"InspectionResult/Inheritance","link-uuid":"f0ca2936-2ca6-401e-98b6-1b1ac39a810d","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eSubpackages/java/references/eClassifiers/CompilationUnitAction/inheritance.html":{"path":"java/CompilationUnitAction/Inheritance","link-uuid":"399d12ef-d5ab-4afb-ab67-927b27fc4500","title":"Inheritance","content":"Supertypes Subtypes  "},"index.html":{"link-uuid":"61f5ada4-9364-4e1b-889e-9a1348644bea","title":"Rules","content":"Nasdanika Rules is a framework for building solutions which inspect data for compliance with a set of rules/standards/principles/guidelines. For example: Inspecting YAML configuration files for compliance with a specific semantic model and naming conventions. Inspecting Java sources or bytecode for compliance with organization-specific guidelines. Inspecting GitLab repository structure or contents. For example, checking for compliance with branching strategies or for Maven dependencies similar to Dependabot, but for internal dependencies such shared libraries. Dependency violations may contain actions to update dependencies, create a merge request, and, say create an issue in the organization&rsquo;s issue tracker, add to backlog and assign to a code owner. Inspecting PDF or Excel files. Inspecting an organization model for, say, span or control or team size and structure. The below diagram shows the key concepts of the framework and their relationships: Green shapes represent Ecore model elements, blue shapes represent Java-only concepts. Action - rules and violations may define actions to be taken to comply with the rule or address a violation. Some actions may be automatically executable. There are many action flavors, see the diagram for more details. Failure - inspection result which indicates that the inspection was not completed correctly. For example, inspection code could throw an exception. Inspectable - base class for things to be inspected. Container of waivers and inspection results. Inspectors can inspect any Java object, Inspectable is a way to store inspection result. Inspection Result - result of inspection. Failure or Violation. Inspector - inspects a Java object and reports results. Multiple inspectors may be composed into a single inspector. An inspector can be associated with (enforce) zero or more Rules. Inspector Set - a collection of inspector created by reflective introspection of annotated Java classes and method. A composite Inspector. Rule - defines the expected state of something, principle/standard. A rule may have zero or more inspectors enforcing the rule. Rule Set - a collection of rules. Rule Sets may form an inheritance hierarchy. E.g. a team rule set may inherit from organization rule sets for technologies used by the team. Severity - Rules may be assigned severity. E.g. &ldquo;Error&rdquo; or &ldquo;Warning&rdquo;. Violation - a deviation from a rule reported by an inspector. E.g. a too large agile team, a misspelled key in YAML configuration or wrong value type for a given key. Waiver (a.k.a. Dispensation) - nullifies (suppresses) violations reported by a rule. Waivers can be permanent - issued for false positives, or temporary - giving a grace period to address a certain violation. An important thing to note is that rules can be used without inspectors and inspectors can be used without rules. One usage scenario is to define and publish a set of rules and then gradually introduce inspectors enforcing the rules. Sources Javadoc Medium Story Rules Inspectors CLI AbstractRuleCommand AbstractInspectorCommand AbstractInspectionCommand Rules Rules and rule sets can be created programmatically, loaded from XMI or YAML, or defined in inspector and inspector set annotations. This section explains how to define rule sets and rules in YAML and register rule set capability factories. Below is an example of rule set YAML definition: rules-rule-set:\n  uris: nasdanika://rules/demo-rule-set  \n  id: demo-rule-set\n  name: Demo Rule Set\n  documentation:\n    content-markdown:\n      source:\n        content-resource:\n          location: demo-rule-set.md\n          interpolate: true  \n  severities:\n    error:\n      name: Error      \n      documentation:\n        content-markdown:\n          source:\n           content-text: |+2\n             Inline markdown ``example``.\n             \n             * One\n             * Two    \n  rules:\n    my-rule:\n      rules-rule:\n        name: My rule\n        severity: nasdanika://rules/demo-rule-set/severities/error\n Consult rule set load specification for supported configuration keys. See Markdown for details regarding how to write markdown documentation. Rule sets can be registered as capabilities to make them available to reflective inspectors. To register a rule set create a class extending RuleSetCapabilityFactory: public class DemoRuleSetCapabilityFactory extends RuleSetCapabilityFactory {\n\n\t@Override\n\tprotected URI getResourceSetURI() {\n\t\treturn URI.createURI(&quot;demo-rule-set.yml&quot;).resolve(Util.createClassURI(getClass()));\n\t}\n\n}\n The above factory loads rule set from a class loader resource. Then open the package which contains rule set definition and add provides to module-info.java: opens &lt;rule set package&gt;;\n\nprovides CapabilityFactory with DemoRuleSetCapabilityFactory;\n After that rule set and its rules can be referenced from reflective inspectors, used by CLI commands to list available rule sets and generate documentation, and loaded programmatically as shown below: CapabilityLoader capabilityLoader = new CapabilityLoader();\nProgressMonitor progressMonitor = ...\nIterable&lt;CapabilityProvider&lt;Object&gt;&gt; ruleSetProviders = capabilityLoader.load(ServiceCapabilityFactory.createRequirement(RuleSet.class), progressMonitor);\nfor (CapabilityProvider&lt;Object&gt; provider: ruleSetProviders) {\n\tprovider.getPublisher().subscribe(ruleSetConsumer, errorConsumer);\n}\n Inspectors Inspectors implement Inspector interface. They can be created by &ldquo;traditional&rdquo; means of implementing Inspector interfaces and by using Inspector annotation. The &ldquo;traditional&rdquo; way is kinda obvious, so this section focuses on how to create inspectors using annotations and register then as capabilities. // Name is derived from the class name\n@RuleSet(&quot;&quot;&quot;\t\t\n\t\tseverities:\n\t\t  error:\n\t\t    name: Error\n\t\t    description: Artifacts with this severity are not allowed to be further processed (e.g. deployed, published to a repository) \n\t\tdocumentation:\n\t\t  exec.content.Markdown:\n\t\t    source:\n\t\t      exec.content.Text: |\n\t\t        TODO:\n\t\t        \n\t\t        * specRef attribute to RuleSet and Rule - support of loading from classloader resources \n\t\t        * Generation of HTML documentation\n\t\t&quot;&quot;&quot;)\npublic class DemoInspectors {\n\t\n\t@Inspector(value = &quot;&quot;&quot;\n\t\t\tname: Invalid YAML\n\t\t\tdocumentation:\n\t\t\t  exec.content.Markdown:\n\t\t\t    source:\n\t\t\t      exec.content.Text: |\n\t\t\t        YAML with syntax errors, e.g. duplicate keys.\n\t\t\t&quot;&quot;&quot;,\n\t\t\tseverity = &quot;error&quot;,\n\t\t\tcondition = &quot;!errors.isEmpty()&quot;) \t\n\tpublic Collection&lt;String&gt; invalidYaml(YamlResource yamlResource) {\n\t\treturn yamlResource.getErrors().stream().map(Diagnostic::getMessage).toList();\n\t}\n\t\n\t@Inspector(rule = &quot;nasdanika://rules/demo-rule-set/rules/my-rule&quot;)\n\tpublic String myRuleInspector(YamlResource yamlResource) {\n\t\treturn &quot;My finding&quot;;\n\t}\n\t\n}\n In the above snippet the class is a collection of inspector methods. It is annotated with RuleSet annotation which defines an in-line rule set. invalidYaml is annotated with Inspector annotation which contains in-line rule definition. myRuleInspector is also annotated with Inspector annotation, but references an externally defined rule by its logical URI - nasdanika://rules/demo-rule-set/rules/my-rule. Type of the first parameter of inspector methods defines the inspection target type, YamlResource in the above example. Inspector set dispatches targets it inspects to compatible methods. Inspector methods may have parameters compatible with the below types in any order: BiPredicate - takes inspected object and InspectionResult. Can be used if the inspector reports more than one finding or findings shall be associated an object other than the target. Context - can be used to configure inspector or provide helper objects. ProgressMonitor - to report progress and check for cancellation. Return values of non-void inspector methods are processed as follows: If the value is an Iterator, Iterable, Stream, or array then it is iterated and each element is processed as explained here If the value is an instance of InspectionResult (Violation or Failure) then it is used AS-IS If the value is a String then it is wrapped into a Violation. The string value is used as the violation name. The violation is associated with the inspector rule. If an inspector method throws an exception, it is wrapped into a Failure. To register an inspector, create a subclass of InspectorCapabilityFactory: public class ReflectiveInspectorFactory extends InspectorCapabilityFactory&lt;Object&gt; {\n\n\t@Override\n\tprotected CompletionStage&lt;Iterable&lt;CapabilityProvider&lt;Inspector&lt;Object&gt;&gt;&gt;&gt; createService(\n\t\t\tClass&lt;Inspector&lt;Object&gt;&gt; serviceType, \n\t\t\tPredicate&lt;Inspector&lt;Object&gt;&gt; serviceRequirement,\n\t\t\tBiFunction&lt;Object, ProgressMonitor, CompletionStage&lt;Iterable&lt;CapabilityProvider&lt;Object&gt;&gt;&gt;&gt; resolver,\n\t\t\tProgressMonitor progressMonitor) {\n\n\t\tInspector&lt;Object&gt; inspector = new InspectorSet(\n\t\t\tRuleManager.LOADING_RULE_MANAGER, \n\t\t\tserviceRequirement,\n\t\t\tfalse, \n\t\t\tprogressMonitor, \n\t\t\tnew DemoInspectors());\n\t\t\n\t\treturn serviceRequirement == null || serviceRequirement.test(inspector) ? wrap(inspector) : empty();\n\t}\n\n}\n and add opens and provides to module-info.java: opens &lt;inspectors package&gt; to org.nasdanika.common; // For inspector reflection\n\t\nprovides CapabilityFactory with &lt;factory class&gt;;\n Registered inspectors can be loaded by calling Inspector.load(). This method can load all registered inspectors or inspectors matching a predicate, e.g. enforcing rules from a specific rule set. Inspectors are responsible for traversing (visiting) their targets and shall be aware of the targets&rsquo; internal structure. NotifierInspector is aware of internal structures of Notifiers - ResourceSet, Resource, EObject. To inspect notifiers: Create an inspector compatible with Notifier Adapt it to NotifierInspector with NotifierInspector.adapt() Obtain content inspector by calling asContentInspector() Call inspect Inspector&lt;Object&gt; inspector = loadInspector(progressMonitor.split(&quot;Loading Inspector&quot;, 1));\nNotifierInspector notifierInspector = NotifierInspector.adapt(inspector);\nResource inputResource = resourceSet.getResource(input, true); // Notifier to inspect\nnotifierInspector\n\t.asContentsInspector(parallel, createPredicate(input))\n\t.inspect(\n\t\tinputResource, \n\t\tinspectionResultConsumer, \n\t\tcontext, \n\t\tinputProgressMonitor);\t\t\t\t\t\n CLI org.nasdanika.models.rules.cli module provides several concrete and abstract command classes and mix-ins for building commands which deal with rule sets, rules, and inspectors. For concrete classes see Nasdanika CLI rules documentation. Some abstract classes are outlined below, consult JavaDoc for more details. AbstractRuleCommand This command provides options to include and exclude rules and rule sets. All options can be specified more than once. --exclude-rule - URI of a rule to exclude from, say, inspection. --include-rule - URI of a rule to include to, say, inspection. --exclude-rule-set - URI of a rule set to exclude from, say, inspection. --include-rule-set - URI of a rule set to include to, say, inspection. If neither of --include-rule or --include-rule-set options are specified, then all rules and rule sets are included by default unless they are excluded by one of exclude options. Include and exclude options can be used together. For example, you may include a rule set and then exclude some rules from it. AbstractInspectorCommand This command extends AbstractRuleCommand. It loads registered inspectors using Inspector.load() and includes only inspectors for matching rules and rule sets. This command can be used as a base for commands which generate documentation about available rules and rule sets. Below is a fragment of the list-rules command which extends AbstractInspectorCommand: @Command(\n\t\tdescription = &quot;Lists available rules&quot;,\n\t\tname = &quot;list-inspectable-rules&quot;,\n\t\tversionProvider = ModuleVersionProvider.class,\n\t\tmixinStandardHelpOptions = true)\n@ParentCommands(RootCommand.class)\npublic class ListInspectableRulesCommand extends AbstractInspectorCommand {\n\n\t...\t\n\n\t@Override\n\tpublic Integer call() throws Exception {\n\t\tProgressMonitor progressMonitor = progressMonitorMixIn.createProgressMonitor(1);\n\t\tInspector&lt;Object&gt; inspector = loadInspector(progressMonitor);\n\t\tMap&lt;EObject, List&lt;Rule&gt;&gt; grouped = Util.groupBy(inspector.getRules(), EObject::eContainer);\n\t\tif (output == null) {\n\t\t\tgenerateReport(grouped, System.out, progressMonitor);\n\t\t} else {\n\t\t\ttry (PrintStream out = new PrintStream(output)) {\n\t\t\t\tgenerateReport(grouped, out, progressMonitor);\n\t\t\t} catch (FileNotFoundException e) {\n\t\t\t\tthrow new NasdanikaException(e);\n\t\t\t}\n\t\t}\n\t\treturn 0;\n\t}\n\t\n\t...\n\t\n}\n AbstractInspectionCommand This command extends AbstractInspectorCommand and provides base functionality for inspecting resources loaded from URI&rsquo;s and their contents. In addition to rule and rule set inclusion/exclusion provided by AbstractRuleCommand this class provides the following options: -e, --exclude-resource - An Ant pattern of resources to exclude from inspection. The pattern is matched against the resource path computed relative to the root resource. For example, dev/*.yml - exclude YAML files in the dev folder. This option can be specified multiple times. -i, --include-resource - An Ant pattern for resources to include. This option can be specified multiple times. --exclude-type - model type to exclude from inspection. For example, exclude constructors or field declarations from inspection of Java code. This option can be specified multiple times. Matching includes super types, i.e. excluding Type would exclude its sub-types as well - Class, Interface, &hellip; Type can be specified in the following ways: Class name, e.g. Type Qualified class name, e.g. java.Type URI - &lt;EPackage NS URI&gt;#//&lt;Class name, e.g. ecore://nasdanika.org/models/java#//Type --include-type - model type to include. This option can be specified multiple times. Can be combined with type exclusion. For example, you may exclude a super-type, but include one of its sub-types. Say, exclude types, but include interfaces. Or, the opposite - include types, but exclude interfaces. -f, --fail-on - Names of severities to fail on (return non-zero exit code). E.g. Error. This option can be specified multiple times. --parallel - Perform inspection in multiple threads. --stop-on-first-fail - stop inspection on first failure - a Violation with severity specified in --fail-on or a Failure. This option can be used in builds/pipelines to fail fast. --limit - Maximum number of results to report. Stop inspection once the limit is reached. This option can be used, for example, to gradually address technical debt - collect a specified number of things to work on in the next iteration (e.g. sprint). Subclasses must implement getInputs() method and may override createResourceSet() method to register resource factories, adapter factories, or URI handlers as shown below in a fragment of inspect-yaml command: @Command(\n\t\tdescription = &quot;Demo of YAML inspection&quot;,\n\t\tname = &quot;inspect-yaml&quot;,\n\t\tversionProvider = ModuleVersionProvider.class,\n\t\tmixinStandardHelpOptions = true)\n@ParentCommands(RootCommand.class)\npublic class InspectYamlCommand extends AbstractInspectionCommand {\n\t\n\t@Parameters(description = {\n\t\t\t&quot;Files and directories&quot;,\n\t\t\t&quot;to inspect&quot;\n\t\t\t},\n\t\t\tarity = &quot;1..*&quot;)\n\tFile[] inputs;\t\n\n\t@Override\n\tprotected List&lt;URI&gt; getInputs() {\n\t\tList&lt;URI&gt; ret = new ArrayList&lt;&gt;();\n\t\tfor (File input: inputs) {\n\t\t\tURI uri = URI.createFileURI(input.getAbsolutePath());\n\t\t\tif (input.isDirectory()) {\n\t\t\t\turi = uri.appendSegment(&quot;&quot;);\n\t\t\t}\n\t\t\tret.add(uri);\n\t\t}\n\t\treturn ret;\n\t}\n\n\t...\t\n\t\n\t@Override\n\tprotected ResourceSet createResourceSet(ProgressMonitor progressMonitor) {\n\t\tResourceSet resourceSet = super.createResourceSet(progressMonitor);\n\t\t// Basic YAML. Add semantic handlers for your problem domain as needed (you'd need to create them). \n\t\tYamlResourceFactory yamlResourceFactory = new YamlResourceFactory(new NcoreYamlHandler());\n\t\tMap&lt;String, Object&gt; extensionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();\n\t\textensionToFactoryMap.put(&quot;yml&quot;, yamlResourceFactory);\n\t\textensionToFactoryMap.put(&quot;yaml&quot;, yamlResourceFactory);\n\t\t\n\t\t// To load directories as resources in order to traverse them\n\t\tresourceSet.getURIConverter().getURIHandlers().add(0, new DirectoryContentFileURIHandler()); \n\t\treturn resourceSet;\n\t}\n\n\t@Override\n\tprotected boolean isIncluded(String path) {\n\t\tString[] includes = getResourceIncludes();\n\t\tif (includes == null) {\n\t\t\treturn path.endsWith(&quot;.yml&quot;) || path.endsWith(&quot;.yaml&quot;);\n\t\t}\n\t\treturn super.isIncluded(path);\n\t}\n\n\t...\n} Inspectable Severity Waiver Action Inspector Inspector Set Inspection Result Rule Rule Set Violation Failure Java Ecore Legend extensions/extends Page-1"},"references/eClassifiers/Action/index.html":{"link-uuid":"b843a763-4c07-4f34-bc47-611c8c2be50f","title":"Action","content":"An action to be taken to address a rule violation"},"references/eClassifiers/UpdateTextResourceAction/inheritance.html":{"path":"UpdateTextResourceAction/Inheritance","link-uuid":"519c8b14-c33d-4062-adfd-2c34aaebe1db","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/ResourceAction/inheritance.html":{"path":"ResourceAction/Inheritance","link-uuid":"94683248-2ec1-4123-b30b-1a12e0605745","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/CreateBinaryResourceAction/inheritance.html":{"path":"CreateBinaryResourceAction/Inheritance","link-uuid":"a24182be-0b81-4a10-8f93-d8dcba37203e","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/UpdateBinaryResourceAction/inheritance.html":{"path":"UpdateBinaryResourceAction/Inheritance","link-uuid":"3114b14d-2288-49ba-840e-46e3ec2269d0","title":"Inheritance","content":"Supertypes "},"glossary.html":{"link-uuid":"c2e2dfbd-acf2-4df1-956b-3958d3c0e7fd","title":"Glossary","content":"Clear Identifier(s) Hide UUID {{data.value.name}} {{data.value[0].value}} {{item.value}}"},"references/eClassifiers/Failure/inheritance.html":{"path":"Failure/Inheritance","link-uuid":"77da1d36-56bf-4d30-9c8e-b5f9ba969596","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Waiver/inheritance.html":{"path":"Waiver/Inheritance","link-uuid":"37374d09-b25d-44a4-90ed-c68b06d6e7b4","title":"Inheritance","content":"Supertypes "},"references/eSubpackages/java/references/eClassifiers/CompilationUnitAction/index.html":{"path":"java/CompilationUnitAction","link-uuid":"d23690f7-4edf-4a3f-92e4-555a1a6d7541","title":"CompilationUnitAction","content":"An action on a compilation unit"},"references/eClassifiers/Rule/references/eStructuralFeatures/actions/index.html":{"path":"Rule/References/actions","link-uuid":"8923301d-b3be-4286-9dd4-02e3e82f8735","title":"actions","content":"Actions to be taken to address rule violations. Rule actions serve as documentation and as templates/prototypes for violation actions."},"references/eClassifiers/UpdateResourceAction/inheritance.html":{"path":"UpdateResourceAction/Inheritance","link-uuid":"cf571308-4d72-42a4-a3f1-2b5725c32d12","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eSubpackages/java/references/eClassifiers/CreateCompilationUnitAction/inheritance.html":{"path":"java/CreateCompilationUnitAction/Inheritance","link-uuid":"4d30a009-7b61-4ec6-91d2-8200fd9b5f53","title":"Inheritance","content":"Supertypes "},"references/eSubpackages/java/references/eClassifiers/UpdateCompilationUnitAction/inheritance.html":{"path":"java/UpdateCompilationUnitAction/Inheritance","link-uuid":"03932ce7-cb37-4e79-b183-9ccada83bc1b","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Action/inheritance.html":{"path":"Action/Inheritance","link-uuid":"cfd6abf3-3d07-4b2f-bde3-6bafa0e45e8b","title":"Inheritance","content":"Supertypes Subtypes  "},"references/eClassifiers/RuleSet/inheritance.html":{"path":"RuleSet/Inheritance","link-uuid":"d147d9ec-2da7-42cd-914d-629be5778211","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Rule/inheritance.html":{"path":"Rule/Inheritance","link-uuid":"bf56764b-d62f-47ed-9386-88c4c2bcccba","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/MoveResourceAction/index.html":{"link-uuid":"97728680-ace0-41ef-8f42-e53778e70b8c","title":"MoveResourceAction","content":"Moves (renames) the resources - changes its identifier"},"references/eClassifiers/CreateTextResourceAction/inheritance.html":{"path":"CreateTextResourceAction/Inheritance","link-uuid":"2d37d12e-3444-40da-9f1c-bc7701da9c01","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/ResourceAction/index.html":{"link-uuid":"e8093493-ff5a-42be-95ad-bf9ddb7e0a4b","title":"ResourceAction","content":"An action on a resource identified by a string identifier, e.g. a path or URI"},"references/eClassifiers/ResourceAction/references/eStructuralFeatures/resourceIdentifier/index.html":{"path":"ResourceAction/Attributes/resourceIdentifier","link-uuid":"59a01897-e729-476e-ae57-ccb8a00d1a37","title":"resourceIdentifier","content":"Resource identifier - path, URI, &hellip;"},"references/eSubpackages/java/references/eClassifiers/DeleteCompilationUnitAction/inheritance.html":{"path":"java/DeleteCompilationUnitAction/Inheritance","link-uuid":"f492d7ac-c04a-4d4e-b928-cc40b46d17f7","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/MoveResourceAction/inheritance.html":{"path":"MoveResourceAction/Inheritance","link-uuid":"126bd81c-430c-451d-ab96-d0d3f8429960","title":"Inheritance","content":"Supertypes "},"references/eClassifiers/Violation/inheritance.html":{"path":"Violation/Inheritance","link-uuid":"0863c0f2-53b1-45b9-92e2-c190f4a33de2","title":"Inheritance","content":"Supertypes "}}