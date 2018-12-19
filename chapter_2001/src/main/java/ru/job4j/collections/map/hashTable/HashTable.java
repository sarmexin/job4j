package ru.job4j.collections.map.hashTable;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.Math.abs;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class HashTable<K, V> implements Iterable<Entry<K, V>> {
    private int capacity = 16;
    private Entry[] table;
    private double loadFactor = 0.3;
    private double threshold = capacity * loadFactor;
    private int index = 0;
    private int modCount = 0;

    HashTable() {
        table = new Entry[capacity];
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            private int expectedModCount = modCount;
            private int positionElement = 0;
            boolean flagHasNext = false;

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                    for (int i = positionElement; i < table.length; i++) {
                        if (table[i] != null) {
                            result = true;
                            positionElement = i;
                            break;
                        }
                    }
                return result;
            }

            @Override
            public Entry<K, V> next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[positionElement++];
            }
        };
    }

    /**
     * Метод добавления пары ключ-значение.
     *
     * @param key
     * @param value
     * @return
     */
    boolean insert(K key, V value) {
        if (threshold < index) {
            this.extension();
        }
        boolean result = false;
        if (key == null) {
            if (table[0] == null) {
                table[0] = new Entry(key, value);
                index++;
                modCount += 1;
                result = true;
            }
            modCount += 1;
        } else {
            int bucket = this.indexFor(key);
            if (table[bucket] == null) {
                index++;
                table[bucket] = new Entry(key, value);
                result = true;
                modCount += 1;
            }
        }

        return result;
    }

    /**
     * Метод получения значения по ключу.
     *
     * @param key
     * @return
     */
    V get(K key) {
        int bucket = this.indexFor(key);
        if (table[bucket] == null) {
            return null;
        }
        return (V) table[bucket].getValue();
    }

    /**
     * Метод удаления пары ключ-значение по ключу.
     *
     * @param key
     * @return
     */
    boolean delete(K key) {
        int bucket = this.indexFor(key);
        if (table[bucket] == null) {
            return false;
        }
        index--;
        table[bucket] = null;
        modCount += 1;
        return true;
    }

    /**
     * Метод расширения хэш-таблицы.
     */
    private void extension() {
        Iterator<Entry<K, V>> iterator = this.iterator();
        int capacity2 = capacity * 2;
        Entry[] table2 = new Entry[capacity2];
        int index2 = index;
        for (int i = 0; i < index2; i++) {
            Entry element = iterator.next();
            table2[this.indexFor((K) element.getKey())] = element;
        }
        table = table2;
    }

    /**
     * Метод нахождения корзины по ключу.
     *
     * @param key
     * @return
     */
    private int indexFor(K key) {
        int h = abs(HashTable.hash(key));
        int bucket = h % capacity;
        return bucket;
    }

    /**
     * Метод вычисления hash функции по ключу.
     *
     * @param key
     * @return
     */
    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
