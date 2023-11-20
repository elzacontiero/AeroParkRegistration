package com.elzacontiero.aeroparker.registration.util;

import com.elzacontiero.aeroparker.registration.model.RegistrationForm;

public class Validator {
    public static ValidationResult validateForm(RegistrationForm registration) {
        ValidationResult result = new ValidationResult();
        result.success = true;

        if (registration.getInputEmail().isEmpty()) {
            result.message = "Email cannot be empty.";
            result.success = false;
        }
        else if (registration.getInputEmail().length() > 255) {
            result.message = "Email field too long. It must be up to 255 characters.";
            result.success = false;
        }
        else if (registration.getInputTitle().length() > 5) {
            result.message = "Title too long. It must be up to five characters.";
            result.success = false;
        }
        else if (registration.getInputFirstName().length() > 50) {
            result.message = "First Name field too long. It must be up to 50 characters.";
            result.success = false;
        }
        else if (registration.getInputFirstName().isEmpty()) {
            result.message = "First Name field cannot be empty.";
            result.success = false;
        }
        else if (registration.getInputLastName().length() > 50) {
            result.message = "Last Name field too long. It must be up to 50 characters.";
            result.success = false;
        }
        else if (registration.getInputLastName().isEmpty()) {
            result.message = "Last Name field cannot be empty.";
            result.success = false;
        }
        else if (registration.getInputAddress1().isEmpty()) {
            result.message = "Address 1 cannot be empty.";
            result.success = false;
        }
        else if (registration.getInputAddress1().length() > 255) {
            result.message = "Address 1 field too long. It must be up to 255 characters.";
            result.success = false;
        }
        else if (registration.getInputAddress2().length() > 255) {
            result.message = "Address 2 field too long. It must be up to 255 characters.";
            result.success = false;
        }
        else if (registration.getInputPostcode().isEmpty()) {
            result.message = "Postcode cannot be empty.";
            result.success = false;
        }
        else if (registration.getInputPostcode().length() > 10) {
            result.message = "Postcode field too long. It must be up to 10 characters.";
            result.success = false;
        }
        else if (registration.getInputPhoneNumber().length() > 20) {
            result.message = "Phone number field too long. It must be up to 20 characters.";
            result.success = false;
        }
        return result;
    }
}
