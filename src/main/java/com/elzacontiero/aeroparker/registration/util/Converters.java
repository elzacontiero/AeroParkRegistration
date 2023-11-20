package com.elzacontiero.aeroparker.registration.util;

import com.elzacontiero.aeroparker.registration.entity.Customer;
import com.elzacontiero.aeroparker.registration.model.RegistrationForm;

import java.time.LocalTime;

public class Converters {
    public static Customer convert(RegistrationForm form) {
        Customer customer = new Customer();
        customer.setRegistered(LocalTime.now());
        customer.setTitle(form.getInputTitle());
        customer.setFirstName(form.getInputFirstName());
        customer.setLastName(form.getInputLastName());
        customer.setEmail(form.getInputEmail());
        customer.setAddress1(form.getInputAddress1());
        customer.setAddress2(form.getInputAddress2());
        customer.setCity(form.getInputCity());
        customer.setPostcode(form.getInputPostcode());
        customer.setPhoneNumber(form.getInputPhoneNumber());
        return customer;
    }
}
