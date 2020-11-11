package com.mak.set;

import com.mak.common.Collection;

public interface Set extends Collection {

    void sort();

    boolean equals(Set set);

    Entry getIndexOf(int index);

    Entry getCurrent();

    boolean add(int value);
}