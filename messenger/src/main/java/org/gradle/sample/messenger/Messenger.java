package org.gradle.sample.messenger;

import java.util.*;

public class Messenger {

    public Messenger() {
    }


    public Map<String,String> getAllMessages() {
        Map<String,String> messages = new LinkedHashMap<>();
        ServiceLoader<MessageProvider> serviceLoader = ServiceLoader.load(MessageProvider.class);
        serviceLoader.forEach(messageProvider -> messages.put(messageProvider.toString(),messageProvider.nextMessage()));
        return messages;
    }
}
