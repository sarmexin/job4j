package ru.job4j.collections.analize;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AnalizeTest {
    @Test
    public void test() {
        User user1 = new User(1, "Alex");
        User user2 = new User(2, "Bob");
        User user3 = new User(3, "Jon");
        User user4 = new User(4, "Nick");
        User user5 = new User(5, "Emily");
        User user6 = new User(6, "Daniel");
        User user7 = new User(3, "Joseph");
        User user8 = new User(8, "Ban");
        User user9 = new User(4, "Jack");
        ArrayList<User> list1 = new ArrayList<>();
        list1.add(user1);
        list1.add(user2);
        list1.add(user3);
        list1.add(user4);
        list1.add(user5);
        ArrayList<User> list2 = new ArrayList<>();
        list2.addAll(list1);
        list2.add(user6);
        list2.add(user8);
        list2.remove(user1);
        list2.set(1, user7);
        list2.set(2, user9);
        Analize analize = new Analize();
        Info expected = new Info(2, 2, 1);
        Info result = analize.diff(list1, list2);
        boolean rls = expected.equals(result);
        assertThat(rls, is(true));
    }
}