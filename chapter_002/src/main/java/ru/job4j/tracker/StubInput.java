package ru.job4j.tracker;

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
     * Давайте рассмотрим, как работает этот метод.
     * у нас есть объект в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы увеличиваем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */

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
}