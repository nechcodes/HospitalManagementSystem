package com.example.hospital;

public class Staff {
    private String name;
    private int id;
    private char gender;
    private int age;
    private String qualification;
    private String specialty;

    public Staff(String name, int id, char gender, int age, String qualification, String specialty) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.qualification = qualification;
        this.specialty = specialty;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getQualification() {
        return qualification;
    }

    public String getSpecialty() {
        return specialty;
    }
}
