repositories {
    google()
    jcenter()
}

dependencies {
    implementation("com.android.tools.build:gradle:7.0.0-alpha04")
}

plugins {
    id("java-gradle-plugin")
    kotlin("jvm") version "1.3.70"
}

gradlePlugin {
    plugins {
        create("S2DGradlePlugin") {
            id = "com.solar2d.application"
            implementationClass = "com.solar2d.S2DGP"
        }
    }
}
