package com.company.model;

import java.io.Serializable;

public class Product implements Serializable {
    private  int id;
    private String name;
    private String  ProductFrom;
    private float price;
    private ProductCategory productCategory;

    public Product() {
    }

    public Product(int id, String name,float price) {
        this.id = id;
        this.name = name;
        this.price=price;
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int id, String name, String productFrom, float price, ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        ProductFrom = productFrom;
        this.price = price;
        this.productCategory = productCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductFrom() {
        return ProductFrom;
    }

    public void setProductFrom(String productFrom) {
        ProductFrom = productFrom;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ProductFrom='" + ProductFrom + '\'' +
                ", price=" + price +
                ", productCategor= " +productCategory +"\n"+
                '}';
    }
}
