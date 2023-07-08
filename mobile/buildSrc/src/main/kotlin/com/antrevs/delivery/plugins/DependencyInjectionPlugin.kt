package com.antrevs.delivery.plugins

import com.antrevs.delivery.utils.implementation
import com.antrevs.delivery.utils.kapt
import org.gradle.api.Plugin
import org.gradle.api.Project

class DependencyInjectionPlugin: Plugin<Project> {

    override fun apply(target: Project) {

        with(target.dependencies) {
            implementation(AppDependencies.DAGGER)
            kapt(AppDependencies.DAGGER_COMPILER)
        }
    }
}
