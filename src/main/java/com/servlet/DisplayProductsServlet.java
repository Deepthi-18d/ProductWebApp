package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import com.dao.ProductDAO;
import com.model.Product;

public class DisplayProductsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html"); // ensure response type

        try {
            System.out.println("DisplayProductsServlet called"); // DEBUG

            ProductDAO dao = new ProductDAO();
            List<Product> list = dao.getAllProducts();

            // DEBUG: check list
            if(list == null) {
                System.out.println("List is NULL");
            } else {
                System.out.println("List size: " + list.size());
            }

            req.setAttribute("products", list);

            RequestDispatcher rd = req.getRequestDispatcher("productdisplay.jsp");
            rd.forward(req, res);

        } catch (Exception e) {

            // VERY IMPORTANT: show error in browser also
            e.printStackTrace();

            PrintWriter out = res.getWriter();
            out.println("<h3>Error occurred:</h3>");
            out.println("<pre>");
            e.printStackTrace(out);  // show error on screen
            out.println("</pre>");
        }
    }
}