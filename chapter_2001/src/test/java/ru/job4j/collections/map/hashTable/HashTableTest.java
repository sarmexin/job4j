package ru.job4j.collections.map.hashTable;

import org.junit.Test;
import ru.job4j.collections.map.user.Calendar;
import ru.job4j.collections.map.user.User;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class HashTableTest {
    //private HashTable hashTable = new HashTable(new User("Maxim", 2, new Calendar(1, 12, 1976)), "First");
    private HashTable<User, Integer> hashTable = new HashTable<>();
    private User user = new User("Nic", 4, new Calendar(17, 12, 1986));
    private User user1 = new User("Maxim", 2, new Calendar(1, 12, 1976));
    private User user2 = new User("Tom", 2, new Calendar(10, 1, 2012));
    private User user3 = new User("Maxim", 2, new Calendar(1, 12, 1976));
    private User user4 = new User("Ane", 2, new Calendar(12, 2, 1980));
    private User user5 = new User("Jane", 3, new Calendar(5, 2, 1980));
    private User user6 = new User("Alice", 7, new Calendar(5, 2, 1980));
    private User user7 = new User("Mary", 5, new Calendar(5, 2, 1980));
    private User user8 = new User("Jackson", 0, new Calendar(5, 2, 1980));
    private User user9 = new User("Marine", 0, new Calendar(5, 2, 1980));
    private User user10 = new User("Ivan", 6, new Calendar(5, 2, 1980));





    @Test
    public void test() {
        assertThat(hashTable.insert(null, 70), is(true));
        assertThat(hashTable.insert(user,100), is(true));
        assertThat(hashTable.insert(user1,101), is(true));
        assertThat(hashTable.insert(user2,102), is(true));
//        assertThat(hashTable.hasNext(), is(true));
//        assertThat(hashTable.next().getValue(), is(70));
//        assertThat(hashTable.hasNext(), is(true));
//        assertThat(hashTable.next().getValue(), is(100));
//        assertThat(hashTable.hasNext(), is(true));
//        assertThat(hashTable.next().getValue(), is(102));
//        assertThat(hashTable.hasNext(), is(true));
//        assertThat(hashTable.next().getValue(), is(101));
//        assertThat(hashTable.hasNext(), is(false));



        assertThat(hashTable.insert(user3,103), is(false)); // КЛАДУ ТАКОЙ ЖЕ КАК И USER1
        assertThat(hashTable.delete(user), is(true));
        assertThat(hashTable.delete(user4), is (false));
        assertThat(hashTable.insert(user5,105), is(true));
        assertThat(hashTable.insert(user6,106), is(true));
        assertThat(hashTable.insert(user7,107), is(true));
 //       assertThat(hashTable.insert(user8,108), is(true));
//        assertThat(hashTable.insert(user9,109), is(true));
//        assertThat(hashTable.insert(user10,110), is(true));


//        assertThat(hashTable.getKeys()[0], is(user));
//        assertThat(hashTable.getKeys()[1], is(user1));
//        assertThat(hashTable.getKeys()[2], is(user2));
//        assertThat(hashTable.getKeys()[3], is(nullValue()));       //user3 не сумел положится
//        assertThat(hashTable.get(user), is(158580));
//        assertThat(hashTable.get(user1), is(10));
//        assertThat(hashTable.get(user2), is(155));
//        assertThat(hashTable.get(user4), is(nullValue()));
//        assertThat(hashTable.insert(user5,1005), is(true));
//        assertThat(hashTable.insert(user6,1006), is(true));
//        assertThat(hashTable.insert(user7,1007), is(true));
//        assertThat(hashTable.insert(user8,1008), is(false));
//        assertThat(hashTable.hasNext(), is (true));
//        assertThat(hashTable.next(), is (158580));
//        assertThat(hashTable.hasNext(), is (true));
//        assertThat(hashTable.next(), is (1007));
//        assertThat(hashTable.hasNext(), is (true));
//        assertThat(hashTable.next(), is (1006));

    }
}