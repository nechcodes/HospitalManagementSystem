package com.example.hospital;

public class Staff {
    private String name;
    private int id;
    private char gender;
    private int age;

    private String phone;
    private String category;
    private String position;

    public Staff(String name, int id, char gender, int age, String phone, String category, String position) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.category = category;
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
    public String getCategory() {
        return category;
    }

    public String getPosition() {
        return position;
    }
}
