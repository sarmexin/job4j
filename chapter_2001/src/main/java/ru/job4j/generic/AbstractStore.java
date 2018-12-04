package ru.job4j.generic;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AbstractStore<T> {
    private SimpleArray<T> simpleArray = new SimpleArray<T>(100);

    public void replace(String id, T model) {
        int element = Integer.parseInt(id);
        simpleArray.set(element, model);
    }

    public void delete(String id) {
        int element = Integer.parseInt(id);
        simpleArray.delete(element);
    }

    public T findById(String id) {
        int element = Integer.parseInt(id);
        return simpleArray.get(element);
    }

    public void add(T model) {
        simpleArray.add(model);
    }
}
