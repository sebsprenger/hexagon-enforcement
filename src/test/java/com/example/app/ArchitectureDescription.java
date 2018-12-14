package com.example.app;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;

public class ArchitectureDescription {

    public static final String PKG = CleanArchApplication.class.getPackage().getName();

    public static final String DOMAIN_LAYER = String.format("%s.domain..", PKG);
    public static final String APPLICATION_LAYER = String.format("%s.application..", PKG);
    public static final String PRIMARY_ADAPTERS = String.format("%s.adapters.primary..", PKG);
    public static final String SECONDARY_ADAPTERS = String.format("%s.adapters.secondary..", PKG);

    public static final JavaClasses CLASSES = new ClassFileImporter().importPackages(PKG);
}
