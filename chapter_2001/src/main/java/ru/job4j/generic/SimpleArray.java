package ru.job4j.generic;

import java.util.Iterator;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int index = 0;

    public SimpleArray(int cell) {
        this.array = (T[]) new Object[cell];
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    public class SimpleArrayIterator implements Iterator<T> {
        private int position = 0;

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (this.position < index) {
                result = true;
            }
            return result;
        }

        @Override
        public T next() {
            T result = null;
            if (!this.hasNext()) {
                throw new ArrayIndexOutOfBoundsException("Выход за границы массива");
            }
            result = array[position++];
            return result;
        }
    }

    /**
     * Метод добавления значения в коллекцию.
     *
     * @param model
     */
    public void add(T model) {
        if (index == array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы массива при добавлении");
        }
        array[index++] = model;
    }

    /**
     * Метод добавления значения по индексу в коллекцию.
     *
     * @param index
     * @param model
     */
    public void set(int index, T model) {
        if (this.size(index)) {
            array[index] = model;
        }
    }

    /**
     * Метод удаления значения по индексу из коллекции.
     *
     * @param index
     */
    public void delete(int index) {
        if (this.size(index)) {
            System.arraycopy(array, index, array, index + 1, array.length - index - 1);
        }
    }

    /**
     * Метод извлечения значения по индексу из коллекции.
     *
     * @param index
     * @return
     */
    public T get(int index) {
        return this.size(index) ? array[index] : null;
    }

    /**
     * Метод проверки невыхода запращеваемого индекса за границу массива.
     *
     * @param index
     * @return
     */
    private boolean size(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы массива");
        }
        return true;
    }
}
