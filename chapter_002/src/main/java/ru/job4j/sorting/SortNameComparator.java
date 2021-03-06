package ru.job4j.sorting;

import ru.job4j.sorting.User;

import java.util.Comparator;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortNameComparator implements Comparator<User> {
    /**
     * Сравнивает имена по длине.
     *
     * @param a
     * @param b
     * @return
     */
    public int compare(User a, User b) {
        return Integer.compare(a.getName().length(), b.getName().length());
    }
}
