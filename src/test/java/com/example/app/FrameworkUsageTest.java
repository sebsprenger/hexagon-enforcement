package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.app.ArchitectureDescription.CLASSES;
import static com.example.app.ArchitectureDescription.DOMAIN_LAYER;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

class FrameworkUsageTest {

    @Test
    @DisplayName("Domain layer should not depend on spring - does not work for annotations")
    void domainSpring() {
        noClasses().that().resideInAPackage(DOMAIN_LAYER).
                should().dependOnClassesThat().resideInAPackage("org.springframework..").check(CLASSES);

        noClasses().that().resideInAPackage(DOMAIN_LAYER).
                should().accessClassesThat().resideInAPackage("org.springframework..").check(CLASSES);

    }

}