plugins {
    `kotlin-dsl`
}

gradlePlugin {

    val module by plugins.creating {
        id = "module-plugin"
        implementationClass = "com.antrevs.delivery.plugins.ModulePlugin"
    }

    val di by plugins.creating {
        id = "di-plugin"
        implementationClass = "com.antrevs.delivery.plugins.DependencyInjectionPlugin"
    }

    val compose by plugins.creating {
        id = "compose-plugin"
        implementationClass = "com.antrevs.delivery.plugins.ComposePlugin"
    }

    val network by plugins.creating {
        id = "network-plugin"
        implementationClass = "com.antrevs.delivery.plugins.NetworkPlugin"
    }

    val data by plugins.creating {
        id = "data-plugin"
        implementationClass = "com.antrevs.delivery.plugins.DataPlugin"
    }
}

dependencies {
    implementation("com.android.tools.build:gradle:7.3.0")
    implementation(kotlin("gradle-plugin:1.8.0"))
}