package com.mak.common;

/**
 * интерфейс Collection
 **/
public interface Collection {
    /**
     * Метод получе размера коллекции
     **/
    int size();

    /**
     * Метод проверки содержащего в коллекции
     **/
    boolean isEmpty();

    /**
     * Метод перевода коллекции в обыкновенный массив
     **/
    int[] toArray();
}