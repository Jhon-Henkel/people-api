package com.people.api.peopleapi.controller;

import com.people.api.peopleapi.exception.AddressNotFoundException;
import com.people.api.peopleapi.exception.PersonNotFoundException;
import com.people.api.peopleapi.model.Address;
import com.people.api.peopleapi.model.Person;
import com.people.api.peopleapi.repository.AddressRepository;
import com.people.api.peopleapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PersonRepository personRepository;

    @PutMapping("/{id}")
    public Address update(@PathVariable Long id, @RequestBody Address address) throws AddressNotFoundException {
        Address addressToUpdate = addressRepository.findById(id).orElseThrow(() -> new AddressNotFoundException(id));
        addressToUpdate.setNumber(address.getNumber());
        addressToUpdate.setCity(address.getCity());
        addressToUpdate.setZipCode(address.getZipCode());
        addressToUpdate.setPublicPlace(address.getPublicPlace());
        addressToUpdate.setMainAddress(address.getMainAddress());
        return addressRepository.save(addressToUpdate);
    }

    @GetMapping("/person/{personId}")
    public List<Address> showAddressForPerson(@PathVariable Long personId) throws PersonNotFoundException {
        Person person = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException(personId));
        return person.getAddress();
    }

    @PostMapping("/person/{personId}")
    public List<Address> insertAddressForPerson(@PathVariable Long personId, @RequestBody Address address) throws PersonNotFoundException {
        Person person = personRepository.findById(personId).orElseThrow(() -> new PersonNotFoundException(personId));
        List<Address> addressToUpdate = person.getAddress();
        addressToUpdate.add(address);
        person.setAddress(addressToUpdate);
        personRepository.save(person);
        return addressToUpdate;
    }
}