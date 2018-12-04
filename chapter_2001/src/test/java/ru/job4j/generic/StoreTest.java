package ru.job4j.generic;

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
    @Test
    public void addUser() {
        UserStore userStore = new UserStore();
        User user1 = new User("user1");
        userStore.add(user1);
        assertThat(userStore.findById("0").getId(), is("user1"));
    }

    @Test
    public void addRole() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("role1");
        roleStore.add(role1);
        assertThat(roleStore.findById("0").getId(), is("role1"));
    }

    @Test
    public void replaceUser() {
        UserStore userStore = new UserStore();
        User user1 = new User("user1");
        User user2 = new User("user2");
        userStore.add(user1);
        userStore.replace("0", user2);
        assertThat(userStore.findById("0").getId(), is("user2"));
    }

    @Test
    public void replaceRole() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("user1");
        Role role2 = new Role("user2");
        roleStore.add(role1);
        roleStore.replace("0", role2);
        assertThat(roleStore.findById("0").getId(), is("user2"));
    }

    @Test
    public void deleteUser() {
        UserStore userStore = new UserStore();
        User user1 = new User("user1");
        User user2 = new User("user2");
        userStore.add(user1);
        userStore.add(user2);
        userStore.delete("0");
        assertThat(userStore.findById("0").getId(), is("user1"));
    }

    @Test
    public void deleteRole() {
        RoleStore roleStore = new RoleStore();
        Role role1 = new Role("role1");
        Role role2 = new Role("role2");
        roleStore.add(role1);
        roleStore.add(role2);
        roleStore.delete("0");
        assertThat(roleStore.findById("0").getId(), is("role1"));
    }

    @Test
    public void findById() {
        UserStore userStore = new UserStore();
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        userStore.add(user1);
        userStore.add(user2);
        userStore.add(user3);
        assertThat(userStore.findById("1").getId(), is("user2"));
    }
}