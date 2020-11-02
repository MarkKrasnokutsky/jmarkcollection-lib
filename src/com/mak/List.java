package com.mak;

public interface List extends Collection{
    Object getIndexOf(int index);
    void add(Object value);
    @Override
    boolean equals(Object o);
}
