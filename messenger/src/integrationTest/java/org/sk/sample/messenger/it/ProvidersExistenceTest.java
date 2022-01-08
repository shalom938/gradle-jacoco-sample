package org.sk.sample.messenger.it;

import org.junit.jupiter.api.Test;
import org.sk.sample.message.spi.MessageProvider;
import org.sk.sample.test.Printer;

import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProvidersExistenceTest {

    //test that we can find the two MessageProviders
    @Test
    public void testProvidersExistence() {

        Printer.printEnv(getClass().getSimpleName());

        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        assertEquals(2, serviceLoader.stream().count(), "two services should be in classpath/modulepath");
    }
}
