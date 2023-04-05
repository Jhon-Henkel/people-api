package com.people.api.peopleapi.controller;

import com.people.api.peopleapi.model.Address;
import com.people.api.peopleapi.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> index() {
        return addressRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Address insert(@RequestBody Address address) {
            return addressRepository.save(address);
        }
}
