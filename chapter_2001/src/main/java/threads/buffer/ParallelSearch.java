package threads.buffer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import threads.produserConsumer.SimpleBlockingQueue;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class ParallelSearch {
    @GuardedBy("this")
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        final Thread consumer = new Thread(
                () -> {
                    while (!Thread.interrupted()) {
                        try {
                            System.out.println(queue.poll());
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();

                        }
                    }
                }
        );
        consumer.start();
        new Thread(
                () -> {
                    for (int index = 0; index != 3; index++) {
                        queue.offer(index);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    consumer.interrupt();
                }
        ).start();
    }
}