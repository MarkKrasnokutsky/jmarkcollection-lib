package com.mak;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Entry implements Cloneable {
    private String hashCode;
    private int value;

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

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object a) {
        if (!(a instanceof Entry)) return false;
        return this.value == ((Entry) a).getValue();
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
     */
    private void insertHashCodeMD5() {
        try {
            // Вызывается статический метод с алгоритмом хэширования MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Вызывается метод, выполняющий оцифровку сообщения с возвратом в виде массива байтов
            byte[] messageDigest = md.digest();

            // Конвентируем массив байтов
            BigInteger no = new BigInteger(1, messageDigest);

            // Конвентируем сообщение в виде значения 16-ичной системы
            this.hashCode = no.toString(16);
        }
        // Специфическое исключение
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}