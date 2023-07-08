apply(from = "./buildSrc/settings.gradle.kts")

include(":app")
include(":core-view")
include(":core")
include(":feature-main")
include(":models")
// put your local path to models
project(":models").projectDir = File("")
include(":feature-authorization")
include(":feature-profile")
include(":feature-ui")
include(":feature-splash")
