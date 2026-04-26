package com.model;

public class Product {

    private int productId;
    private String productName;
    private String category;
    private double price;
    private int quantity;
    private int soldQuantity;

    // ✅ Default constructor (optional but good)
    public Product() {}

    // ✅ Parameterized constructor (IMPORTANT)
    public Product(int productId, String productName, String category,
            double price, int quantity, int soldQuantity) {

 this.productId = productId;
 this.productName = productName;
 this.category = category;
 this.price = price;
 this.quantity = quantity;
 this.soldQuantity = soldQuantity;
}

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }
}