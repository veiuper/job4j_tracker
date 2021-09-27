package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine =
                ((Predicate<Person>) Person -> Person.getName().contains(key))
                        .or(Person -> Person.getSurname().contains(key))
                        .or(Person -> Person.getPhone().contains(key))
                        .or(Person -> Person.getAddress().contains(key));
        ArrayList<Person> rsl = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                rsl.add(person);
            }
        }
        return rsl;
    }
}
