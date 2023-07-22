plugins {
    id ("com.android.library")
    id ("module-plugin")
    id ("di-plugin")
    id ("network-plugin")
    id ("compose-plugin")
    id ("data-plugin")
}

dependencies {
    implementation(project(":models"))
}
