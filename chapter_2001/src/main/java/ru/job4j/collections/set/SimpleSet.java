package ru.job4j.collections.set;

import ru.job4j.collections.list.array.DynamicContainer;

import java.util.Iterator;

/**
 * @param <E>
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleSet<E> implements Iterable<E> {
    private DynamicContainer<E> dynamicContainer;

    SimpleSet(Object[] array) {
        this.dynamicContainer = new DynamicContainer<>(array);
    }

    @Override
    public Iterator<E> iterator() {
        return dynamicContainer.iterator();
    }

    /**
     * Метод добавляет значение в коллекцию.
     *
     * @param e
     */
    public void add(E e) {
        if (!contains(e)) {
            dynamicContainer.add(e);
        }
    }

    /**
     * Метод проверяет на дубликаты в коллекции.
     *
     * @param e
     * @return
     */
    private boolean contains(E e) {
        Iterator<E> iterator = this.iterator();
        boolean result = false;
        for (int i = 0; i < dynamicContainer.getIndex() + 1; i++) {
            if (iterator.next().equals(e)) {
                result = true;
            }
        }
        return result;
    }
}
