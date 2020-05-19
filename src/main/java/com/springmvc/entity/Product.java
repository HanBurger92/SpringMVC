package com.springmvc.entity;

import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository("product")
public class Product {

    private String productCode; // primary key
    private String productName;
    private String type;
    private String category;
    private String unit;
    private String cost;
    private String price;
    private String certificate;
    private Date expirationDate;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", unit='" + unit + '\'' +
                ", cost='" + cost + '\'' +
                ", price='" + price + '\'' +
                ", certificate='" + certificate + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
