package ru.job4j.collections.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    Tree(Integer value) {
        this.root = new Node<E>((E) value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (!this.findBy(child).isPresent()) {
            if (this.findBy(parent).isPresent()) {
                result = true;
                Node<E> el = this.findBy(parent).get();
                el.add(new Node<>(child));
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator();
    }

    public class TreeIterator implements Iterator<E> {

        @Override
        public boolean hasNext() {
            Node<E> parent1;
            Node<E> child1;


            return false;
        }

        @Override
        public E next() {
            return null;
        }
    }
//    private boolean bypass(E child) {
//        boolean result = false;
//        Iterator<E> iterator = this.iterator();
//        boolean flag = true;
//        while (flag)
//        if (iterator.hasNext()) {
//            if (iterator.next().equals(child)) {
//                flag = false;
//                result = true;
//            }
//        }
//        return result;
//    }
}
