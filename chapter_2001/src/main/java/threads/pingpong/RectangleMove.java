package threads.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    int step = 1;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        while (true) {
            this.rect.setX(this.rect.getX() + step);
            if (this.rect.getX() + step == 300) {
                step = -1;
            }
            if (this.rect.getX() + step == 0) {
                step = 1;
            }
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}