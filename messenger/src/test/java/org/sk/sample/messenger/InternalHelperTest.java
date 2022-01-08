package org.sk.sample.messenger;

import org.junit.jupiter.api.Test;
import org.sk.sample.message.spi.MessageProvider;
import org.sk.sample.messenger.internal.InternalHelper;
import org.sk.sample.test.Printer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InternalHelperTest {

    @Test
    void testInternalHelper() {

        Printer.printEnv(getClass().getSimpleName());

        MessageProvider messageProvider = () -> Optional.of("Hello");
        String msg = new InternalHelper().getMessageFromProvider(messageProvider);
        assertEquals("Hello", msg, "unexpected message " + msg);
    }
}
