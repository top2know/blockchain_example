plugins {
    kotlin("plugin.spring")
}

dependencies {
    implementation(kotlin("stdlib"))

    api(project(":example-domain"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}
