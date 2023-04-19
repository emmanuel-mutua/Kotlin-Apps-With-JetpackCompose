
DAGGER HILT

plugins {
    id 'com.google.dagger.hilt.android' version '2.45' apply false
}

buildscript {

    ext.hilt_version = '2.35'
    dependencies {
        classpath "com.google.dagger:hilt-android-gradle-plugin:$hilt_version"
    }
}

plugins {

    id 'kotlin-kapt'
}

dependencies {

        implementation "com.google.dagger:hilt-android:2.44"
    kapt "com.google.dagger:hilt-compiler:2.44"
    
    }

