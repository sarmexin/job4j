package ru.job4j.list.linked;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicLinked<E> implements Iterable {
    private int size;
    private Node<E> first = null;
    private int modCount = 0;
    private int index = 0;


    @Override
    public Iterator iterator() {
        return new DynamicLinkedIterator();
    }

    public class DynamicLinkedIterator implements Iterator<Node<E>> {
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            boolean result = false;
            Node<E> result2 = first;
            for (int i = 0; i < index; i++) {
                result2 = result2.next;
            }
            if (result2 != null) {
                result = true;
            }
            return result;
        }

        @Override
        public Node<E> next() {
            Node<E> result = first;
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Exception!");
            }
            for (int i = 0; i == index; i++) {
                result = result.next;
            }
            index++;
            return result;
        }
    }

    /**
     * Метод вставляет в начало списка данные.
     *
     * @param date
     */
    public void add(E date) {
        modCount++;
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Метод получения элемента по индексу
     */
    public Node<E> get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    /**
     * Класс предназначен для хранения данных.
     *
     * @param <E>
     */
    public static class Node<E> {
        E date;
        Node<E> next;

        public E getDate() {
            return date;
        }

        Node(E date) {
            this.date = date;
        }
    }
}
