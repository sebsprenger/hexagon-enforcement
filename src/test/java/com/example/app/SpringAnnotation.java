package com.example.app;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaAnnotation;

public class SpringAnnotation extends DescribedPredicate<JavaAnnotation> {

    public SpringAnnotation() {
        super("Spring Annotations", null);
    }

    @Override
    public boolean apply(JavaAnnotation annotation) {
        return annotation.getType().getPackageName().startsWith("org.springframework");
    }
}
