package ru.job4j.collections.tree;

import java.util.ArrayList;
import java.util.List;

public class Node <E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();  //множество детей
    private final E value;  //значение и есть ключ

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) { //добавление ребёнка
        this.children.add(child);
    }

    public List<Node<E>> leaves() {  //возвращает список детей
        return this.children;
    }

    public boolean eqValue(E that) {   //сравникает значения (да - нет)
        return this.value.compareTo(that) == 0;

    }
}
