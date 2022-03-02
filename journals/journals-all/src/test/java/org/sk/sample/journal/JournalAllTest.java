package org.sk.sample.journal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.sk.sample.journals.Journals;
import org.sk.sample.journals.exception.JournalInitException;

class JournalAllTest {

    //test we got all in the classpath/module path correctly

    @Test
    void testJournalCreate() throws JournalInitException {
        Journal<String> stringJournal = Journals.stringJournal();
        assertNotNull(stringJournal, "string journal is null");
        assertEquals(0, stringJournal.size(), "string journal should be empty");
    }

    @Test
    void testJournalMaxSize() throws JournalInitException {
        Journal<String> stringJournal = Journals.stringJournal(5);
        assertNotNull(stringJournal, "string journal is null");
        assertEquals(0, stringJournal.size(), "string journal should be empty");

        for (int i = 0; i < 10; i++) {
            stringJournal.add("item-" + i);
        }

        assertEquals(5, stringJournal.size(), "journal size should be 5");

    }

}
