package ru.job4j.collections.map.hashTable;

import java.util.Iterator;

import static java.lang.Math.abs;

public class HashTable<K, V> implements Iterator<K> {
    private int capacity;
    private Object[] table;
    private Object[] keys;
    private int index = 0;
    private int number = 0;

    public Object[] getTable() {
        return table;
    }

    public Object[] getKeys() {
        return keys;
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new Object[capacity];
        keys = new Object[capacity];
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        if (table.length == 0) {
            return false;
        }
        for (int i = 0; i < table.length - index; i++) {
            if (table[index + i] != null) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public K next() {
        K result = null;
        if (index < table.length) {
            if (table[index] == null) {
                for (int i = index + 1; i < table.length; i++) {
                    if (table[i] != null) {
                        result = (K) table[i];
                        index = i;
                        break;
                    }
                }
            } else {
                result = (K) table[index++];
            }
        }
        //System.out.println("next = " + result);
        return result;
    }

    boolean insert(K key, V value) {
        int bucket = this.findBucket(key);
        ;
        if (table[bucket] != null) {
            //System.out.println("повтор");
            return false;
        }
        if (number > capacity * 0.2) {
            this.extension();
        }
        keys[number] = key;
        //System.out.println("keys" + "[" + number + "] = " +  keys[number]);
        table[bucket] = value;
        //System.out.println("table" + "[" + bucket + "] = " +  table[bucket]);
        //System.out.println("number;" + number);
        number++;
        //System.out.println("number++;" + number);
        //System.out.println("--------------------------------");
        //System.out.println("Value in " + bucket + " = " + table[bucket]);
        return true;
    }

    private void extension() {
        //System.out.println(" В методе расширения");
        int capacity2 = capacity * 2;
        Object[] table2 = new Object[capacity2];
        for (int i = 0; i < number; i++) {
            //System.out.println("i " + i);
            int bucket = this.findBucket((K) keys[i]);
            //System.out.println(keys[i]);
            V value = this.get((K) keys[i]);
            table2[bucket] = value;
        }
        //System.out.println("Расширился table");
        table = table2;
        for (int i = 0; i < 20; i++) {
            //System.out.println(this.next());
        }
    }

    V get(K key) {
        int bucket = this.findBucket(key);
        //System.out.println(bucket);
        if (table[bucket] == null) {
            return null;
        }
        return (V) table[bucket];
    }

    boolean delete(K key) {
        int bucket = this.findBucket(key);
        if (table[bucket] == null) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (keys[i].equals(key)) {
                keys[i] = null;
                break;
            }
        }
        number--;

        table[bucket] = null;
        return true;
    }

    private int findBucket(K key) {
        int h = abs(HashTable.hash(key));
        int bucket = h % capacity;
        return bucket;
    }

    static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

}
