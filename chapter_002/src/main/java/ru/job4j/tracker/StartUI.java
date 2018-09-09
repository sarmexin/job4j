package ru.job4j.tracker;

/**
 * StartUI.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа для получения списка всех заявок.
     */
    private static final String FA = "1";
    /**
     * Константа для редактирования заявки
     */
    private static final String EI = "2";
    /**
     * Константа для удаления заявки.
     */
    private static final String DI = "3";
    /**
     * Константа для удаления заявки.
     */
    private static final String FII = "4";
    /**
     * Константа для поиска заявки по имени.
     */
    private static final String FIN = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (FA.equals(answer)) {
                this.getList();
            } else if (EI.equals(answer)) {
                this.editItem();
            } else if (DI.equals(answer)) {
                this.deleteItem();
            } else if (FII.equals(answer)) {
                this.findItemById();
            } else if (FIN.equals(answer)) {
                this.findItemByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализующий вывод списка всех заявок из хранилища.
     */
    private void getList() {
        System.out.println("-------------Список всех заявок --------------------");
        for (Item str : tracker.findAll()) {
            System.out.println("Id: " + str.getId() + " name: " + str.getName() + " desc: " + str.getDescription() + " created " + str.getCreated());
        }
    }

    /**
     * Метод реализующий изменение заявки по Id в хранилище.
     */
    private void editItem() {
        String id = this.input.ask("Введите Id заяки :");
        Item item = new Item();
        item = this.tracker.findById(id);
        System.out.println("Id: " + item.getId() + " name: " + item.getName() + " desc: " + item.getDescription() + " created " + item.getCreated());
        String desc = this.input.ask("Введите новое описание :");
        item.setDesc(desc);
        System.out.println("Id: " + item.getId() + " name: " + item.getName() + " desc: " + item.getDescription() + " created " + item.getCreated());
    }

    /**
     * Метод реализующий удаление заявки по Id в хранилище.
     */
    private void deleteItem() {
        String id = this.input.ask("Введите Id заяки :");
        this.tracker.delete(id);
    }

    /**
     * Метод реализующий вывод меню.
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item.");
        System.out.println("1. Show all items.");
        System.out.println("2. Edit Item");
        System.out.println("3. Delete Item");
        System.out.println("4. Find Item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Programm");
    }

    /**
     * Метод реализующий вывод заявки по Id из хранилища.
     */
    private void findItemById() {
        String id = this.input.ask("Введите Id заяки :");
        Item item = new Item();
        item = tracker.findById(id);
        System.out.println("Id: " + item.getId() + " name: " + item.getName() + " desc: " + item.getDescription() + " created " + item.getCreated());
    }

    /**
     * Метод реализующий вывод списка заявок по имени заявки из хранилища.
     */
    private void findItemByName() {
        String name = this.input.ask("Введите имя заявки :");
        for (Item str : this.tracker.findByName(name)) {
            System.out.println("Id: " + str.getId() + " name: " + str.getName() + " desc: " + str.getDescription() + " created " + str.getCreated());
        }
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