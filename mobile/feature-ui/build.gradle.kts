plugins {
    id ("com.android.library")
    id ("module-plugin")
    id ("di-plugin")
    id ("compose-plugin")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":core-view"))
}
