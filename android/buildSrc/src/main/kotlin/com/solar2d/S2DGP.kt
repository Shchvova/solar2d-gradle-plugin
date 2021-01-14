package com.solar2d

import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import org.gradle.api.InvalidUserCodeException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.DependencyResolutionListener
import org.gradle.api.artifacts.ResolvableDependencies
import org.gradle.api.model.ObjectFactory
import javax.inject.Inject

abstract class S2DGP : Plugin<Project> {

    @Inject
    protected abstract fun getObjectFactory(): ObjectFactory?


//    project.apply(mapOf("from" to "test.gradle"))


    override fun apply(project: Project) {
        project.pluginManager.withPlugin("com.android.application") {
            val androidPlugin = checkNotNull(project.plugins.findPlugin(AppPlugin::class.java)) { "Unable to find applied Android Application Plugin" }
            val android = checkNotNull(androidPlugin.extension) { "Unable to find Android Plugin configuration" }
            project.gradle.addListener(object : DependencyResolutionListener {
                override fun beforeResolve(dependencies: ResolvableDependencies) {
                    TODO("Not yet implemented")
                }

                override fun afterResolve(dependencies: ResolvableDependencies) {
                    TODO("Not yet implemented")
                }

            })
            project.gradle.afterProject {
                if(it == project) {
                    configureAndroid(project, android)
                }
            }
        }
        project.afterEvaluate{
            if(project.plugins.findPlugin(AppPlugin::class.java) == null) {
                 throw InvalidUserCodeException("The ${BuildConfig.NAME} (\"${BuildConfig.pluginId}\") requires Android Application plugin (\"com.android.application\"), but the project ${project.name} doesn't have it applied.")
            }
        }
    }

    private fun configureAndroid(project: Project, android: BaseExtension) {
        android.defaultConfig {
            println(it.applicationId)
        }
        project.dependencies( {
            it.implementation("androidx.multidex:multidex:2.0.1")
        });
    }
}