plugins {
    id("com.android.application")
    id("kotlin-android")
    // Apply the App Distribution Gradle plugin
    id("com.google.firebase.appdistribution")
    // Google Services plugin
    id("com.google.gms.google-services")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.vad99lord.firebasetest"
        minSdk = 21
        targetSdk = 31
        versionCode = 1
        versionName = "1.2"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("proguard-rules.pro")
            )
            firebaseAppDistribution {
                appId="1:909192653282:android:48abc640749149a74471bb"
                artifactType="APK"
            }
        }
        getByName("debug") {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
            firebaseAppDistribution {
                appId="1:909192653282:android:2386e2b8f60ae6ef4471bb"
                artifactType="APK"
            }
        }
    }
    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
