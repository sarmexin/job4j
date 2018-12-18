package ru.job4j.collections.map.hashTable;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.collections.map.user.Calendar;
import ru.job4j.collections.map.user.User;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class HashTableTest {
    private HashTable<User, Integer> hashTable = new HashTable<>();
    private User user = new User("Nic", 4, new Calendar(17, 12, 1986));
    private User user1 = new User("Maxim", 2, new Calendar(1, 12, 1976));
    private User user2 = new User("Tom", 2, new Calendar(10, 1, 2012));
    private User user3 = new User("Maxim", 2, new Calendar(1, 12, 1976));
    private User user4 = new User("Ane", 2, new Calendar(12, 2, 1980));
    private User user5 = new User("Jane", 3, new Calendar(5, 2, 1980));

    @Before
    public void testInsert() {
        assertThat(hashTable.insert(null, 70), is(true));
        assertThat(hashTable.insert(user, 100), is(true));
        assertThat(hashTable.insert(user1, 101), is(true));
        assertThat(hashTable.insert(user2, 102), is(true));
    }

    @Test
    public void testGet() {
        assertThat(hashTable.get(user1), is(101));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIterator() {
        Iterator<Entry<User, Integer>> iterator = hashTable.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is(70));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is(100));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is(102));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is(101));
        assertThat(iterator.hasNext(), is(false));
        assertThat(hashTable.insert(user3, 103), is(false));  //коллизия
        assertThat(hashTable.insert(user4, 104), is(true));
        Iterator<Entry<User, Integer>> iterator2 = hashTable.iterator();
        assertThat(hashTable.insert(user5, 105), is(true));
        assertThat(iterator2.hasNext(), is(true));
    }
}