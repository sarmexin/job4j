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
            System.out.println("Test1");
        };
        Runnable runnable2 = () -> {
                System.out.println("Test2");
        };
        System.out.println("Запуск в работу тест1");
        threadPool.work(runnable);
        System.out.println("Запуск в работу тест2");
        threadPool.work(runnable2);
        System.out.println("Запуск в работу тест3");
        threadPool.work(runnable);
        try {
            System.out.println("Заснул главный поток на 3 секунды");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
        try {
            System.out.println("Заснул главный поток на 3 секунды");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}