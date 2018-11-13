package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Person> result = persons.stream()
                .filter(x -> x.getName().contains(key) || x.getSurname().contains(key) || x.getAddress().contains(key) || x.getPhone().contains(key))
                .collect(Collectors.toList());
        return result;
    }
}
