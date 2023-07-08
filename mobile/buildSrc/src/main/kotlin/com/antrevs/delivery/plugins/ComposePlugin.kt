package com.antrevs.delivery.plugins

import AppDependencies
import AppVersions
import com.android.build.gradle.BaseExtension
import com.antrevs.delivery.utils.debugImplementation
import com.antrevs.delivery.utils.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.extensions.getByType(BaseExtension::class.java).run {
            buildFeatures.compose = true
            composeOptions.kotlinCompilerExtensionVersion = AppVersions.KOTLIN_COMPILER_EXTENSION
        }
        with(target.dependencies) {
            implementation(AppDependencies.COMPOSE_ACTIVITY)
            implementation(AppDependencies.COMPOSE_UI)
            implementation(AppDependencies.COMPOSE_MATERIAL)
            implementation(AppDependencies.COMPOSE_PREVIEW)
            implementation(AppDependencies.COMPOSE_VIEWMODEL)
            implementation(AppDependencies.COMPOSE_LIFECYCLE)
            implementation(AppDependencies.COMPOSE_NAVIGATION)
            debugImplementation(AppDependencies.COMPOSE_TOOLING)
            debugImplementation(AppDependencies.COMPOSE_MANIFEST)
        }
    }
}
