import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "nnl.rocks.projects"
version = "0.1-SNAPSHOT"

buildscript {
    repositories {
        mavenCentral()
        jcenter()
        maven("https://jitpack.io")
        maven("https://repo.spring.io/milestone")
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:1.5.9.RELEASE")
    }
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

plugins {
    kotlin("jvm") version "1.2.20"
    kotlin("plugin.spring") version "1.2.20"
    kotlin("plugin.jpa") version "1.2.20"
    kotlin("plugin.noarg") version "1.2.20"
    kotlin("plugin.allopen") version "1.2.20"
    id("io.spring.dependency-management") version "1.0.3.RELEASE"
}

apply {
    plugin("org.springframework.boot")
}

dependencies {

    compile("com.github.neonailol.kactoos:kactoos-jvm:master-SNAPSHOT")

    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))

    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.springframework.boot:spring-boot-starter-validation")

    compile("com.h2database:h2")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")

    testCompile("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }
}
