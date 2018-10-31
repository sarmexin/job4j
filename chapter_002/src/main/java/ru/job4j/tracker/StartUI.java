package ru.job4j.tracker;

import java.util.List;
import java.util.function.Consumer;

/**
 * StartUI.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Флажок для выхода.
     * Программа работает до тех пор, пока значение истинно.
     */
    public boolean working = true;
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
     * Основой цикл программы, с выводом на экран меню.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        do {
            Consumer<List<UserAction>> consumer = x -> {
                for (UserAction action : x) {
                    if (action != null) {
                        System.out.println(action.info());
                    }
                }
            };
            consumer.accept(menu.getActions());
            menu.select((input.ask("select:", menu.getRange())));
        } while (this.working);
    }

    public void stop() {
        this.working = false;
    }


    /**
     * Запускт программы.
     *
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}