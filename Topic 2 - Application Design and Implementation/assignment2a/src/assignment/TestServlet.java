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
		
//    	System.out.println("DEBUG : called init()");
    	
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		
//		System.out.println("DEBUG : called destroy()");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		request.setAttribute("firstname", firstname);
		request.setAttribute("lastname", lastname);
		
		if(firstname == null || lastname == null || firstname.equals("") || lastname.equals("")) {
			request.getRequestDispatcher("TestError.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("TestResponse.jsp").forward(request, response);
		}
		
//		response.getWriter().append(firstname).append(lastname);		
//		System.out.println("DEBUG : called doGet()");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
