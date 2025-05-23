plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.gms.google-services") // Apply Google Services plugin
    id("dev.flutter.flutter-gradle-plugin") // Flutter plugin
}

android {
    namespace = "com.example.flutter_demo_app"
    compileSdk = flutter.compileSdkVersion
    ndkVersion = flutter.ndkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    defaultConfig {
        applicationId = "com.example.flutter_demo_app"
        minSdk = flutter.minSdkVersion
        targetSdk = flutter.targetSdkVersion
        versionCode = flutter.versionCode
        versionName = flutter.versionName
    }

    buildTypes {
        release {
            // Use debug signing config temporarily; replace with your own signing config for production
            signingConfig = signingConfigs.getByName("debug")
            isMinifyEnabled = false // Enable if you want to shrink code
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            signingConfig = signingConfigs.getByName("debug")
        }
    }
}

dependencies {
    // Import the Firebase BoM to manage Firebase SDK versions
    implementation(platform("com.google.firebase:firebase-bom:33.14.0"))

    // Add Firebase SDKs you want to use (no versions needed when using BoM)
    implementation("com.google.firebase:firebase-analytics")

    // Add other Firebase dependencies as needed, e.g.:
    // implementation("com.google.firebase:firebase-auth")
    // implementation("com.google.firebase:firebase-firestore")

    // Flutter dependencies (if not already added by Flutter plugin)
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.10")
}

flutter {
    source = "../.."
}
