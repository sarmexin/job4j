package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUserTest {
    /**
     * Проверка метода sort, который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     * Test sort.
     */
    @Test
    public void test() {
        TreeSet<User> result = new TreeSet<>();
        TreeSet<User> expect = new TreeSet<>();
        List<User> list = new ArrayList<>();
        SortUser sortUser = new SortUser();
        User user1 = new User("Tom", 20);
        User user2 = new User("Nick", 25);
        User user3 = new User("Alice", 21);
        User user4 = new User("Bob", 10);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        expect.add(user4);
        expect.add(user1);
        expect.add(user3);
        expect.add(user2);
        result.addAll(sortUser.sort(list));
        assertThat(result, is(expect));
    }
}
