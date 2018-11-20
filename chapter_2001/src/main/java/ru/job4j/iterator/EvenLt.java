package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EvenLt implements Iterator<Integer> {
    private int[] numbers;
    private int index = 0;

    public EvenLt(final int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        return numbers[index] % 2 == 0;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return numbers[index++];
        } else {
            throw new NoSuchElementException("No such element");
        }
    }
}