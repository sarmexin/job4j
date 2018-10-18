package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserConvertTest {
    /**
     * Test process
     */
    @Test
    public void test() {
        UserConvert ob = new UserConvert();
        List<User> list = new ArrayList<>();
        list.add(new User("Вася", "Саратов"));
        list.add(new User("Рома", "Воронеж"));
        User user1 = new User("Вася", "Саратов");
        User user2 = new User("Рома", "Воронеж");
        HashMap<Integer, User> result = ob.process(list);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(user1.hashCode(), user1);
        expect.put(user2.hashCode(), user2);
        assertThat(result, is(expect));

    }
}