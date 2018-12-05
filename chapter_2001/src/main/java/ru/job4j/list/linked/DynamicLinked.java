package ru.job4j.list.linked;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DynamicLinked<M> implements Iterable<DynamicLinked.Node> {
    private int size;
    private Node<M> first;
    private int modCount = 0;

    @Override
    public Iterator<DynamicLinked.Node> iterator() {
        return new DynamicLinkedIterator();
    }

    private class DynamicLinkedIterator implements Iterator<DynamicLinked.Node> {
        private int expectedModCount = modCount;
        private int index = 0;

        @Override
        public boolean hasNext() {
            boolean result = false;
            Node<M> result2 = first;
            for (int i = 0; i < index; i++) {
                result2 = result2.next;
            }
            if (result2 != null) {
                result = true;
            }
            return result;
        }

        @Override
        public DynamicLinked.Node next() {
            Node<M> result = first;
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
    public void add(M date) {
        if (size == 0) {
            first = new Node<>(date);
            this.size++;
        } else {
            modCount++;
            Node<M> newLink = new Node<>(date);
            newLink.next = this.first;
            this.first = newLink;
            this.size++;
        }
    }

    /**
     * Метод получения элемента по индексу
     */
    public Node<M> get(int index) {
        Node<M> result = this.first;
        if (first != null) {
            for (int i = 0; i < index - 1; i++) {
                result = result.next;
            }
        }
        return result;
    }

    /**
     * Метод удаления первого элемента.
     * @return
     */
    public Node<M> delete() {
        Node<M> result = this.first;
        if (first != null) {
            first = first.next;
            this.size--;
            modCount++;
        }
        return result;
    }

    public Node<M> deleteFIFO() {
        Node<M> result = this.first;
        Node<M> result2 = null;
        if (first != null) {
            for (int i = 0; i < size; i++) {
                //System.out.println("In DynamicLinked :" + result.getDate());
                result2 = result;
                result = result.next;
            }
            result = result2;
            size--;
        }
        //System.out.println("***1***" + result);
        return result;
    }

    /**
     * Класс предназначен для хранения данных.
     *
     * @param <E>
     */
    public class Node<E> {
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
