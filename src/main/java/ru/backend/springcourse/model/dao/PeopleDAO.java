package ru.backend.springcourse.model.dao;

import org.springframework.stereotype.Component;
import ru.backend.springcourse.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private List<Person> personList = new ArrayList<Person>();
    public static int COUNTER_ID = 0;

    {
        personList.add(new Person(COUNTER_ID, "Vadim", "Tarakanov"));
        personList.add(new Person(COUNTER_ID++, "Anton", "Svinov"));
        personList.add(new Person(COUNTER_ID++, "Semen", "Sobaken"));
        personList.add(new Person(COUNTER_ID++, "Kama", "Pulya"));
        personList.add(new Person(COUNTER_ID++, "Gena", "Alga"));
    }

    public List<Person> getAllPeople() {
        return personList;
    }

    public Person getPersonById(final int index) {
        return personList.stream().filter(person -> person.getId() == index).findAny().orElse(null);
    }

    public void addPerson(Person person) {
        person.setId(COUNTER_ID++);
        personList.add(person);
    }

    public void updatePerson(Person person, int id) {
        Person personShouldBeUpdated = getPersonById(id);
        personShouldBeUpdated.setName(person.getName());
    }
}
