package com.mak;

public class LinkedList {
    private Entry[] arrayString = new Entry[0];
    private int index = -1; // Текущий индекс массива

    int size() {
        return arrayString.length;
    }

    Entry getCurrent() {
        return arrayString[index];
    }

    Entry getIndexOf(int index) {
        return arrayString[index];
    }

    void add(String value) {
        int length = arrayString.length + 1;
        Entry[] arrayTemp = arrayString.clone();
        arrayString = new Entry[length];
        System.arraycopy(arrayTemp, 0, arrayString, 0, arrayTemp.length);
        arrayString[arrayTemp.length] = new Entry(value);
        index++;
    }

    String previous() {
        Entry current = getCurrent();
        if (current == null) {
            return null;
        }
        Entry previous = current.previous();
        if (previous == null) {
            return null;
        }
        return previous.toString();
    }

    String next() {
        Entry current = getCurrent();
        if (current == null) {
            return null;
        }
        Entry next = current.next();
        if (next == null) {
            return null;
        }
        return next.toString();
    }

    private class Entry {
        private final String s;

        public Entry(String s) {
            this.s = s;
        }

        Entry previous() {
            try {
                return arrayString[index - 1];
            } catch (ArrayIndexOutOfBoundsException ex) {
                return null;
            }
        }

        Entry next() {
            try {
                return arrayString[index + 1];
            } catch (ArrayIndexOutOfBoundsException ex) {
                return null;
            }
        }

        @Override
        public String toString() {
            return this.s;
        }

    }
}
