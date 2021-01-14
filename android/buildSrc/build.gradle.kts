repositories {
    google()
    jcenter()
}

dependencies {
    implementation("com.android.tools.build:gradle:3.5.3")
}

plugins {
    id("java-gradle-plugin")
    id("de.fuerstenau.buildconfig") version "1.1.8"
    kotlin("jvm") version "1.3.70"
}

val pluginId = "com.solar2d.application"

gradlePlugin {
    plugins {
        create("S2DGradlePlugin") {
            id = pluginId
            implementationClass = "com.solar2d.S2DGP"
        }
    }
}

buildConfig {
    buildConfigField("String", "pluginId", pluginId)
    appName = "Solar2D Android Gradle Plugin"       // sets value of NAME field
    version = project.version.toString()
    packageName = "com.solar2d"  // sets the package of the BuildConfig class,
}