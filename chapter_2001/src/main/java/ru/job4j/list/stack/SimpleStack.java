package ru.job4j.list.stack;

import ru.job4j.list.linked.DynamicLinked;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleStack<T> {
    private DynamicLinked<T> list = new DynamicLinked<>();

    /**
     * Метод кладёт елемент в стек.
     *
     * @param date
     */
    public void push(T date) {
        list.add(date);
    }

    /**
     * Метод возвращает значение из стека и удаляет его в коллекции.
     *
     * @return
     */
    public T pool() {
        T t = null;
        DynamicLinked<T>.Node<T> delete = list.delete();
        if (delete != null) {
            t =delete.getDate();
        }
        return t;
    }

    public boolean isEmpty() {
        return list.getSize() == 0;
    }
}
