package org.sk.sample.journal;

import org.junit.jupiter.api.Test;
import org.sk.sample.journals.Journals;
import org.sk.sample.journals.exception.JournalInitException;

import static org.junit.jupiter.api.Assertions.*;

public class JournalAllTest {


    //test we got all in the classpath/module path correctly

    @Test
    public void testJournalCreate() throws JournalInitException {
        Journal<String> stringJournal = Journals.stringJournal();
        assertNotNull(stringJournal,"string journal is null");
        assertTrue(stringJournal.size() == 0,"string journal should be empty");
    }

    @Test
    public void testJournalMaxSize() throws JournalInitException {
        Journal<String> stringJournal = Journals.stringJournal(5);
        assertNotNull(stringJournal,"string journal is null");
        assertTrue(stringJournal.size() == 0,"string journal should be empty");

        for (int i = 0; i < 10; i++) {
            stringJournal.add("item-"+i);
        }

        assertEquals(5,stringJournal.size(),"journal size should be 5");

    }

}
