package com.mak.common;

public interface Collection {
    int size();

    Entry getIndexOf(int index);

    Entry getCurrent();

    boolean add(int value);

    boolean isEmpty();

    int[] toArray();
}