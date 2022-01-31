package org.sk.sample.message.spi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class MessageProviderTest {

    @Test
    void testCapitalize() {
        MessageProvider messageProvider = (() -> Optional.of("hello"));
        String capitalized = messageProvider.capitalize(messageProvider.nextMessage().orElse(null));
        Assertions.assertEquals("Hello", capitalized, "first letter should be capitalized");
    }

    @Test
    void testNextMessageCapitalize() {
        MessageProvider messageProvider = (() -> Optional.of("hello"));
        String capitalized = messageProvider.nextMessageCapitalize().orElse(null);
        Assertions.assertEquals("Hello", capitalized, "first letter should be capitalized");
    }
}
