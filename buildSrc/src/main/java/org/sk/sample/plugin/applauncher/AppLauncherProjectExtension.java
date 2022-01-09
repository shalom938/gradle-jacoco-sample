package org.sk.sample.plugin.applauncher;

import org.gradle.api.file.DirectoryProperty;
import org.gradle.api.provider.Property;

public abstract class AppLauncherProjectExtension {

    abstract Property<Integer> getPort();
    abstract Property<String> getHost();
    abstract DirectoryProperty getInstallationDirectory();
    abstract DirectoryProperty getJavaHome();
    abstract Property<String> getJavaOpts();

    public AppLauncherProjectExtension() {
        getPort().convention(8001);
        getHost().convention("localhost");
        getJavaOpts().convention("");
    }
}
