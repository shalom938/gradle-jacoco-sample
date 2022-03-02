package org.sk.sample.cmd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sk.sample.message.spi.MessageProvider;

import java.util.Optional;

public class CommandLineMessageProvider implements MessageProvider {

    private static final Logger LOGGER = LogManager.getLogger();

    public CommandLineMessageProvider() {
        LOGGER.debug("creating a new instance");
    }

    @Override
    public Optional<String> nextMessage() {
        Optional<String> result = Optional.of(capitalize(ProcessHandle.current().info().commandLine().orElse(null)));
        LOGGER.trace("nextMessage invoked, returning: {}",result.orElseGet(null));
        return result;
    }
}
