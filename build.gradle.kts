import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    `base`
    kotlin("jvm") version "1.2.21" apply false
    id("io.spring.dependency-management") version "1.0.4.RELEASE"
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
        maven("https://repo.spring.io/libs-milestone")
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

subprojects {

    apply {
        plugin("io.spring.dependency-management")
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

            dependencySet(
                mapOf(
                    "group" to "org.springframework.boot",
                    "version" to "2.0.0.RC1"
                )
            ) {
                entry("spring-boot-starter-web")
            }
        }
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}
