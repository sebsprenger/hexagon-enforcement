package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.app.ArchitectureDescription.CLASSES;
import static com.example.app.ArchitectureDescription.DOMAIN_LAYER;
import static com.example.app.Frameworks.SPRING_ANNOTATIONS;
import static com.example.app.Frameworks.SPRING_FRAMEWORK;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class FrameworkUsageTest {

    @Test
    @DisplayName("Domain layer should not depend on spring")
    void domainSpring() {
        classes().that().resideInAPackage(DOMAIN_LAYER).should()
                .notBeAnnotatedWith(SPRING_ANNOTATIONS).check(CLASSES);

        noClasses().that().resideInAPackage(DOMAIN_LAYER).
                should().dependOnClassesThat().resideInAPackage(SPRING_FRAMEWORK).check(CLASSES);

        noClasses().that().resideInAPackage(DOMAIN_LAYER).
                should().accessClassesThat().resideInAPackage(SPRING_FRAMEWORK).check(CLASSES);
    }

}