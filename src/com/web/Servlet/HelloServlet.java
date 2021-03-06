package com.web.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 呼叫 HttpServlet 附帶的日誌函數輸出資訊到控制台
		this.log("執行 doGet 方法... ");

		// 處理 doGet
		this.execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.log("執行 doPost 方法... ");

		// 處理 doPost
		this.execute(request, response);
	}

	@Override
	public long getLastModified(HttpServletRequest request) {

		this.log("執行 getLastModified 方法... ");

		return 0;
	}

	private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		// 存取該 Servlet 的 URI
		String requestURI = request.getRequestURI();
		// 存取該 Servlet 的方式，是 GET 還是 POST
		String method = request.getMethod();
		// 客戶端傳送的參數 param 值
		String param = request.getParameter("param");

		System.out.println(requestURI);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.println("	以 " + method + " 方式存取該頁面。取到的 param 參數為：" + param + "<br/>");

		out.println("	<form action='" + requestURI + "' method='get'><input type='text' name='param' value=''><input type='submit' value='以 GET 方式存取 RequestServlet'></form>");
		out.println("	<form action='" + requestURI + "' method='post'><input type='text' name='param' value=''><input type='submit' value='以 POST 方式存取 RequestServlet'></form>");

		// 由客戶端瀏覽器讀取該文件的更新時間
		out.println("	<script>document.write('本頁面最後更新時間：' + document.lastModified + '<br />'); </script>");
		out.println("	<script>document.write('本頁面URL：' + location + '<br/>' ); </script>");

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();

	}
}
