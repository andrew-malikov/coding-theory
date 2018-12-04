import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

group = "osu.labs.coding-theory"
version = "1.0.0"

kotlin.sourceSets {
    getByName("main").kotlin.srcDir("src")
    getByName("main").resources.srcDir("resources")
    getByName("test").kotlin.srcDir("test")
    getByName("test").resources.srcDir("test/resources")
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