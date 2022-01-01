package org.sk.sample.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.sk.sample.app.server.Server;
import org.sk.sample.messenger.spi.MessageProvider;

import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

//test that we can find the two MessageProvider in this sample project.
public class ProvidersExistenceTest {

    @BeforeAll
    public static void addUses() {
        //in order to query service providers the module needs to declare 'uses',
        //but the application module doesn't really need that, so this will add the 'uses' only for
        //the test
        Server.class.getModule().addUses(MessageProvider.class);
    }


    @Test
    public void testProvidersExistence() {
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        assertEquals(2, serviceLoader.stream().count(), "two services should be in classpath/modulepath");
    }
}