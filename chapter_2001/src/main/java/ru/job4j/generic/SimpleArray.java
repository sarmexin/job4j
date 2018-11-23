package ru.job4j.generic;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int index = 0;

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public SimpleArray(int cell) {
        this.array = (T[]) new Integer[cell];
    }

    public void add(T model) {
        if (index == array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы массива при добавлении");
        } else {
            array[index++] = model;
        }
    }

    public void set(int index, T model) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы массива");
        } else {
            array[index] = model;
        }
    }

    public void delete(int index) {
        if (index >= array.length && index >= 0) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы массива");
        } else {
            array[index] = null;
        }
    }

    public T get(int index) {
        if (index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Выход за границы массива");
        } else {
            return array[index];
        }
    }
}
