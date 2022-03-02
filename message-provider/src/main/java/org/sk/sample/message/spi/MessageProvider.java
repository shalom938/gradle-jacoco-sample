package org.sk.sample.message.spi;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * A provider of messages.
 * <p>
 * implementation of this interface are required to produce a message every time {@link #nextMessage()} is called.
 */
public interface MessageProvider {

    Optional<String> nextMessage();

    default Optional<String> nextMessageCapitalize(){
        return Optional.of(capitalize(nextMessage().orElse(null)));
    }

    //todo: change to abbreviate
    default String capitalize(String message) {
        return StringUtils.capitalize(message);
    }

}
