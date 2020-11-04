package com.mak.list;

import com.mak.common.Collection;
import com.mak.common.Entry;

public interface List extends Collection {
    Entry getIndexOf(int index);

    void add(Object value);

    boolean equals(List list);
}
