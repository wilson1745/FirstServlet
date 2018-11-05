
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Servlet implementation class RedirectServlet
 */
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Integer> map = new HashMap<String, Integer>();

	@Override
	public void init() throws ServletException {
		map.put("/upload.html", 0);
		map.put("/postPersonalInformation.html", 0);
		map.put("/login.html", 0);
		map.put("/index.html", 0);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filename = request.getParameter("filename");
		
		if (filename != null) {
			// 點擊得到map裡index的值
			int hit = map.get(filename);
			// Map value更新
			map.put(filename, ++hit);
			// 重新整理網頁
			response.sendRedirect(request.getContextPath() + filename);
		} else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
			out.println("<HTML>");
			out.println("  <HEAD><TITLE>檔案瀏覽</TITLE></HEAD>");
			out.println("	<link rel='stylesheet' type='text/css' href='../css/style.css'>");
			out.println("  <BODY><br/>");

			out.println("<fieldset align=center style=width:90%><legend>檔案瀏覽</legend>");
			out.println("<table width=100%>");
			out.println("	<tr>");
			out.println("		<td><b>檔案名</b></td>");
			out.println("		<td><b>瀏覽次數</b></td>");
			out.println("		<td><b>瀏覽</b></td>");
			out.println("	</tr>");

			for (Entry<String, Integer> entry : map.entrySet()) {
				out.println("<tr>");
				out.println("	<td>" + entry.getKey() + "</td>");
				out.println("	<td>" + entry.getValue() + "</td>");
				out.println("	<td><a href='" + request.getRequestURI() + "?filename=" + entry.getKey() + "' target='_blank' onclick='location=location; '>瀏覽</a></td>");
				out.println("</tr>");
			}

			out.println("</table>");
			out.println("	</legend>");
			out.println("  </BODY>");
			out.println("</HTML>");
			out.flush();
			out.close();
		}
	}

	@Override
	public void destroy() {
		map = null;
	}
}
