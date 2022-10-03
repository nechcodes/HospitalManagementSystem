package com.example.hospital;

import javafx.beans.property.SimpleStringProperty;

public class Dispenser {
    private SimpleStringProperty dFormulation, dName, dClass, dDose, dDuration, dFrequency, dQuantity, dUnitPrice;
    private Double dTotalBill;



    public Dispenser(String dFormulation, String dName, String dClass, String dDose,
                     String dDuration, String dFrequency, String dQuantity, String unitPrice) {
        this.dFormulation = new SimpleStringProperty(dFormulation);
        this.dName = new SimpleStringProperty(dName);
        this.dClass = new SimpleStringProperty(dClass);
        this.dDose = new SimpleStringProperty(dDose);
        this.dDuration = new SimpleStringProperty(dDuration);
        this.dFrequency = new SimpleStringProperty(dFrequency);
        this.dQuantity = new SimpleStringProperty(dQuantity);
        this.dUnitPrice = new SimpleStringProperty(unitPrice);
    }

    public String getdFormulation() {
        return dFormulation.get();
    }

    public SimpleStringProperty dFormulationProperty() {
        return dFormulation;
    }

    public void setdFormulation(String dFormulation) {
        this.dFormulation.set(dFormulation);
    }

    public String getdName() {
        return dName.get();
    }

    public SimpleStringProperty dNameProperty() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName.set(dName);
    }

    public String getdClass() {
        return dClass.get();
    }

    public SimpleStringProperty dClassProperty() {
        return dClass;
    }

    public void setdClass(String dClass) {
        this.dClass.set(dClass);
    }

    public String getdDose() {
        return dDose.get();
    }

    public SimpleStringProperty dDoseProperty() {
        return dDose;
    }

    public void setdDose(String dDose) {
        this.dDose.set(dDose);
    }

    public String getdDuration() {
        return dDuration.get();
    }

    public SimpleStringProperty dDurationProperty() {
        return dDuration;
    }

    public void setdDuration(String dDuration) {
        this.dDuration.set(dDuration);
    }

    public String getdFrequency() {
        return dFrequency.get();
    }

    public SimpleStringProperty dFrequencyProperty() {
        return dFrequency;
    }

    public void setdFrequency(String dFrequency) {
        this.dFrequency.set(dFrequency);
    }

    public String getdQuantity() {
        return dQuantity.get();
    }

    public SimpleStringProperty dQuantityProperty() {
        return dQuantity;
    }

    public void setdQuantity(String dQuantity) {
        this.dQuantity.set(dQuantity);
    }

    public String getdUnitPrice() {
        return dUnitPrice.get();
    }

    public SimpleStringProperty dUnitPriceProperty() {
        return dUnitPrice;
    }

    public void setdUnitPrice(String dUnitPrice) {
        this.dUnitPrice.set(dUnitPrice);
    }

    public Double getdTotalBill() {
        return dTotalBill;
    }

    public void setdTotalBill(Double dTotalBill) {
        this.dTotalBill = dTotalBill;
    }
}