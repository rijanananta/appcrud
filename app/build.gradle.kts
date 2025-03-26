plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt") // KAPT untuk Room Database
}

android {
    namespace = "com.example.apcrud"
    compileSdk = 35 // Gunakan versi yang stabil

    defaultConfig {
        applicationId = "com.example.apcrud"
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    dependenciesInfo {
        includeInApk = true
        includeInBundle = true
    }
}

// ✅ Konfigurasi KAPT (Wajib untuk Room Database)
kapt {
    correctErrorTypes = true
}

// ✅ Versi Library
val kotlinVersion = "1.9.0"
val roomVersion = "2.6.1"
val lifecycleVersion = "2.7.0"
val navigationVersion = "2.7.7" // ✅ Gunakan versi terbaru untuk Navigation

dependencies {
    // ✅ Jetpack Compose & Material
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation("androidx.compose.material3:material3:1.2.0") // ✅ Gunakan versi stabil

    // ✅ Room Database (Gunakan KAPT untuk Annotation Processing)
    implementation("androidx.room:room-runtime:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")

    // ✅ Lifecycle & ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")

    // ✅ Navigation Compose
    implementation("androidx.navigation:navigation-compose:$navigationVersion")

    // ✅ Kotlin BOM untuk kompatibilitas
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"))

    // ✅ Testing Libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.10.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

    // ✅ Debugging Tools
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
