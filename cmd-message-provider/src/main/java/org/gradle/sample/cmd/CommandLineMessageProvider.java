package org.gradle.sample.cmd;

import org.gradle.sample.messenger.MessageProvider;

public class CommandLineMessageProvider implements MessageProvider {

    @Override
    public String nextMessage() {
        return capitalize(ProcessHandle.current().info().commandLine().orElse("no command line???"));
    }
}
