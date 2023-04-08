package com.people.api.peopleapi;

import com.people.api.peopleapi.controller.AddressController;
import com.people.api.peopleapi.model.Address;
import com.people.api.peopleapi.repository.AddressRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AddressControllerUnitTest {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressController addressController;

    @Test
    @SneakyThrows
    void testUpdate() {
        Address address1 = new Address();
        address1.setCity("City 1");
        address1.setMainAddress(true);
        address1.setNumber(1);
        address1.setPublicPlace("Main St 1");
        address1.setZipCode(88899900);

        Address addressInserted = addressRepository.save(address1);

        addressInserted.setCity("City 2");
        addressInserted.setMainAddress(true);
        addressInserted.setNumber(2);
        addressInserted.setPublicPlace("Main St 2");
        addressInserted.setZipCode(88899902);

        Address addressUpdated = addressController.update(addressInserted.getId(), addressInserted);

        assertEquals("City 2", addressUpdated.getCity());
        assertTrue(addressUpdated.getMainAddress());
        assertEquals(2, addressUpdated.getNumber());
        assertEquals("Main St 2", addressUpdated.getPublicPlace());
        assertEquals(88899902, addressUpdated.getZipCode());
    }
}
