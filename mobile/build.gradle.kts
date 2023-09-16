import java.io.ByteArrayOutputStream

plugins {
    id("io.gitlab.arturbosch.detekt") version("1.23.1")
}

detekt {
    toolVersion = AppVersions.DETEKT
    config.setFrom(file("detekt-config.yml"))
    val listOfFiles = getDiffFilesList()
    printGreen("Files will be detekt:")
    listOfFiles.forEach(::printBlue)
    source.setFrom(listOfFiles)
    basePath = projectDir.path
}

fun printGreen(text: String) = println("\u001b[32m$text\u001b[0m")

fun printBlue(text: String) = println("\u001b[34m$text\u001b[0m")

fun getDiffFilesList(): List<String> =
    runCommand("git diff --name-only main")
        .split("\n")
        .filter { it.startsWith("mobile") }
        .map { it.replace("mobile/", "") }

fun runCommand(command: String): String {
    val outputStream = ByteArrayOutputStream()
    project.exec {
        commandLine = command.split(" ")
        standardOutput = outputStream
    }
    String(outputStream.toByteArray()).let { result ->
        //println("run command result: $result")
        return result.trim()
    }
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
        classpath(AppDependencies.DETEKT_FORMATTING)
    }
}
