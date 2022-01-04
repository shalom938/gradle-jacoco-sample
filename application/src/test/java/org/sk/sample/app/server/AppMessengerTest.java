package org.sk.sample.app.server;

import org.junit.jupiter.api.Test;
import org.sk.sample.messenger.Messenger;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


//test that messenger works in this module

class AppMessengerTest {


    @Test
    void testMessage() {

        Messenger messenger = new Messenger();
        Map<String, String> msgs = messenger.getAllMessages();
        assertEquals(2,msgs.size(),"expecting 2 messages");
        assertNotNull(msgs, "messenger returned null");
        assertFalse(msgs.isEmpty(), "messenger returned empty map");

        msgs.forEach((k, v) -> {
            assertNotNull(k, "message provider name is null");
            assertNotNull(k, "message provider message is null");
            System.out.println("got message from ".concat(k).concat(", message: ").concat(v));
        });

    }
}
