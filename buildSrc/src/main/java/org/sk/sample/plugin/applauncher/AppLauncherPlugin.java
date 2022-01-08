package org.sk.sample.plugin.applauncher;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.jvm.toolchain.JavaLanguageVersion;
import org.gradle.jvm.toolchain.JavaToolchainService;

public class AppLauncherPlugin implements Plugin<Project> {


    @Override
    public void apply(final Project project) {
        String javaHome = project.getExtensions().getByType(JavaToolchainService.class).
                                        launcherFor(javaToolchainSpec ->
                                            javaToolchainSpec.getLanguageVersion().set(JavaLanguageVersion.of(11))).
                                            get().getMetadata().getInstallationPath().getAsFile().getAbsolutePath();




    }
}
