package ru.job4j.generic;

import java.util.Iterator;

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
        private int index = 0;
        private int step = 0;

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (index < array.length) {
                if (array[index] != null) {
                    result = true;
                    step = 1;
                } else {
                    step = 0;
                    for (int i = index; i < array.length - index; i++) {
                        step++;
                        if (array[index + step] != null) {
                            index += step;
                            result = true;
                            break;
                        }
                    }
                }
            }
            return result;
        }

        @Override
        public T next() {
            T result = null;
            if (this.hasNext()) {
                result = array[index];
                index += step;
            }
            return result;
        }
    }

    public void add(T model) {
        if (index == array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы массива при добавлении");
        }
        array[index++] = model;
    }

    public void set(int index, T model) {
        if (this.size(index)) {
            array[index] = model;
        }
    }

    public void delete(int index) {
        if (this.size(index)) {
            array[index] = null;
        }
    }

    public T get(int index) {
        return this.size(index) ? array[index] : null;
    }

    private boolean size(int index) {
        if (index >= array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы массива");
        }
        return true;
    }
}
