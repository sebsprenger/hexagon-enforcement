package com.example.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.app.ArchitectureDescription.*;
import static com.example.app.Layers.classesIn;

class HexagonTest {

    @Test
    @DisplayName("Domain layer should have no dependencies")
    void domainDependencies() {
        classesIn(DOMAIN_LAYER).shouldOnlyDependOn(DOMAIN_LAYER).check(CLASSES);
    }

    @Test
    @DisplayName("Domain layer may be only be used by adapters and application layer")
    void domainDependents() {
        classesIn(DOMAIN_LAYER).shouldOnlyBeUsedBy(PRIMARY_ADAPTERS, SECONDARY_ADAPTERS, APPLICATION_LAYER).check(CLASSES);
    }

    @Test
    @DisplayName("Application layer may depend on domain layer")
    void applicationDependencies() {
        classesIn(APPLICATION_LAYER).shouldOnlyDependOn(APPLICATION_LAYER, DOMAIN_LAYER).check(CLASSES);
    }

    @Test
    @DisplayName("Application layer must only be used by primary adapters")
    void applicationDependents() {
        classesIn(APPLICATION_LAYER).shouldOnlyBeUsedBy(PRIMARY_ADAPTERS).check(CLASSES);
    }

    @Test
    @DisplayName("Primary Adapters may depend on application layer and domain layer")
    void primaryAdaptersDependencies() {
        classesIn(PRIMARY_ADAPTERS).shouldOnlyDependOn(PRIMARY_ADAPTERS, APPLICATION_LAYER, DOMAIN_LAYER).check(CLASSES);
    }

    @Test
    @DisplayName("Primary Adapters must not be used by anyone else")
    void primaryAdaptersDependents() {
        classesIn(PRIMARY_ADAPTERS).shouldOnlyBeUsedBy(PRIMARY_ADAPTERS).check(CLASSES);
    }

    @Test
    @DisplayName("Secondary Adapters only may use domain layer")
    void secondaryAdapterDependecies() {
        classesIn(SECONDARY_ADAPTERS).shouldOnlyDependOn(SECONDARY_ADAPTERS, DOMAIN_LAYER).check(CLASSES);
    }

    @Test
    @DisplayName("Secondary Adapters must not be used by anyone else")
    void secondaryAdapterDependent() {
        classesIn(SECONDARY_ADAPTERS).shouldOnlyBeUsedBy(SECONDARY_ADAPTERS).check(CLASSES);
    }

}