plugins {
    id("io.micronaut.application") version "1.4.2"
}

repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
}

dependencies {
    implementation(platform("org.apache.logging.log4j:log4j-bom:2.14.1"))

    implementation("io.micronaut:micronaut-http-server-netty")
    implementation("io.micronaut:micronaut-management")
    implementation("org.apache.logging.log4j:log4j-api")

    runtimeOnly("org.apache.logging.log4j:log4j-core")
    runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl")

    testImplementation("org.assertj:assertj-core")
    testImplementation("org.mockito:mockito-core")
    testImplementation("net.javacrumbs.json-unit:json-unit-assertj:2.25.0")
    testImplementation("io.cucumber:cucumber-java:6.10.3")

    annotationProcessor("io.soabase.record-builder:record-builder-processor:1.19")
    compileOnly("io.soabase.record-builder:record-builder-core:1.19")
}

application {
    mainClass.set("com.example.Application")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(16))
    }
}


