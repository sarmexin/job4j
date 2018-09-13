package ru.job4j.tracker;

import java.util.*;

/**
 * Tracker.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
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
     * Метод реализаущий добавление заявки в хранилище.
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
     * Метод редактирующий заявки в хранилище.
     *
     * @param id
     * @param item
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        if (this.findById(id) != null) {
            for (int index = 0; index != position; index++) {
                if (this.items[index].getId().equals(id)) {
                    item.setId(id);
                    this.items[index] = item;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Метод удаляющий заявку в хранилище.
     *
     * @param id
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != position; index++) {
            if (this.items[index].getId().equals(id)) {
                System.arraycopy(items, (index + 1), items, index, (position - index));
                position--;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получение списка всех заявок.
     *
     * @return Возвращает копию массива items без null елементов.
     */
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * Получение списка по имени.
     *
     * @param key
     * @return массив заявок
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int j = 0;
        for (int i = 0; i < this.position; i++) {
            if (this.items[i].getName().equals(key)) {
                result[j++] = items[i];
            }
        }
        return Arrays.copyOf(result, j);
    }


    /**
     * получение заявки по id.
     *
     * @param id
     * @return заявку
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