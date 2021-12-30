package org.gradle.sample.journal;

import org.gradle.sample.journal.impl.StringJournal;

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
        return msg.substring(0, Math.min(msg.length() - 1, 30)) + "...";
    }

}
