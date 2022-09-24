package com.example.hospital;

import javafx.beans.property.SimpleStringProperty;

public class Drug {

    private SimpleStringProperty drugName;
    private SimpleStringProperty drugDose;
    private SimpleStringProperty formulation;
    private SimpleStringProperty drugClass;
    private String tabletsPerPack;
    private String unitPrice;
    private String purchaseDate;
    private String expDate;
    private String quantityForm;
    private String quantity;

    public Drug(String drugName, String drugDose,
                String formulation, String drugClass, String quantityForm, String quantity, String tabletsPerPack,
                String unitPrice, String purchaseDate, String expDate) {

            this.drugName = new SimpleStringProperty(drugName);
            this.drugDose = new SimpleStringProperty(drugDose);
            this.formulation = new SimpleStringProperty(formulation);
            this.drugClass = new SimpleStringProperty(drugClass);
            this.quantityForm = quantityForm;
            this.quantity = quantity;
            this.tabletsPerPack = tabletsPerPack;
            this.unitPrice = unitPrice;
            this.purchaseDate = purchaseDate;
            this.expDate = expDate;
    }

    public String getDrugName() {
        return drugName.get();
    }

    public SimpleStringProperty drugNameProperty() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName.set(drugName);
    }

    public String getDrugDose() {
        return drugDose.get();
    }

    public SimpleStringProperty drugDoseProperty() {
        return drugDose;
    }

    public void setDrugDose(String drugDose) {
        this.drugDose.set(drugDose);
    }

    public SimpleStringProperty getFormulation() {
        return formulation;
    }

    public SimpleStringProperty formulationProperty() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation.set(formulation);
    }

    public String getDrugClass() {
        return drugClass.get();
    }

    public SimpleStringProperty drugClassProperty() {
        return drugClass;
    }

    public void setDrugClass(String drugClass) {
        this.drugClass.set(drugClass);
    }

    public String getTabletsPerPack() {
        return tabletsPerPack;
    }

    public void setTabletsPerPack(String tabletsPerPack) {
        this.tabletsPerPack = tabletsPerPack;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }
    public String getQuantityForm() {
        return quantityForm;
    }

    public void setQuantityForm(String quantityForm) {
        this.quantityForm = quantityForm;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}