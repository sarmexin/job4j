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
    private static final String SHOW = "1";
    /**
     * Константа для редактирования заявки.
     */
    private static final String EDIT = "2";
    /**
     * Константа для удаления заявки.
     */
    private static final String DELETE = "3";
    /**
     * Константа для удаления заявки.
     */
    private static final String FINDID = "4";
    /**
     * Константа для поиска заявки по имени.
     */
    private static final String FINDNAME = "5";
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
            } else if (SHOW.equals(answer)) {
                this.getList();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findItemById();
            } else if (FINDNAME.equals(answer)) {
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
            System.out.println(str);
        }
    }

    /**
     * Метод реализующий изменение заявки по Id в хранилище.
     */
    private void editItem() {
        String id = this.input.ask("Введите Id заяки :");
        if (this.tracker.findById(id) != null) {
            Item item = this.tracker.findById(id);
            System.out.println(item);
            String desc = this.input.ask("Введите новое описание :");
            item.setDesc(desc);
            System.out.println(item);
            this.tracker.replace(id, item);
            System.out.println("Заявка : " + id + " изменена.");
        } else {
            System.out.println("Заявки с таким Id не найдено.");
        }
    }

    /**
     * Метод реализующий удаление заявки по Id в хранилище.
     */
    private void deleteItem() {
        String id = this.input.ask("Введите Id заяки :");
        if (this.tracker.findById(id) != null) {
            this.tracker.delete(id);
            System.out.println("Заявка : " + id + " удалена");
        } else {
            System.out.println("Заявки с таким Id не найдено.");
        }
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
        if (this.tracker.findById(id) != null) {
            Item item = tracker.findById(id);
            System.out.println(item);
        } else {
            System.out.println("Заявки с Id : " + id + " не найдено.");
        }
    }

    /**
     * Метод реализующий вывод списка заявок по имени заявки из хранилища.
     */
    private void findItemByName() {
        String name = this.input.ask("Введите имя заявки :");
        if (this.tracker.findByName(name).length != 0) {
            for (Item str : this.tracker.findByName(name)) {
                System.out.println(str);
            }
        } else {
            System.out.println("Заявки с именем : " + name + " не найдено.");
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