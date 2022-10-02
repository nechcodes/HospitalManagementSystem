package com.example.hospital;

public class Dispenser {
    private String dFormulation, dName, dClass, ddDose, dDuration, dFrequency, dQuantity, dUnitPrice;
    private Double dTotalBill;



    public Dispenser(String dFormulation, String dName, String dClass, String dDose,
                     String dDuration, String dFrequency, String dQuantity, String unitPrice) {
        this.dFormulation = dFormulation;
        this.dName = dName;
        this.dClass = dClass;
        this.ddDose = dDose;
        this.dDuration = dDuration;
        this.dFrequency = dFrequency;
        this.dQuantity = dQuantity;
        this.dUnitPrice = unitPrice;
    }

    public String getdFormulation() {
        return dFormulation;
    }

    public String getdName() {
        return dName;
    }

    public String getdClass() {
        return dClass;
    }

    public String getDdDose() {
        return ddDose;
    }

    public String getdDuration() {
        return dDuration;
    }

    public String getdFrequency() {
        return dFrequency;
    }

    public String getdQuantity() {
        return dQuantity;
    }

    public String getdUnitPrice() {
        return dUnitPrice;
    }

    private double getdTotalBill() {
        return dTotalBill;
    }

    public void setdFormulation(String dFormulation) {
        this.dFormulation = dFormulation;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public void setdClass(String dClass) {
        this.dClass = dClass;
    }

    public void setDdDose(String ddDose) {
        this.ddDose = ddDose;
    }

    public void setdDuration(String dDuration) {
        this.dDuration = dDuration;
    }

    public void setdFrequency(String dFrequency) {
        this.dFrequency = dFrequency;
    }

    public void setdQuantity(String dQuantity) {
        this.dQuantity = dQuantity;
    }

    public void setdUnitPrice(String dUnitPrice) {
        this.dUnitPrice = dUnitPrice;
    }

    public void setdTotalBill(Double dTotalBill) {
        this.dTotalBill = dTotalBill;
    }
}