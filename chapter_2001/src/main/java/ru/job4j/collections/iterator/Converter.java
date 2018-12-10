package ru.job4j.collections.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Converter {
    private Iterator<Iterator<Integer>> iterator;
    private Iterator<Integer> currentIterator = null;

    /**
     * Метод, принимает итераор итераторов и возвращапет итератоп
     * @param it
     * @return
     */
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        this.iterator = it;
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                selectCurrentIterator();
                return (currentIterator != null && currentIterator.hasNext());
            }

            @Override
            public Integer next() {
                selectCurrentIterator();
                if (currentIterator == null) {
                    throw new NoSuchElementException();
                }
                return currentIterator.next();
            }
        };
    }

    /**
     * Метод проверяет есть ли следующий елемент во внутреннем итераторе
     */
    private void selectCurrentIterator() {
        if (currentIterator != null && currentIterator.hasNext()) {
            return;
        }
        while (iterator.hasNext()) {
            Iterator<Integer> nextIterator = iterator.next();
            if (nextIterator.hasNext()) {
                currentIterator = nextIterator;
                break;
            }
        }
    }
}


