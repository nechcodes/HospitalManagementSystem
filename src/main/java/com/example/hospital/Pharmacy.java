//package com.example.hospital;
//
//import java.util.Date;
//
//public class Pharmacy {
//    private String genericName;
//    private int drugClass;
//    private Date lastSupply;
//    private int stockCount;
//    private Date expiryDate;
//
//    public Pharmacy(String genericName, int drugClass, int stockCount) {
//        this.genericName = genericName;
//        this.drugClass = drugClass;
//        this.stockCount = stockCount;
//    }
//
//    public void dispense(String name, int dose, String frequency, String duration){
//        System.out.println("This drug should be taken " + frequency + " for " + duration + "\n Please ensure compliance");
//        stockCount--;
//    }
//
//    public void reStock(String name, String dose, int quantity, Date expiryDate){
//        System.out.println(quantity + " " + name + " " + "added to stock");
//        stockCount += quantity;
//        setExpiryDate(expiryDate);
//    }
//
//    private Date setExpiryDate(Date expiryDate) {
//        return expiryDate;
//    }
//
//    public String getGenericName() {
//        return genericName;
//    }
//
//    public int getDrugClass() {
//        return drugClass;
//    }
//
//    public Date getLastSupply() {
//        return lastSupply;
//    }
//
//    public int getStockCount() {
//        return stockCount;
//    }
//
//    public Date getExpiryDate() {
//        return expiryDate;
//    }
//}