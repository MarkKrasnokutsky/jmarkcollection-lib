package com.mak;

public class ArrayList <T> {
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

    public int size() {
        return array.length;
    }

    public Object getElement(int index) {
        return array[index];
    }

    public boolean find(T element) {
        for (Object i: array) {
            if (i == element) {
                return true;
            }
        }
        return false;
    }

    public void removeElementLastIndex() {
        Object[] arrayTemp = array.clone();
        array = new Object[array.length - 1];
        for (int i = 0; i < arrayTemp.length - 1; i++) {
            array[i] = arrayTemp[i];
        }
    }

    public void addElementLastIndex(T element) {
        int length = array.length + 1;
        Object[] arrayTemp = array.clone();
        array = new Object[length];
        System.arraycopy(arrayTemp, 0, array, 0, arrayTemp.length);
        array[arrayTemp.length] = element;
    }

}
