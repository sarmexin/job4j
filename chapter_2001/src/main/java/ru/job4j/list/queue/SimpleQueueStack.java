package ru.job4j.list.queue;

import ru.job4j.list.linked.DynamicLinked;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueueStack<T> {
    private DynamicLinked<T> list = new DynamicLinked<>();

    public void push(T date) {
        list.add(date);
    }

    public T pool() {
        DynamicLinked.Node el = list.deleteFIFO();
        T result = (T) "null";
        if (el != null) {
            result = (T) el.getDate();
        }
        return result;
    }
}
