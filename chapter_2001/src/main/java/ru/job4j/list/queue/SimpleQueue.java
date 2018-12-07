package ru.job4j.list.queue;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleQueue<T> {
    private int flag = 0;
    private SimpleQueueStack<T> stack = new SimpleQueueStack<>();
    private SimpleQueueStack<T> stack2 = new SimpleQueueStack<>();
    private SimpleQueueStack<T> stack3 = new SimpleQueueStack<>();

    /**
     * метод poll - должен возвращать значение и удалять его из коллекции.
     *
     * @return
     */
    public T pool() {
        if (flag == 1) {
            this.relaying();
            flag = 0;
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
        flag = 1;
    }

    /**
     * Метод перекладывает значения из выходящего(2) в промежуточный(3), затем из входящего(1) в выходящий(2),
     * затем их промежуточного(3) в выходящий(2).
     */
    public void relaying() {
        int length;
        length = stack2.getSize();
        for (int i = 0; i < length; i++) {
            stack3.push(stack2.pool());
        }
        length = stack.getSize();
        for (int i = 0; i < length; i++) {
            stack2.push(stack.pool());
        }
        length = stack3.getSize();
        for (int i = 0; i < length; i++) {
            stack2.push(stack3.pool());
        }
    }
}
