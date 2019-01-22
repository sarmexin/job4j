package threads.produserConsumer;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Consumer<T> implements Runnable {
    SimpleBlockingQueue<T> simpleBlockingQueue;
    Thread t;

    public Consumer(SimpleBlockingQueue<T> simpleBlockingQueue) {
        this.simpleBlockingQueue = simpleBlockingQueue;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
            try {
                System.out.println("Взял ---- " + simpleBlockingQueue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
