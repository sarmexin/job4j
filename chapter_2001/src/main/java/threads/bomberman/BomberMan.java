package threads.bomberman;

import java.util.concurrent.locks.ReentrantLock;

public class BomberMan {
    ReentrantLock[][] board = new ReentrantLock[10][10];

    /**
     * Конструктор.
     */
    public BomberMan() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                ReentrantLock locker = new ReentrantLock();
                board[x][y] = locker;
            }
        }
//        for (int x = 0; x < 10; x++) {
//            for (int y = 0; y < 10; y++) {
//                System.out.println(board[x][y]);
//            }
//        }
    }

    /**
     * Метод запуска потоков.
     */
    public void start() {
        Thread hero = new Thread(new Hero());
      //  Thread monster = new Thread(new Monster());
        hero.start();
     //   monster.start();
        try {
            hero.join();
      //      monster.join();
        } catch (InterruptedException e) {
            System.out.println("<<< Вылетели при старте потоков");
            e.printStackTrace();
        }
    }

    /**
     * Класс, пораждающий поток героя.
     */
    class Hero implements Runnable {
        BomberMan bomberMan = new BomberMan();
        @Override
        public void run() {
        //    System.out.println("В методе run hero");
            Position position = new Position(5, 5);
            board[position.getPosX()][position.getPosY()].lock();
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("HERO   Проверка на закрытие =" + position.getPosX() + "  " + position.getPosY() + "  " + board[position.getPosX()][position.getPosY()]);
                System.out.println("------------" +  board[5][4]);
                board[position.getPosX()][position.getPosY()].unlock();
                position = bomberMan.step(position);
                try {
                    System.out.println("В потоке hero stop 2 sec");
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
//    class Monster implements Runnable {
//        BomberMan bomberMan = new BomberMan();
//        @Override
//        public void run() {
//         //   System.out.println("В методе run Monster");
//            Position position = new Position(8, 8);
//            System.out.println("В начале " + position.posX + "  " + position.getPosY());
//            board[position.getPosX()][position.getPosY()].lock();
//            while (!Thread.currentThread().isInterrupted()) {
//                board[position.getPosX()][position.getPosY()].unlock();
//                position = bomberMan.step(position);
//                System.out.println(position.posX + "  " + position.getPosY());
//                try {
//                    System.out.println("В потоке Monster stop 2 sec");
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    System.out.println("<<< Вылетели в Monster");
//                    Thread.currentThread().interrupt();
//                }
//            }
//        }
//    }

    /**
     * Метод определяющий направление хода.
     *
     * @return
     */
    public synchronized Position step(Position position) {
        do {
            int step = (int) (Math.random() * 4);
   //         System.out.println("step in = " + step);
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
        } while (!this.check(position));

        return position;
    }

    /**
     * Метод проверяет возможность перемещения по этим координатам.
     *
     * @return boolean.
     */
    public synchronized boolean check(Position position) {
        boolean result = false;
        if (position.getPosX() > -1 && position.getPosX() < 10 && position.getPosY() > -1 && position.getPosY() < 10 && board[position.getPosX()][position.getPosY()].tryLock()) {
            result = true;
            System.out.println("Удалось переместится на новое место =" + position.getPosX() + "  " + position.getPosY());
            System.out.println("Проверка на закрытие в методе проверки check =" + board[position.getPosX()][position.getPosY()]);
            System.out.println("------------" +  board[5][4]);
        }
        if (!result) {
            System.out.println("НЕЕЕЕЕЕЕ  удалось переместится на новое место");
        }
        return result;
    }
}
