package threads.produserConsumer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class SimpleBlockingQueue<T> {
    private int tank = 5;

    @GuardedBy("this")
    private Queue<T> queue = new LinkedList<>();

    /**
     * Метод кладёт значение в очередь.
     *
     * @param value
     */
    public synchronized void offer(T value) {
        while (queue.size() >= tank) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
        queue.offer(value);
        System.out.println("Положил " + value);
        notify();
    }

    /**
     * Метод берёт значение из очереди.
     *
     * @return
     */
    public synchronized T poll() throws InterruptedException {
        while (queue.size() == 0) {
                wait();
            }
        notify();
        return queue.poll();
    }

}