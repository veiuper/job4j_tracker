package ru.job4j.bank;

import java.util.Objects;

/**
 * Этот класс содержим методы управления счетом.
 */
public class Account {
    /**
     * Содержит реквизиты счета в формате {@link String}.
     */
    private String requisite;
    /**
     * Содержит баланс счета в формате {@code double}.
     */
    private double balance;

    /**
     * Создает новый счет.
     *
     * @param requisite реквизиты счета в формате {@link String}.
     * @param balance   баланс счета в формате {@code double}.
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Возвращает реквизиты счета.
     *
     * @return реквизиты счета в формате {@link String}.
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Устанавливает реквизиты счета.
     *
     * @param requisite реквизиты счета в формате {@link String}.
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Возвращает баланс счета.
     *
     * @return баланс счета в формате {@code double}.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс счета.
     *
     * @param balance баланс счета в формате {@code double}.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Возвращает результат сравнения на тождество другому счету по реквизитам.
     *
     * @param o счет в формате {@link Account}.
     * @return результат сравнения: {@code true} или {@code false}.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Возвращает хэш-код счета, сформированный по реквизитам счета.
     *
     * @return хэш-код счета в формате {@code int}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
