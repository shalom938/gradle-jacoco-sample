package org.sk.sample.journals;

import org.sk.sample.journal.Journal;
import org.sk.sample.journals.exception.JournalInitException;
import org.sk.sample.journals.util.ReflectionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Journals {

    private static final Logger LOGGER = LoggerFactory.getLogger(Journals.class);

    private Journals(){}

    //just for jpms practicing:
    //module journal-impls does not export org.sk.sample.journal.impl.string.StringJournal
    //but opens the package for reflection, so can only create StringJournal
    //through reflection.

    public static Journal<String> stringJournal() throws JournalInitException {
        LOGGER.info("Creating String journal");
        return ReflectionUtil.createStringJournal();
    }

    public static Journal<String> stringJournal(int maxSize) throws JournalInitException {
        LOGGER.info("Creating String journal with maxSize {}",maxSize);
        return ReflectionUtil.createStringJournal(maxSize);
    }

}
