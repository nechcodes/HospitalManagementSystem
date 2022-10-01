package com.example.hospital;

public class Appointment extends Patient{
    public Appointment(String firstName, String lastName, String hospitalNumber, String age, String address, String phone, String gender, String occupation, String entryPoint, String referral) {
        super(firstName, lastName, hospitalNumber, age, address, phone, gender, occupation, entryPoint, referral);
    }
}
