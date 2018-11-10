<%@ page language="java" contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>JSP Scriptlets</title>
</head>
<body>
	<%
		String param = request.getParameter("param");

		if ("1".equals(param)) {
	%>
	芙 蓉 樓 送 辛 漸
	<br /> 寒 雨 連 江 夜 入 吳 ，
	<br /> 平 明 送 客 楚 山 孤 。
	<br /> 洛 陽 親 友 如 相 問 ，
	<br /> 一 片 冰 心 在 玉 壺 。
	<%
		} else if ("2".equals(param)) {
	%>
	九 月 九 日 憶 山 東 兄 弟
	<br /> 獨 在 異 鄉 為 異 客 ，
	<br /> 每 逢 佳 節 倍 思 親 。
	<br /> 遙 知 兄 弟 登 高 處 ，
	<br /> 遙 知 兄 弟 登 高 處 ，
	<%
		} else if ("3".equals(param)) {
	%>
	近 試 上 張 水 部
	<br /> 洞 房 昨 夜 停 紅 燭 ，
	<br /> 待 曉 堂 前 拜 舅 姑 。
	<br /> 妝 罷 低 聲 問 夫 婿 ，
	<br /> 畫 眉 深 淺 入 時 無 ？
	<%
		} else {
	%>
	唐詩三百首詩文資料 param=1, 2, 3
	<br />
	<br>
	<a href="if.jsp?param=1">if.jsp?param=1</a>
	<br>
	<a href="if.jsp?param=2">if.jsp?param=2</a>
	<br>
	<a href="if.jsp?param=3">if.jsp?param=3</a>
	<br>
	<%
		}
	%>
</body>
</html>
