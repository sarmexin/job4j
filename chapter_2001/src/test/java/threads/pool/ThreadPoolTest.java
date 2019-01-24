package threads.pool;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreadPoolTest {
    @Test
    public void test() {
        ThreadPool threadPool = new ThreadPool();
        System.out.println("Length pool =" + threadPool.size);
        threadPool.pool();
        System.out.println(threadPool.getThreads().get(0).getName());
        System.out.println(threadPool.getThreads().get(1).getName());
    }

}