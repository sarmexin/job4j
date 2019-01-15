package threads.problem;

public class Consumer implements Runnable{
    ProblemDemo problemDemo;
    Thread t;

    public Consumer() {
        Manufacturer manufacturer = new Manufacturer();
        this.problemDemo = manufacturer.getProblemDemo();
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Принял =" + problemDemo.getValue());
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println("000");
        }
    }
}
