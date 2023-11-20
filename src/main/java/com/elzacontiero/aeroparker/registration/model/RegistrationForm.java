package com.elzacontiero.aeroparker.registration.model;

public class RegistrationForm {
    private String inputTitle;
    private String inputFirstName;
    private String inputLastName;
    private String inputEmail;
    private String inputAddress1;
    private String inputAddress2;
    private String inputCity;
    private String inputPostcode;
    private String inputPhoneNumber;

    public String getInputTitle() {
        return inputTitle;
    }

    public void setInputTitle(String inputTitle) {
        this.inputTitle = inputTitle;
    }

    public String getInputFirstName() {
        return inputFirstName;
    }

    public void setInputFirstName(String inputFirstName) {
        this.inputFirstName = inputFirstName;
    }

    public String getInputLastName() {
        return inputLastName;
    }

    public void setInputLastName(String inputLastName) {
        this.inputLastName = inputLastName;
    }

    public String getInputEmail() {
        return inputEmail;
    }

    public void setInputEmail(String inputEmail) {
        this.inputEmail = inputEmail;
    }

    public String getInputAddress1() {
        return inputAddress1;
    }

    public void setInputAddress1(String inputAddress1) {
        this.inputAddress1 = inputAddress1;
    }

    public String getInputAddress2() {
        return inputAddress2;
    }

    public void setInputAddress2(String inputAddress2) {
        this.inputAddress2 = inputAddress2;
    }

    public String getInputCity() {
        return inputCity;
    }

    public void setInputCity(String inputCity) {
        this.inputCity = inputCity;
    }

    public String getInputPostcode() {
        return inputPostcode;
    }

    public void setInputPostcode(String inputPostcode) {
        this.inputPostcode = inputPostcode;
    }

    public String getInputPhoneNumber() {
        return inputPhoneNumber;
    }

    public void setInputPhoneNumber(String inputPhoneNumber) {
        this.inputPhoneNumber = inputPhoneNumber;
    }

    @Override
    public String toString() {
        return "FormRegistration{" +
                "inputTitle='" + inputTitle + '\'' +
                ", inputFirstName='" + inputFirstName + '\'' +
                ", inputLastName='" + inputLastName + '\'' +
                ", inputEmail='" + inputEmail + '\'' +
                ", inputAddress1='" + inputAddress1 + '\'' +
                ", inputAddress2='" + inputAddress2 + '\'' +
                ", inputCity='" + inputCity + '\'' +
                ", inputPostcode='" + inputPostcode + '\'' +
                ", inputPhoneNumber='" + inputPhoneNumber + '\'' +
                '}';
    }
}
