package com.elzacontiero.aeroparker.registration.controller;

import com.elzacontiero.aeroparker.registration.entity.Customer;
import com.elzacontiero.aeroparker.registration.repo.CustomerRepository;
import com.elzacontiero.aeroparker.registration.util.Converters;
import com.elzacontiero.aeroparker.registration.util.ValidationResult;
import com.elzacontiero.aeroparker.registration.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import com.elzacontiero.aeroparker.registration.model.RegistrationForm;

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

        ValidationResult validation = Validator.validateForm(registration);

        if (validation.success) {
            // If passed all validations, check if email was already used in the Database.
            String email = registration.getInputEmail().toLowerCase();
            Customer customer = repository.findCustomerByEmail(email);
            if (customer != null) {
                validation.message = "Email already registered.";
                validation.success = false;
            } else {
                customer = Converters.convert(registration);
                customer = repository.save(customer);
                validation.message = "Registration success. Customer ID=" + customer.getId();
                validation.success = true;
            }
        }

        logger.debug("Registration message: " + validation.message);
        model.addAttribute("showError", !validation.success);
        model.addAttribute("message", validation.message);

        return "registration";
    }

}

