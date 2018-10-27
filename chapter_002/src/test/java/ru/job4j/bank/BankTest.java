package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BankTest {
    /**
     * Test addUser.
     */
    @Test
    public void testAddUserAnd() {
        User user = new User("Alice", "6302 863254");
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("35000", "1001002115"));
        TreeMap<User, ArrayList<Account>> expect = new TreeMap<>();
        expect.put(user, accounts);
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addAccountToUser("6302 863254", new Account("35000", "1001002115"));
        TreeMap<User, ArrayList<Account>> result = bank.getTreeMap();
        assertThat(result, is(expect));
    }

    /**
     * Test deleteUser.
     */
    @Test
    public void testDeleteUser() {
        User user1 = new User("Alice", "6302 863254");
        User user2 = new User("Nick", "6303 898874");
        ArrayList<Account> accounts1 = new ArrayList<>();
        accounts1.add(new Account("35000", "1001002115"));
        TreeMap<User, ArrayList<Account>> expect = new TreeMap<>();
        expect.put(user2, accounts1);
        Bank bank = new Bank();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("6302 863254", new Account("10000", "1001002116"));
        bank.addAccountToUser("6303 898874", new Account("35000", "1001002115"));
        bank.deleteUser(user1);
        TreeMap<User, ArrayList<Account>> result = bank.getTreeMap();
        assertThat(result, is(expect));
    }

    /**
     * Test addAccountToUser.
     */
    @Test
    public void testAdAccountToUser() {
        User user = new User("Alice", "6302 863254");
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("35000", "1001002115"));
        accounts.add(new Account("10000", "1001002116"));
        TreeMap<User, ArrayList<Account>> expect = new TreeMap<>();
        expect.put(user, accounts);
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addAccountToUser("6302 863254", new Account("35000", "1001002115"));
        bank.addAccountToUser("6302 863254", new Account("10000", "1001002116"));
        TreeMap<User, ArrayList<Account>> result = bank.getTreeMap();
        assertThat(result, is(expect));
    }

    /**
     * Test deleteAccountFromUser.
     */
    @Test
    public void testDeleteAccountFromUser() {
        User user = new User("Alice", "6302 863254");
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("10000", "1001002116"));
        TreeMap<User, ArrayList<Account>> expect = new TreeMap<>();
        expect.put(user, accounts);
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addAccountToUser("6302 863254", new Account("35000", "1001002115"));
        bank.addAccountToUser("6302 863254", new Account("10000", "1001002116"));
        bank.deleteAccountFromUser("6302 863254", new Account("3500", "1001002115"));
        TreeMap<User, ArrayList<Account>> result = bank.getTreeMap();
        assertThat(result, is(expect));
    }

    /**
     * Test getUserAccount.
     */
    @Test
    public void testGetUserAccount() {
        User user = new User("Alice", "6302 863254");
        ArrayList<Account> expect = new ArrayList<>();
        expect.add(new Account("35000", "1001002115"));
        expect.add(new Account("10000", "1001002116"));
        Bank bank = new Bank();
        bank.addUser(user);
        bank.addAccountToUser("6302 863254", new Account("35000", "1001002115"));
        bank.addAccountToUser("6302 863254", new Account("10000", "1001002116"));
        List<Account> result = bank.getUserAccount("6302 863254");
        assertThat(result, is(expect));
    }

    /**
     * Test transferMoney.
     */
    @Test
    public void testTransferMoney() {
        User user1 = new User("Alice", "6302 863254");
        User user2 = new User("Nick", "6302 863255");
        Bank bank = new Bank();
        bank.addUser(user1);
        bank.addUser(user2);
        bank.addAccountToUser("6302 863254", new Account("35000", "1001002115"));
        bank.addAccountToUser("6302 863254", new Account("10000", "1001002116"));
        bank.addAccountToUser("6302 863255", new Account("70000", "1001002117"));
        bank.addAccountToUser("6302 863255", new Account("15000", "1001002118"));
        bank.transferMoney("6302 863254", "1001002116", "6302 863255", "1001002117", 1000.27);
        double expect1 = 8999.73, result2 = 71000.27;
        double result1 = Double.parseDouble(bank.getTreeMap().get(user1).get(1).getValue());
        double expect2 = Double.parseDouble(bank.getTreeMap().get(user2).get(0).getValue());
        assertThat(result1, is(expect1));
    }
}
