package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = Person -> Person.getName().contains(key);
        Predicate<Person> predicateSurname = Person -> Person.getSurname().contains(key);
        Predicate<Person> predicatePhone = Person -> Person.getPhone().contains(key);
        Predicate<Person> predicateAddress = Person -> Person.getAddress().contains(key);
        Predicate<Person> combine = predicateName.or(predicateSurname).or(predicatePhone).or(predicateAddress);
        ArrayList<Person> rsl = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                rsl.add(person);
            }
        }
        return rsl;
    }
}
