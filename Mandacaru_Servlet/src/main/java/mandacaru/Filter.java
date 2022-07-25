package mandacaru;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * Servlet Filter implementation class Filter
 */
public class Filter extends HttpFilter implements jakarta.servlet.Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public Filter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
//		chain.doFilter(request, response);
		// TODO Auto-generated method stub
        response.getWriter();
          
        // This will print output on console
        System.out.println(
        		"Before filter - Preprocessing before servlet");        
        String firstName = request.getParameter("first_name");

        if(firstName.equals("Samuel")) { //Se na requisição tiver o nome, tá autorizado
        	// some authentication if required
        	chain.doFilter(request, response); //Deixa ir pro servlet
        } else {
        	response.setContentType("text/html");
        	response.getWriter().append("Não autorizado");
        }

        // This will print output on console
        System.out.println(
        		"After servlet - Following code will execute after running the servlet - PostProcessing"); 
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
