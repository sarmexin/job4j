package threads.userStorage;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserStorageTest {
    UserStorage userStorage = new UserStorage();
    User user1 = new User(1, 10000);
    User user2 = new User(2, 20000);
    User user3 = new User(3, 30000);
    User user4 = new User(1, 40000);

    @Before
    public void before() {
        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);
        userStorage.add(user4);
    }

    @Test
    public void add() {
        UserStorage userStorage1 = new UserStorage();
        userStorage1.add(user1);
        userStorage1.add(user2);
        userStorage1.add(user3);
        assertThat(userStorage1, is(userStorage));
    }

    @Test
    public void update() {
        UserStorage userStorage1 = new UserStorage();
        userStorage1.add(user4);
        userStorage1.add(user2);
        userStorage1.add(user3);
        userStorage.update(user4);
        assertThat(userStorage1, is(userStorage));
    }

    @Test
    public void delete() {
        UserStorage userStorage1 = new UserStorage();
        userStorage1.add(user2);
        userStorage1.add(user3);
        userStorage.delete(user1);
        assertThat(userStorage1, is(userStorage));
    }

    @Test
    public void transfer() {
        UserStorage userStorage1 = new UserStorage();
        User user5 = new User(1, 20000);
        User user6 = new User(2, 10000);
        userStorage1.add(user5);
        userStorage1.add(user6);
        userStorage1.add(user3);
        userStorage.transfer(user2.getId(), user1.getId(), 10000);
        assertThat(userStorage1, is(userStorage));
    }
}