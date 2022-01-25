package org.sk.sample.messenger.internal;

import org.sk.sample.message.spi.MessageProvider;

import java.util.Optional;

//just a simple internal class to test module boundaries
public class InternalHelper {
    public String getMessageFromProvider(MessageProvider messageProvider) {
        Optional<String> msg = messageProvider.nextMessage();
        return msg.orElse(null);
    }
}
