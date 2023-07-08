plugins {
    id ("com.android.application")
    id ("module-plugin")
    id ("di-plugin")
    id ("network-plugin")
    id ("compose-plugin")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.antrevs.delivery"

    defaultConfig {
        applicationId = "com.antrevs.delivery"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    packagingOptions.resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
}

dependencies {
    implementation(AppDependencies.MULTIDEX)
    implementation(project(":core"))
    implementation(project(":core-view"))
    implementation(project(":feature-splash"))
    implementation(project(":feature-main"))
    implementation(project(":feature-authorization"))
    implementation(project(":feature-profile"))
    implementation(project(":feature-ui"))
}