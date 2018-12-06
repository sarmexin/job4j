package ru.job4j.list.queue;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueue<T> {
    private SimpleQueueStack<T> stack = new SimpleQueueStack<>();
    private SimpleQueueStack<T> stack2 = new SimpleQueueStack<>();

    public SimpleQueueStack<T> getStack2() {
        return stack2;
    }

    /**
     * метод poll - должен возвращать значение и удалять его из коллекции.
     *
     * @return
     */
    public T pool() {
        T result = stack.pool();
        stack2.push(result);
        return result;
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
