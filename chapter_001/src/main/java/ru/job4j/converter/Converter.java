package ru.job4j.converter;

/**
 * ��������� ������.
 */
public class Converter {

    /**
     * ������������ ����� � ����.
     * @param value �����.
     * @return ����.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * ������������ ����� � �������.
     * @param value �����.
     * @return �������
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * ������������ ���� � �����.
     * @param value �����.
     * @return ����.
     */
    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * ������������ ������� � �����.
     * @param value �����.
     * @return ����.
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
}