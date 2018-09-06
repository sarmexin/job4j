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
    private Item[] itemsAll;
    private Item[] itemsName;
    private Item itemId = new Item();



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
        for (int index = 0; index != this.items.length; index++) {
            if (this.items[index].getId().equals(id)) {
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
        for (int index = 0; index != this.items.length; index++) {
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
     * @return
     */
    public Item[] findAll() {
         System.arraycopy(this.items, 0, itemsAll, 0, position);
        return itemsAll;

    }

    /**
     * Получение списка по имени
     *
     * @param key
     * @return
     */
    public Item[] findByName(String key) {
        int index2 = 0;
        for (int index = 0; index !=items.length; index++) {
            if (this.items[index].getName().equals(key)) {
                itemsName[index2++] = this.items[index];
                if (this.items[index] == null) {
                    break;
                }
            }
        }
        return itemsName;
    }

    /**
     * получение заявки по id
     *
     * @param id
     * @return
     */
    public Item findById(String id) {
        for (int index = 0; index != items.length; index++) {
            if (this.items[index].getId().equals(id)) {
                itemId = items[index];
            } else {
                itemId =  null;
            }
            break;
        }
        return itemId;
    }
}