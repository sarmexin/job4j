package ru.job4j.list.stack;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class SimpleStack<T> {
    private Node<T> first;
    private int position = 0;

    /**
     * Метод вставляет в начало списка данные.
     *
     * @param date
     */
    public void push(T date) {
        if (position == 0) {
            first = new Node<>(date);
            this.position++;
        } else {
            Node<T> newLink = new Node<>(date);
            newLink.next = this.first;
            this.first = newLink;
            this.position++;
        }
    }

    /**
     * Метод возвращает значение и удаляет его из коллекции.
     *
     * @return
     */
    public Node<T> pool() {
        Node<T> result = this.first;
        first = first.next;
        System.out.println("pool =" + first.getDate());
        return result;
    }

    public class Node<E> {
        E date;
        Node<E> next;

        public E getDate() {
            return date;
        }

        public Node(E date) {
            this.date = date;
        }
    }
}
