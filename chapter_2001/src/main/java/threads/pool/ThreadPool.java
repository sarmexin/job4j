package threads.pool;
import threads.produserConsumer.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks = new SimpleBlockingQueue<>();
    int size = Runtime.getRuntime().availableProcessors();

    public List<Thread> getThreads() {
        return threads;
    }

    private class Action implements Runnable {

        @Override
        public void run() {
            try {
                tasks.poll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pool() {
        for (int i = 0; i < size; i++) {
            System.out.println(i);
            Action newAction = new Action();
            Thread thread = new Thread(newAction);
            threads.add(thread);
            thread.start();

        }
        System.out.println(threads);
        System.out.println(Thread.currentThread().getName());

    }


    public void work(Runnable job) {
        tasks.offer(job);
    }

    public void shutdown() {

    }
}
