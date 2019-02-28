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
    private String created;

    public Item() {

    }


    /**
     * Конструктор инициализирующий поля
     *
     * @param name
     * @param description
     * @param created
     */
    public Item(String name, String description, String created) {
        this.name = name;
        this.desc = description;
        this.created = created;
    }


//    public Item(String id,String name, String description, String created) {
//        this.name = name;
//        this.desc = description;
//        this.created = created;
//    }

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

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.desc;
    }

    public String getCreated() {
        return created;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
