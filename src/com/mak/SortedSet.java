package com.mak;

public class SortedSet extends HashSet {

    /**
     * Добавляет элемент в массив объектов класса Entry
     *
     * @param value - значение элемента
     */
    @Override
    public boolean add(int value) {
        boolean result = super.add(value);
        int length = super.size();
        if (result) {
            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    if (array[j].getValue() < array[i].getValue()) {
                        int temp = array[j].getValue();
                        array[j].setValue(array[i].getValue());
                        array[i].setValue(temp);
                    }
                }
            }
        }
        return result;
    }
}
