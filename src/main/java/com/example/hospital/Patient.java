package com.example.hospital;

import javafx.beans.property.SimpleStringProperty;

public class Patient {
    private SimpleStringProperty patientId;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty email;
    private SimpleStringProperty gender;
    private SimpleStringProperty age;
    private SimpleStringProperty phone;
    private SimpleStringProperty occupation;
    private SimpleStringProperty address;
    private SimpleStringProperty entryPoint;
    private SimpleStringProperty referral;

    public Patient(String patientId,
                   String firstName,
                   String lastName,
                   String age,
                   String gender,
                   String occupation,
                   String address,
                   String email,
                   String phone,
                   String entryPoint,
                   String referral) {
        this.patientId = new SimpleStringProperty(patientId);
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.address = new SimpleStringProperty(address);
        this.gender = new SimpleStringProperty(gender);
        this.age = new SimpleStringProperty(age);
        this.phone = new SimpleStringProperty(phone);
        this.occupation = new SimpleStringProperty(occupation);
        this.entryPoint = new SimpleStringProperty(entryPoint);
        this.referral = new SimpleStringProperty(referral);
    }

    public String getPatientId() {
        return patientId.get();
    }

    public SimpleStringProperty patientIdProperty() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId.set(patientId);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getGender() {
        return gender.get();
    }

    public SimpleStringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getOccupation() {
        return occupation.get();
    }

    public SimpleStringProperty occupationProperty() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation.set(occupation);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getEntryPoint() {
        return entryPoint.get();
    }

    public SimpleStringProperty entryPointProperty() {
        return entryPoint;
    }

    public void setEntryPoint(String entryPoint) {
        this.entryPoint.set(entryPoint);
    }

    public String getReferral() {
        return referral.get();
    }

    public SimpleStringProperty referralProperty() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral.set(referral);
    }
}