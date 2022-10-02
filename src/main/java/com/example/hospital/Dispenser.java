package com.example.hospital;

public class Dispenser {
    private String dFormulation, dName, dClass, ddDose, dDuration, dFrequency, dQuantity;
    private Double dUnitPrice, dTotalBill;



    public Dispenser(String dFormulation, String dName, String dClass, String ddDose,
                     String dDuration, String dFrequency, String dQuantity, Double unitPrice) {
        this.dFormulation = dFormulation;
        this.dName = dName;
        this.dClass = dClass;
        this.ddDose = ddDose;
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

    public Double getdUnitPrice() {
        return dUnitPrice;
    }

    private double getdTotalBill() {
        return dTotalBill;
    }
}