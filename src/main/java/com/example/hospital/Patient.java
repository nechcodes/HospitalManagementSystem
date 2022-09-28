package com.example.hospital;

import java.util.Date;

public class Patient {
    private String firstName;
    private String lastName;
    private String hospitalNumber;
    private String gender;
    private String age;
    private String phone;
    private String occupation;
    private String address;
    private String entryPoint;
    private String referral;

    public Patient(String firstName, String lastName, String hospitalNumber, String age, String address,
                   String phone, String gender, String occupation, String entryPoint, String referral) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.hospitalNumber = hospitalNumber;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.occupation = occupation;
        this.entryPoint = entryPoint;
        this.referral = referral;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getHospitalNumber() {
        return hospitalNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getAddress() {
        return address;
    }

    public String getEntryPoint() {
        return entryPoint;
    }

    public String getReferral() {
        return referral;
    }
}