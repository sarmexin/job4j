package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MatrixIterator implements Iterator<Integer> {
    private int[][] array;
    private int column = 0;
    private int line = 0;
    private boolean flag = true;

    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (flag) {
            column = 0;
            flag = false;
        }
        if (line < array.length && column < array[line].length) {
            result = true;
        }
        return result;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            if (column + 1 == array[line].length) {
                flag = true;
                return array[line++][column];
            } else {
                return array[line][column++];
            }
        } else {
            throw new NoSuchElementException("No such element");
        }
    }
}
