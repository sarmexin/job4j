package threads.bomberman;

import org.junit.Test;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BomberManTest {
    private final BomberMan bomberMan = new BomberMan();

    @Test
    public void test() {
        Position position = new Position(0, 0);
        bomberMan.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}