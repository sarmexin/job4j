package ru.job4j.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {
    /**
     * @param left
     * @param right
     * @return
     */
    @Override
    public int compare(String left, String right) {
        List<Character> listLeft = new ArrayList<>();
        List<Character> listRight = new ArrayList<>();
        for (int i = 0; i != left.length(); i++) {
            listLeft.add(left.charAt(i));
        }
        for (int i = 0; i != right.length(); i++) {
            listRight.add(right.charAt(i));
        }
        int l = left.length();
        int r = right.length();
        int m = l > r ? r : l;
        for (int i = 0; i != m; i++) {
            int n = Character.compare(listLeft.get(i), listRight.get(i));
            if (n != 0) {
                return n > 0 ? 1 : -1;
            }
        }
        if (l == r) {
            return 0;
        } else {
            return l > r ? 1 : -1;
        }
    }
}