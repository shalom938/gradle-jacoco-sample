package org.sk.sample.cmd;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sk.sample.message.spi.MessageProvider;
import org.sk.sample.test.Printer;

import java.util.Optional;
import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CommandLineMessageProviderTest {


    @BeforeAll
    public static void addUses(){
        CommandLineMessageProvider.class.getModule().addUses(MessageProvider.class);
    }



    @Test
    void testCmdProvider() {

        Printer.printEnv(getClass().getSimpleName());

        Optional<String> msg = new CommandLineMessageProvider().nextMessage();
        assertNotNull(msg.orElse(null), "CommandLineMessageProvider returned null message");
    }


    //this test should run inside the module system
    @Test
    void testAsService(){
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        assertEquals(1, serviceLoader.stream().count(), "CommandLineMessageProvider service should be found");
        CommandLineMessageProvider commandLineMessageProvider = (CommandLineMessageProvider) serviceLoader.findFirst().get();
        Optional<String> msg = commandLineMessageProvider.nextMessage();
        assertNotNull(msg.orElse(null), "CommandLineMessageProvider returned null message");
    }
}
