object ApplicationId {
    const val id = "com.renaldysabdo.apigithub"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val compileSdk = 30
    val minSdk = 19
    val targetSdk = 30
    val buildTools = "30.0.2"
    val kotlin = "1.4.21"
    val coreKtx = "1.3.2"
    val appCompat = "1.2.0"
    val constraintLayout = "2.0.4"
    val materialDesign = "1.2.1"
    val espresso = "3.3.0"
    val junit = "4.13.1"
    val androidxJunit = "1.1.2"

    val recyclerview = "1.0.0"
    val glide = "4.10.0"
    val retrofit = "2.9.0"
    val legacySupport = "1.0.0"
    val multidex = "2.0.1"
    val cardview = "1.0.0"
    val koin = "2.1.6"
    val coroutines = "1.3.9"
    val loggingInterceptor = "4.9.0"
    val lifecycle = "2.2.0"
    val pagedList = "3.0.0-alpha03"
    val timber = "4.7.1"
    val circleImage = "3.1.0"
}

object Libraries {
    //glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    //koin
    val koinCore = "org.koin:koin-core:${Versions.koin}"
    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    //retrofit
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val okhttp = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"
    //coroutines
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    //pagedList
    val pagedList = "androidx.paging:paging-runtime:${Versions.pagedList}"
    //timber
    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    //circle image
    val circleImage = "de.hdodenhof:circleimageview:${Versions.circleImage}"
    //legacy
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    //ui list
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    //multidex
    val multidex = "androidx.multidex:multidex:${Versions.multidex}"
    //lifecycle
    val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
}

object KotlinLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
}

object AndroidLibraries {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val materialDesign  = "com.google.android.material:material:${Versions.materialDesign}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val androidxJunit = "androidx.test.ext:junit:${Versions.androidxJunit}"
    val jUnit = "junit:junit:${Versions.junit}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}