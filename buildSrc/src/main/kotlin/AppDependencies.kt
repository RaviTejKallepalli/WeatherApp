object AppDependencies {
    // std lib
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"

    // android ui
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val material = "com.google.android.material:material:${Versions.material}"

    // test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    private const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
    private const val mockK = "io.mockk:mockk:${Versions.mockK}"

    // Junit5
    const val junit5Plugin =
        "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junit5Plugin}"
    private const val junitJupiterApi = "org.junit.jupiter:junit-jupiter-api:${Versions.junit5}"
    private const val junitJupiterEngine =
        "org.junit.jupiter:junit-jupiter-engine:${Versions.junit5}"
    private const val junitParams = "org.junit.jupiter:junit-jupiter-params:${Versions.junit5}"
    private const val junitVintageEngine =
        "org.junit.vintage:junit-vintage-engine:${Versions.junit5}"

    // dependency injection
    const val hiltAndroidGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    private const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    private const val hiltAnnotationProcessor =
        "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    // Architecture components
    private const val viewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    private const val liveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycleVersion}"
    private const val lifeCycleCompiler =
        "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycleVersion}"

    private const val livedataUnitTest = "androidx.arch.core:core-testing:${Versions.archVersion}"

    // Navigation component
    const val navSafeArgsPlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navGraphVersion}"
    private const val navigationUI =
        "androidx.navigation:navigation-ui-ktx:${Versions.navGraphVersion}"
    private const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navGraphVersion}"

    private const val navigationTesting =
        "androidx.navigation:navigation-testing:${Versions.navGraphVersion}"

    // Room component
    private const val roomRunTime = "androidx.room:room-runtime:${Versions.roomVersion}"
    private const val roomAnnotationProcessor =
        "androidx.room:room-compiler:${Versions.roomVersion}"
    private const val roomKotlinAndCoroutines = "androidx.room:room-ktx:${Versions.roomVersion}"

    private const val roomTestingVersion = "androidx.room:room-testing:${Versions.roomVersion}"

    // work manager component
    private const val workManagerRunTime =
        "androidx.work:work-runtime-ktx:${Versions.workManagerVersion}"
    private const val hiltWorkManager = "androidx.hilt:hilt-work:${Versions.hiltWorkManager}"
    private const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"

    private const val workManagerTesting =
        "androidx.work:work-testing:${Versions.workManagerVersion}"

    // Networking
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    private const val loggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    private const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    private const val moshiCodeGenAnnotationProcessor =
        "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
    private const val moshiConverter =
        "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}"

    // Coroutines
    private const val coroutineKtx =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesKtx}"
    private const val coroutinesTesting =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesKtx}"

    // Glide
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    private const val glideAnnotation = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Glide libraries
    val glideLibraries = arrayListOf<String>().apply {
        add(glide)
    }

    val glideAnnotationLibraries = arrayListOf<String>().apply {
        add(glideAnnotation)
    }

    // Networking libraries
    val networkingLibraries = arrayListOf<String>().apply {
        add(retrofit)
        add(okHttp)
        add(loggingInterceptor)
        add(moshiKotlin)
        add(moshiConverter)
    }

    val networkingAnnotationProcessor = arrayListOf<String>().apply {
        add(moshiCodeGenAnnotationProcessor)
    }

    // Work manager libraries
    val workManagerLibraries = arrayListOf<String>().apply {
        add(workManagerRunTime)
        add(hiltWorkManager)
    }

    val workManagerTestingLibraries = arrayListOf<String>().apply {
        add(workManagerTesting)
    }

    // Room Libraries
    val roomLibraries = arrayListOf<String>().apply {
        add(roomRunTime)
        add(roomKotlinAndCoroutines)
    }

    val roomAnnotationProcessorLibraries = arrayListOf<String>().apply {
        add(roomAnnotationProcessor)
    }

    val roomTestingLibraries = arrayListOf<String>().apply {
        add(roomTestingVersion)
    }

    // App Libraries
    val appLibraries = arrayListOf<String>().apply {
        add(coreKtx)
        add(appcompat)
        add(constraintLayout)
        add(material)
        add(coroutineKtx)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testRuntimeEngines = arrayListOf<String>().apply {
//        add(junitJupiterEngine)
//        add(junitVintageEngine)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
        add(mockitoKotlin)
        add(coroutinesTesting)
        add(mockK)
//        add(junitJupiterApi)
//        add(junitParams)
    }

    // Hilt libraries
    val hiltLibraries = arrayListOf<String>().apply {
        add(hiltAndroid)
    }

    val hiltAnnotationProcessorLibraries = arrayListOf<String>().apply {
        add(hiltAnnotationProcessor)
        add(hiltCompiler)
    }

    // Architecture components Libraries
    val lifeCycleComponentLibraries = arrayListOf<String>().apply {
        add(viewModel)
        add(liveData)
        add(lifeCycleCompiler)
    }

    val lifeCycleTestComponentLibraries = arrayListOf<String>().apply {
        add(livedataUnitTest)
    }

    // Navigation Libraries
    val navGraphLibraries = arrayListOf<String>().apply {
        add(navigationUI)
        add(navigationFragment)
    }

    val navGraphTestingLibraries = arrayListOf<String>().apply {
        add(navigationTesting)
    }
}
