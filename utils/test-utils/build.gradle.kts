
plugins {
    `java-library`
}

dependencies {
    annotationProcessor(libs.lombok)
    compileOnly(libs.lombok)

    api(libs.junit.api)
    implementation(libs.apache.commonsLang)

    api(libs.edc.junit)
    api(libs.awaitility.java)
    api(libs.jakarta.rsApi)
    api(libs.postgres)
    api(project(":extensions:wrapper:clients:java-client"))
    api(project(":utils:json-and-jsonld-utils"))

    implementation(project(":utils:versions"))
    implementation(libs.edc.jsonLd)
    implementation(libs.assertj.core)
    implementation(libs.jooq.jooq)
    implementation(libs.mockserver.netty)
    implementation(libs.testcontainers.testcontainers)
    implementation(libs.testcontainers.junitJupiter)
    implementation(libs.testcontainers.postgresql)
    implementation(libs.restAssured.restAssured)
    implementation("ch.qos.logback:logback-core:1.5.6")
}

group = libs.versions.sovityEdcExtensionGroup.get()

publishing {
    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])
        }
    }
}
