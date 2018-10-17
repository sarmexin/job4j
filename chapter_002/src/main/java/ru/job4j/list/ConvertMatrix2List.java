package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConvertMatrix2List {
    /**
     * Метод конвертирует двухмерный массив в ArrayList
     *
     * @param array
     * @return
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] el : array) {
            for (int el2 : el) {
                list.add(el2);
            }
        }
        return list;
    }
}
