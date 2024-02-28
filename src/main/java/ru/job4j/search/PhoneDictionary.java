package ru.job4j.search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = str -> str.getName().contains(key);
        Predicate<Person> surname = str -> str.getSurname().contains(key);
        Predicate<Person> phone = str -> str.getPhone().contains(key);
        Predicate<Person> address = str -> str.getAddress().contains(key);
        Predicate<Person> combine = name.or(surname).or(phone).or(address);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

}
