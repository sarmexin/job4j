package threads.pingpong;

import javafx.scene.shape.Rectangle;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class RectangleMove implements Runnable {
    private final Rectangle rect;
    int step = 1;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
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
                Thread.currentThread().interrupt();
            }
        }
    }
}