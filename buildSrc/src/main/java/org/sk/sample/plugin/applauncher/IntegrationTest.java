package org.sk.sample.plugin.applauncher;

import org.gradle.api.GradleException;
import org.gradle.api.services.BuildServiceRegistry;
import org.gradle.api.tasks.testing.Test;

import javax.inject.Inject;
import java.io.IOException;

public class IntegrationTest extends Test {

    private AppLauncher appLauncher;
    private BuildServiceRegistry buildServiceRegistry;


    @Inject
    public IntegrationTest(BuildServiceRegistry buildServiceRegistry) {
        this.buildServiceRegistry = buildServiceRegistry;
    }

    @Override
    public void executeTests() {

        System.out.println("in task IntegrationTest");
        appLauncher = (AppLauncher) buildServiceRegistry.getRegistrations().getByName("appLauncher").getService().get();
        try {
            System.out.println("task IntegrationTest: starting app ");
            appLauncher.startApp();
            super.executeTests();
        } catch (IOException e) {
            throw new GradleException("could not start tests",e);
        }finally {
            System.out.println("task IntegrationTest: stopping app");
            //todo: maybe call shutdown http here too?
            appLauncher.close();
        }

    }

}
