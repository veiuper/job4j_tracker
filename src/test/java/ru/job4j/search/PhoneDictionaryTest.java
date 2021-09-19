package ru.job4j.search;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Valeriy", "Osipov", "+7999999999", "Sredneuralsk"));
        ArrayList<Person> persons = phones.find("Valeriy");
        assertThat(persons.get(0).getSurname(), is("Osipov"));
    }

    @Test
    public void whenFindByNameEmpty() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Valeriy", "Osipov", "+7999999999", "Sredneuralsk"));
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.size(), is(0));
    }
}