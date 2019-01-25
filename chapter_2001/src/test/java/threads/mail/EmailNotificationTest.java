package threads.mail;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class EmailNotificationTest {  //Через ExecutorService создайте задачу, которая будет создать данные для пользователя и передавать их в метод send.
    EmailNotification emailNotification = new EmailNotification();
    User user = new User("Sergey", "sarmexin@gmail.com");

    @Test
    public void emailTo() {
        emailNotification.emailTo(user);

    }

    @Test
    public void close() {
    }

    @Test
    public void emailTo1() {
    }

    @Test
    public void send() {
    }
}