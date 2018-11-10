<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>JSP Scriptlets</title>
</head>
<body>
	<%
		int num = 10;
		int result = 1;
		for (int i = 1; i <= num; i++) {
			result *= i;
			out.println("數字" + i + "的階層" + result + " <br/>");
		}
		out.println("<hr/>");
		out.println("數字 " + num + "的階層: " + result);
	%>

	<br /> 數字
	<%=num%>
	的階層為：
	<%=result%>
</body>
</html>