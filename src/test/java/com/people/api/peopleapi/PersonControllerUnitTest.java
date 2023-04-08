package com.people.api.peopleapi;

import com.people.api.peopleapi.controller.PersonController;
import com.people.api.peopleapi.model.Person;
import com.people.api.peopleapi.repository.PersonRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonControllerUnitTest {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonController personController;

    @Test
    void contextLoads() {
    }

    @Test
    void testIndex() {
        Person person1 = new Person();
        person1.setName("Persin 1");
        person1.setBirthDate(new Date(1995, Calendar.OCTOBER, 12));
        personRepository.save(person1);
        List<Person> list = personController.index();

        assertEquals(1, list.toArray().length);

        Person person2 = new Person();
        person2.setName("Person2");
        person2.setBirthDate(new Date(1998, Calendar.DECEMBER, 15));
        personRepository.save(person2);
        List<Person> list2 = personController.index();

        assertEquals(2, list2.toArray().length);
    }

    @Test
    @SneakyThrows
    void testShow() {
        Person person3 = new Person();
        person3.setName("Person3");
        person3.setBirthDate(new Date(1999, Calendar.JANUARY, 10));
        Person personInsert = personRepository.save(person3);
        Person personInserted = personController.show(personInsert.getId());

        assertEquals(personInsert.getId(), personInserted.getId());
        assertEquals("Person3", personInserted.getName());
        assertEquals(new Date(1999, Calendar.JANUARY, 10), personInserted.getBirthDate());
    }

    @Test
    @SneakyThrows
    void testInsert() {
        Person person4 = new Person();
        person4.setName("Person4");
        person4.setBirthDate(new Date(2002, Calendar.MARCH, 30));
        Person personInserted = personController.insert(person4);

        assertEquals("Person4", personInserted.getName());
        assertEquals(new Date(2002, Calendar.MARCH, 30), personInserted.getBirthDate());
    }

    @Test
    @SneakyThrows
    void testUpdate() {
        Person person5 = new Person();
        person5.setName("Person5");
        person5.setBirthDate(new Date(1985, Calendar.NOVEMBER, 21));
        Person personInserted = personController.insert(person5);

        assertEquals("Person5", personInserted.getName());
        assertEquals(new Date(1985, Calendar.NOVEMBER, 21), personInserted.getBirthDate());
    }
}
