package org.sk.sample.messenger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sk.sample.message.spi.MessageProvider;
import org.sk.sample.messagejournal.MessagesJournal;
import org.sk.sample.messenger.internal.InternalHelper;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ServiceLoader;

public class Messenger {

    private static final Logger LOGGER = LogManager.getLogger();

    private MessagesJournal journal = MessagesJournal.create();
    private InternalHelper internalHelper = new InternalHelper();


    public Map<String, String> getAllMessages() {
        LOGGER.debug("getAllMessages invoked");
        Map<String, String> messages = new LinkedHashMap<>();
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        LOGGER.debug("found {} MessageProvider's ",serviceLoader.stream().count());
        serviceLoader.forEach(messageProvider -> {
            LOGGER.debug("got provider {}",messageProvider);
            String msg = internalHelper.getMessageFromProvider(messageProvider);
            if (msg != null) {
                LOGGER.debug("got message {} from provider {}",msg,messageProvider);
                messages.put(messageProvider.toString(), msg);
                journal.add(msg);
            }
        });
        return messages;
    }
}
