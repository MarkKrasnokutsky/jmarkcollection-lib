package com.mak;

/**
 * Обобщенний класс ArrayList
 **/
public class ArrayList <T> {
    /**
     * Массив элементов типа Object
     **/
    private Object[] array;

    @SafeVarargs
    public ArrayList(T... nums) {
        array = new Object[nums.length];
        int i = 0;
        for (T e : nums) {
            array[i] = e;
            i++;
        }
    }

    /**
     * Возвращает длину связанного списка
     * @return Длина списка
     **/
    public int size() {
        return array.length;
    }

    /**
     * Возвращает элемент списка по индексу
     * @param index Индекс списка
     * @return Элемент списка по индексу
     **/
    public Object getElement(int index) {
        return array[index];
    }

     /**
      * Проверка на существование элемента в списке
      * @param element Элемент списка
      * @return булевое значение
     **/
    public boolean find(T element) {
        for (Object i: array) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * Удаляет последний по индексу элемент списка
     **/
    public void removeElementLastIndex() {
        Object[] arrayTemp = array.clone();
        array = new Object[array.length - 1];
        for (int i = 0; i < arrayTemp.length - 1; i++) {
            array[i] = arrayTemp[i];
        }
    }

    /**
     * Добавляет элемент в конец списка
     * @param element Добавляемый элемент
     **/
    public void addElementLastIndex(T element) {
        int length = array.length + 1;
        Object[] arrayTemp = array.clone();
        array = new Object[length];
        System.arraycopy(arrayTemp, 0, array, 0, arrayTemp.length);
        array[arrayTemp.length] = element;
    }

}
