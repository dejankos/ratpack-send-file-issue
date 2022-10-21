buildscript {
    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("io.ratpack:ratpack-gradle:1.10.0-milestone-8")
    }
}


plugins {
    id("java")
}

apply {
    plugin<ratpack.gradle.RatpackPlugin>()
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ratpack:ratpack-guice:1.10.0-milestone-8")
    implementation("ch.qos.logback:logback-classic:1.4.4")


    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}