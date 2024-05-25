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

[Sources](https://github.com/Nasdanika-models/rules)

## Rules



## Inspectors


### Reflective



## CLI
