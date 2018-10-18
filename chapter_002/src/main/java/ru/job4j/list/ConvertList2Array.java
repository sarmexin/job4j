package ru.job4j.list;

import java.util.ArrayList;
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
        if (list.size() % rows != 0) {
            cells++;
        }
        int[][] array = new int[rows][cells];
        int i = 0, j = 0;
        for (Integer el : list) {
            array[i][j++] = el;
            if (j == cells) {
                j = 0;
                i++;
            }
        }
        if (list.size() % rows != 0) {
            for (int a = 0; a != cells - j; a++) {
                array[cells - 1][j + a] = 0;
            }
        }
        return array;
    }

    /**
     * Метод создаёт один List<Integer> из List<int[]>
     *
     * @param list
     * @return
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] el : list) {
            for (int i : el) {
                result.add(i);
            }
        }
        return result;
    }

}
