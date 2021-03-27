package assignment;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        
    	super();

    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init(ServletConfig config) throws ServletException {
		
    	// test message to console
    	System.out.println("DEBUG : called init()");
    	
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		
		// test message to console
		System.out.println("DEBUG : called destroy()");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// test message to console
		System.out.println("DEBUG : called doGet()");
		
		
		// attributes to process
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		request.setAttribute("firstname", firstname);
		request.setAttribute("lastname", lastname);
		
		// check for empty or null values
		if(firstname == null || lastname == null || firstname.equals("") || lastname.equals("")) {
			// send to error page
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		} else {
			
			// send to expected response page
			request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		}
		
		// modified original code for working through early assignment steps
//		response.getWriter().append(firstname).append(lastname);
		
		// default code
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
