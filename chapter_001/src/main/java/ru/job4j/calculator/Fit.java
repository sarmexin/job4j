package ru.job4j.calculator;

/**
 * ��������� ������� ���������� ����.
 */
public class Fit {

    /**
     * ��������� ��� ��� �������.
     * @param height ����.
     * @return ��������� ���.
     */
    public double manWeight(double height) {
        return (height - 100) * 1.15;
    }

    /**
     * ��������� ��� ��� �������.
     * @param height ����.
     * @return ��������� ���.
     */
    public double womanWeight(double height) {
        return (height - 110) * 1.15;
    }
}