package org.gradle.sample.journal.impl;

import com.google.common.collect.EvictingQueue;
import org.gradle.sample.journal.Journal;

import java.util.List;
import java.util.Objects;

public class StringJournal implements Journal<String> {

    private final EvictingQueue<String> evictingQueue;

    private final static StringJournal INSTANCE = new StringJournal();

    private StringJournal() {
        String size = System.getProperty("org.gradle.sample.journal.string.size","100");
        this.evictingQueue = EvictingQueue.create(Integer.valueOf(size));
    }

    public static StringJournal getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean add(String item) {
        Objects.requireNonNull(item,"StringJournal does not allow null elements");
        return evictingQueue.add(item);
    }

    @Override
    public boolean remove(String item) {
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
        evictingQueue.clear();
    }

    @Override
    public boolean contains(String obj) {
        return evictingQueue.contains(obj);
    }
}
