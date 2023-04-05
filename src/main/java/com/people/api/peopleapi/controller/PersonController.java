package com.people.api.peopleapi.controller;

import com.people.api.peopleapi.exception.PersonNotFoundException;
import com.people.api.peopleapi.model.Person;
import com.people.api.peopleapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonRepository peopleRepository;

    @GetMapping
    public List<Person> index() {
        return peopleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person show(@PathVariable Long id) throws PersonNotFoundException {
        return peopleRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person insert(@RequestBody Person people) {
        return peopleRepository.save(people);
    }
}