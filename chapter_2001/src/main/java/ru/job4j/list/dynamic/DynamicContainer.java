package ru.job4j.list.dynamic;

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
    private int index = 0;

    public DynamicContainer(Object[] container) {
        this.container = container;
        for (Object element : container) {
            System.out.println(element);
        }
    }

    public Object[] getContainer() {
        return container;
    }

    @Override
    public Iterator<E> iterator() {
        return new ContainerIterator<E>();
    }

    public class ContainerIterator<E> implements Iterator<E> {
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            boolean result = false;
            if (expectedModCount == modCount) {
                if (index < container.length && container[index] != null) {
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
            return (E) container[index++];
        }
    }

    public void add(E value) {
        Object[] container2;
        modCount++;
        if (container.length >= index) {
            container2 = new Object[index + 3];
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
