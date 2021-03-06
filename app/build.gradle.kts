plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kotlin-android")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.deneb.epicsevenappdb"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled =  false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packagingOptions {
        exclude("LICENSE.txt")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/ASL2.0")
        exclude("META-INF/NOTICE")
        exclude("META-INF/NOTICE")
    }

    buildFeatures {
        //compose=true
        viewBinding=true
    }
    composeOptions {
        kotlinCompilerVersion = "1.4.10"
        kotlinCompilerExtensionVersion = "1.0.0-alpha02"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        //useIR = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    //Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.10")
    //Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.3.8")

    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.annotation:annotation:1.2.0")
    implementation("androidx.preference:preference-ktx:1.1.1")
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.3.1")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-savedstate:2.4.0-alpha02")

    // Firebase Cloud Firestore (Kotlin)
    implementation("com.google.firebase:firebase-firestore-ktx:23.0.1")

    // KOIN
    val koin_version = "2.1.6"
    // Koin AndroidX Scope feature
    implementation ("org.koin:koin-androidx-scope:$koin_version")

// Koin AndroidX ViewModel feature
    implementation( "org.koin:koin-androidx-viewmodel:$koin_version")

// Koin AndroidX Fragment Factory (unstable version)
    implementation ("org.koin:koin-androidx-fragment:$koin_version")
    //implementation("org.koin:koin-androidx-viewmodel:2.1.0-alpha-10")

    //Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.5")


    kapt("androidx.room:room-compiler:2.3.0")
    compileOnly("javax.annotation:jsr250-api:1.0")
    compileOnly("javax.inject:javax.inject:1")

    implementation("org.jetbrains.anko:anko:0.10.8")

    implementation("com.github.bumptech.glide:glide:4.11.0")

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")
    implementation("androidx.room:room-runtime:2.3.0")

    implementation("com.michael-bull.kotlin-result:kotlin-result:1.1.6")

    implementation ("com.github.HarinTrivedi:FABRevealMenu-master:2.0.0")

    //RatingBar


    //Compose

/*    val composeVersion = "1.0.0-alpha02"

    implementation("androidx.compose.runtime:runtime-dispatch:$composeVersion")
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.animation:animation-core:$composeVersion")
    implementation("androidx.compose.animation:animation:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation( "androidx.compose.ui:ui-geometry:$composeVersion")
    implementation("androidx.compose.ui:ui-graphics:$composeVersion")
    implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.material:material-icons-core:$composeVersion")
    implementation( "androidx.compose.material:material-icons-extended:$composeVersion")
    implementation( "androidx.compose.runtime:runtime-rxjava2:$composeVersion")
    implementation("androidx.compose.ui:ui-text:$composeVersion")
    implementation("androidx.compose.ui:ui-text:$composeVersion")
    implementation("androidx.compose.ui:ui-text-android:$composeVersion")
    implementation("androidx.compose.ui:ui-util:$composeVersion")
    implementation ("androidx.compose.ui:ui-viewbinding:$composeVersion")

    //coil
    implementation("dev.chrisbanes.accompanist:accompanist-coil:0.2.1")*/

    // Unit Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.nhaarman:mockito-kotlin:1.5.0")
    testImplementation("org.mockito:mockito-core:3.5.6")
    testImplementation("io.kotlintest:kotlintest:2.0.7")
    testImplementation("android.arch.core:core-testing:1.1.1")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0")
    testImplementation("org.robolectric:robolectric:4.4")
    testImplementation("org.amshove.kluent:kluent-android:1.61")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
    testImplementation("org.mockito:mockito-inline:3.4.6")


}
