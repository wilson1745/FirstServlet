<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%
	Locale locale = request.getLocale();
	Calendar calendar = Calendar.getInstance(locale);
	int hour = calendar.get(Calendar.HOUR_OF_DAY);
	String greeting = "";
	if (hour <= 6) greeting = "hour <= 6";
	else if (hour <= 9) greeting = "hour <= 9";
	else if (hour <= 12) greeting = "hour <= 12";
	else if (hour <= 18) greeting = "hour <= 18";
	else if (hour <= 24) greeting = "hour <= 24";
	else greeting = "What the fuck is going on???";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Welcome Page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<table>
		<tr>
			<td><%=greeting%></td>
		</tr>
	</table>
</body>
</html>