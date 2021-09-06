plugins {
    id("org.jetbrains.kotlin.js") version "1.5.30"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/kotlin-js-wrappers")
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
}

kotlin {
    js {
        browser {
            commonWebpackConfig {
                cssSupport.enabled = true
            }
        }
        binaries.executable()
    }
}

dependencies {
    //React, React DOM + Wrappers (chapter 3)
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:17.0.2-pre.241-kotlin-1.5.30")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:17.0.2-pre.241-kotlin-1.5.30")
    implementation(npm("react", "17.0.2"))
    implementation(npm("react-dom", "17.0.2"))
    api(npm("react-bootstrap", "1.6.1"))
}
