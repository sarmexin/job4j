package ru.job4j.collections.analize;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User {
    int id;
    String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public User(int id, String name) {

        this.id = id;
        this.name = name;
    }
}
