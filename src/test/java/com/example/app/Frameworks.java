package com.example.app;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaAnnotation;

public class Frameworks {

    public static final String SPRING_FRAMEWORK = "org.springframework..";

    public static final DescribedPredicate<JavaAnnotation> SPRING_ANNOTATIONS = new SpringAnnotation();

}
