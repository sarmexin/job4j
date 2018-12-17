package ru.job4j.collections.map.user;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Database {
    private static User user1 = new User("Maxim", 1, new Calendar(1, 12, 1976));
    private static User user2 = new User("Maxim", 1, new Calendar(1, 12, 1976));

    public static void main(String args[]) {
        System.out.println(user1.equals(user2));
        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        Map<User, Object> map = new HashMap<>();
        map.put(user1, "One");
        map.put(user2, "Two");
        System.out.println(map);

    }
}
