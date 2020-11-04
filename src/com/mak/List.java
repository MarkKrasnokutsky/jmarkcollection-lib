package com.mak;

public interface List extends Collection {
    Entry getIndexOf(int index);

    void add(Object value);

    boolean equals(List list);
}
