package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.SQLIntegrityConstraintViolationException;

import com.dao.ProductDAO;
import com.model.Product;

public class AddProductServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        try {
            // 📥 GET FORM VALUES
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String category = req.getParameter("category");
            double price = Double.parseDouble(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int soldQuantity = Integer.parseInt(req.getParameter("soldQuantity"));

            // 📦 CREATE OBJECT
            Product p = new Product(id, name, category, price, quantity, soldQuantity);

            ProductDAO dao = new ProductDAO();

            try {
                dao.addProduct(p);

                // ✅ SUCCESS MESSAGE SENT TO DISPLAY PAGE
                res.sendRedirect("DisplayProductsServlet?msg=added");

            } 
            catch (SQLIntegrityConstraintViolationException e) {

                // ❌ Duplicate ID
                req.setAttribute("msg", "Product ID already exists!");
                req.getRequestDispatcher("productadd.jsp").forward(req, res);
            } 
            catch (Exception e) {

                e.printStackTrace();
                req.setAttribute("msg", "Error: " + e.getMessage());
                req.getRequestDispatcher("productadd.jsp").forward(req, res);
            }

        } catch (Exception e) {

            e.printStackTrace();
            res.getWriter().println("<h3 style='color:red;'>ERROR: " + e.getMessage() + "</h3>");
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}