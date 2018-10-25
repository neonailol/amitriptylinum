import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.2.71"
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    id("com.github.ben-manes.versions") version "0.20.0"
}

allprojects {

    group = "nnl.rocks.amitriptylinum"
    version = "1.0-SNAPSHOT"

    buildscript {
        repositories {
            mavenCentral()
            jcenter()
            maven("https://jitpack.io")
        }
    }

    repositories {
        mavenCentral()
        jcenter()
        maven("https://jitpack.io")
    }

    apply {
        plugin("io.spring.dependency-management")
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.0.6.RELEASE") {
                bomProperties(mapOf("kotlin.version" to "1.2.71"))
            }
        }

        dependencies {
            dependency("com.github.neonailol:kactoos:ce10c0bc7e")
        }
    }

    tasks {
        withType(KotlinCompile::class) {
            kotlinOptions {
                jvmTarget = "1.8"
                javaParameters = true
                freeCompilerArgs = listOf("-Xjsr305=strict")
            }
        }
    }
}

tasks.withType<Wrapper> {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = "4.10.2"
}
