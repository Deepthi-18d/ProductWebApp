package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

import com.dao.ProductDAO;
import com.model.Product;

public class ReportServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        try {
            String type = req.getParameter("type");
            String value = req.getParameter("value");

            ProductDAO dao = new ProductDAO();
            List<Product> list = new ArrayList<>();

            if (type == null || value == null) {
                req.setAttribute("error", "Invalid input");
                req.getRequestDispatcher("report_form.jsp").forward(req, res);
                return;
            }

            switch (type) {

                case "price":
                    double price = Double.parseDouble(value);
                    list = dao.getByPrice(price);
                    break;

                case "category":
                    list = dao.getByCategory(value);
                    break;

                case "top":
                    int n = Integer.parseInt(value);
                    list = dao.getTopSelling(n);
                    break;

                default:
                    req.setAttribute("error", "Invalid report type");
                    req.getRequestDispatcher("report_form.jsp").forward(req, res);
                    return;
            }

            req.setAttribute("products", list);
            req.getRequestDispatcher("report_result.jsp").forward(req, res);

        } catch (Exception e) {
            e.printStackTrace();

            req.setAttribute("error", e.getMessage());
            req.getRequestDispatcher("report_form.jsp").forward(req, res);
        }
    }

    // optional safety
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doPost(req, res);
    }
}