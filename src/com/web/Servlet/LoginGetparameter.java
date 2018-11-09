package com.web.Servlet;

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
		//JSP輸入的帳號密碼
	  	String name = request.getParameter("name");
	  	String password= request.getParameter("mypassword");	
		System.out.println(name);
		System.out.println(password);
	  	
	  	//init-param所設定的帳號密碼
	  	String secretName = getServletConfig().getInitParameter("name");
	  	String secretPassword = getServletConfig().getInitParameter("password"); 	
		System.out.println(secretName);
		System.out.println(secretPassword);
	  	
	  	if(secretName.equals(name) && secretPassword.equals(password)) {
	  		// 讓request攜帶一個myname的name參數
	  		request.setAttribute("myname", name);
	  		request.getRequestDispatcher("index.jsp").forward(request, response);
	  		return;
	  	} else {
	  		request.getRequestDispatcher("ErrorPage.jsp").forward(request, response);
	  	}
		
		/*request.getRequestDispatcher("index.jsp").forward(request, response);
		String name = request.getParameter("name");
		String pass = request.getParameter("mypassword");
		request.setAttribute("myname", name);
		request.setAttribute("mypass", pass);
		String na = (String) request.getAttribute("myname");
		String pa = (String) request.getAttribute("mypass");
		//PrintWriter out = response.getWriter();
		System.out.println(na);
		System.out.println(pa);*/
	  	
		//sendRedirect間接產生一個新的request
		//response.sendRedirect("login.jsp");
	}

}
