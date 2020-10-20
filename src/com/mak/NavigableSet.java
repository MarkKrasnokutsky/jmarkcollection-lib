package com.mak;

public class NavigableSet {
    private int[] arrayElements;
    private int index = -1;

    /**
     * Возвращает длину массива объектов Entry
     *
     * @return длина массива arrayElements
     */
    int size() {
        return arrayElements.length;
    }

    /**
     * Возвращает текущей элемент массива
     *
     * @return метод add с типом хэш-суммы Long и со значение value
     * @throws ArrayIndexOutOfBoundsException - если мы укажем индекс, которого в массиве не присутствует, выбросится ошибка
     */
    int getCurrent() throws ArrayIndexOutOfBoundsException {
        if (index == -1 || index > arrayElements.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        return arrayElements[index];
    }

    /**
     * Возвращает элемент массива по индексу
     *
     * @param index - индекс элемента в массиве
     * @return элемент по индексу из массива
     * @throws ArrayIndexOutOfBoundsException - если мы укажем индекс, которого в массиве не присутствует, выбросится ошибка
     */
    int getIndexOf(int index) throws ArrayIndexOutOfBoundsException {
        if (index == -1 || index > arrayElements.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        return arrayElements[index];
    }

    /**
     * Добавляет элемент в массив объектов класса Entry
     *
     * @param value - значение элемента
     */
    void add(int value) {
        int length = arrayElements.length + 1;
        int[] arrayTemp = arrayElements.clone();
        arrayElements = new int[length];
        for (int i = 0; i < arrayTemp.length; i++) {
            arrayElements[i] = arrayTemp[i];
        }
        arrayElements[arrayTemp.length] = value;
        index++;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (arrayElements[j] < arrayElements[i]) {
                    int temp = arrayElements[j];
                    arrayElements[j] = arrayElements[i];
                    arrayElements[i] = temp;
                }
            }
        }
    }

    int first() {
        return arrayElements[0];
    }

    int last() {
        return arrayElements[arrayElements.length - 1];
    }

    int[] headSet(int end) {
        int[] arrayTemp = new int[arrayElements.length];
        for (int i = 0; i < arrayElements.length; i++) {
            if (arrayElements[i] <= end) {
                arrayTemp[i] = arrayElements[i];
            }
        }
        return arrayTemp;
    }

    int[] subSet(int start, int end) {
        int[] arrayTemp = new int[arrayElements.length];
        for (int i = 0; i < arrayElements.length; i++) {
            if (arrayElements[i] >= start && arrayElements[i] <= end) {
                arrayTemp[i] = arrayElements[i];
            }
        }
        return arrayTemp;
    }

    int[] tailSet(int start) {
        int[] arrayTemp = new int[arrayElements.length];
        for (int i = 0; i < arrayElements.length; i++) {
            if (arrayElements[i] >= start) {
                arrayTemp[i] = arrayElements[i];
            }
        }
        return arrayTemp;
    }
}
