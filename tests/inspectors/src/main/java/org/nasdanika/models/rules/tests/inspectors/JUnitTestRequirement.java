package org.nasdanika.models.rules.tests.inspectors;

/**
 * Requirement to generate JUnit test for a method
 * @param jUnitVersion JUnit version, e.g. 5
 */
public record JUnitTestRequirement(
		String jUnitVersion, 
		boolean disabled,
		boolean useGenAI,
		boolean commentGenAIOutput,
		boolean massageGenAIOutput,
		boolean generateExplanation,
		boolean generateReview) {}
