package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class User implements Comparable<User> {
    private String name;
    private String passport;
    private List<Account> accounts = new ArrayList<>();

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public int compareTo(User user) {
        return passport.compareTo(user.getPassport());
    }

    @Override
    public String toString() {
        return "name='" + name + '\''
                + '}';
    }
}
