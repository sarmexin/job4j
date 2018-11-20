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
        boolean result = false;
        if (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                result = true;
            } else {
                if (this.search() != 0) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (hasNext() && numbers[index] % 2 == 0) {
            return numbers[index++];
        } else {
            if (this.search() != 0) {
                index = this.search();
            } else {
                throw new NoSuchElementException("No such element");
            }
        }
        return numbers[index++];
    }

    private int search() {
        int result = 0;
        for (int i = index + 1; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
}

//throw new NoSuchElementException("No such element");