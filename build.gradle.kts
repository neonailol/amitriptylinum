
group = "nnl.rocks.projects"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven("https://jitpack.io")
}

plugins {
    kotlin("jvm") version "1.2.20"
}

dependencies {
    compile(kotlin("stdlib"))
}
