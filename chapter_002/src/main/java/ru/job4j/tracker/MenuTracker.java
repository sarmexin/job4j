package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;


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
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddAction());
        this.actions.add(new ShowItems());
        this.actions.add(new MenuTracker.EditItem());
        this.actions.add(new MenuTracker.DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new ExitProgram());
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(String key) {
        this.actions.get(Integer.parseInt(key)).execute(this.input, this.tracker);
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

    private class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("-------------Список всех заявок --------------------");
            for (Item str : tracker.findAll()) {
                System.out.println(str);
            }
        }

        @Override
        public String info() {
            return "1. Show all items";
        }
    }

    private static class EditItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return "2. Edit item";
        }
    }

    private static class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return "3. Delete item";
        }
    }

    public class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
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

        @Override
        public String info() {
            return "4. Find item by Id";
        }
    }

    private class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 5;
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

        @Override
        public String info() {
            return "5. Find items by name";
        }
    }
    private class ExitProgram implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return "6. Exit Program";
        }
    }

}