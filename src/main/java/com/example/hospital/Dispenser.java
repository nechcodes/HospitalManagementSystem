package com.example.hospital;

import javafx.beans.property.SimpleStringProperty;

public class Dispenser {
    private SimpleStringProperty dFormulation, dName, dDose, dDuration, dFrequency, dQuantity, dUnitPrice, sales;
    private Double dTotalBill;



    public Dispenser(String dFormulation,
                     String dName,
                     String dDose,
                     String dFrequency,
                     String dDuration,
                     String dQuantity,
                     String unitPrice,
                     String sales) {
        this.dFormulation = new SimpleStringProperty(dFormulation);
        this.dName = new SimpleStringProperty(dName);
        this.dDose = new SimpleStringProperty(dDose);
        this.dFrequency = new SimpleStringProperty(dFrequency);
        this.dDuration = new SimpleStringProperty(dDuration);
        this.dQuantity = new SimpleStringProperty(dQuantity);
        this.dUnitPrice = new SimpleStringProperty(unitPrice);

        sales = String.valueOf(
                Double.valueOf(dQuantity) * Double.parseDouble(unitPrice));

        this.sales = new SimpleStringProperty(sales);

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

    public String getSales() {
        return sales.get();
    }

    public SimpleStringProperty salesProperty() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales.set(sales);
    }

    public void setdTotalBill(Double dTotalBill) {
        this.dTotalBill = dTotalBill;
    }
}