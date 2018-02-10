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

        val kotlinVersion = "1.2.21"
        val springBootVersion = "2.0.0.RC1"
        val jacksonVersion = "2.9.2"

        dependencies {

            dependency("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
            dependency("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")
            dependency("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
            dependency("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
            dependency("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")

        }
    }
}

dependencies {
    subprojects.forEach {
        archives(it)
    }
}
