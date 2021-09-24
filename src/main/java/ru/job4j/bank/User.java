package ru.job4j.bank;

import java.util.Objects;

/**
 * Этот класс содержит методы управления пользователем.
 */
public class User {
    /**
     * Содержит паспортные данные пользователя в формате {@link String}.
     */
    private String passport;
    /**
     * Содержит имя пользователя в формате {@link String}.
     */
    private String username;

    /**
     * Создает нового пользователя.
     *
     * @param passport паспортные данные пользователя в формате {@link String}.
     * @param username имя пользователя в формате {@link String}.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает паспортные данные пользователя.
     *
     * @return паспортные данные пользователя в формате {@link String}.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает паспортные данные пользователя.
     *
     * @param passport паспортные данные пользователя в формате {@link String}.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает имя пользователя.
     *
     * @return имя пользователя в формате {@link String}.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает имя пользователя.
     *
     * @param username имя пользователя в формате {@link String}.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Возвращает результат сравнения на тождество другому пользователю по паспортным данным.
     *
     * @param o пользователь в формате {@link User}.
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хэш-код пользователя, сформированный по паспортным данным.
     *
     * @return хэш-код счета в формате {@code int}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
