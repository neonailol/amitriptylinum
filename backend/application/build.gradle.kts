import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `application`
    kotlin("jvm")
}

application {
    mainClassName = "nnl.rocks.amitriptylinum.backend.MainKt"
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
}
