plugins {
    `groovy-gradle-plugin`
    `java-gradle-plugin`
}


gradlePlugin {
    plugins {
        create("AppLauncherPlugin") {
            id = "org.sk.sample.plugin.applauncher.AppLauncherPlugin"
            implementationClass = "org.sk.sample.plugin.applauncher.AppLauncherPlugin"
        }
    }
}
