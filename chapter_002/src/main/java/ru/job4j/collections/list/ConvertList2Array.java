package ru.job4j.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> list2 = new ArrayList<>();
        list2.addAll(list);
        int cells = list.size() / rows;
        if (list.size() % rows != 0) {
            cells++;
            for (int i = 0; i != cells * rows - list.size(); i++) {
                list2.add(0);
            }
        }
        int[][] array = new int[rows][cells];
        for (int i = 0; i < cells; i++) {
            List<Integer> result = list2.stream()
                    .skip(i * cells)
                    .limit(cells)
                    .collect(Collectors.toList());
            array[i] = result.stream().mapToInt(x -> x).toArray();
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
