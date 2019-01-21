package threads.produserConsumer;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Producer<T> implements Runnable {
    SimpleBlockingQueue<T> simpleBlockingQueue;
    Thread t;
    T[] value;
    int step = 0;
    T valueOutput;

    public Producer(SimpleBlockingQueue<T> simpleBlockingQueue, T[] value) {
        this.simpleBlockingQueue = simpleBlockingQueue;
        this.value = value;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println();
            }
            valueOutput = value[step++];
            simpleBlockingQueue.offer(valueOutput);
        }
    }
}
