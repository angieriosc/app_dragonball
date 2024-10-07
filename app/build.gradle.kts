plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.kotlin.exam_s"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.kotlin.exam_s"
        minSdk = 24
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
    buildFeatures {
        viewBinding = true
        buildConfig = true
        dataBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.ui.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //Retrofit is used for network calls, with a Gson converter to parse JSON responses from a web API into Java/Kotlin objects
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson converter for parsing JSON responses using Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // Glide library for image loading and caching
    implementation("com.github.bumptech.glide:glide:4.12.0")
    // Annotation processor for Glide to generate necessary code during compilation
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    // Glide transformations for applying effects to images
    implementation("jp.wasabeef:glide-transformations:4.3.0")

    // Kotlin Coroutines for handling asynchronous tasks
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1")

    // AndroidX Fragment library with Kotlin extensions
    implementation("androidx.fragment:fragment-ktx:1.5.0")
    // AndroidX Activity library with Kotlin extensions
    implementation("androidx.activity:activity-ktx:1.5.0")

    // Data Binding library for connecting UI components with data
    implementation("androidx.databinding:databinding-runtime:7.1.2")

    // ViewModel library for managing UI-related data lifecycle-aware
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")
    // LiveData library for observing data changes in a lifecycle-aware way
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
}
