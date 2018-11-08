package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet1
 */
public class LoginGetparameter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginGetparameter() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
		String name = request.getParameter("name");
		String pass = request.getParameter("mypassword");
		request.setAttribute("myname", name);
		request.setAttribute("mypass", pass);
		String na = (String) request.getAttribute("myname");
		String pa = (String) request.getAttribute("mypass");
		//PrintWriter out = response.getWriter();
		System.out.println(na);
		System.out.println(pa);
		//sendRedirect間接產生一個新的request
		//response.sendRedirect("login.jsp");
	}

}
