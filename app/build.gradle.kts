import org.jetbrains.kotlin.storage.CacheResetOnProcessCanceled.enabled

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    // Add the Google services Gradle plugin
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.giveback"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.giveback"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        dataBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.databinding:databinding-runtime:8.3.1")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("com.google.firebase:firebase-firestore-ktx:24.11.1")

    // api key push를 위한 라이브러리
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.14")
    implementation("com.google.code.gson:gson:2.10.1")

    // 8개이상의 라이브러리를 추가하기 위함
    implementation("androidx.multidex:multidex:2.0.1")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("com.github.bumptech.glide:glide:4.16.0")

    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.8.0"))

    // 파이어베이스 인증을 사용하기 위함
    implementation("com.google.firebase:firebase-auth-ktx:22.3.1")

    // 파이어베이스 실시간 데이터베이스를 사용하기 위함
    implementation("com.google.firebase:firebase-database-ktx")

    // 파이어베이스 스토리지를 사용하기 위함
    implementation("com.google.firebase:firebase-storage-ktx:20.2.1")

    // 파이어베이스 클라우드 메시징을 사용하기 위함
    implementation("com.google.firebase:firebase-messaging-ktx:12.0.0")
    implementation("com.google.firebase:firebase-analytics-ktx:21.1.1")
}