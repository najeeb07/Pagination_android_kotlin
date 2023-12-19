plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
//    kotlin("kapt")
//    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.najeebappdev.dogs"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.najeebappdev.dogs"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    viewBinding {
        enable = true
    }
}

//kapt {
//    correctErrorTypes = true
//}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.14-SNAPSHOT")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val paging_version = "3.2.1"

    implementation("androidx.paging:paging-runtime:$paging_version")

    implementation("io.coil-kt:coil-compose:2.5.0")


//    implementation("com.google.dagger:hilt-android:2.48")
//    kapt("com.google.dagger:hilt-android-compiler:2.48")



    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")
    //moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.15.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")


}