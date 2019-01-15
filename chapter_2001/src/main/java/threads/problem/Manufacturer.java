package threads.problem;

public class Manufacturer implements Runnable {
    ProblemDemo problemDemo = new ProblemDemo();
    Thread t;

    public Manufacturer() {
        t = new Thread(this);
        t.start();
    }

    public ProblemDemo getProblemDemo() {
        return problemDemo;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                i++;
                problemDemo.setValue(i);
                System.out.println("Положил =" + i);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("kkk");
        }
    }
}
