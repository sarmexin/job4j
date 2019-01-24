package threads.mail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EmailNotification {
    ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public void emailTo(User user) {  //он должен через ExecutorService отправлять почту.
        String subject = String.format("subject = Notification: %s, to email: %s", user.getUserName(),user.getEmail());
        String body = String.format("body = Add a new event to %s", user.getUserName());
        pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(subject);
                System.out.println(body);
            }
        });

    }

    public void close() {  //он должен закрыть pool. То есть в классе EmailNotification должно быть поле pool, которые используется в emailTo и close().
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void send(String subject, String body, String email) {

    }


}
