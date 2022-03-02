package org.sk.sample.plugin.applauncher;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import org.gradle.api.logging.Logging;
import org.gradle.api.provider.Provider;
import org.gradle.jvm.toolchain.JavaLanguageVersion;
import org.gradle.jvm.toolchain.JavaToolchainService;

public class AppLauncherPlugin implements Plugin<Project> {

    private static final Logger LOGGER = Logging.getLogger(AppLauncherPlugin.class);

    @Override
    public void apply(final Project project) {

        var javaHome = project.getExtensions().getByType(JavaToolchainService.class).
                launcherFor(javaToolchainSpec ->
                        javaToolchainSpec.getLanguageVersion().set(JavaLanguageVersion.of(11))).
                get().getMetadata().getInstallationPath();


        var extension = project.getExtensions().create("appLauncher", AppLauncherProjectExtension.class);
        extension.getJavaHome().convention(javaHome);
        //this is a convention, the actual path should be set in the extension
        extension.getInstallationDirectory().convention(project.getLayout().getBuildDirectory().get().dir("install/application"));


        project.afterEvaluate(project1 -> {
            project1.getGradle().getSharedServices().
                    registerIfAbsent("appLauncher", AppLauncher.class, spec -> {
                        LOGGER.info("configuring AppLauncher parameters");
                        spec.getParameters().getJavaHome().set(extension.getJavaHome().get());
                        spec.getParameters().getHost().set(extension.getHost().get());
                        spec.getParameters().getPort().set(extension.getPort().get());
                        spec.getParameters().getJavaOpts().set(extension.getJavaOpts().get());
                        spec.getParameters().getInstallationDirectory().set(extension.getInstallationDirectory().get());
                        spec.getMaxParallelUsages().set(1);
                    });
        });
    }
}
