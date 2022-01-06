package org.sk.sample.journal.impl.string;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringJournalTest {

    private static Integer JOURNAL_SIZE = 5;


    @Test
    void testMessagesJournal() {

        StringJournal journal = new StringJournal(JOURNAL_SIZE);
        journal.add("item-1");
        journal.add("item-1");
        assertEquals(2, journal.size(), "journal size should be 2");
        assertTrue(journal.contains("item-1"), "journal should contain the item");
        journal.add("item-2");
        assertEquals(3, journal.size(), "journal size should be 3");
        assertTrue(journal.contains("item-2"), "journal should contain the item");

        journal.clear();
        assertEquals(0, journal.size(), "journal size should be 0");

        for (int i = 0; i < 10; i++) {
            journal.add("item-" + i);
        }

        //although adding 10 items the journal is limited to JOURNAL_SIZE
        assertEquals(JOURNAL_SIZE, journal.size(), () -> "journal size should be " + JOURNAL_SIZE);
        assertTrue(journal.contains("item-9"), "journal should contain item-9");
        journal.remove("item-9");
        assertFalse(journal.contains("item-9"), "journal should NOT contain item-9");
        assertEquals(JOURNAL_SIZE - 1, journal.size(), "journal size should be " + (JOURNAL_SIZE - 1));

        List<String> asList1 = journal.list();
        List<String> asList2 = journal.list();
        assertFalse(asList1 == asList2, "list should be different objects");
        assertLinesMatch(asList1, asList2, "lists are not equal");

    }

}
