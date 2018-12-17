package ru.job4j.collections.map.hashTable;

import java.util.Iterator;

import static java.lang.Math.abs;

public class HashTable<K, V> implements Iterable<Entry<K, V>> {
    private int capacity = 16;
    private Entry[] table;
    private double loadFactor = 0.3;
    private double threshold = capacity * loadFactor;
    private int index = 0;

    public HashTable() {
        table = new Entry[capacity];
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            int position = 0;
            @Override
            public boolean hasNext() {
                boolean result = false;
                if (table.length == 0) {
                    return false;
                }
                for (int i = 0; i < table.length - position; i++) {
                    if (table[position + i] != null) {
                        result = true;
                        break;
                    }
                }
                return result;

            }

            @Override
            public Entry<K, V> next() {
                Entry result = null;
                if (index < table.length) {
                    for (int i = position; i < table.length; i++) {
                        if (table[i] != null) {
                            //System.out.println("next  =" + i);
                            result = table[i];
                            position = i + 1;
                            break;
                        }
                    }

                }
                //System.out.println("next = " + table[index].getValue());
                return result;
            }
        };
    }

    boolean insert(K key, V value) {
        if (threshold < index) {
            this.extension();
        }
        boolean result = false;
        if (key == null) {
            if (table[0] == null) {
                table[0] = new Entry(key, value);
                //System.out.println("0");
                //System.out.println("не занято 0  " + value);
                index++;
                result = true;
            }
            } else {
                //System.out.println("ne 0");
                int bucket = this.indexFor(key);
                if (table[bucket] == null) {
                    //System.out.println("не занято " + bucket + "  " + value);
                    index++;
                    table[bucket] = new Entry(key, value);
                    result = true;
                }
            }

        return result;
    }

    V get(K key) {
        int bucket = this.indexFor(key);
        if (table[bucket] == null) {
            return null;
        }
        return (V) table[bucket].getValue();
    }

    boolean delete(K key) {
        int bucket = this.indexFor(key);
        if (table[bucket] == null) {
            return false;
        }
        index--;
        table[bucket] = null;
        return true;
    }

    private void extension() {
        //System.out.println(" В методе расширения");
        Iterator<Entry<K, V>> iterator = this.iterator();
        int capacity2 = capacity * 2;
        Entry[] table2 = new Entry[capacity2];
        int index2 = index;
        for (int i = 0; i < index2; i++) {
            Entry element = iterator.next();
            //System.out.println(index2 + " перекладываем " + element.getValue());
            table2[this.indexFor((K) element.getKey())] = element;
        }
        table = table2;
    }

    private int indexFor(K key) {
        int h = abs(HashTable.hash(key));
        int bucket = h % capacity;
        return bucket;
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


}
