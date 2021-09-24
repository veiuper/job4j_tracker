package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Этот класс содержит различные методы управления классами: {@link User}, {@link Account}.
 */
public class BankService {
    /**
     * Хранит соответствия пользователей их списку аккаунтов.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя.
     *
     * @param user пользователь в формате {@link User}.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Ищет пользователя по паспортным данным.
     *
     * @param passport строка паспортных данных в формате {@link String}.
     * @return {@code null} или найденный пользователь в формате {@link User}.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Добавляет счет к пользователю по паспортным данным.
     *
     * @param passport строка паспортных данных в формате {@link String}.
     * @param account  счет в формате {@link Account}.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> list = users.get(user);
            if (!list.contains(account)) {
                list.add(account);
            }
        }
    }

    /**
     * Ищет счет по паспортным данным пользователя и реквизитам счета.
     *
     * @param passport  строка паспортных данных в формате {@link String}.
     * @param requisite реквизиты счета в формате {@link String}.
     * @return {@code null} или счет в формате {@link Account}.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (requisite.equals(account.getRequisite())) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Переводит средства со счета на счет.
     *
     * @param srcPassport   строка паспортных данных отправителя в формате {@link String}.
     * @param srcRequisite  реквизиты счета отправителя в формате {@link String}.
     * @param destPassport  строка паспортных данных получателя в формате {@link String}.
     * @param destRequisite реквизиты счета получателя в формате {@link String}.
     * @param amount        количество средств в формате {@code double}.
     * @return результат перевода: {@code true} или {@code false}.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                 double amount) {
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        if (srcAccount != null && srcAccount.getBalance() >= amount) {
            Account destAccount = findByRequisite(destPassport, destRequisite);
            if (destAccount != null) {
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                destAccount.setBalance(destAccount.getBalance() + amount);
                return true;
            }
        }
        return false;
    }
}
