package org.sk.sample.messenger;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessengerNoMessagesTest {

    //this test suite is whitebox testing, gradle will execute it with classpath and not module-path.
    //and there for Messenger should not find any providers because it's not running in the module system.
    //this test ensures that.
    @Test
    void testMessage() {
        Messenger messenger = new Messenger();
        Map<String, String> msgs = messenger.getAllMessages();
        assertEquals(0, msgs.size(), "messenger should not find providers here");
    }


}
