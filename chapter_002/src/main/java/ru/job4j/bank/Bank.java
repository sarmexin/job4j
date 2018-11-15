package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

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
     * Добавление счёта клиенту банка по номеру  номеру паспорта.
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
     * @return List<Account>
     */
    public List<Account> getUserAccount(String passport) {
        User user = this.searchByPassport(passport);
        List<Account> list = new ArrayList<>();
        return treeMap.get(user).stream()
                .collect(Collectors.toList());
    }

    /**
     * Перечисление денежных средств со счёта одного клиента банка на счёт другого клиента банка.
     *
     * @param srcPassport
     * @param srcRequisite
     * @param destPassport
     * @param destRequisite
     * @param amount
     * @return boolean
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean result = true;
        Account srcAccount = this.searchByPassportAndRequisites(srcPassport, srcRequisite);
        Account destAccount = this.searchByPassportAndRequisites(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
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
     * Поиск по номеру паспорта и номеру счёта клиента банка.
     *
     * @param passport
     * @param requisites
     * @return account
     */
    private Account searchByPassportAndRequisites(String passport, String requisites) {
        User user = this.searchByPassport(passport);
        Account result = null;
        Optional<Account> optional = treeMap.get(user).stream()
                .filter(x -> x.getRequisites().equals(requisites))
                .findFirst();
        return optional.get();
    }

    /**
     * Поиск по номеру паспорта  - ключа для treeMap.
     *
     * @param passport
     * @return user
     */
    private User searchByPassport(String passport) {
        User result = null;
        Set<Map.Entry<User, ArrayList<Account>>> set = treeMap.entrySet();
        Optional<Map.Entry<User, ArrayList<Account>>> optional = set.stream()
                .filter(x -> x.getKey().getPassport().equals(passport))
                .findFirst();
        return optional.get().getKey();
    }
}
