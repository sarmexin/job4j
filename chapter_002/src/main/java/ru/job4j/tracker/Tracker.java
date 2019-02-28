package ru.job4j.tracker;

import ru.job4j.bank.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Tracker.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Tracker implements ITracker {
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
        System.out.println("in old tracker");
        boolean result = false;
        if (this.findById(id) != null) {
            result = items.stream()
                    .filter(x -> x.getId().equals(id))
                    .map(x -> items.set(items.indexOf(x), item))
                    .anyMatch(x -> x.getId().equals(id));
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
        Optional<Item> optional = items.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
        if (optional.isPresent()) {
            result = true;
            items.remove(optional.get());
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
        return items.stream()
                .filter(x -> x.getName().equals(key))
                .collect(Collectors.toList());
    }

    /**
     * получение заявки по id.
     *
     * @param id
     * @return заявку
     */
    public Item findById(String id) {
        Item result = null;
        Optional<Item> optional = items.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst();
        return optional.isPresent() ? optional.get() : null;
    }
}