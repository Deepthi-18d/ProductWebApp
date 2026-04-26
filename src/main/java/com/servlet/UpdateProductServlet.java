package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import com.dao.ProductDAO;
import com.model.Product;

public class UpdateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            // 📥 GET FORM DATA
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String category = req.getParameter("category");
            double price = Double.parseDouble(req.getParameter("price"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int soldQuantity = Integer.parseInt(req.getParameter("soldQuantity"));

            // 📦 SET INTO MODEL
            Product p = new Product();
            p.setProductId(id);
            p.setProductName(name);
            p.setCategory(category);
            p.setPrice(price);
            p.setQuantity(quantity);
            p.setSoldQuantity(soldQuantity);

            // 🔌 DAO CALL
            ProductDAO dao = new ProductDAO();
            int rows = dao.updateProduct(p);

            // 🎯 RESULT HANDLING
            if (rows == 0) {
                req.setAttribute("msg", "Data not found to update with this ID");
                RequestDispatcher rd = req.getRequestDispatcher("productupdate.jsp");
                rd.forward(req, res);
            } else {
                // ✅ SUCCESS MESSAGE
                res.sendRedirect("DisplayProductsServlet?msg=updated");
            }

        } catch (Exception e) {
            e.printStackTrace();

            res.getWriter().println(
                "<h3 style='color:red;'>ERROR: " + e.getMessage() + "</h3>"
            );
        }
    }

    // 🔁 safety method
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}