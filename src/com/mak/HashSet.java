package com.mak;

import java.util.Random;

/**
 * Класс реализует функционал HashSet, работает с массивом объектов Entry так, что для обычного пользователя класс Entry сокрытый
 * Обобщенный класс
 */
public class HashSet {
    protected Entry[] array = new Entry[0];
    private int index = -1;

    public HashSet() {

    }

    public HashSet(int... numbers) {
        for (int number : numbers) {
            this.add(number);
        }
    }

    /**
     * Возвращает длину массива объектов Entry
     *
     * @return длина массива array
     */
    int size() {
        return array.length;
    }

    /**
     * Возвращает текущей элемент массива
     *
     * @return метод add с типом хэш-суммы Long и со значение value
     * @throws ArrayIndexOutOfBoundsException - если мы укажем индекс, которого в массиве не присутствует, выбросится ошибка
     */
    Entry getCurrent() throws ArrayIndexOutOfBoundsException {
        if (index == -1 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        return array[index];
    }

    /**
     * Возвращает элемент массива по индексу
     *
     * @param index - индекс элемента в массиве
     * @return элемент по индексу из массива
     * @throws ArrayIndexOutOfBoundsException - если мы укажем индекс, которого в массиве не присутствует, выбросится ошибка
     */
    Entry getIndexOf(int index) throws ArrayIndexOutOfBoundsException {
        if (index == -1 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        return array[index];
    }

    /**
     * Добавляет элемент в массив объектов класса Entry
     *
     * @param value - значение элемента
     */
    boolean add(int value) {
        boolean result = true;
        for (Entry element : array) {
            if (value == element.getValue()) {
                result = false;
                break;
            }
        }
        if (result) {
            int length = array.length + 1;
            Entry[] arrayTemp = array.clone();
            array = new Entry[length];
            for (int i = 0; i < arrayTemp.length; i++) {
                array[i] = arrayTemp[i];
            }
            array[arrayTemp.length] = new Entry(value);
            index++;
        }
        return result;
    }
}