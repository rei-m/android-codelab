// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
//    ext.kotlin_version = "1.3.72"
    val kotlin_version by extra("1.3.72")
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

//task clean(type: Delete) {
//    delete(rootProject.buildDir)
//}
task<Delete>("clean") {
    delete(rootProject.buildDir)
}
