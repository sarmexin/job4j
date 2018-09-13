package ru.job4j.calculator;

/**
 * Calculator.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Calculator {

    private double result;

    /**
     * Method add.
     *
     * @param first
     * @param second
     * @return result
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Method subtract.
     *
     * @param first
     * @param second
     * @return result
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Method div.
     *
     * @param first
     * @param second
     * @return result
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Method multiple.
     *
     * @param first
     * @param second
     * @return result
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Method getResult.
     *
     * @return result
     */
    public double getResult() {
        return this.result;
    }
}