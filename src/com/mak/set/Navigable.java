package com.mak.set;

import com.mak.common.Entry;

public interface Navigable {
    Entry first();
    Entry last();
    Entry[] headSet(int end) throws ArrayIndexOutOfBoundsException;
    Entry[] subSet(int start, int end) throws ArrayIndexOutOfBoundsException;
    Entry[] tailSet(int start) throws ArrayIndexOutOfBoundsException;
}
