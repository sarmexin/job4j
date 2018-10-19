package ru.job4j.tracker;

import java.util.Objects;

/**
 * Item.
 *
 * @author Sergey Gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Item {
    private String id;
    private String name;
    private String desc;
    private long created;

    public Item() {

    }

    /**
     * Конструктор инициализирующий поля
     *
     * @param name
     * @param description
     * @param created
     */
    public Item(String name, String description, long created) {
        this.name = name;
        this.desc = description;
        this.created = created;
    }

    /**
     * Конструктор инициализирующий поля.
     *
     * @param name
     * @param description
     */
    public Item(String name, String description) {
        this.name = name;
        this.desc = description;
    }

    /**
     * Переопределение метода toString.
     *
     * @return
     */
    public String toString() {
        return "Id: " + this.getId() + " name: " + this.getName() + " desc: " + this.getDescription() + " created " + this.getCreated();
    }

    /**
     * @return возвращает Id.
     */
    public String getId() {
        return this.id;
    }

    /**
     * @return возвращает name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return возвращает desc.
     */
    public String getDescription() {
        return this.desc;
    }

    /**
     * @return возвращает created.
     */
    public long getCreated() {
        return created;
    }

    /**
     * Принимает Id.
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Принимает name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Принимает desc.
     *
     * @param desc
     */

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Принимает created.
     *
     * @param created
     */
    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
