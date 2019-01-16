package threads.problem;

import org.junit.Test;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ProblemDemoTest {
    @Test
    public void test() {
        new Manufacturer();
        new Consumer();
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("");
        }
    }

}