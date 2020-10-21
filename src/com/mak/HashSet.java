package com.mak;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Класс реализует функционал HashSet, работает с массивом объектов Entry так, что для обычного пользователя класс Entry сокрытый
 * Обобщенный класс
 */
public class HashSet {
    private Entry[] array = new Entry[0];
    private int index = -1;

    public HashSet() {

    }

    public HashSet(int ...numbers) {
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

    Entry first() {
        return array[0];
    }

    Entry last() {
        return array[array.length - 1];
    }

    Entry[] headSet(int end) {
        Entry[] arrayTemp = new Entry[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i].getValue() <= end) {
                arrayTemp[i] = array[i].clone();
            }
        }
        return arrayTemp;
    }

    Entry[] subSet(int start, int end) {
        Entry[] arrayTemp = new Entry[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i].getValue() >= start && array[i].getValue() <= end) {
                arrayTemp[i] = array[i].clone();
            }
        }
        return arrayTemp;
    }

    Entry[] tailSet(int start) {
        Entry[] arrayTemp = new Entry[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i].getValue() >= start) {
                arrayTemp[i] = array[i].clone();
            }
        }
        return arrayTemp;
    }

    static HashSet intersection(HashSet a, HashSet b) {
        HashSet c = new HashSet();
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < b.size(); j++) {
                if (a.getIndexOf(i).equals(b.getIndexOf(j))) {
                    c.add(b.getIndexOf(j).getValue());
                }
            }
        }
        return c;
    }

    public void show() {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("[%d] = %d \t", i, array[i].getValue());
        }
        System.out.println();
    }

    /**
     * Хранит элементы и их хэш суммы
     * Обобщенный класс
     */
    private class Entry implements Cloneable {
        private String hashCode;
        int value;

        public Entry(int value) {
            this.value = value;
            insertHashCodeMD5();
        }

        @Override
        public Entry clone() {
            return new Entry(this.value);
        }

        /**
         * Возвращает хэш-сумму
         *
         * @return hashcode - хэш-сумма элемента
         */
        public String getHashCode() {
            return hashCode;
        }

        public int getValue() {
            return value;
        }

        public void setHashCode(String hashCode) {
            this.hashCode = hashCode;
        }

        public void setValue(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object a) {
            if (!(a instanceof Entry)) return false;
            return this.value == ((Entry) a).getValue();
        }

        /**
         * Добавление хэш-суммы с помощью большого числа Long
         */
        private void insertHashCode() {
            Random r = new Random();
            this.hashCode = String.valueOf(Math.abs(r.nextLong()));
            while (true) {
                int t = 0;
                for (Entry arrayElement : array) {
                    if (arrayElement != null && this.hashCode.equals(arrayElement.getHashCode())) {
                        this.hashCode = String.valueOf(Math.abs(r.nextLong()));
                    } else {
                        t++;
                    }
                }
                if (t == array.length) {
                    break;
                }
            }
        }

        /**
         * Вывод значения в виде строки
         *
         * @return value - значение в виде строки
         */
        @Override
        public String toString() {
            return String.valueOf(this.value);
        }

        /**
         * Добавление хэш-суммы с помощью кодировки MD5
         *
         * @throws NoSuchAlgorithmException - проверяет на наличие алгоритма
         */
        private void insertHashCodeMD5() {
            try {
                // Static getInstance method is called with hashing MD5
                MessageDigest md = MessageDigest.getInstance("MD5");

                // digest() method is called to calculate message digest
                //  of an input digest() return array of byte
                byte[] messageDigest = md.digest();

                // Convert byte array into signum representation
                BigInteger no = new BigInteger(1, messageDigest);

                // Convert message digest into hex value
                this.hashCode = no.toString(16);
            }
            // For specifying wrong message digest algorithms
            catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

}