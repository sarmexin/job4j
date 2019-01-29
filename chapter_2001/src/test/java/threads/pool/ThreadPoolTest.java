package threads.pool;

import org.junit.Test;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ThreadPoolTest {
    @Test
    public void test() {
        ThreadPool threadPool = new ThreadPool();
        threadPool.pool();
        Runnable runnable = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Test1");
            }
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Test2");
            }
        };
        System.out.println("Запуск в работу тест1");
        threadPool.work(runnable);
        System.out.println("Запуск в работу тест2");
        threadPool.work(runnable2);
        System.out.println("Запуск в работу тест1");
        threadPool.work(runnable);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("программная остановка");
        threadPool.shutdown();
    }
}