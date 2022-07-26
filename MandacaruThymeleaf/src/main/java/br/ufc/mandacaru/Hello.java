package br.ufc.mandacaru;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import br.ufc.mandacaru.config.ThymeleafConfig;
import br.ufc.mandacaru.model.Address;
import br.ufc.mandacaru.model.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hello
 */
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
		TemplateEngine templateEngine = (TemplateEngine) getServletContext()
				.getAttribute(ThymeleafConfig.TEMPLATE_ENGINE_ATTR);
		IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext())
				.buildExchange(request, response);
		WebContext context = new WebContext(webExchange);
		Address address1 = new Address("Rua Zacarias Carlos de Melo", "63700-000");
		Person person1 = new Person(1, "Almada", address1);
		Address address2 = new Address("Rua das Oiticicas", "60700-000");
		Person person2 = new Person(2, "Anderson", address2);
		Address address3 = new Address("Rua das Carnaubas", "60000-000");
		Person person3 = new Person(3, "Francisco", address3);
		List<Person> people = new ArrayList<Person>();
		people.add(person1);
		people.add(person2);
		people.add(person3);
		context.setVariable("people", people);
		
//		context.setVariable("name", "Samuel Henrique");
//		context.setVariable("hello", "Hello World");
		templateEngine.process("hello", context, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
