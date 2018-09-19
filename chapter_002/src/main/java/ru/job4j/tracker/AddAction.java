package ru.job4j.tracker;

/**
 * @author Sergey Gavrilov (mailto:sermexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class AddAction implements UserAction {
    private int key;
    private String name;

    /**
     * Кщнструктор.
     *
     * @param key
     * @param name
     */
    public AddAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * @return Возвращает ключ.
     */
    @Override
    public int key() {
        return key;
    }

    /**
     * Добавление новой заявки.
     *
     * @param input   объект типа Input.
     * @param tracker объект типа Tracker.
     */
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки :");
        String desc = input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * @return Возвращает информацию о действии.
     */
    @Override
    public String info() {
        return String.format("%d. %s", key, name);
    }
}