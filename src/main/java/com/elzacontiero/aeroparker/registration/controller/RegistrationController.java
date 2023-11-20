package com.elzacontiero.aeroparker.registration.controller;

import com.elzacontiero.aeroparker.registration.entity.Customer;
import com.elzacontiero.aeroparker.registration.repo.CustomerRepository;
import com.elzacontiero.aeroparker.registration.util.Converters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.elzacontiero.aeroparker.registration.model.RegistrationForm;

import java.sql.SQLIntegrityConstraintViolationException;

@Controller
public class RegistrationController {

    @Autowired
    CustomerRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        model.addAttribute("showMessage", false);
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationAnswer(@ModelAttribute RegistrationForm registration, Model model) {
        logger.info("Form received: " + registration);

        // Check the email already exist or not.
        String email = registration.getInputEmail().toLowerCase();
        Customer customer = repository.findCustomerByEmail(email);
        String message;
        boolean error = false;

        if (customer != null) {
            message = "Email already registered.";
            error = true;
        }
        else if (email.isEmpty()) {
            message = "Email cannot be empty.";
            error = true;
        }
        else if (email.length() > 255) {
            message = "Email field too long. It must be up to 255 characters.";
            error = true;
        }
        else if (registration.getInputTitle().length() > 5) {
            message = "Title too long. It must be up to five characters.";
            error = true;
        }
        else if (registration.getInputFirstName().length() > 50) {
            message = "First Name field too long. It must be up to 50 characters.";
            error = true;
        }
        else if (registration.getInputFirstName().isEmpty()) {
            message = "First Name field cannot be empty.";
            error = true;
        }
        else if (registration.getInputLastName().length() > 50) {
            message = "Last Name field too long. It must be up to 50 characters.";
            error = true;
        }
        else if (registration.getInputLastName().isEmpty()) {
            message = "Last Name field cannot be empty.";
            error = true;
        }
        else if (registration.getInputAddress1().isEmpty()) {
            message = "Address 1 cannot be empty.";
            error = true;
        }
        else if (registration.getInputAddress1().length() > 255) {
            message = "Address 1 field too long. It must be up to 255 characters.";
            error = true;
        }
        else if (registration.getInputAddress2().length() > 255) {
            message = "Address 2 field too long. It must be up to 255 characters.";
            error = true;
        }
        else if (registration.getInputPostcode().isEmpty()) {
            message = "Postcode cannot be empty.";
            error = true;
        }
        else if (registration.getInputPostcode().length() > 10) {
            message = "Postcode field too long. It must be up to 10 characters.";
            error = true;
        }
        else if (registration.getInputPhoneNumber().length() > 20) {
            message = "Phone number field too long. It must be up to 20 characters.";
            error = true;
        }
        else {
            customer = Converters.convert(registration);
            customer = repository.save(customer);
            message = "Registration success. Customer ID=" + customer.getId();
        }

        logger.debug("Registration message: " + message);
        model.addAttribute("showError", error);
        model.addAttribute("message", message);

        return "registration";
    }

}

