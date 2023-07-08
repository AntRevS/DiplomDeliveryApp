package com.antrevs.delivery.utils

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

internal fun DependencyHandler.implementation(dep: String): Dependency? =
    add("implementation", dep)

internal fun DependencyHandler.debugImplementation(dep: String): Dependency? =
    add("debugImplementation", dep)

internal fun DependencyHandler.kapt(dep: String): Dependency? =
    add("kapt", dep)