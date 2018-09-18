package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Long.valueOf;

/**
 * StartUI.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
            MenuTracker menu = new MenuTracker(this.input, this.tracker);
            List<Integer> range = new ArrayList<>();
            menu.fillActions();
            for (int i = 0; i < menu.getActionsLength(); i++) {
                range.add(i);
            }
            do {
                menu.show();
                menu.select((input.ask("select:")));
            } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }


    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}