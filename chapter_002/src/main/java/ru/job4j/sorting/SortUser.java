package ru.job4j.sorting;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {
    TreeSet<User> treeSet = new TreeSet<User>();

    /**
     * Метод который будет возвращать TreeSet пользователей, отсортированных по возрасту в порядке возрастания.
     *
     * @param list
     * @return
     */
    public Set<User> sort(List<User> list) {
        treeSet.addAll(list);
        return treeSet;
    }
}
