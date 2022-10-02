package com.example.hospital;

import java.util.Objects;

public class Doctor extends Staff{
    private String specialty;
    public Doctor(String name, String id, String gender, String age, String phone,
                  String qualification, String position, String specialty) {
        super(name, id, gender, age, phone, qualification, position, "Family Medicine");

        if (!Objects.equals(super.getPosition(), "Medical Officer") &&
                !Objects.equals(super.getPosition(), "House Officer"))
            this.specialty = specialty;
        else
            this.specialty = "NONE";
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        if (!Objects.equals(super.getPosition(), "Medical Officer") &&
                !Objects.equals(super.getPosition(), "House Officer"))
        this.specialty = specialty;
        else
            this.specialty = "NONE";
    }
}