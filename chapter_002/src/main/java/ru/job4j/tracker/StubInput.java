package ru.job4j.tracker;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StubInput implements Input {

    /**
     * Это поле содержит последовательность ответов пользователя.
     */
    private final String[] value;

    /**
     * Поле считает количество вызовом метода ask.
     */
    private int position;

    /**
     * Конструктор.
     *
     * @param value
     */
    public StubInput(final String[] value) {
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
        return this.value[position++];
    }

    @Override
    public int ask(String question, int[] range) {
        throw new UnsupportedOperationException("Unsupported operation");
    }
}