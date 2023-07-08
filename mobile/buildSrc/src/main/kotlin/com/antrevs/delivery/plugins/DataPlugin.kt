package com.antrevs.delivery.plugins

import AppDependencies
import com.antrevs.delivery.utils.implementation
import com.antrevs.delivery.utils.kapt
import org.gradle.api.Plugin
import org.gradle.api.Project

class DataPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target.dependencies) {
            implementation(AppDependencies.ROOM_RUNTIME)
            kapt(AppDependencies.ROOM_RUNTIME)
        }
    }
}