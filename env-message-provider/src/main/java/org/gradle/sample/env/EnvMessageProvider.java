package org.gradle.sample.env;

import org.gradle.sample.messenger.spi.MessageProvider;

import java.util.Optional;

public class EnvMessageProvider implements MessageProvider {

    @Override
    public Optional<String> nextMessage() {

        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append("ENV:").append(System.lineSeparator());
        System.getenv().forEach((k, v) -> msgBuilder.append(k).append("=").append(v).append(",").append(System.lineSeparator()));
        msgBuilder.append("PROPERTIES:").append(System.lineSeparator());
        System.getProperties().forEach((k, v) -> msgBuilder.append(k).append("=").append(v).append(",").append(System.lineSeparator()));

        return Optional.of(msgBuilder.toString());
    }
}
