val edcVersion: String by project
val edcGroup: String by project

plugins {
    `java-library`
    `maven-publish`
}

dependencies {
    api("${edcGroup}:core-spi:${edcVersion}")
    api("${edcGroup}:policy-engine-spi:${edcVersion}")
    api("${edcGroup}:control-plane-spi:${edcVersion}")
    implementation("${edcGroup}:api-core:${edcVersion}")

    testImplementation("${edcGroup}:control-plane-core:${edcVersion}")
    testImplementation("${edcGroup}:junit:${edcVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

publishing {
    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])
        }
    }
}
