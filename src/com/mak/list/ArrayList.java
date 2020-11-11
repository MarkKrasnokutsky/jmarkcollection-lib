package com.mak.list;

/**
 * Обобщенний класс ArrayList
 **/
public class ArrayList implements List {
    /**
     * Массив элементов типа Object
     **/
    private int[] array;

    @SafeVarargs
    public ArrayList(int... nums) {
        array = new int[nums.length];
        int i = 0;
        for (int e : nums) {
            array[i] = e;
            i++;
        }
    }

    /**
     * Возвращает длину связанного списка
     *
     * @return Длина списка
     **/
    public int size() {
        return array.length;
    }

    @Override
    public boolean isEmpty() {
        if (array.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int[] toArray() {
        return array;
    }

    /**
     * Возвращает элемент списка по индексу
     *
     * @param index Индекс списка
     * @return Элемент списка по индексу
     **/
    public int getElement(int index) {
        return array[index];
    }

    /**
     * Проверка на существование элемента в списке
     *
     * @param element Элемент списка
     * @return булевое значение
     **/
    public boolean find(int element) {
        for (int i : array) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Удаляет последний по индексу элемент списка
     **/
    public void remove() {
        int[] arrayTemp = array.clone();
        array = new int[array.length - 1];
        for (int i = 0; i < arrayTemp.length - 1; i++) {
            array[i] = arrayTemp[i];
        }
    }

    @Override
    public void add(int value) {
        int length = array.length + 1;
        int[] arrayTemp = array.clone();
        array = new int[length];
        System.arraycopy(arrayTemp, 0, array, 0, arrayTemp.length);
        array[arrayTemp.length] = value;
    }

}
