package ru.job4j.collections.list;

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
    List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        Arrays.stream(array).map(Arrays::stream).forEach(x -> x.forEach(list::add));
        return list;
    }
}
