package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MenuTracker {

    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     *
     * @return Массив range.
     */
    public int[] getRange() {
        int[] range = new int[this.getActionsLength()];
        for (int i = 0; i < this.getActionsLength(); i++) {
            range[i] = i;
        }
        return range;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddAction(0, "Add new Item."));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new MenuTracker.EditItem(2, "Edit item"));
        this.actions.add(new MenuTracker.DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemsByName(5, "Find items by name"));
        this.actions.add(new ExitProgram(ui, 6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    /**
     * Метод реализующий вывод списка всех заявок из хранилища.
     */
    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------Список всех заявок --------------------");
            for (Item str : tracker.findAll()) {
                System.out.println(str);
            }
        }
    }

    /**
     * Метод реализующий изменение заявки по Id в хранилище.
     */
    private static class EditItem extends BaseAction {
        private int key;
        private String name;

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите Id заяки :");
            if (tracker.findById(id) != null) {
                Item item = tracker.findById(id);
                System.out.println(item);
                String desc = input.ask("Введите новое описание :");
                item.setDesc(desc);
                System.out.println(item);
                tracker.replace(id, item);
                System.out.println("Заявка : " + id + " изменена.");
            } else {
                System.out.println("Заявка с Id : " + id + " не найдена.");
            }
        }
    }

    /**
     * Метод реализующий удаление заявки по Id в хранилище.
     */
    private static class DeleteItem extends BaseAction {
        private int key;
        private String name;

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите Id заяки :");
            if (tracker.delete(id)) {
                System.out.println("Заявка : " + id + " удалена");
            } else {
                System.out.println("Заявка с Id : " + id + " не найдена.");
            }
        }
    }

    /**
     * Метод реализующий вывод заявки по Id из хранилища.
     */
    public class FindItemById extends BaseAction {
        private int key;
        private String name;

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Введите Id заяки :");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("Заявки с Id : " + id + " не найдено.");
            }
        }
    }

    /**
     * Метод реализующий вывод списка заявок по имени заявки из хранилища.
     */
    private class FindItemsByName extends BaseAction {
        private int key;
        private String name;

        public FindItemsByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Введите имя заявки :");
            Item[] array = tracker.findByName(name);
            if (array.length != 0) {
                for (Item str : array) {
                    System.out.println(str);
                }
            } else {
                System.out.println("Заявки с именем : " + name + " не найдено.");
            }
        }
    }

    /**
     *
     */
    private class ExitProgram implements UserAction {
        private int key;
        private String name;
        private final StartUI ui;

        public ExitProgram(StartUI ui, int key, String name) {
            this.ui = ui;
            this.key = key;
            this.name = name;
        }

        @Override
        public int key() {
            return key;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();

        }

        @Override
        public String info() {
            return String.format("%d. %s", key, name);
        }
    }

}