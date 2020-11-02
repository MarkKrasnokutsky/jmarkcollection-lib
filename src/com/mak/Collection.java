package com.mak;

public interface Collection {
    int size();
    Object getIndexOf(int index);
    Object getCurrent();
    boolean add(int value);
    boolean isEmpty();
    @Override
    int hashCode();
    Object[] toArray();
}
