import org.gradle.api.artifacts.dsl.DependencyHandler

object Libraries {
    //Android
    private const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    private const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    private const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.fragmentKtx}"
    private const val testJunit = "androidx.test.ext:junit:${Versions.testJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    private const val jUnit = "junit:junit:${Versions.jUnit}"
    // UI library
    private const val material = "com.google.android.material:material:${Versions.material}"
    private const val circleImage = "de.hdodenhof:circleimageview:${Versions.circleImage}"
    private const val lottie = "com.airbnb.android:lottie:${Versions.lottie}"
    private const val imageSlider = "com.github.smarteist:autoimageslider:${Versions.imageSlider}"
    //Others
    private const val commonFunction = "com.github.dodyac:commonFunction:${Versions.commonFunction}"
    private const val sqliteZ = "com.github.dodyac:Sqlitez:${Versions.sqliteZ}"
    private const val materialDialog = "dev.shreyaspatil.MaterialDialog:MaterialDialog:${Versions.materialDialog}"
    private const val dotsIndicator = "com.tbuonomo:dotsindicator:${Versions.dotsIndicator}"
    private const val cupBoard = "nl.qbusict:cupboard:${Versions.cupBoard}"
    private const val balloon = "com.github.skydoves:balloon:${Versions.balloon}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdlib)
        add(coreKtx)
        add(appCompat)
        add(constraintLayout)
        add(legacySupport)
        add(fragmentKtx)
        add(material)
        add(circleImage)
        add(lottie)
        add(imageSlider)
        add(commonFunction)
        add(sqliteZ)
        add(materialDialog)
        add(dotsIndicator)
        add(cupBoard)
        add(balloon)
        add("com.google.code.gson:gson:2.8.7")
    }

    val testLibraries = arrayListOf<String>().apply {
        add(jUnit)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(testJunit)
        add(espressoCore)
    }

    fun DependencyHandler.implementationX(list: List<String>) {
        list.forEach { dependency -> add("implementation", dependency) }
    }

    fun DependencyHandler.kaptX(list: List<String>) {
        list.forEach { dependency -> add("kapt", dependency) }
    }

    fun DependencyHandler.androidTestImplementationX(list: List<String>) {
        list.forEach { dependency -> add("androidTestImplementation", dependency) }
    }

    fun DependencyHandler.testImplementationX(list: List<String>) {
        list.forEach { dependency -> add("testImplementation", dependency) }
    }
}