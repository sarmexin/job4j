package threads.bomberman;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BomberMan {
    private final Board board = new Board();

    /**
     * Метод запуска потоков.
     */
    public void start() {
        Thread hero = new Thread(new Hero());
        Thread monster = new Thread(new Monster());
        hero.start();
        monster.start();
        try {
            hero.join();
            monster.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Класс, пораждающий поток героя.
     */
    class Hero implements Runnable {
        @Override
        public void run() {
            Position dist;
            Position position = new Position(7, 7);
            board.boards[position.getPosX()][position.getPosY()].lock();
            while (!Thread.currentThread().isInterrupted()) {
                boolean result = false;
                while (!result) {
                    dist = step(position);
                    result = board.move(position, dist);
                }
                System.out.println("hero");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /**
     * Класс, пораждающий поток чудовища.
     */
    class Monster implements Runnable {
        @Override
        public void run() {
            Position dist;
            Position position = new Position(5, 5);
            board.boards[position.getPosX()][position.getPosY()].lock();
            while (!Thread.currentThread().isInterrupted()) {
                boolean result = false;
                while (!result) {
                    dist = step(position);
                    result = board.move(position, dist);
                }
                System.out.println("monster");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    /**
     * Метод определяющий направление хода.
     *
     * @return новую позицию, определённую случайным образом.
     */
    public synchronized Position step(Position position) {
        int step = (int) (Math.random() * 4);
        System.out.println("step in = " + step);
        if (step == 0) {
            int x = position.getPosX() + 1;
            position.setPosX(x);
        }
        if (step == 1) {
            int x = position.getPosX() - 1;
            position.setPosX(x);
        }
        if (step == 2) {
            int x = position.getPosY() + 1;
            position.setPosY(x);
        }
        if (step == 3) {
            int x = position.getPosY() - 1;
            position.setPosY(x);
        }
        return position;
    }
}
