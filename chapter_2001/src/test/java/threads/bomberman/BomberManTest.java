package threads.bomberman;

import org.junit.Test;

import static org.junit.Assert.*;

public class BomberManTest {
    BomberMan bomberMan = new BomberMan();
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