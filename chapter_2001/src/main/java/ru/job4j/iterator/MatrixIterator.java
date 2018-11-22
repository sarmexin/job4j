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

    public MatrixIterator(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (line == array.length) {
            result = false;
        } else {
            if (line < array.length || column < array[line].length) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No such element");
        }
        int result = array[line][column++];
        if (column == array[line].length) {
            column = 0;
            line++;
        }
        return result;
    }
}
