
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCookieServlet
 */
@WebServlet("/LoginCookieServlet")
public class LoginCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String AUTO_USER_KEY = "AUTO_USER_KEY";
	private String TEST_USER = "levin";
	private String TEST_PWD = "123456";

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (null != cookie.getName() && null != cookie.getValue()) {
					String name = cookie.getName();
					String value = cookie.getValue();

					if (AUTO_USER_KEY.equals(name) && (TEST_USER + "||" + TEST_PWD).equals(value)) {
						// 有取得user
						request.setAttribute("user", value.toString().split("||")[0]);
						request.getRequestDispatcher("/UserServlet").forward(request, response);
						return;
					}
				}
			}
		}
		// if get the wrong id & password
		response.sendRedirect("login.html");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCookieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
