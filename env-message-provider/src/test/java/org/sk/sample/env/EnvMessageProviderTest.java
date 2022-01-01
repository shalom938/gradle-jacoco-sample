package org.sk.sample.env;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnvMessageProviderTest {

    @Test
    void testCmdProvider() {
        Optional<String> msg = new EnvMessageProvider().nextMessage();
        assertNotNull(msg.orElse(null), "EnvMessageProvider returned null message");
    }
}
