package org.sk.sample.plugin.applauncher;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.provider.Provider;
import org.gradle.jvm.toolchain.JavaLanguageVersion;
import org.gradle.jvm.toolchain.JavaToolchainService;

public class AppLauncherPlugin implements Plugin<Project> {


    @Override
    public void apply(final Project project) {
        var javaHome = project.getExtensions().getByType(JavaToolchainService.class).
                launcherFor(javaToolchainSpec ->
                        javaToolchainSpec.getLanguageVersion().set(JavaLanguageVersion.of(11))).
                get().getMetadata().getInstallationPath();


        var extension = project.getExtensions().create("appLauncher", AppLauncherProjectExtension.class);
        extension.getJavaHome().convention(javaHome);
        //todo: take the value from installDist task
        extension.getInstallationDirectory().convention(project.getLayout().getBuildDirectory().get().dir("install/application"));


        project.afterEvaluate(project1 -> {
            Provider<AppLauncher> serviceProvider = project1.getGradle().getSharedServices().
                    registerIfAbsent("appLauncher", AppLauncher.class, spec -> {
                        System.out.println("configuring AppLauncher parameters");
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
