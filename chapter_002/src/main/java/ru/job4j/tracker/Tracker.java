package ru.job4j.tracker;

import java.util.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Генерация случайного числа.
     */
    private static final Random RN = new Random();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод редактирующий заявки в хранилище
     *
     * @param id
     * @param item
     */
    public void replace(String id, Item item) {
        for (int index = 0; index != position; index++) {
            if (this.items[index].getId().equals(id)) {
                item.setId(id);
                this.items[index] = item;
                break;
            }
        }
    }

    /**
     * Метод удаляющий заявку в хранилище
     *
     * @param id
     */
    public void delete(String id) {
        for (int index = 0; index != position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(items, (index + 1), items, index, (position - index));
                position--;
                break;
            }
        }
    }

    /**
     * Получение списка всех заявок
     *
     * @return Возвращает копию массива items без null елементов
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Получение списка по имени
     *
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        int counter = 0;
        int counter2 = 0;
        for (int index = 0; index != position; index++) {
            if (this.items[index].getName().equals(key)) {
                counter++;
            }
        }
        Item[] result = new Item[counter];
        for (int index = 0; index != position; index++) {
            if (this.items[index].getName().equals(key)) {
                result[counter2++] = items[index];
            }
        }
        return result;
    }


    /**
     * получение заявки по id
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index != position; index++) {
            if (this.items[index].getId().equals(id)) {
                result = items[index];
                break;
            }
        }
        return result;
    }
}