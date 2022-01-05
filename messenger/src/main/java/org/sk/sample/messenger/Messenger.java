package org.sk.sample.messenger;

import org.sk.sample.messagejournal.MessagesJournal;
import org.sk.sample.message.spi.MessageProvider;
import org.sk.sample.messenger.internal.InternalHelper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;

public class Messenger {

    private MessagesJournal journal = MessagesJournal.create();
    private InternalHelper internalHelper = new InternalHelper();

    public Messenger() {
    }


    public Map<String, String> getAllMessages() {
        Map<String, String> messages = new LinkedHashMap<>();
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        serviceLoader.forEach(messageProvider -> {
            String msg = internalHelper.getMessageFromProvider(messageProvider);
            if (msg != null) {
                messages.put(messageProvider.toString(), msg);
                journal.add(msg);
            }
        });
        return messages;
    }
}
