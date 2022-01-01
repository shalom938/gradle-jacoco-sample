package org.sk.sample.journals;

import org.sk.sample.journal.Journal;
import org.sk.sample.journals.exception.JournalInitException;
import org.sk.sample.journals.util.ReflectionUtil;

public class Journals {


    public static Journal<String> stringJournal() throws JournalInitException {
        return ReflectionUtil.createStringJournal();
    }

    public static Journal<String> stringJournal(int maxSize) throws JournalInitException {
        return ReflectionUtil.createStringJournal(maxSize);
    }

}
