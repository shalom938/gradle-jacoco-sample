package org.sk.sample.messagejournal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MessagesJournalTest {

    private static Integer JOURNAL_SIZE = 5;

    @BeforeAll
    public static void beforeTest() {
        System.setProperty("org.sk.sample.journal.string.maxSize", JOURNAL_SIZE.toString());
    }


    @Test
    void testMessagesJournal() {

        MessagesJournal journal = MessagesJournal.create();
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

        String stats = journal.stats();
        assertNotNull(stats, "stats is null");
        //the journal size at this point is JOURNAL_SIZE-1, and we know that the stats string has 1 header line
        //plus a line for each message
        assertEquals((long) JOURNAL_SIZE, stats.lines().count(), "stats string should have ");
        System.out.println("journal stats: " + stats);

    }

}
