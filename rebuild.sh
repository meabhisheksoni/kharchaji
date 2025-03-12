./gradlew installDebug && adb shell am force-stop com.example.kharchaji && adb shell monkey -p com.example.kharchaji -c android.intent.category.LAUNCHER 1
