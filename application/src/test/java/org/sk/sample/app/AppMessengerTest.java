package org.sk.sample.app;


import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.sk.sample.messenger.Messenger;
import org.sk.sample.test.Printer;

import java.lang.management.ManagementFactory;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


//test that messenger works and wired correctly in this module
class AppMessengerTest {

    @Test
    void testMessage() {

        Printer.printEnv(getClass().getSimpleName());

        Messenger messenger = new Messenger();
        Map<String, String> msgs = messenger.getAllMessages();
        assertEquals(2, msgs.size(), "expecting 2 messages");
        assertNotNull(msgs, "messenger returned null");
        assertFalse(msgs.isEmpty(), "messenger returned empty map");

        msgs.forEach((k, v) -> {
            assertNotNull(k, "message provider name is null");
            assertNotNull(k, "message provider message is null");
            System.out.println(StringUtils.capitalize("got message from ".concat(k).concat(", message: ").concat(v)));
        });
    }
}
