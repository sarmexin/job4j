package ru.job4j.list.recurrence;

import ru.job4j.list.linked.DynamicLinked;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Recurrence<M> implements Iterable<Recurrence.Node> {
    private int size;
    private Node<M> first;
    private int modCount = 0;

    public Node<M> getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new RecurrenceIterator();
    }

    private class RecurrenceIterator implements Iterator<Node<M>> {
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
        public Node<M> next() {
            Node<M> result = first;
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Exception!");
            }
            for (int i = 0; i < index; i++) {
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
     * Метод получения значения по индексу
     *
     * @param index
     * @return
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
     * Метод удаления Last Input значения.
     *
     * @return
     */
    public Node<M> delete() {
        Node<M> result = this.first;
        if (first != null) {
            first = first.next;
            this.size--;
            this.modCount++;
        }
        return result;
    }

    /**
     * Метод проверяющий связный список на замыкания.
     *
     * @return
     */
    public boolean hasCycle() {
        if ( first == null ) return false;

        Node turtle = first;
        Node hare = first;

        while ( hare.next != null && hare.next.next != null ) {
            turtle = turtle.next;
            hare = hare.next.next;

            if ( turtle == hare ) return true;
        }

        return false;
    }

    /**
     * Класс предназначен для хранения данных.
     *
     * @param <E>
     */
    public static class Node<E> {
        E date;
        Node<E> next;

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getDate() {
            return date;
        }

        Node(E date) {
            this.date = date;
        }
    }
}
