package ru.job4j.collections.map.user;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {
    static User user1 = new User("Maxim", 1, new Calendar(1, 12, 1976));
    static User user2 = new User("Maxim", 1, new Calendar(1, 12, 1976));

    @Test
    public void test() {
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "One");
        map.put(user2, "Two");
        System.out.println(user1.equals(user2));
        System.out.println(map);
    }

}