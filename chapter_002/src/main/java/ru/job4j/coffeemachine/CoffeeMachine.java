package ru.job4j.coffeemachine;

import java.util.Arrays;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class CoffeeMachine {
    private int[] money = new int[]{1, 2, 5, 10};

    /**
     * @param value Купюра принята
     * @param price Стоимость напитка
     * @return Массив монет
     */
    int[] changes(int value, int price) {
        int number = 0, index = 0, deliv = 0;
        int[] delivery = new int[50];
        for (int i = 1; i != 5; i++) {
            number = (value - price - deliv) / money[money.length - i];
            for (int j = 0; j != number; j++) {
                delivery[index++] = money[money.length - i];
                deliv += money[money.length - i];
            }
            if ((value - price) % money[money.length - i] == 0) {
                break;
            }
        }

        return Arrays.copyOf(delivery, index);

    }

}
//public static void main(String[] args) {