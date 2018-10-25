package ru.job4j.sorting;

import ru.job4j.sorting.User;

import java.util.Comparator;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class UserNameComparator implements Comparator<User> {
    /**
     * Сравнивает имена.
     *
     * @param a
     * @param b
     * @return
     */
    public int compare(User a, User b) {
        return a.getName().compareTo(b.getName());
    }
}
