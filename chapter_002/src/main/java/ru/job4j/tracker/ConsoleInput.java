package ru.job4j.tracker;

import java.util.*;

/**
 * Запрос пользователя в консоли.
 * ConsoleInput.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Метод реализующий ввод данных от пользователя.
     *
     * @param question
     * @return ответ пользователя.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * Метод для выбора пункта меню и проверки на существование такого пункта.
     *
     * @param question
     * @param range
     * @return
     */
    public int ask(String question, List<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutException("out of menu range");
        }
        return key;
    }
}
