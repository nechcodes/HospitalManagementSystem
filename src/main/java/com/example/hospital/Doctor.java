package com.example.hospital;

public class Doctor extends Staff{
    private String specialty;
    public Doctor(String name, int id, char gender, int age, String phone,
                  String qualification, String position, String specialty) {
        super(name, id, gender, age, phone, qualification, position);

        if (super.getPosition() != "Medical Officer" &&
                super.getPosition() != "House Officer")
            this.specialty = specialty;
        else
            this.specialty = "NONE";
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        if (super.getPosition() != "Medical Officer" &&
                super.getPosition() != "House Officer")
        this.specialty = specialty;
        else
            this.specialty = "NONE";
    }
}