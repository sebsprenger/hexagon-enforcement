package com.example.app;

import com.tngtech.archunit.lang.ArchRule;
import org.apache.commons.lang3.ArrayUtils;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class Layers {
    private static final String[] STANDARD_PACKAGES = {
            "java.."
    };

    private final String layer;

    public Layers(String layer) {
        this.layer = layer;
    }

    public static Layers classesIn(String layer) {
        return new Layers(layer);
    }

    public ArchRule shouldOnlyDependOn(String... layers) {
        String[] specifiedAndStandard = ArrayUtils.addAll(layers, STANDARD_PACKAGES);
        return classes().that().resideInAPackage(layer).
                should().onlyDependOnClassesThat().resideInAnyPackage(specifiedAndStandard);
    }

    public ArchRule shouldOnlyBeUsedBy(String... layers) {
        String[] specifiedAndItself = ArrayUtils.add(layers, layer);
        return classes().that().resideInAPackage(layer).
                should().onlyHaveDependentClassesThat().resideInAnyPackage(specifiedAndItself);

    }
}
