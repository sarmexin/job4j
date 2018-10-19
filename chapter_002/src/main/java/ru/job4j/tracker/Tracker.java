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
    private final List<Item> items = new ArrayList<>();
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
        this.items.add(item);
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
            for (int index = 0; index != items.size(); index++) {
                if (items.get(index).getId().equals(id)) {
                    item.setId(id);
                    items.remove(index);
                    items.add(index, item);
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
        for (int index = 0; index != items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                items.remove(index);
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
    public List<Item> findAll() {
        return items;
    }

    /**
     * Получение списка по имени.
     *
     * @param key
     * @return массив заявок
     */
    public List<Item> findByName(String key) {
        List<Item> items2 = new ArrayList<>();
        for (Item element : items) {
            if (element.getName().equals(key)) {
                items2.add(element);
            }
        }
        return items2;
    }

    /**
     * получение заявки по id.
     *
     * @param id
     * @return заявку
     */
    public Item findById(String id) {
        Item result = null;
        for (Item element : items) {
            if (element.getId().equals(id)) {
                result = element;
            }
        }
        return result;
    }
}