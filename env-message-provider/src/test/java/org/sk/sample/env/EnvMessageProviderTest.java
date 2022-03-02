package org.sk.sample.env;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sk.sample.message.spi.MessageProvider;
import org.sk.sample.test.Printer;

import java.util.Optional;
import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class EnvMessageProviderTest {


    @BeforeAll
    public static void addUses() {
        EnvMessageProviderTest.class.getModule().addUses(MessageProvider.class);
    }


    @Test
    void testNextMessage() {

        Printer.printEnv(getClass().getSimpleName());

        Optional<String> msg = new EnvMessageProvider().nextMessage();
        assertNotNull(msg.orElse(null), "EnvMessageProvider returned null message");
    }


    //this test should run inside the module system
    @Test
    void testAsService() {
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        assertEquals(1, serviceLoader.stream().count(), "EnvMessageProvider service should be found");
        EnvMessageProvider envMessageProvider = (EnvMessageProvider) serviceLoader.findFirst().get();
        Optional<String> msg = envMessageProvider.nextMessage();
        assertNotNull(msg.orElse(null), "EnvMessageProvider returned null message");
    }
}
