plugins {
    id("io.gitlab.arturbosch.detekt") version("1.23.1")
}

detekt {
    toolVersion = "1.23.1"
    config.setFrom(file("detekt-config.yml"))
    val moduleNames = listOf("core", "feature", "app")
    val listOfModules = projectDir.absoluteFile.listFiles()?.filter {
        it.isDirectory && moduleNames.any { name ->
            it.name.contains(name, ignoreCase = true)
        }
    }?.map { "${it.name}/src/main/java" }
    source.setFrom(listOfModules)
    basePath = projectDir.path
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
        classpath("io.gitlab.arturbosch.detekt:detekt-formatting:1.23.1")
    }
}
