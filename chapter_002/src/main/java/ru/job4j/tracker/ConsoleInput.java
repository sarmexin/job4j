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
     * Метод реализующий запрос пользователя.
     * @param question
     * @return ответ пользователя.
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
