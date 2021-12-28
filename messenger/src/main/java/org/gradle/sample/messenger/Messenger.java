package org.gradle.sample.messenger;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Messenger {

    private MessageProvider messageProvider;


    public Messenger() {
        ServiceLoader<MessageProvider> sl
                = ServiceLoader.load(MessageProvider.class);
        Iterator<MessageProvider> iter = sl.iterator();
        if (!iter.hasNext())
            throw new RuntimeException("No service MessageProvider found!");
        this.messageProvider = iter.next();
    }


    public String getNextMessage() {
        return messageProvider.nextMessage();
    }
}
