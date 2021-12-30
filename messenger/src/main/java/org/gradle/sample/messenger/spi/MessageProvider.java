package org.gradle.sample.messenger.spi;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public interface MessageProvider {


    Optional<String> nextMessage();

    default String capitalize(String message) {
        return StringUtils.capitalize(message);
    }

}
