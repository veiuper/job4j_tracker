package ru.job4j.bank;

import java.util.*;

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
    public Optional<User> findByPassport(String passport) {
        return users
                .keySet()
                .stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Добавляет счет к пользователю по паспортным данным.
     *
     * @param passport строка паспортных данных в формате {@link String}.
     * @param account  счет в формате {@link Account}.
     */
    public void addAccount(String passport, Account account) {
        Optional<User> optionalUser = findByPassport(passport);
        if (optionalUser.isPresent()) {
            List<Account> list = users.get(optionalUser.get());
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
    public Optional<Account> findByRequisite(String passport, String requisite) {
        var rsl = Optional.<Account>empty();
        Optional<User> optionalUser = findByPassport(passport);
        if (optionalUser.isPresent()) {
            return users
                    .get(optionalUser.get())
                    .stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst();
        }
        return rsl;
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
        Optional<Account> srcOptional = findByRequisite(srcPassport, srcRequisite);
        if (srcOptional.isPresent()
                && srcOptional.get().getBalance() >= amount) {
            Optional<Account> destOptional = findByRequisite(destPassport, destRequisite);
            if (destOptional.isPresent()) {
                srcOptional.get().setBalance(srcOptional.get().getBalance() - amount);
                destOptional.get().setBalance(destOptional.get().getBalance() + amount);
                return true;
            }
        }
        return false;
    }
}
