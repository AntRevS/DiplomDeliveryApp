package com.antrevs.delivery.plugins

import AppDependencies
import com.android.build.gradle.BaseExtension
import com.antrevs.delivery.utils.implementation
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

class ModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.extensions.getByType(BaseExtension::class.java).run {

            setCompileSdkVersion(AppVersions.COMPILE_SDK)

            defaultConfig {
                minSdk = AppVersions.MIN_SDK
                targetSdk = AppVersions.TARGET_SDK
                multiDexEnabled = true
                vectorDrawables.useSupportLibrary = true
                multiDexEnabled = true
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
        }
        with(target.plugins) {
            apply("kotlin-android")
            apply("kotlin-parcelize")
            apply("kotlin-kapt")
        }
        with(target.dependencies) {
            implementation(AppDependencies.CORE_KTX)
            implementation(AppDependencies.RUNTIME_KTX)
        }
    }
}
