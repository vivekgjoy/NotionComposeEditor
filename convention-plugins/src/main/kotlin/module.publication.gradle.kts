import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.tasks.bundling.Jar
import org.gradle.kotlin.dsl.`maven-publish`

plugins {
    `maven-publish`
    signing
}

publishing {
    // Configure all publications
    publications.withType<MavenPublication> {
        // Stub javadoc.jar artifact
        artifact(tasks.register("${name}JavadocJar", Jar::class) {
            archiveClassifier.set("javadoc")
            archiveAppendix.set(this@withType.name)
        })

        // Maven Central coordinates
        groupId = "com.notioncompose"
        artifactId = project.name
        version = project.version.toString()

        // Provide artifacts information required by Maven Central
        pom {
            name.set("NotionComposeEditor")
            description.set("A beautiful Notion-style rich text editor for Compose Multiplatform")
            url.set("https://github.com/vivekgjoy/NotionComposeEditor")

            licenses {
                license {
                    name.set("Apache-2.0")
                    url.set("https://www.apache.org/licenses/LICENSE-2.0")
                }
            }
            issueManagement {
                system.set("Github")
                url.set("https://github.com/vivekgjoy/NotionComposeEditor/issues")
            }
            scm {
                connection.set("scm:git:git://github.com/vivekgjoy/NotionComposeEditor.git")
                developerConnection.set("scm:git:ssh://github.com/vivekgjoy/NotionComposeEditor.git")
                url.set("https://github.com/vivekgjoy/NotionComposeEditor")
            }
            developers {
                developer {
                    id.set("vivekgjoy")
                    name.set("VivekG")
                    email.set("") // Add your email if you want
                }
            }
        }
    }
}

signing {
    useInMemoryPgpKeys(
        System.getenv("OSSRH_GPG_SECRET_KEY_ID"),
        System.getenv("OSSRH_GPG_SECRET_KEY"),
        System.getenv("OSSRH_GPG_SECRET_KEY_PASSWORD"),
    )
    sign(publishing.publications)
}

// TODO: remove after https://youtrack.jetbrains.com/issue/KT-46466 is fixed
project.tasks.withType(AbstractPublishToMaven::class.java).configureEach {
    dependsOn(project.tasks.withType(Sign::class.java))
}