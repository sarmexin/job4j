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

    /**
     * Проверка метода sortNameLength, который будет сортировать List<User> по длине имени.
     * Test sortNameLength.
     */
    @Test
    public void sortByNameLength() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        List<User> result = new ArrayList<>();
        List<User> expect = new ArrayList<>();
        User user1 = new User("Tom", 20);
        User user2 = new User("Alice", 21);
        User user3 = new User("Nick", 25);
        User user4 = new User("Bob", 10);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        expect.add(user1);
        expect.add(user4);
        expect.add(user3);
        expect.add(user2);
        result.addAll(sortUser.sortNameLength(list));
        assertThat(result, is(expect));
    }

    /**
     * Еусе метода sortByAllFields, который будет отсортировать List<User> по обоим полям, сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
     * Test sortByAllFields.
     */
    @Test
    public void sortByNameLengthAndAge() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        List<User> result = new ArrayList<>();
        List<User> expect = new ArrayList<>();
        User user1 = new User("Tom", 25);
        User user2 = new User("Alice", 10);
        User user3 = new User("Tom", 20);
        User user4 = new User("Alice", 21);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        expect.add(user2);
        expect.add(user4);
        expect.add(user3);
        expect.add(user1);
        result.addAll(sortUser.sortByAllFields(list));
        assertThat(result, is(expect));
    }
}
