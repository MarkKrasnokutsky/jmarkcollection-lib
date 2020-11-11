package com.mak.list;

/**
 * Класс LinkedList - Связанный список
 **/
public class LinkedList {
    /**
     * Массив для работы с данными
     **/
    private Entry[] array = new Entry[0];
    private int index = -1; // Текущий индекс массива

    /**
     * Возвращает длину связанного списка
     * @return Длина списка
     **/
    int size() {
        return array.length;
    }

    /**
     * Возвращает текущий элемент списка
     * @return Текущий элемент списка
     **/
    Entry getCurrent() {
        return array[index];
    }

    /**
     * Возвращает элемент списка по введённому списку
     * @param index Индекс элемента списка
     * @return Элемент списка по индексу
     **/
    Entry getIndexOf(int index) {
        return array[index];
    }

    /**
     * Добавление элемента в список
     * @param value добавляемый элемент
     **/
    void add(String value) {
        int length = array.length + 1;
        Entry[] arrayTemp = array.clone();
        array = new Entry[length];
        System.arraycopy(arrayTemp, 0, array, 0, arrayTemp.length);
        array[arrayTemp.length] = new Entry(value);
        index++;
    }

    /**
     * Вовзращает предыдущий элемент от текущего из списка
     * @return Предыдущий элемент от текущего из списка
     **/
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

    /**
     * Вовзращает следущий элемент от текущего из списка
     * @return Следущий элемент от текущего из списка
     **/
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

    /**
     * Сокрытый класс для записи значения элемента списка
     **/
    private class Entry {
        /**
         * Значение элемента в списке
         **/
        private final String s;

        public Entry(String s) {
            this.s = s;
        }

        /**
         * Вовзращает предыдущий элемент от текущего из списка
         **/
        Entry previous() {
            try {
                return array[index - 1];
            } catch (ArrayIndexOutOfBoundsException ex) {
                return null;
            }
        }

        /**
         * Вовзращает следущий элемент от текущего из списка
         **/
        Entry next() {
            try {
                return array[index + 1];
            } catch (ArrayIndexOutOfBoundsException ex) {
                return null;
            }
        }

        /**
         * Переопределенный метод toString()
         * @return Текущий элемент списка (объекта класса Entry)
         **/
        @Override
        public String toString() {
            return this.s;
        }

    }
}
