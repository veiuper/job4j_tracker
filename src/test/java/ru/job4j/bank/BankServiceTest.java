package ru.job4j.bank;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BankServiceTest {

    @Test
    public void whenFindByPassportNoUsersNotFinds() {
        BankService bank = new BankService();
        Assert.assertNull(bank.findByPassport("0123 456789"));
    }

    @Test
    public void whenFindByPassportTwoUsersNotFinds() {
        BankService bank = new BankService();
        bank.addUser(new User("0123 456789", "username 1"));
        bank.addUser(new User("1234 567890", "username 2"));
        Assert.assertNull(bank.findByPassport("2345 678901"));
    }

    @Test
    public void whenFindByPassportTwoUsersFinds() {
        String passport = "0123 456789";
        BankService bank = new BankService();
        User expected = new User("0123 456789", "username 1");
        bank.addUser(expected);
        bank.addUser(new User("1234 567890", "username 2"));
        User actual = bank.findByPassport(passport);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void whenAddUserNoUsers() {
        String passport = "0123 456789";
        BankService bank = new BankService();
        User user = new User(passport, "username 1");
        bank.addUser(user);
        assertThat(bank.findByPassport(passport), is(user));
    }

    @Test
    public void whenAddUserTwoUsers() {
        String passport = "1234 567890";
        BankService bank = new BankService();
        bank.addUser(new User("0123 456789", "username 1"));
        bank.addUser(new User("1234 567890", "username 2"));
        User user = new User(passport, "username 3");
        bank.addUser(user);
        assertThat(bank.findByPassport(passport), is(user));
    }

    @Test
    public void whenAddUserTwoUsersNotAdd() {
        String passport = "0123 456789";
        BankService bank = new BankService();
        bank.addUser(new User(passport, "username 1"));
        bank.addUser(new User("1234 567890", "username 2"));
        User user = new User(passport, "username 3");
        bank.addUser(user);
        assertThat(bank.findByPassport(passport), is(user));
    }

    @Test
    public void whenAddAccountNoUserNotAdd() {
        BankService bank = new BankService();
        String passport = "0123 456789";
        String requisite = "account 1";
        bank.addAccount(passport, new Account(requisite, 0));
        assertNull(bank.findByRequisite(passport, requisite));
    }

    @Test
    public void whenAddAccountTwoUsersNotAdd() {
        String passport = "2345 678901";
        String requisite = "account 1";
        BankService bank = new BankService();
        bank.addUser(new User("0123 456789", "username 1"));
        bank.addUser(new User("1234 567890", "username 2"));
        bank.addAccount(passport, new Account(requisite, 0));
        assertNull(bank.findByRequisite(passport, requisite));
    }

    @Test
    public void whenAddAccount() {
        String passport = "0123 456789";
        String requisite = "account 1";
        BankService bank = new BankService();
        bank.addUser(new User(passport, "username 1"));
        Account account = new Account(requisite, 0);
        bank.addAccount(passport, account);
        assertThat(bank.findByRequisite(passport, requisite), is(account));
    }

    @Test
    public void whenFindByRequisiteNoUsersNotFindsUser() {
        BankService bank = new BankService();
        Assert.assertNull(bank.findByRequisite("0123 456789", "account 1"));
    }

    @Test
    public void whenFindByRequisiteTwoUsersNotFindsUser() {
        BankService bank = new BankService();
        bank.addUser(new User("0123 456789", "username 1"));
        bank.addUser(new User("1234 567890", "username 2"));
        Assert.assertNull(bank.findByRequisite("2345 678901", "account 1"));
    }

    @Test
    public void whenFindByRequisiteTwoUsersNotFindsAccount() {
        String passport = "0123 456789";
        String requisite = "account 1";
        BankService bank = new BankService();
        bank.addUser(new User(passport, "username 1"));
        bank.addUser(new User("1234 567890", "username 2"));
        Assert.assertNull(bank.findByRequisite(passport, "account 1"));
    }

    @Test
    public void whenFindByRequisiteTwoUsersFindsAccount() {
        String passport = "0123 456789";
        String requisite = "account 1";
        BankService bank = new BankService();
        bank.addUser(new User(passport, "username 1"));
        bank.addUser(new User("1234 567890", "username 2"));
        Account expected = new Account(requisite, 0);
        bank.addAccount(passport, expected);
        Assert.assertEquals(expected, bank.findByRequisite(passport, requisite));
    }

    @Test
    public void whenTransferMoneySrcAccountNotFind() {
        BankService bank = new BankService();
        boolean actual = bank.transferMoney("0123 456789", "account 1",
                "1234 567890", "account 2",
                1);
        assertFalse(actual);
    }

    @Test
    public void whenTransferMoneyDestAccountNotFind() {
        BankService bank = new BankService();
        String passport = "0123 456789";
        String requisite = "account 1";
        bank.addUser(new User(passport, "username 1"));
        bank.addAccount(passport, new Account(requisite, 0));
        boolean actual = bank.transferMoney(passport, requisite,
                "1234 567890", "account 2",
                1);
        assertFalse(actual);
    }

    @Test
    public void whenTransferMoneySrcBalanceLow() {
        BankService bank = new BankService();
        String passport1 = "0123 456789";
        String requisite1 = "account 1";
        String passport2 = "123 4567890";
        String requisite2 = "account 2";
        bank.addUser(new User(passport1, "username 1"));
        bank.addAccount(passport1, new Account(requisite1, 0));
        bank.addUser(new User(passport2, "username 2"));
        bank.addAccount(passport2, new Account(requisite2, 0));
        boolean actual = bank.transferMoney(passport1, requisite1, passport2, requisite2, 0.01);
        assertFalse(actual);
    }

    @Test
    public void whenTransferMoney() {
        BankService bank = new BankService();
        String passport1 = "0123 456789";
        String requisite1 = "account 1";
        String passport2 = "123 4567890";
        String requisite2 = "account 2";
        bank.addUser(new User(passport1, "username 1"));
        bank.addAccount(passport1, new Account(requisite1, 0.01));
        bank.addUser(new User(passport2, "username 2"));
        bank.addAccount(passport2, new Account(requisite2, 0));
        boolean actual = bank.transferMoney(passport1, requisite1, passport2, requisite2, 0.01);
        assertTrue(actual);
    }
}