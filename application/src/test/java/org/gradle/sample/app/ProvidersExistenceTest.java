package org.gradle.sample.app;

import org.gradle.sample.app.server.Server;
import org.gradle.sample.messenger.spi.MessageProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ServiceLoader;

import static org.junit.jupiter.api.Assertions.assertEquals;

//test that we can find the two MessageProvider in this sample project.
//need to add uses for that to work
public class ProvidersExistenceTest {

    @BeforeAll
    public static void addUses() {
        Server.class.getModule().addUses(org.gradle.sample.messenger.spi.MessageProvider.class);
    }


    @Test
    public void testProvidersExistence() {
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        assertEquals(2, serviceLoader.stream().count(), "two services should be in classpath/modulepath");
    }
}
