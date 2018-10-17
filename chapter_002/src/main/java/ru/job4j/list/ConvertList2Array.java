package ru.job4j.list;

import java.util.List;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertList2Array {
    /**
     * Метод разбивает list на количество rows двухмерного массива
     *
     * @param list
     * @param rows
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() / rows;
        if (list.size() % 3 != 0) {
            cells++;
        }
        int[][] array = new int[rows][cells];
        int i = 0, j = 0, n = 0;
        for (Integer el : list) {
            array[i][j++] = el;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        if (list.size() != rows * cells) {
            n = rows * cells - list.size();
        }
        return array;
    }
}
