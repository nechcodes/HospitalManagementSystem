package com.example.hospital;

import java.util.Date;

public class Patient  {
        private String name;
        private int id;
        private char gender;
        private int age;

        private Date lastVisit;

        public Patient(String name, int id, char gender, int age, Date lastVisit) {
            this.name = name;
            this.id = id;
            this.gender = gender;
            this.age = age;
            this.lastVisit = lastVisit;
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

    public Date getLastVisit() {
        return lastVisit;
    }
}
