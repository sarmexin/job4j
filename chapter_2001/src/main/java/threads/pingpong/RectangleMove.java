package threads.pingpong;

import javafx.scene.shape.Rectangle;

public class RectangleMove implements Runnable {
    private final Rectangle rect;
    int step = 1;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run()  {
        double position;
        while (!Thread.currentThread().isInterrupted()) {
            position = this.rect.getX() + step;
            this.rect.setX(position);
            if (position == 300) {
                step = -1;
            }
            if (position == 0) {
                step = 1;
            }
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}