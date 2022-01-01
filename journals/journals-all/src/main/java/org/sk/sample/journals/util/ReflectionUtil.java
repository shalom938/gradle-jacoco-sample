package org.sk.sample.journals.util;

import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;
import org.sk.sample.journal.Journal;
import org.sk.sample.journals.exception.JournalInitException;

@SuppressWarnings("unchecked")
public class ReflectionUtil {

    private static final String STRING_JOURNAL_CLS = "org.sk.sample.journal.impl.string.StringJournal";

    private ReflectionUtil() {
    }

    //unsafe cast here, but it should be fine, we know the classes.
    //to achieve type safety we need to require the journals-impls module classes and just
    //use them.
    //but this is mostly to show how module sample.journal.impl opens reflection access to this
    // module and to commons-lang3

    public static Journal<String> createStringJournal() throws JournalInitException {

        try {
            Class<? extends Journal<String>> cls = (Class<? extends Journal<String>>) ClassUtils.getClass(STRING_JOURNAL_CLS);
            return ConstructorUtils.invokeConstructor(cls);
        } catch (ReflectiveOperationException e) {
            throw new JournalInitException("Could not create String journal, please verify that the journal implementation module is present.",e);
        }
    }



    public static Journal<String> createStringJournal(int maxSize) throws JournalInitException {
        try {
            Class<? extends Journal<String>> cls = (Class<? extends Journal<String>>) ClassUtils.getClass(STRING_JOURNAL_CLS);
            return ConstructorUtils.invokeConstructor(cls, maxSize);
        } catch (ReflectiveOperationException e) {
            throw new JournalInitException("Could not create String journal, please verify that the journal implementation module is present.",e);
        }
    }

}
