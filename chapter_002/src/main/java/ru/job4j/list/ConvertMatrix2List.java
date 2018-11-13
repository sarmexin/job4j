package ru.job4j.list;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        Integer[][] array2 = new Integer[array.length][array.length];
        int i = 0, j = 0;
        for (int[] el : array) {
            for (int el2 : el) {
                array2[i][j] = Integer.valueOf(array[i][j++]);

            }
            j = 0;
            i++;
        }
        return Stream.of(array2).flatMap(Stream::of)
                .collect(Collectors.toList());

    }
}
