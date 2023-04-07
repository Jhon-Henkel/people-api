package com.people.api.peopleapi.exception;

public class AddressNotFoundException  extends Exception {
    public AddressNotFoundException(Long id) {
        super("Address not found with ID " + id);
    }
}