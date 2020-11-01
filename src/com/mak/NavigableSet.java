package com.mak;

public class NavigableSet extends HashSet {

    /**
     * Возвращает первый элемент списка
     *
     * @return первый элемент списка
     **/
    Entry first() {
        return super.array[0];
    }

    /**
     * Возвращает последний элемент списка
     *
     * @return последний элемент списка
     **/
    Entry last() {
        return super.array[super.size() - 1];
    }

    /**
     * Возвращает массив, элементы которого состоят из первых элементов множества до указанного индекса
     *
     * @param end индекс последнего элемента нового массива
     * @return массив с элементами
     * @throws ArrayIndexOutOfBoundsException проверка на вхождение индекса
     **/
    Entry[] headSet(int end) throws ArrayIndexOutOfBoundsException {
        if (end >= 0 && end < super.size()) {
            Entry[] arrayTemp = new Entry[super.size()];
            for (int i = 0; i < super.size(); i++) {
                if (i <= end) {
                    arrayTemp[i] = super.array[i].clone();
                }
            }
            return arrayTemp;
        }
        throw new ArrayIndexOutOfBoundsException("Указанный индекс за пределами массива");
    }

    /**
     * Возвращает массив, элементы которого начинаются с указанного стартового индекса до указанного конечного индекса
     *
     * @param start индекс первого элемента нового массива
     * @param end   индекс последнего элемента нового массива
     * @return массив с элементами
     * @throws ArrayIndexOutOfBoundsException проверка на вхождение индекса
     **/
    Entry[] subSet(int start, int end) throws ArrayIndexOutOfBoundsException {
        if ((end >= 0 && end < super.size()) && (start >= 0 && start < super.size())) {
            Entry[] arrayTemp = new Entry[super.size()];
            for (int i = 0; i < super.size(); i++) {
                if (i >= start && i <= end) {
                    arrayTemp[i] = super.array[i].clone();
                }
            }
            return arrayTemp;
        }
        throw new ArrayIndexOutOfBoundsException("Указанные индексы за пределами массива");
    }

    /**
     * Возвращает массив, элементы которого начинаются с указанного стартового индекса до конечноого индекса массива
     *
     * @param start индекс первого элемента нового массива
     * @return массив с элементами
     **/
    Entry[] tailSet(int start) throws ArrayIndexOutOfBoundsException {
        if (start >= 0 && start < super.size()) {
            Entry[] arrayTemp = new Entry[super.size()];
            for (int i = 0; i < super.size(); i++) {
                if (i >= start) {
                    arrayTemp[i] = super.array[i].clone();
                }
            }
            return arrayTemp;
        }
        throw new ArrayIndexOutOfBoundsException("Указанный индекс за пределами массива");
    }
}