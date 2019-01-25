package threads.mail;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EmailNotification {
    ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * @param user
     */
    public void emailTo(User user) {
        pool.submit(new Runnable() {
            @Override
            public void run() {
                EmailNotification emailNotification = new EmailNotification();
                String subject = String.format("subject = Notification: %s, to email: %s", user.getUserName(), user.getEmail());
                String body = String.format("body = Add a new event to %s", user.getUserName());
                emailNotification.send(subject, body, user.getEmail());
            }
        });

    }

    /**
     *
     */
    public void close() {
        pool.shutdown();
        while (!pool.isTerminated()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param subject
     * @param body
     * @param email
     */
    public void send(String subject, String body, String email) {
        System.out.println(subject);
        System.out.println(body);
    }
}
