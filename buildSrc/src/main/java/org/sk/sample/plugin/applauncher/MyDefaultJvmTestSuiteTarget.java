package org.sk.sample.plugin.applauncher;

import org.gradle.api.Buildable;
import org.gradle.api.internal.tasks.AbstractTaskDependency;
import org.gradle.api.internal.tasks.TaskDependencyResolveContext;
import org.gradle.api.plugins.JavaBasePlugin;
import org.gradle.api.tasks.TaskContainer;
import org.gradle.api.tasks.TaskDependency;
import org.gradle.api.tasks.TaskProvider;
import org.gradle.api.tasks.testing.Test;
import org.gradle.util.internal.GUtil;

import javax.inject.Inject;

public abstract class MyDefaultJvmTestSuiteTarget implements MyJvmTestSuiteTarget, Buildable {

    private final String name;
    private final TaskProvider<? extends Test> testTask;

    @Inject
    public MyDefaultJvmTestSuiteTarget(String name, TaskContainer tasks) {

        System.out.println("in MyDefaultJvmTestSuiteTarget");
        this.name = name;

        // Might not always want Test type here?
        this.testTask = tasks.register(name, IntegrationTest.class, t -> {
            t.setDescription("Runs the " + GUtil.toWords(name) + " suite.");
            t.setGroup(JavaBasePlugin.VERIFICATION_GROUP);
        });
    }

    @Override
    public String getName() {
        return name;
    }

    @SuppressWarnings("unchecked")
    public TaskProvider<Test> getTestTask() {
        return (TaskProvider<Test>) testTask;
    }

    @Override
    public TaskDependency getBuildDependencies() {
        return new AbstractTaskDependency() {
            @Override
            public void visitDependencies(TaskDependencyResolveContext context) {
                context.add(getTestTask());
            }
        };
    }
}
