package org.sk.sample.journal;

import java.util.List;

public interface Journal<T> {

    boolean add(T item);

    boolean remove(T item);

    int size();

    List<T> list();

    void clear();

    boolean contains(T obj);



}
