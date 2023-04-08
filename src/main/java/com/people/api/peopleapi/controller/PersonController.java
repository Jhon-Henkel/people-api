package com.people.api.peopleapi.controller;

import com.people.api.peopleapi.exception.PersonNotFoundException;
import com.people.api.peopleapi.model.Person;
import com.people.api.peopleapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> index() {
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person show(@PathVariable Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person insert(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    public Person update(@PathVariable Long id, @RequestBody Person person) throws PersonNotFoundException {
        Person personToUpdate = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        personToUpdate.setName(person.getName());
        personToUpdate.setBirthDate(person.getBirthDate());
        personToUpdate.setAddress(person.getAddress());
        return personRepository.save(personToUpdate);
    }
}