package threads.bomberman;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Board {
    final ReentrantLock[][] boards = new ReentrantLock[10][10];

    /**
     * Конструктор.
     */
    public Board() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                ReentrantLock locker = new ReentrantLock();
                boards[x][y] = locker;
            }
        }
    }

    /**
     * Метод проверяющий возможность перемещения фигуры.
     *
     * @param source начальная позиция.
     * @param dist   конечная позиция.
     * @return
     */
    public boolean move(Position source, Position dist) {
        boolean result = false;
        boolean res = false;
        if (dist.getPosX() > -1 && dist.getPosX() < 10 && dist.getPosY() > -1 && dist.getPosY() < 10) {
            try {
                res = boards[dist.getPosX()][dist.getPosY()].tryLock(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (res) {
                result = true;
                boards[source.getPosX()][source.getPosY()].unlock();
                System.out.println("Удалось переместится на новое место =" + dist.getPosX() + "  " + dist.getPosY());
            }
        }
        return result;
    }


}
