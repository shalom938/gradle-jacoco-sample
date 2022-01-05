package org.sk.sample.env;

import org.sk.sample.message.spi.MessageProvider;

import java.util.Optional;

public class EnvMessageProvider implements MessageProvider {

    @Override
    public Optional<String> nextMessage() {
        StringBuilder msgBuilder = new StringBuilder();
        msgBuilder.append("ENV: ");
        System.getenv().forEach((k, v) -> msgBuilder.append(k).append("=").append(v).append(","));
        msgBuilder.append(System.lineSeparator());
        msgBuilder.append("PROPERTIES:");
        System.getProperties().forEach((k, v) -> msgBuilder.append(k).append("=").append(v).append(","));
        msgBuilder.append(System.lineSeparator());
        return Optional.of(msgBuilder.toString());
    }
}
