package com.mak.set;

/**
 * Класс реализует функционал HashSet, работает с массивом объектов Entry так, что для обычного пользователя класс Entry сокрытый
 * Обобщенный класс
 */
public class HashSet implements Set {
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
    @Override
    public int size() {
        return array.length;
    }

    /**
     * Возвращает текущей элемент массива
     *
     * @return метод add с типом хэш-суммы Long и со значение value
     * @throws ArrayIndexOutOfBoundsException - если мы укажем индекс, которого в массиве не присутствует, выбросится ошибка
     */
    @Override
    public Entry getCurrent() throws ArrayIndexOutOfBoundsException {
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
    @Override
    public Entry getIndexOf(int index) throws ArrayIndexOutOfBoundsException {
        if (index == -1 || index > array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
        }
        return array[index];
    }

    /**
     * Добавляет элемент в массив объектов класса Entry
     *
     * @param value - значение элемента
     * @return Истина - добавлен в коллекцию, Ложь - не добавлен в коллекцию
     */
    @Override
    public boolean add(int value) {
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

    /**
     * Проверка на существование массива
     *
     * @return Истина - массив пустой, Ложь - массив не пустой
     */
    @Override
    public boolean isEmpty() {
        if (array.length == 0) {
            return true;
        }
        return false;
    }

    /**
     * Преобразование коллекции в массив
     *
     * @return Массив с целочисленными значениями
     */
    @Override
    public int[] toArray() {
        int[] arrayInt = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            arrayInt[i] = getIndexOf(i).getValue();
        }
        return arrayInt;
    }

    /**
     * Сортировка коллекции (пузырьковкая)
     */
    @Override
    public void sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].getValue() < array[i].getValue()) {
                    int temp = array[j].getValue();
                    array[j].setValue(array[i].getValue());
                    array[i].setValue(temp);
                }
            }
        }
    }

    /**
     * Сравнение двух коллекций
     *
     * @param set Вторая коллекция, реализующая интерфейс Set
     * @return Истина - коллекции равны, Ложь - коллекции не равны
     */
    @Override
    public boolean equals(Set set) {
        if (array.length != set.size()) {
            return false;
        }
        boolean isEquals = false;
        sort();
        set.sort();
        for (int i = 0; i < array.length; i++) {
            if (set.getIndexOf(i).getValue() == array[i].getValue()) {
                isEquals = true;
            }
        }
        return isEquals;
    }

}