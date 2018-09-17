package ru.job4j.tracker;

public interface UserAction {
    /**
     * Метод возвращает ключ опции.
     *
     * @return
     */
    int key();

    /**
     * Основной метод
     *
     * @param input   объект типа Input.
     * @param tracker объект типа Tracker.
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном меню.
     *
     * @return
     */
    String info();
}
