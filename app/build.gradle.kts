import Libraries.androidTestImplementationX
import Libraries.implementationX
import Libraries.testImplementationX

plugins {
    id(Config.Plugins.android)
    kotlin(Config.Plugins.kotlinAndroid)
    kotlin(Config.Plugins.kotlinKapt)
}

android {
    compileSdkVersion(Versions.compileSdk)
    buildToolsVersion(Versions.buildTool)

    defaultConfig {
        applicationId = ApplicationId.appId
        minSdkVersion(Versions.minSdk)
        targetSdkVersion(Versions.targetSdk)
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        multiDexEnabled = true
        vectorDrawables.useSupportLibrary = true
        testInstrumentationRunner = Config.testRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures.viewBinding = true
    kotlinOptions.jvmTarget = Versions.jvm
    lintOptions.disable("ContentDescription")
}

dependencies {
    implementationX(Libraries.appLibraries)
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    androidTestImplementationX(Libraries.androidTestLibraries)
    testImplementationX(Libraries.testLibraries)
}