
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HolisticCounter
 */
public class HolisticCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static int classCount = 0;
	int count = 0;
	static Hashtable instances = new Hashtable();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HolisticCounter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		count++;
		out.println("Since loading, this servlet instance has been accessed " + count + " times.");
		instances.put(this, this);
		out.println("There are currently " + instances.size() + " instances.");
		classCount++;
		out.println("Across all instances, this servlet class has been " + "accessed " + classCount + " times.");
	}
}
