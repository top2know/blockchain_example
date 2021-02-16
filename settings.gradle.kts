pluginManagement {
    val mavenUser: String by settings
    val mavenPassword: String by settings
    repositories {
        gradlePluginPortal()
        mavenLocal()
        mavenCentral()
        maven {
            name = "maven-snapshots"
            url = uri("https://artifacts.vostokservices.com/repository/maven-snapshots/")
            mavenContent {
                snapshotsOnly()
            }
            credentials {
                username = mavenUser
                password = mavenPassword
            }
        }
        maven {
            name = "maven-releases"
            url = uri("https://artifacts.vostokservices.com/repository/maven-releases/")
            mavenContent {
                releasesOnly()
            }
            credentials {
                username = mavenUser
                password = mavenPassword
            }
        }
    }
}

rootProject.name = "example-app"

include(
    "example-webapp:example-webapp-api",
    "example-webapp:example-webapp-app",
    "example-contract:example-contract-api",
    "example-contract:example-contract-app",
    "example-domain"
)