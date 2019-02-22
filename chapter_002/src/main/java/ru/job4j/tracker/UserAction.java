package ru.job4j.tracker;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
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
    void execute(Input input, ITracker tracker);

    /**
     * Метод возвращает информацию о данном меню.
     *
     * @return
     */
    String info();
}
