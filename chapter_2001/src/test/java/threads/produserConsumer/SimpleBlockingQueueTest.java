package threads.produserConsumer;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.IntStream;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleBlockingQueueTest {
    final CopyOnWriteArrayList<Integer> buffer = new CopyOnWriteArrayList<>();
    final SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>();

    Thread producer = new Thread(
            () -> {
                IntStream.range(0, 5).forEach(
                        queue::offer
                );
            }
    );
    Thread consumer = new Thread(
            () -> {
                while (!queue.getQueue().isEmpty() || !Thread.currentThread().isInterrupted()) {
                    try {
                        System.out.println("In buffer");
                        buffer.add(queue.poll());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
            }
    );
    @Test
    public void start() {
        producer.start();
        consumer.start();
        try {
            producer.join();
            consumer.interrupt();
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(buffer, is(Arrays.asList(0, 1, 2, 3, 4)));
    }

}


//   SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>();
//    Integer[] array1 = new Integer[1000];
//    Integer[] array2 = new Integer[1000];
//
//    @Before
//    public void before() {
//        for (int i = 0; i < 1000; i++) {
//            array1[i] = i;
//            array2[i] = i + 1000;
//        }
//    }
//
//    @Test
//    public void getSize() {
//        Producer<Integer> producer1 = new Producer<>(simpleBlockingQueue, array1);
//        Producer<Integer> producer2 = new Producer<>(simpleBlockingQueue, array2);
//        Consumer<Integer> consumer1 = new Consumer<>(simpleBlockingQueue);
//        Consumer<Integer> consumer2 = new Consumer<>(simpleBlockingQueue);
//        try {
//            consumer1.t.join();
//            producer1.t.join();
//            consumer2.t.join();
//            producer2.t.join();
//        } catch (InterruptedException e) {
//            System.out.println("InterruptedException");
//        }
//    }