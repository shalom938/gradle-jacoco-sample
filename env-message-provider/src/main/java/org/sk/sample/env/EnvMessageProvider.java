package org.sk.sample.env;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sk.sample.message.spi.MessageProvider;

import java.util.Optional;

public class EnvMessageProvider implements MessageProvider {

    private static final Logger LOGGER = LogManager.getLogger();

    public EnvMessageProvider() {
        LOGGER.debug("creating a new instance");
    }

    @Override
    public Optional<String> nextMessage() {
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append("ENV: ");
        System.getenv().forEach((k, v) -> msgBuilder.append(k).append("=").append(v).append(","));
        msgBuilder.append(System.lineSeparator());
        msgBuilder.append("PROPERTIES:");
        System.getProperties().forEach((k, v) -> msgBuilder.append(k).append("=").append(v).append(","));
        msgBuilder.append(System.lineSeparator());
        Optional<String> result = Optional.of(msgBuilder.toString());
        LOGGER.debug("nextMessage invoked, returning: {}",result.orElseGet(null));
        return result;
    }
}
