package ru.job4j.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {
    /**
     * Метод, выполняющий подсчет функции в диапазоне.
     *
     * @param start
     * @param end
     * @param func
     * @return
     */
    public List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> buffer = new ArrayList<>();
        for (int i = start; i != end; i++) {
            buffer.add(func.apply((double) i));
        }
        return buffer;
    }
}
