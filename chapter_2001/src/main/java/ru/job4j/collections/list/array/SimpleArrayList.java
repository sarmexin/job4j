package ru.job4j.collections.list.array;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @param <E>
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayList<E> implements Iterable<SimpleArrayList.Node> {
    private int position;
    private Node<E> first;
    private int modCount = 0;
    private int size;

    public SimpleArrayList(int size) {
        this.size = size;
    }

    @Override
    public Iterator<Node> iterator() {
        return new SimpleArrayListTest();
    }

    private class SimpleArrayListTest implements Iterator<Node> {
        private int expectedModCount = modCount;
        private int index = 0;

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
        public Node next() {
            Node<E> result = first;
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Контейнер изменён");
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
        if (position == size) {
            throw new IndexOutOfBoundsException("Контейнер заполнен полностью");
        }
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.position++;
        modCount++;
    }

    /**
     * Метод удаления первого элемента в списке.
     *
     * @return
     */
    public boolean delete(E date) {
        Node<E> node = this.first;
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (node.next.date.equals(date)) {
                node.next = node.next.next;
                result = true;
                position--;
                break;
            }
        }
        return result;
    }

    /**
     * Метод получения элемента по индексу
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
     * Метод получения размера заполненной коллекции.
     *
     * @return
     */
    public int getSize() {
        return this.position;
    }

    /**
     *
     * @param index
     * @param model
     */
    public void set(int index, E model) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Выход за границы контейнера");
        }
        Node<E> node = this.first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.date = model;
    }

    /**
     * Класс предназначен для хранения данных.
     *
     * @param <E>
     */
    public static class Node<E> {
        E date;
        Node<E> next;
        Node(E date) {
            this.date = date;
        }
    }
}
