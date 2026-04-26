package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ReportCriteriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 protected void doGet(HttpServletRequest req,HttpServletResponse res)
 throws ServletException,IOException {
  req.getRequestDispatcher("report_form.jsp").forward(req,res);
 }
}