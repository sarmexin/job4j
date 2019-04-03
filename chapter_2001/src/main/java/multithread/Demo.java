package multithread;

/**
 * Created by Guest on 03.04.2019.
 */
public class Demo {
    public static void main(String[] args) {
        new NewThread("Один");
        new NewThread("Два");
        new NewThread("Три");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Главный поток прерван");
        }
        System.out.println("Главный поток завершён");
    }
}
