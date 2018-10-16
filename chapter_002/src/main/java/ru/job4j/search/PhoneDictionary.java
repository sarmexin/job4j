package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    /**
     * Добавление елемента списка телефонного справочника.
     *
     * @param person
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Поиск совпадений по ключу в телефонном справочнике.
     *
     * @param key
     * @return
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (int i = 0; i != persons.size(); i++) {
            Person element = persons.get(i);
            if (element.getName().contains(key) || element.getSurname().contains(key) || element.getAddress().contains(key) || element.getPhone().contains(key)) {
                result.add(element);
            }
        }
        return result;
    }
}
