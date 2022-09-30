package com.example.hospital;

public class Doctor extends Staff{
    private String specialty;
    public Doctor(String name, String id, String gender, String age, String phone,
                  String qualification, String position, String specialty) {
        super(name, id, gender, age, phone, qualification, position, "Family Medicine");

        if (super.getPosition() != "Medical Officer" &&
                super.getPosition() != "House Officer")
            this.specialty = specialty;
        else
            this.specialty = "NONE";
    }

    public String getSpecialty() {
        return specialty;
    }

    public Doctor p (String name, String id, String gender, String age, String phone,
                      String qualification, String position, String specialty) {
        Doctor p = new Doctor (getName(), getId(), getGender(), getAge(), getPhone(),
                getDepartment(), getPosition(), getSpecialty());

        if (super.getPosition() != "Medical Officer" &&
                super.getPosition() != "House Officer")
            this.specialty = specialty;
        else
            this.specialty = "NONE";
        return p;
    }

    public void setSpecialty(String specialty) {
        if (super.getPosition() != "Medical Officer" &&
                super.getPosition() != "House Officer")
        this.specialty = specialty;
        else
            this.specialty = "NONE";
    }
}