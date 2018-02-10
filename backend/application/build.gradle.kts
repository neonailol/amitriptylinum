import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `application`
    kotlin("jvm")
    id("io.spring.dependency-management")
}

application {
    mainClassName = "nnl.rocks.amitriptylinum.backend.MainKt"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
}
