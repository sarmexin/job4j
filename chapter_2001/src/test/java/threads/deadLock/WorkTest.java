package threads.deadLock;

import org.junit.Test;

public class WorkTest {
    @Test
    public void test() {
        Work work = new Work();
        work.start();
    }
}