package multithread;

/**
 * Created by Guest on 03.04.2019.
 */
public class NewThread implements Runnable {
    String name;
    Thread t;
    NewThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("Новый поток: " + t);
        t.start();
    }
    public void run() {
        try{
            for(int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        }  catch (InterruptedException e) {
            System.out.println(name + " прерван");
        }
        System.out.println(name + " завершен");
    }
}
