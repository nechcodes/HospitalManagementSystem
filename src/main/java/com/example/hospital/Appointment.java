package com.example.hospital;

public  class Appointment{
    private String firstName;
    private String lastName;
    private String hospitalNumber;
    private String appointmentVenue;
    private String date;

    public Appointment(String firstName, String lastName,
                       String hospitalNumber, String appointmentVenue, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospitalNumber = hospitalNumber;
        this.appointmentVenue = appointmentVenue;
        this.date = date;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHospitalNumber() {
        return hospitalNumber;
    }

    public void setHospitalNumber(String hospitalNumber) {
        this.hospitalNumber = hospitalNumber;
    }

    public String getAppointmentVenue() {
        return appointmentVenue;
    }

    public void setAppointmentVenue(String appointmentVenue) {
        this.appointmentVenue = appointmentVenue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
