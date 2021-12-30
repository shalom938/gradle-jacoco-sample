package org.gradle.sample.messenger;

import org.gradle.sample.journal.MessagesJournal;
import org.gradle.sample.messenger.spi.MessageProvider;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;

public class Messenger {

    private MessagesJournal journal = MessagesJournal.create();

    public Messenger() {
    }


    public Map<String, String> getAllMessages() {
        Map<String, String> messages = new LinkedHashMap<>();
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        serviceLoader.forEach(messageProvider -> {
            Optional<String> msg = messageProvider.nextMessage();
            if (msg.isPresent()) {
                messages.put(messageProvider.toString(), msg.get());
                journal.add(msg.get());
            }
        });
        return messages;
    }
}
