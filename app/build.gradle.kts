plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    kotlin("kapt")  // Asegúrate de tener KAPT
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.google.gms.google.services) // Plugin de Hilt


}

android {
    namespace = "com.proyecto.practica"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.proyecto.practica"
        minSdk = 26
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // Hilt Core
    implementation("com.google.dagger:hilt-android:2.48")
    implementation(libs.firebase.auth) // Reemplaza con la última versión estable
    kapt("com.google.dagger:hilt-compiler:2.48") // Reemplaza con la misma versión que hilt-android

    // Hilt para ViewModels en Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0") // Reemplaza con la última versión estable

    //Firestore
    implementation("com.google.firebase:firebase-firestore-ktx:25.0.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}