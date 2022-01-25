package org.sk.sample.messenger.it;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.sk.sample.messenger.Messenger;
import org.sk.sample.test.Printer;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessengerTest {

    @Test
    void testMessage() {

        Printer.printEnv(getClass().getSimpleName());

        Messenger messenger = new Messenger();
        Map<String, String> msgs = messenger.getAllMessages();
        assertNotNull(msgs, "messenger returned null");
        assertFalse(msgs.isEmpty(), "messenger returned empty map");
        assertEquals(2, msgs.size(), "expecting 2 messages");

        msgs.forEach((key, value) -> {
            assertNotNull(key, "message provider name is null");
            assertNotNull(value, "message provider message is null");
            System.out.println("***************************************************");
            System.out.println(StringUtils.capitalize("got message from ".concat(key).concat(", message: ").concat(value)));
        });

    }
}
