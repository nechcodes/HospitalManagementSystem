package com.example.hospital;

public class Staff {
    private String name;
    private String id;
    private String gender;
    private String age;
    private String phone;
    private String category;
    private String position;
    private String department;

    public Staff(String name, String id, String gender, String age, String phone, String category, String position, String department) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.category = category;
        this.position = position;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
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
    public String getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}