package ru.job4j.sorting;

import ru.job4j.search.SortNameComparator;
import ru.job4j.search.UserAgeComparator;
import ru.job4j.search.UserNameComparator;

import java.util.*;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SortUser {
    private TreeSet<User> treeSet = new TreeSet<User>();

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

    /**
     * Метод, который будет сортировать List<User> по длине имени.
     *
     * @param list
     * @return
     */
    public List<User> sortNameLength(List<User> list) {
        SortNameComparator sortNameComparator = new SortNameComparator();
        TreeSet<User> treeSetName = new TreeSet<>(sortNameComparator);
        treeSetName.addAll(list);
        List<User> list2 = new ArrayList<>();
        list2.addAll(treeSetName);
        return list2;
    }

    /**
     * Метод, котрый будет отсортировать List<User> по обоим полям, сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
     *
     * @param list
     * @return
     */
    public List<User> sortByAllFields(List<User> list) {
        Comparator<User> comp = new UserNameComparator().thenComparing(new UserAgeComparator());
        TreeSet<User> treeSet = new TreeSet<>(comp);
        treeSet.addAll(list);
        List<User> list2 = new ArrayList<>();
        list2.addAll(treeSet);
        return list2;
    }
}
