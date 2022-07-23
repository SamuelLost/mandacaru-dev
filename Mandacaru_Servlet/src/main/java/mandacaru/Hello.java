package mandacaru;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/ok") //Mapeamento sem ser no web.xml
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstName = request.getParameter ("first_name" );
		String lastName = request.getParameter ("last_name" );
		response.getWriter().append("FirstName: " + firstName).append("\nLastName: " + lastName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
//		response.getWriter().append("POST - Hello World");
		String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String subjects = String.join(", ", request.getParameterValues("subject"));
 
        String initParam = getInitParameter("caderno");
        String contextParam = getServletContext().getInitParameter("country");
        response.getWriter().append("POST First Name: ").append(firstName)
        		.append("\nLast Name: ").append(lastName).append("\nSubjects: " + subjects)
        		.append("\nInit: " + initParam).append("\nContext: " + contextParam);
	}

}
