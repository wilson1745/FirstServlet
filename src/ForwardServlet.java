
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;

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

		if (destination == null) {
			ServletConfig conf = this.getServletConfig();
			destination = conf.getInitParameter("destination");
			System.out.println(destination);
			Date date1 = new Date();
			request.setAttribute("date", date1);
			RequestDispatcher dispatcher = request.getRequestDispatcher("forward.jsp");
			dispatcher.forward(request, response);
		} else if ("file".equals(destination)) {
			System.out.println("get into web.xml");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/web.xml");
			dispatcher.forward(request, response);
		} else if ("jsp".equals(destination)) {
			System.out.println("get into forward.jsp");
			Date date = new Date();
			request.setAttribute("date", date);
			RequestDispatcher dispatcher = request.getRequestDispatcher("forward.jsp");
			dispatcher.forward(request, response);
		} else if ("servlet".equals(destination)) {
			System.out.println("get into LifeCycleServlet");
			RequestDispatcher dispatcher = request.getRequestDispatcher("LifeCycleServlet");
			dispatcher.forward(request, response);
		} else {
			System.out.println("Fuck you");
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().println("缺少參數。用法：" + request.getRequestURL() + "?destination=jsp 或者 file 或者 servlet ");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
