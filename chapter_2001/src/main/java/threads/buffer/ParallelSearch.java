package threads.buffer;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import threads.produserConsumer.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class ParallelSearch {
    @GuardedBy("this")
    public static void main(String[] args) {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<Integer>();
        boolean flag = false;
        final Thread consumer = new Thread(
                () -> {
                    while (!Thread.interrupted()){
                        try {
                            System.out.println(queue.poll());
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            Thread.currentThread().interrupt();
                            break;
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