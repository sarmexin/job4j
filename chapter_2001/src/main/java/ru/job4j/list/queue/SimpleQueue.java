package ru.job4j.list.queue;

import ru.job4j.list.linked.DynamicLinked;

public class SimpleQueue<T> {

    private SimpleQueueStack<T> stack = new SimpleQueueStack<>();
    private SimpleQueueStack<T> stack2 = new SimpleQueueStack<>();

    /**
     * метод poll - должен возвращать значение и удалять его из коллекции.
     * @return
     */
    public T pool() {
        T result =  stack.pool();
        //System.out.println("***3***" + result);
        return result;
    }

    /**
     * кладёт значение в коллекцию.
     * @param value
     */
    public void push(T value) {
        stack.push(value);

    }
}
