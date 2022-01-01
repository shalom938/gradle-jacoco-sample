package org.sk.sample.messenger;

import org.junit.jupiter.api.Test;

import java.lang.management.ManagementFactory;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MessengerTest {


    @Test
    void testMessage() {

        //just for exploring the java command line and for demonstrating how to add a java module
        //only for tests, in this case java.management
        System.out.println("command line arguments in unit test MessengerTest:");
        ManagementFactory.getRuntimeMXBean().getInputArguments().forEach(s -> System.out.println("arg: " + s));

        Messenger messenger = new Messenger();
        Map<String, String> msgs = messenger.getAllMessages();
        assertNotNull(msgs, "messenger returned null");
        assertFalse(msgs.isEmpty(), "messenger returned empty map");

        msgs.forEach((k, v) -> {
            assertNotNull(k, "message provider name is null");
            assertNotNull(k, "message provider message is null");
            System.out.println("got message from ".concat(k).concat(", message: ").concat(v));
        });

    }
}
