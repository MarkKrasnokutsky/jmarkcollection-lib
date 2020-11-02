package com.mak;

import java.util.Comparator;

public interface Set<E> extends Collection{
    String getHashCode();
    void sort(E coll);
    @Override
    boolean equals(Object o);
    E subList(int fromIndex, int toIndex);
    E copyOf (E coll);
}
