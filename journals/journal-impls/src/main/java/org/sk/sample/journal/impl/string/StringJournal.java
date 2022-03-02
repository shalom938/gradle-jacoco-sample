package org.sk.sample.journal.impl.string;

import com.google.common.collect.EvictingQueue;
import org.sk.sample.journal.Journal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Objects;

@SuppressWarnings("ALL") //EvictingQueue is beta
public class StringJournal implements Journal<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StringJournal.class);

    private EvictingQueue<String> evictingQueue;

    public StringJournal() {
        this(Integer.parseInt(System.getProperty("org.sk.sample.journal.string.maxSize", "100")));
    }

    public StringJournal(int maxSize) {
        LOGGER.info("Creating new StringJournal");
        this.evictingQueue = EvictingQueue.create(maxSize);
    }


    @Override
    public boolean add(String item) {
        LOGGER.trace("Adding {} to journal",item);
        Objects.requireNonNull(item, "StringJournal does not allow null elements");
        return evictingQueue.add(item);
    }

    @Override
    public boolean remove(String item) {
        LOGGER.trace("Removing {} from journal",item);
        return evictingQueue.remove(item);
    }

    @Override
    public int size() {
        return evictingQueue.size();
    }

    public List<String> list() {
        return List.copyOf(evictingQueue);
    }

    @Override
    public void clear() {
        LOGGER.trace("Clearing journal");
        evictingQueue.clear();
    }

    @Override
    public boolean contains(String obj) {
        return evictingQueue.contains(obj);
    }
}
