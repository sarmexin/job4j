package ru.job4j.collections.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int size;
    private int mod = 0;

    Tree(E value) {
        this.root = new Node<E>(value);
    }

    public boolean isBinary() {
        boolean result = true;
        ArrayDeque<Node<E>> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(root);
        Node<E> el = arrayDeque.poll();
        while (el != null) {
            if (el.leaves() != null && el.leaves().size() <= 2) {
                for (Node<E> node : el.leaves()) {
                    arrayDeque.offer(node);
                }
            } else {
                result = false;
                break;
            }
            el = arrayDeque.poll();
        }
        return result;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        if (!this.findBy(child).isPresent()) {
            Optional<Node<E>> pr = this.findBy(parent);
            if (pr.isPresent()) {
                result = true;
                Node<E> el = pr.get();
                el.add(new Node<>(child));
                size++;
                mod++;
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
        private int expectedMod = mod;
        private int index;
        ArrayDeque<Node<E>> states = new ArrayDeque<>();
        TreeIterator() {
            states.offer(root);
        }

        @Override
        public boolean hasNext() {
            if (expectedMod != mod) {
                throw new ConcurrentModificationException();
            }
            return index < size;
        }

        @Override
        public E next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            Node<E> el = states.poll();
            if (el.leaves() != null) {
                for (Node<E> node : el.leaves()) {
                    states.offer(node);
                }
            }
            return el.getValue();
        }
    }
}
