package NewProjects;


import java.util.Scanner;

public class Face {

    WorkSql workSql = new WorkSql();
    public void menu() {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Menu:");
            System.out.println("0 - Вывести весь список автомобилей");
            System.out.println("1 - add");
            System.out.println("2 - Найти автомобиль по цвету");
            System.out.println("3 - Найти автомобиль по клиенту");
            System.out.println("4 - Создать таблицу клиент");
            System.out.println("5 - Статистика");
            System.out.println("99 - Выход");
            int num = in.nextInt();
            if (num == 1) {
                System.out.println("-->1");
                System.out.println("Введите марку автомобиля");
                String name = in.nextLine();
                name = in.nextLine();
                System.out.println("Введите цвет авомобиля");
                String color = in.nextLine();
                System.out.println("Введите год выпуска автомобиля");
                int year = in.nextInt();
                workSql.addCars(name, color, year);
                workSql.viewingTableCars();
            }
            if (num == 0) {
                workSql.viewingTableCars();
            }
            if (num == 99) {
                break;
            }
            if (num == 2) {
                System.out.println("Введите цвет автомобиля");
                String color = in.nextLine();
                color = in.nextLine();
                workSql.viewForColorCars(color);
            }
            if (num ==4) {
                workSql.createTableClient();
            }
            if (num == 5) {
                workSql.statistic();
            }

        }
    }
}
