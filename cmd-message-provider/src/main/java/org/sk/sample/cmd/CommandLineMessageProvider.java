package org.sk.sample.cmd;

import org.sk.sample.message.spi.MessageProvider;

import java.util.Optional;

public class CommandLineMessageProvider implements MessageProvider {

    @Override
    public Optional<String> nextMessage() {
        return Optional.of(capitalize(ProcessHandle.current().info().commandLine().orElse(null)));
    }
}
