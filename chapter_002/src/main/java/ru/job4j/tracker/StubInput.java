package ru.job4j.tracker;

import java.util.List;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {

    /**
     * Это поле содержит последовательность ответов пользователя.
     */
    private final List<String> value;

    /**
     * Поле считает количество вызовом метода ask.
     */
    private int position;

    /**
     * Конструктор.
     *
     * @param value
     */
    public StubInput(final List<String> value) {
        this.value = value;
    }

    /**
     * Method ask.
     *
     * @param question Вопрос пользователю.
     * @return
     */
    @Override
    public String ask(String question) {
        return this.value.get(position++);
    }

    @Override
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
