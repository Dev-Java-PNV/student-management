plugins {
    id("java")
}

group = "developer"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("mysql:mysql-connector-java:8.0.33")
    implementation ("io.github.cdimascio:java-dotenv:5.2.2")
    implementation ("commons-beanutils:commons-beanutils:1.9.4")
}

tasks.test {
    useJUnitPlatform()
}