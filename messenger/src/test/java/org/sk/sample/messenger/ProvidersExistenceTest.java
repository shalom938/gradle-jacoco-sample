package org.sk.sample.messenger;

import org.junit.jupiter.api.Test;
import org.sk.sample.message.spi.MessageProvider;

import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

//test that we can find the two MessageProvider
public class ProvidersExistenceTest {


    @Test
    public void testProvidersExistence() {
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        assertEquals(2, serviceLoader.stream().count(), "two services should be in classpath/modulepath");
    }
}
