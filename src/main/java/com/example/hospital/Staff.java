package com.example.hospital;

public class Staff {
    private String name;
    private int id;
    private char gender;
    private int age;

    private String phone;
    private String qualification;
    private String position;

    public Staff(String name, int id, char gender, int age, String phone, String qualification, String position) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.qualification = qualification;
        this.position = position;
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

    public String getPhone() {
        return phone;
    }
    public String getQualification() {
        return qualification;
    }

    public String getPosition() {
        return position;
    }
}
