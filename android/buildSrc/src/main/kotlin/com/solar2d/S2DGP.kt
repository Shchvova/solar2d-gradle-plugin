package com.solar2d

import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.AppPlugin
import org.gradle.BuildListener
import org.gradle.BuildResult
import org.gradle.api.initialization.Settings
import org.gradle.api.invocation.Gradle

class S2DGP : Plugin<Project> {
    override fun apply(project: Project) {
        project.pluginManager.withPlugin("com.android.application") {
            val androidPlugin = project.plugins.findPlugin(AppPlugin::class.java)!!
            println(androidPlugin)
//            val android = androidPlugin.extension
//            project.afterEvaluate {
//                android.defaultConfig {
//                    println("${it.applicationId}")
//                }
//            }
            //androidPlugin.variantManager.createAndroidTasks()
        }
    }
}