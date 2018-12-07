package ru.job4j.collections.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

/**
 * Test.
 *
 * @author Sergey Gavrilov (mailto:sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class StoreTest {
    private UserStore userStore = new UserStore();
    private RoleStore roleStore = new RoleStore();

    @Before
    public void before() {
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        Role role1 = new Role("role1");
        Role role2 = new Role("role2");
        Role role3 = new Role("role3");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.add(role3);
    }

    @Test
    public void addUser() {
        assertThat(userStore.findById("user1").getId(), is("user1"));
        assertThat(userStore.findById("user2").getId(), is("user2"));
    }

    @Test
    public void addRole() {
        assertThat(roleStore.findById("role2").getId(), is("role2"));
        assertThat(roleStore.findById("role1").getId(), is("role1"));
    }

    @Test
    public void replaceUser() {
        User user4 = new User("user4");
        userStore.replace("user2", user4);
        assertThat(userStore.findById("user4").getId(), is("user4"));
    }

    @Test
    public void replaceRole() {
        Role role4 = new Role("role4");
        roleStore.replace("role2", role4);
        assertThat(roleStore.findById("role4").getId(), is("role4"));
    }

    @Test
    public void deleteUser() {
        userStore.delete("user3");
        assertThat(userStore.findById("user3"), is(nullValue()));
    }

    @Test
    public void deleteRole() {
        roleStore.delete("role3");
        assertThat(roleStore.findById("role3"), is(nullValue()));
    }
}