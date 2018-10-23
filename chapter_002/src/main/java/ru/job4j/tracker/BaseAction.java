package ru.job4j.tracker;

public abstract class BaseAction implements UserAction {
    private int key;
    private String name;

    protected BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }
    protected BaseAction() {

    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%d : %s", this.key, this.name);
    }
}