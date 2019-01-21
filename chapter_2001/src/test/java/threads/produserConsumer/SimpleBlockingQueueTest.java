package threads.produserConsumer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleBlockingQueueTest {
    SimpleBlockingQueue<Integer> simpleBlockingQueue = new SimpleBlockingQueue<>();
    Integer[] array1 = new Integer[1000];
    Integer[] array2 = new Integer[1000];

    @Before
    public void before() {
        for (int i = 0; i < 1000; i++) {
            array1[i] = i;
            array2[i] = i + 1000;
        }
    }

    @Test
    public void getSize() {
        Producer<Integer> producer1 = new Producer<>(simpleBlockingQueue, array1);
        Producer<Integer> producer2 = new Producer<>(simpleBlockingQueue, array2);
        Consumer<Integer> consumer1 = new Consumer<>(simpleBlockingQueue);
        Consumer<Integer> consumer2 = new Consumer<>(simpleBlockingQueue);
        try {
            consumer1.t.join();
            producer1.t.join();
            consumer2.t.join();
            producer2.t.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
    }
}