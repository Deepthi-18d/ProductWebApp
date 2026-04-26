package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

import com.dao.ProductDAO;

public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            // 📥 GET ID FROM FORM
            int id = Integer.parseInt(req.getParameter("id"));

            // 🔌 DAO CALL
            ProductDAO dao = new ProductDAO();
            int rows = dao.deleteProduct(id);

            // 🎯 RESULT HANDLING
            if (rows == 0) {
                req.setAttribute("msg", "Data not present to delete with this ID");
                RequestDispatcher rd = req.getRequestDispatcher("productdelete.jsp");
                rd.forward(req, res);
            } else {
                // ✅ SUCCESS MESSAGE
                res.sendRedirect("DisplayProductsServlet?msg=deleted");
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