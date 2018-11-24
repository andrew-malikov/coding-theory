import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

group = "osu.labs.coding-theory"
version = "1.0.0"

kotlin.sourceSets {
    this["main"].kotlin.srcDir("src")
    this["main"].resources.srcDir("resources")
    this["test"].kotlin.srcDir("test")
    this["test"].resources.srcDir("test/resources")
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}