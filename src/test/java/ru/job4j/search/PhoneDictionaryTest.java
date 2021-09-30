package ru.job4j.search;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Valeriy", "Osipov", "+7999999999", "Sredneuralsk"));
        var persons = phones.find("Valeriy");
        assertThat(persons.get(0).getSurname(), is("Osipov"));
    }

    @Test
    public void whenFindByNameEmpty() {
        var phones = new PhoneDictionary();
        phones.add(new Person("Valeriy", "Osipov", "+7999999999", "Sredneuralsk"));
        var persons = phones.find("Petr");
        assertThat(persons.size(), is(0));
    }
}