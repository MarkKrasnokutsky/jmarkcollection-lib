package com.mak.list;

import com.mak.common.Collection;

public interface List<E> extends Collection {

    void add(E value);

    boolean equals(List<E> list);
}
