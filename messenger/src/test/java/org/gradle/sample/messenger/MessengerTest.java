package org.gradle.sample.messenger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MessengerTest {


    @Test
    public void testMessage() throws ReflectiveOperationException {
        Messenger messenger = new Messenger();
        String msg = messenger.getNextMessage();
        System.out.println("got message "+msg);
        assertNotNull(msg);
    }
}
