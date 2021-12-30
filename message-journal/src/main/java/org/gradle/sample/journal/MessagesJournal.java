package org.gradle.sample.journal;

import org.gradle.sample.journal.impl.StringJournal;
import org.gradle.sample.utilities.MessageFormatter;

import java.util.List;

public interface MessagesJournal extends Journal<String> {

    static MessagesJournal create() {
        return new MessagesJournal() {
            @Override
            public boolean add(String item) {
                return StringJournal.getInstance().add(item);
            }

            @Override
            public boolean remove(String item) {
                return StringJournal.getInstance().remove(item);
            }

            @Override
            public int size() {
                return StringJournal.getInstance().size();
            }

            @Override
            public List<String> list() {
                return StringJournal.getInstance().list();
            }

            @Override
            public void clear() {
                StringJournal.getInstance().clear();
            }

            @Override
            public boolean contains(String obj) {
                return StringJournal.getInstance().contains(obj);
            }
        };
    }


    default String stats() {
        StringBuilder statsBuilder = new StringBuilder();
        statsBuilder.append("The Journal contains " + size() + " items.");
        statsBuilder.append(System.lineSeparator());
        list().forEach(msg -> {
            statsBuilder.append(messagePreview(msg)).append(System.lineSeparator());
        });
        return statsBuilder.toString();
    }


    private String messagePreview(String msg) {
        //todo: intellij doesn't see utilities as automatic modules.
        // builds fine with gradle and also builds fine with intellij but the editor shows errors
        // https://youtrack.jetbrains.com/issue/IDEA-183692
        return MessageFormatter.messagePreview(msg);
    }

}
