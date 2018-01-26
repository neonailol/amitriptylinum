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
        classpath(kotlin("gradle-plugin", "1.2.21"))
    }
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

plugins {
    kotlin("jvm") version "1.2.21"
    kotlin("plugin.spring") version "1.2.21"
    kotlin("plugin.jpa") version "1.2.21"
    kotlin("plugin.noarg") version "1.2.21"
    kotlin("plugin.allopen") version "1.2.21"
    id("io.spring.dependency-management") version "1.0.4.RELEASE"
    `maven`
}

apply {
    plugin("org.springframework.boot")
    plugin("kotlin")
}

dependencies {

    compile("com.github.neonailol.kactoos:kactoos-jvm:master-SNAPSHOT")

    compile(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))

    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    compile("org.springframework.boot:spring-boot-starter-validation")
    compile("org.springframework.boot:spring-boot-starter-security")
    compile("org.springframework.boot:spring-boot-starter-undertow")
    compile("org.springframework.boot:spring-boot-starter-logging")

    compile("org.springframework.security.oauth:spring-security-oauth2")

    compile("com.h2database:h2")
    compile("org.hibernate:hibernate-java8")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    compile("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    compile("io.springfox:springfox-spring-web:2.8.0")
    compile("io.springfox:springfox-swagger2:2.8.0")
    compile("io.springfox:springfox-swagger-ui:2.8.0")

    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("org.springframework.security:spring-security-test")
}

tasks {

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xjsr305=strict")
        }
    }

    "pom" {
        doLast {
            maven.pom().writeTo("pom.xml")
        }
    }
}
