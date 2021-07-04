buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Config.Dependencies.androidPlugin)
        classpath(Config.Dependencies.kotlinPlugin)
        classpath(Config.Dependencies.googlePlugin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url = uri(Config.Repositories.jitPack) }
        maven { url = uri(Config.Repositories.pluginGradle) }
    }
}

tasks.register("clean",Delete::class){ delete(rootProject.buildDir) }