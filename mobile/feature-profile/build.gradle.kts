plugins {
    id ("com.android.library")
    id ("module-plugin")
    id ("di-plugin")
    id ("compose-plugin")
    id ("network-plugin")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":core-view"))
    implementation(project(":models"))
}
