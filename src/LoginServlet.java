
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private String AUTO_USER_KEY = "AUTO_USER_KEY";
	private String TEST_USER = "levin";
	private String TEST_PWD = "123456";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String passwd = request.getParameter("password");
		
		if (TEST_USER.equals(user) && TEST_PWD.equals(passwd)) {
			String login = request.getParameter("login");
			
			if ("auto".equals(login)) {
				Cookie cookie = new Cookie(AUTO_USER_KEY, TEST_USER + "||" + TEST_PWD);
				cookie.setMaxAge(7 * 24 * 60 * 60);
				response.addCookie(cookie);
			}
			request.setAttribute("user", user);
			request.getRequestDispatcher("/UserServlet").forward(request, response);
		} else {
			response.sendRedirect("login.html");
		}
	}

}
