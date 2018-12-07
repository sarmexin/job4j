package ru.job4j.collections.generic;

import java.util.Iterator;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray = new SimpleArray<T>(100);

    public void add(T model) {
        simpleArray.add(model);
    }

    public void replace(String id, T model) {
        int counter = 0;
        for (T next : simpleArray) {
            if (id.equals(next.getId())) {
                simpleArray.set(counter, model);
                break;
            }
        }
    }

    public void delete(String id) {
        int counter = 0;
        for (T next : simpleArray) {
            if (id.equals(next.getId())) {
                simpleArray.delete(counter);
                break;
            }
            counter++;
        }
    }

    public T findById(String id) {
        T result = null;
        Iterator<T> iterator = simpleArray.iterator();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (id.equals(next.getId())) {
                result = next;
                break;
            }
        }
        return result;
    }
}
