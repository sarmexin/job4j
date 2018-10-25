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
        int m = Math.min(left.length(), right.length());
        int result = Integer.compare(left.length(), right.length());
        for (int i = 0; i < m; i++) {
            int n = Character.compare(left.charAt(i), right.charAt(i));
            if (n != 0) {
                result = n;
                break;
            }
        }
        return result;
    }
}