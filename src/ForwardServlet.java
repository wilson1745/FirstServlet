
import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ForwardServlet
 */
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForwardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String destination = request.getParameter("destination");

		System.out.println(destination);

		// 跳躍到 /WEB-INF/web.xml。透過地址欄輸入網址是不能存取到該檔案的，但是 forward 可以
		if ("file".equals(destination)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("C:\\Users\\cbluo\\eclipse-workspace\\FirstServlet\\WebContent\\WEB-INF\\web.xml");
			dispatcher.forward(request, response);
		}
		// 跳躍到 /forward.jsp
		else if ("jsp".equals(destination)) {
			// 透過 setAttribute 方法傳遞一個 Date 對像給 JSP 頁面
			Date date = new Date();
			request.setAttribute("date", date);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/forward.jsp");
			dispatcher.forward(request, response);
		}
		// 跳躍到另一個 Servlet
		else if ("servlet".equals(destination)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/FirstServlet/src/ForwardServlet.java");
			dispatcher.forward(request, response);
		} else {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("缺少參數。用法：" + request.getRequestURL() + "?destination=jsp 或者 file 或者 servlet ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doput(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
