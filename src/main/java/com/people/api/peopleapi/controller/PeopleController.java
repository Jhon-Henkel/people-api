package com.people.api.peopleapi.controller;

import com.people.api.peopleapi.model.People;
import com.people.api.peopleapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;

    @GetMapping
    public List<People> index() {
        return peopleRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public People insert(@RequestBody People people) {
        return peopleRepository.save(people);
    }
}