package com.dao;

import java.sql.*;
import java.util.*;
import com.model.Product;

public class ProductDAO {

    private Connection con;

    // 🔌 Constructor
    public ProductDAO() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/productdb", "root", "Dhhh@63788182");
    }

    // ➕ ADD PRODUCT
    public void addProduct(Product p) throws Exception {

        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO Products (ProductID, ProductName, Category, Price, Quantity, SoldQuantity) VALUES (?, ?, ?, ?, ?, ?)"
        );

        ps.setInt(1, p.getProductId());
        ps.setString(2, p.getProductName());
        ps.setString(3, p.getCategory());
        ps.setDouble(4, p.getPrice());
        ps.setInt(5, p.getQuantity());

        // IMPORTANT FIX:
        ps.setInt(6, p.getSoldQuantity());
        ps.executeUpdate();
    }
    // ✏️ UPDATE PRODUCT ✅ FIXED
    public int updateProduct(Product p) throws Exception {

        PreparedStatement ps = con.prepareStatement(
            "UPDATE Products SET ProductName=?, Category=?, Price=?, Quantity=?, SoldQuantity=? WHERE ProductID=?"
        );

        ps.setString(1, p.getProductName());
        ps.setString(2, p.getCategory());
        ps.setDouble(3, p.getPrice());
        ps.setInt(4, p.getQuantity());

        // 🔥 IMPORTANT
        ps.setInt(5, p.getSoldQuantity());

        ps.setInt(6, p.getProductId());

        return ps.executeUpdate();
    }

    // ❌ DELETE PRODUCT ✅ FIXED
    public int deleteProduct(int id) throws Exception {
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM Products WHERE ProductID=?");

        ps.setInt(1, id);

        return ps.executeUpdate(); // 👈 returns rows
    }

    // 📋 DISPLAY ALL PRODUCTS
    public List<Product> getAllProducts() throws Exception {
        List<Product> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Products");

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getInt("ProductID"));
            p.setProductName(rs.getString("ProductName"));
            p.setCategory(rs.getString("Category"));
            p.setPrice(rs.getDouble("Price"));
            p.setQuantity(rs.getInt("Quantity"));
            p.setSoldQuantity(rs.getInt("SoldQuantity")); // 🔥 ADD THIS

            list.add(p);
        }

        return list;
    }

    // 📊 REPORT: PRICE > VALUE
    public List<Product> getByPrice(double price) throws Exception {
        List<Product> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Products WHERE Price > ?");

        ps.setDouble(1, price);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getInt("ProductID"));
            p.setProductName(rs.getString("ProductName"));
            p.setCategory(rs.getString("Category"));
            p.setPrice(rs.getDouble("Price"));
            p.setQuantity(rs.getInt("Quantity"));
            p.setSoldQuantity(rs.getInt("SoldQuantity")); // 🔥 ADD THIS

            list.add(p);
        }

        return list;
    }

    // 📊 REPORT: CATEGORY
    public List<Product> getByCategory(String category) throws Exception {
        List<Product> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Products WHERE Category=?");

        ps.setString(1, category);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getInt("ProductID"));
            p.setProductName(rs.getString("ProductName"));
            p.setCategory(rs.getString("Category"));
            p.setPrice(rs.getDouble("Price"));
            p.setQuantity(rs.getInt("Quantity"));
            p.setSoldQuantity(rs.getInt("SoldQuantity")); // 🔥 ADD THIS

            list.add(p);
        }
        return list;
    }

    // 📊 REPORT: TOP N PRODUCTS
    public List<Product> getTopSelling(int n) throws Exception {

        List<Product> list = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM Products ORDER BY SoldQuantity DESC LIMIT ?"
        );

        ps.setInt(1, n);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Product p = new Product();
            p.setProductId(rs.getInt("ProductID"));
            p.setProductName(rs.getString("ProductName"));
            p.setCategory(rs.getString("Category"));
            p.setPrice(rs.getDouble("Price"));
            p.setQuantity(rs.getInt("Quantity"));
            p.setSoldQuantity(rs.getInt("SoldQuantity")); // 🔥 ADD THIS
            list.add(p);
        }

        return list;
    }
}