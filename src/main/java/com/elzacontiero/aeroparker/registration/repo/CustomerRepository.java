package com.elzacontiero.aeroparker.registration.repo;

import com.elzacontiero.aeroparker.registration.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // You can add custom queries or methods here if needed
    Customer findCustomerByEmail(String email);
}
