package org.gradle.sample.cmd;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommandLineMessageProviderTest {

    @Test
    void testCmdProvider() {
        Optional<String> msg = new CommandLineMessageProvider().nextMessage();
        assertNotNull(msg.orElse(null), "CommandLineMessageProvider returned null message");
    }
}
