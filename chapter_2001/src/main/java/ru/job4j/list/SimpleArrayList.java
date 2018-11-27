package ru.job4j.list;

/**
 * @param <E>
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     *
     * @param date
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Метод удаления первого элемента в списке.
     *
     * @return
     */
    public boolean delete(E date) {
        Node<E> node = this.first;
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (node.next.date.equals(date)) {
                node.next = node.next.next;
                result = true;
                size--;
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
     * Метод получения размера коллекции.
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     *
     * @param <E>
     */
    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }


}
