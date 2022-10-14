package com.example.hospital;

import javafx.beans.property.SimpleStringProperty;

public class Drug {

    SimpleStringProperty id;
    private SimpleStringProperty drugClass;
    private SimpleStringProperty formulation;
    private SimpleStringProperty drugName;
    private SimpleStringProperty quantity;
    private SimpleStringProperty unitForm;
    private SimpleStringProperty purchaseDate;
    private SimpleStringProperty expDate;
    private SimpleStringProperty unitCostPrice;
    private SimpleStringProperty unitSellingPrice;

    public Drug(
                String drugClass,
                String formulation,
                String drugName,
                String quantity,
                String unitForm,
                String purchaseDate,
                String expDate,
                String unitCostPrice,
                String unitSellingPrice) {
        this.drugClass = new SimpleStringProperty(drugClass);
        this.formulation = new SimpleStringProperty(formulation);
        this.drugName = new SimpleStringProperty(drugName);
        this.quantity = new SimpleStringProperty(quantity);
        this.unitForm = new SimpleStringProperty(unitForm);
        this.purchaseDate = new SimpleStringProperty(purchaseDate);
        this.expDate = new SimpleStringProperty(expDate);
        this.unitCostPrice = new SimpleStringProperty(unitCostPrice);
        this.unitSellingPrice = new SimpleStringProperty(unitSellingPrice);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
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

    public String getFormulation() {
        return formulation.get();
    }

    public SimpleStringProperty formulationProperty() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation.set(formulation);
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

    public String getQuantity() {
        return quantity.get();
    }

    public SimpleStringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public String getUnitForm() {
        return unitForm.get();
    }

    public SimpleStringProperty unitFormProperty() {
        return unitForm;
    }

    public void setUnitForm(String unitForm) {
        this.unitForm.set(unitForm);
    }

    public String getPurchaseDate() {
        return purchaseDate.get();
    }

    public SimpleStringProperty purchaseDateProperty() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate.set(purchaseDate);
    }

    public String getExpDate() {
        return expDate.get();
    }

    public SimpleStringProperty expDateProperty() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate.set(expDate);
    }

    public String getUnitCostPrice() {
        return unitCostPrice.get();
    }

    public SimpleStringProperty unitCostPriceProperty() {
        return unitCostPrice;
    }

    public void setUnitCostPrice(String unitCostPrice) {
        this.unitCostPrice.set(unitCostPrice);
    }

    public String getUnitSellingPrice() {
        return unitSellingPrice.get();
    }

    public SimpleStringProperty unitSellingPriceProperty() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(String unitSellingPrice) {
        this.unitSellingPrice.set(unitSellingPrice);
    }
}