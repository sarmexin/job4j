package ru.job4j.collections.list.queue;

import ru.job4j.collections.list.stack.SimpleStack;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueue<T> {
    private SimpleStack<T> stack = new SimpleStack<>();
    private SimpleStack<T> stack2 = new SimpleStack<>();

    /**
     * метод poll - должен возвращать значение и удалять его из коллекции.
     *
     * @return
     */
    public T pool() {
        if (stack2.isEmpty()) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pool());
            }
        }
        return stack2.pool();
    }

    /**
     * кладёт значение в коллекцию.
     *
     * @param value
     */
    public void push(T value) {
        stack.push(value);
    }
}
