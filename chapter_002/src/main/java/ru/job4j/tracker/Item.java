package ru.job4j.tracker;

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
}
