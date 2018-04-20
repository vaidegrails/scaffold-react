package com.scaffoldreact.scaffoldreact.annotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target


@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE])
/**
 * All classes that hold this annotation are automatically treated as a scaffold object
 */
@interface ScaffoldViews {
    String[] views() default ["CREATE", "SHOW", "LIST", "DELETE"]
}
