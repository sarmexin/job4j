package threads.pool;

import threads.produserConsumer.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    int size = Runtime.getRuntime().availableProcessors();

    public List<Thread> getThreads() {
        return threads;
    }

    /**
     * Класс, переопределяющий метод run, который берёт задачи из блокирующей очереди.
     */
    private class Action implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    tasks.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Метод создаёт потоки и складывает их в пул threads.
     */
    public void pool() {
        for (int i = 0; i < size; i++) {
            Action newAction = new Action();
            Thread thread = new Thread(newAction);
            threads.add(thread);
            thread.start();
        }
        System.out.println(threads);

    }

    /**
     * Метод добавляет задачи в блокирующию очередь.
     *
     * @param job задача(поток).
     */
    public void work(Runnable job) {
        tasks.offer(job);
    }

    /**
     * Метод программной остановки потока.
     */
    public void shutdown() {
        for (int i = 0; i < size; i++) {
            threads.get(i).interrupt();
        }
        System.out.println("end");
    }
}
