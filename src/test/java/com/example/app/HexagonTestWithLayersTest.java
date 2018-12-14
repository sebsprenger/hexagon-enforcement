package com.example.app;

import com.tngtech.archunit.library.Architectures;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.example.app.ArchitectureDescription.*;


public class HexagonTestWithLayersTest {

    private Architectures.LayeredArchitecture layers() {
        return layeredArchitecture().
                layer("domain").definedBy(DOMAIN_LAYER).
                layer("application").definedBy(APPLICATION_LAYER).
                layer("primary-adapters").definedBy(PRIMARY_ADAPTERS).
                layer("secondary-adapters").definedBy(SECONDARY_ADAPTERS).
                layer("spring").definedBy("org.springframework..");
    }

    @Test
    public void hexagon() {
        layers().
            whereLayer("primary-adapters").mayNotBeAccessedByAnyLayer().
            whereLayer("secondary-adapters").mayNotBeAccessedByAnyLayer().
            whereLayer("application").mayOnlyBeAccessedByLayers("primary-adapters").
            whereLayer("domain").mayOnlyBeAccessedByLayers("primary-adapters", "secondary-adapters", "application").

            check(CLASSES);
    }

    @Test
    public void spring() {
        layers().
                whereLayer("spring").mayOnlyBeAccessedByLayers("primary-adapters", "secondary-adapters", "application").
                because("Domain should be kept spring-free").
                check(CLASSES);
    }

    @Test
    public void domain() {
        layers().
            whereLayer("domain").mayOnlyBeAccessedByLayers("primary-adapters", "secondary-adapters", "application").
            as("Domain may only be access by adapters and application").
            check(CLASSES);
    }

    @Test
    public void application() {
        layers().
            whereLayer("application").mayOnlyBeAccessedByLayers("primary-adapters").
            as("Application may one by access by primary adapters").
            check(CLASSES);
    }

    @Test
    public void primaryAdapters() {
        layers().
            whereLayer("primary-adapters").mayNotBeAccessedByAnyLayer().
            as("Primary adapters may not be accessed").
            check(CLASSES);
    }

    @Test
    public void secondaryAdapters() {
        layers().
            whereLayer("secondary-adapters").mayNotBeAccessedByAnyLayer().
            as("Secondary adapters may not be accessed").
            check(CLASSES);

    }

}