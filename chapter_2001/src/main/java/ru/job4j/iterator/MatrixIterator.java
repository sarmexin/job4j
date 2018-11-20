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
        if (flag && array.length > line) {
            result = true;
        }
        if (line < array.length) {
            if (column < array[line].length) {
                result = true;
            }
        }
        if (line < array.length) {
            if (column + 1 == array[line].length) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        int length = array[line].length;
        if (hasNext()) {
            if (flag) {
                column = 0;
            }
            if (length == 1) {
                flag = true;
            }
            if (column + 1 == length) {
                flag = true;
            }
            if (column + 1 < length) {
                if (flag) {
                    flag = false;
                }
            }
            if (flag) {
                return array[line++][column];
            } else {
                return array[line][column++];
            }
        } else {
            throw new NoSuchElementException("No such element");
        }
    }
}
