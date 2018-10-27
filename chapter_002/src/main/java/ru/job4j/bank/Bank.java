package ru.job4j.bank;

import java.util.*;

/**
 * @author Sergey gavrilov (sarmexin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Bank {
    private TreeMap<User, ArrayList<Account>> treeMap = new TreeMap<>();

    public TreeMap<User, ArrayList<Account>> getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(TreeMap<User, ArrayList<Account>> treeMap) {
        this.treeMap = treeMap;
    }

    /**
     * Добавление нового клиента банка.
     *
     * @param user
     */
    public void addUser(User user) {
        treeMap.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Удаление клиента банка.
     *
     * @param user
     */
    public void deleteUser(User user) {
        if (treeMap.containsKey(user)) {
            this.treeMap.remove(user);
        }
    }

    /**
     * Добавление счёта клиенту банка по номеру паспорта.
     *
     * @param passport
     * @param account
     */
    public void addAccountToUser(String passport, Account account) {
        User user = this.searchByPassport(passport);
        if (user != null) {
            treeMap.get(user).add(account);
        }
    }

    /**
     * Удаление счёта клиента банка по номеру пасспорта.
     *
     * @param passport
     * @param account
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = this.searchByPassport(passport);
        if (user != null) {
            treeMap.get(user).remove(treeMap.get(user).indexOf(account));
        }
    }

    /**
     * Получение всех счетов клиента банка по номеру паспорта.
     *
     * @param passport
     * @return
     */
    public List<Account> getUserAccount(String passport) {
        User user = this.searchByPassport(passport);
        List<Account> list = new ArrayList<>();
        if (user != null) {
            list.addAll(treeMap.get(user));
        }
        return list;
    }

    /**
     * Перечисление денежных средств со счёта одного клиента на счёт другого клиента банка.
     *
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = true;
        User user1 = this.searchByPassport(srcPassport);
        User user2 = this.searchByPassport(destPassport);
        boolean flag1 = false, flag2 = false;
        Account srcAccount = null, destAccount = null;
        for (Account account : this.treeMap.get(user1)) {
            if (account.getRequisites().equals(srcRequisite)) {
                srcAccount = account;
                flag1 = true;
                break;
            }
        }
        for (Account account : this.treeMap.get(user2)) {
            if (account.getRequisites().equals(destRequisite)) {
                destAccount = account;
                flag2 = true;
                break;
            }
        }
        if (flag1 && flag2) {
            double srcMoney1 = Double.parseDouble(srcAccount.getValue());
            double destMoney = Double.parseDouble(destAccount.getValue());
            if (srcMoney1 > amount) {
                srcAccount.setValue(Double.toString(srcMoney1 - amount));
                destAccount.setValue(Double.toString(destMoney + amount));
            } else {
                result = false;
            }
        }
        return result;
    }

    /**
     * Поиск по номеру паспорта ключа для treeMap.
     *
     * @param passport
     * @return
     */
    private User searchByPassport(String passport) {
        User result = null;
        Set<Map.Entry<User, ArrayList<Account>>> set = treeMap.entrySet();
        for (Map.Entry<User, ArrayList<Account>> me : set) {
            if (me.getKey().getPassport().equals(passport)) {
                result = me.getKey();
            }
        }
        return result;
    }
}
