import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}


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
    compile(project(":arithmetic-coding:lib"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Jar> {
    manifest {
        attributes(
                Pair("Main-Class", "arithmetic.coding.decompressing.cli.MainKt")
        )
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
}