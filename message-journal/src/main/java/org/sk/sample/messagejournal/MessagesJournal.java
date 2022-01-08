package org.sk.sample.messagejournal;

import org.sk.sample.journal.Journal;
import org.sk.sample.journals.Journals;
import org.sk.sample.journals.exception.JournalInitException;
import org.sk.sample.utilities.MessageFormatter;

import java.util.List;

public interface MessagesJournal extends Journal<String> {

    static MessagesJournal create() {
        return new MessagesJournal() {

            private final Journal<String> stringJournal;

            {
                try {
                    stringJournal = Journals.stringJournal();
                } catch (JournalInitException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public boolean add(String item) {
                return stringJournal.add(item);
            }

            @Override
            public boolean remove(String item) {
                return stringJournal.remove(item);
            }

            @Override
            public int size() {
                return stringJournal.size();
            }

            @Override
            public List<String> list() {
                return stringJournal.list();
            }

            @Override
            public void clear() {
                stringJournal.clear();
            }

            @Override
            public boolean contains(String obj) {
                return stringJournal.contains(obj);
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
        return MessageFormatter.messagePreview(msg);
    }

}
