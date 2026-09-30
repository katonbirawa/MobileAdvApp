plugins {
    alias(libs.plugins.android.application)  // Mengaplikasikan Plugin Android Application utama
    alias(libs.plugins.kotlin.android)  //Mengaktifkan dukungan kompilasi bahasa Kotlin untukk android
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.mobileadvapp"
    // Menentukan namespace unik untuk generate kelas R dan BuildConfig aplikasi
    compileSdk = 36
    // // Menentukan SDK Android yang digunakan untuk mengompilasi aplikasi (API level 36)

    defaultConfig {
        // ID unik aplikasi di Google Play Store dan perangkat pengguna
        applicationId = "com.example.mobileadvapp"
        // // Batas minimal versi Android yang didukung (API 24 / Android 7.0 Nougat)
        minSdk = 24
        // Target versi Android yang dioptimalkan saat aplikasi dijalankan (API level 36)
        targetSdk = 36
        // Kode versi internal aplikasi (harus bertambah setiap rilis/update)
        versionCode = 1
        // Nama versi aplikasi yang tampil/terlihat oleh pengguna
        versionName = "1.0"
        // Runner yang digunakan untuk menjalankan unit test instrumen pada Android
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            // Mengatur apakah pengecilan kode (code obfuscation/minification) diaktifkan untuk build release
            isMinifyEnabled = false

            // Konfigurasi file aturan ProGuard/R8 untuk optimasi dan pengamannya
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
        // // Menentukan target versi JVM untuk kompilasi kode Kotlin (Java 11)
    }
    buildFeatures {
        viewBinding = true
        // // Mengaktifkan fitur View Binding untuk mempermudah dan mengamankan akses ke tampilan UI (layout XML)
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}