package ru.job4j.collections.list.array;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DynamicContainer<E> implements Iterable<E> {
    private Object[] container;
    private int modCount = 0;
    private int index;

    public DynamicContainer(Object[] container) {
        this.container = container;
        this.index = container.length - 1;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public Iterator<E> iterator() {
        return new ContainerIterator<E>();
    }

    public class ContainerIterator<E> implements Iterator<E> {
        private int position = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (expectedModCount == modCount) {
                if (position < container.length && container[position] != null) {
                    result = true;
                }
            } else {
                throw new ConcurrentModificationException("FATAL");
            }
            return result;
        }

        @Override
        public E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                return null;
            }
            return (E) container[position++];
        }
    }

    public void add(E value) {
        Object[] container2;
        int length = container.length;
        modCount++;
        if (length >= index) {
            container2 = new Object[length + 1];
            System.arraycopy(container, 0, container2, 0, length);
            container = container2;
        }
        container[++index] = value;
    }

    public E get(int index) {
        E result = null;
        if (index < container.length && index >= 0) {
            result = (E) container[index];
        }
        return result;
    }
}
