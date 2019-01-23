package threads.nonBlockingCache;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StorageTest {
    @Test
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        Thread thread = new Thread(
                () -> {
                    try {
                        throw new RuntimeException("Throw Exception in Thread");
                    } catch (Exception e) {
                        ex.set(e);
                    }
                }
        );
        thread.start();
        thread.join();
        Assert.assertThat(ex.get().getMessage(), is("Throw Exception in Thread"));
    }

//    @Test
//    public void test() throws InterruptedException{
//        AtomicReference<Exception> ex = new AtomicReference<>();
//        Storage storage = new Storage();
//        Base base1 = new Base(1, 0, "first");
//        Base base2 = new Base(2, 0, "второй");
//        Base base3 = new Base(3, 0, "третий");
//        storage.add(base1);
//        storage.add(base2);
//        storage.add(base3);
//        storage.delete(base3);
//        Base base4 = new Base(2, 0, "второй исправленный");
//        Base base5 = new Base(2, 0, "второй исправленный  2");
//        storage.update(base4);
//        Thread thread3 = new Thread(
//                () -> {
//                    try {
//                        System.out.println("111>>>");
//                        while (true) {
//                            System.out.println("Поток 1");
//                            Thread.sleep(1000);
//                            System.out.println("222>>>");
//                            storage.update(base4);
//
//
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//        );
//
//        Thread thread2 = new Thread(
//                () -> {
//                    try {
//                        while (true) {
//                            System.out.println("Поток 2");
//                            Thread.sleep(1000);
//                            System.out.println(">>>");
//                            storage.update(base5);
//
//
//                        }
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//        );
//        thread3.start();
//        thread2.start();
//        thread2.join();
//        thread3.join();
//    }
}