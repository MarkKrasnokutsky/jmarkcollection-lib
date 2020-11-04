package com.mak.set;

import com.mak.common.Collection;

public interface Set extends Collection {

    void sort();

    boolean equals(Set set);
}