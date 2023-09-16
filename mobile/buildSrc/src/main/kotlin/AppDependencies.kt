object AppDependencies {

    const val MULTIDEX = "androidx.multidex:multidex:${AppVersions.MULTIDEX}"

    const val CORE_KTX = "androidx.core:core-ktx:${AppVersions.CORE_KTX}"
    const val RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx:${AppVersions.RUNTIME_KTX}"

    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${AppVersions.COMPOSE_ACTIVITY}"
    const val COMPOSE_UI = "androidx.compose.ui:ui:${AppVersions.COMPOSE_UI}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${AppVersions.COMPOSE_MATERIAL}"
    const val COMPOSE_PREVIEW = "androidx.compose.ui:ui-tooling-preview:${AppVersions.COMPOSE_UI}"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${AppVersions.COMPOSE_UI}"
    const val COMPOSE_MANIFEST = "androidx.compose.ui:ui-test-manifest:${AppVersions.COMPOSE_UI}"
    const val COMPOSE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-compose:${AppVersions.LIFECYCLE}"
    const val COMPOSE_LIFECYCLE = "androidx.lifecycle:lifecycle-runtime-compose:2.6.0"
    const val COMPOSE_NAVIGATION = "androidx.navigation:navigation-compose:${AppVersions.COMPOSE_NAVIGATION}"

    const val DAGGER = "com.google.dagger:dagger:${AppVersions.DAGGER}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${AppVersions.DAGGER}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${AppVersions.RETROFIT}"
    const val GSON = "com.squareup.retrofit2:converter-gson:${AppVersions.RETROFIT}"

    const val ROOM_RUNTIME = "androidx.room:room-runtime:${AppVersions.ROOM}"
    const val ROOM_COMPILER = "androidx.room:room-compiler:${AppVersions.ROOM}"

    const val DETEKT_FORMATTING = "io.gitlab.arturbosch.detekt:detekt-formatting:${AppVersions.DETEKT}"
}
