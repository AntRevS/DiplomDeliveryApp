package com.antrevs.delivery.plugins

import AppDependencies
import com.antrevs.delivery.utils.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project

class NetworkPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target.dependencies) {
            implementation(AppDependencies.RETROFIT)
            implementation(AppDependencies.GSON)
        }
    }
}