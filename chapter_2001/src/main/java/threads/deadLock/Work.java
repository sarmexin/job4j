package threads.deadLock;

public class Work {

    class User1 {
        public synchronized void input() {
            user2.print();
        }

        public synchronized void print() {
            System.out.println("in 1");
        }
    }

    class User2 {
        public synchronized void input() {
            user1.print();

        }

        public synchronized void print() {
            System.out.println("in 2");
        }
    }

    User1 user1;
    User2 user2;

    Runnable runnable1 = () -> {
        user1.print();
    };

    Runnable runnable2 = () -> {
        user2.print();
    };

    public void start() {
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
