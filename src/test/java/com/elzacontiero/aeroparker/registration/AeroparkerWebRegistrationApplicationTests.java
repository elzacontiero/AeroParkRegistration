package com.elzacontiero.aeroparker.registration;

import com.elzacontiero.aeroparker.registration.entity.Customer;
import com.elzacontiero.aeroparker.registration.repo.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

@SpringBootTest
class AeroparkerWebRegistrationApplicationTests {

    @Autowired
    CustomerRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    void saveToDatabase() {
        Customer c = new Customer();
        c.setTitle("Mrs");
        c.setFirstName("Elza");
        c.setLastName("Contiero");
        c.setEmail("contieroelza@gmail.com");
        c.setAddress1("29 Marigold Way");
        c.setCity("Newark");
        c.setPostcode("NG244FQ");
        c.setPhoneNumber("987654321");
        Customer response = repo.save(c);
        Assertions.assertTrue(response.getId() > 0);
        System.out.println(response);

        repo.delete(response);
    }

}
