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
        Customer customer = repository.findCustomerByEmail(registration.getInputEmail());
        String message;
        boolean error = false;

        if (customer != null) {
            message = "Email already registered.";
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

