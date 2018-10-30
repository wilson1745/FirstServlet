<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<jsp:directive.page import="java.util.Date" />
<jsp:directive.page import="java.text.SimpleDateFormat" />
<%
	Date date = (Date) request.getAttribute("date");
	System.out.println(date);
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Forward 跳轉</TITLE>
<link rel='stylesheet' type='text/css'
	href='<%=request.getContextPath()%>/css/style.css'>
</HEAD>
<BODY>
	<div align='center'>
		<br />
		<fieldset style="width: 90%">
			<legend> Forward 跳轉 </legend>
			<br />
			<div style=''>
				<div class='leftDiv' style='width: 250px;'>從 ForwardServlet
					中取到的 Date 為</div>
				<div align='left' class='rightDiv'>
					<%
						SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						out.print("<h2 align=\"center\">" + ft.format(date) + "</h2>");
					%>
				</div>
			</div>
			<br />
			<div style=''>
				<div align="center">
					<input type='button'
						onclick='location="<%=request.getContextPath()%>/ForwardServlet?destination=servlet"; '
						onmouseover="window.status='<%=request.getContextPath()%>/ForwardServlet?destination=servlet'"
						value='跳轉到 Servlet' class=button> <input type='button'
						onclick='location="<%=request.getContextPath()%>/ForwardServlet?destination=file"; '
						onmouseover="window.status='<%=request.getContextPath()%>/ForwardServlet?destination=file'"
						value='跳轉到 web.xml' class=button> <input type='button'
						onclick='location="<%=request.getContextPath()%>/ForwardServlet?destination=jsp"; '
						onmouseover="window.status='<%=request.getContextPath()%>/ForwardServlet?destination=jsp'"
						value='跳轉到 JSP' class=button>
				</div>
			</div>
</BODY>
</HTML>

