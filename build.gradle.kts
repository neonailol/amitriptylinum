import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `base`
    kotlin("jvm") version "1.2.21" apply false
    id("io.spring.dependency-management") version "1.0.4.RELEASE"
}

configure<DependencyManagementExtension> {

    overriddenByDependencies(false)

    dependencies {
        dependencySet(
            mapOf(
                "group" to "org.jetbrains.kotlin",
                "version" to "1.2.21"
            )
        ) {
            entry("kotlin-stdlib-jdk8")
            entry("kotlin-reflect")
            entry("kotlin-test")
        }
    }
}

allprojects {

    group = "nnl.rocks.amitriptylinum"
    version = "1.0-SNAPSHOT"

    buildscript {
        repositories {
            mavenCentral()
            jcenter()
            maven("https://jitpack.io")
            maven("https://repo.spring.io/milestone")
        }

        dependencies {
            classpath(kotlin("gradle-plugin", "1.2.21"))
        }
    }

    repositories {
        mavenCentral()
        jcenter()
        maven("https://jitpack.io")
        maven("https://repo.spring.io/milestone")
    }

    tasks {
        withType<KotlinCompile> {
            kotlinOptions {
                jvmTarget = "1.8"
                javaParameters = true
                freeCompilerArgs = listOf("-Xjsr305=strict")
            }
        }
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}
