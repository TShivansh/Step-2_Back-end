package p1;

import java.io.PrintWriter;
import java.lang.ClassNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HibernateConfig
 */
@WebServlet("/HibernateConfig")
public class HibernateConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HibernateManager hm = new HibernateManager();
		student s = new student();
		s.setSid(4);
		s.setSname("Ram");
		
		boolean b1 = hm.connect();
		boolean b2 = hm.insert(s);
		PrintWriter writer = response.getWriter();
		if(b1==true && b2==true) {
			writer.println("Hibernate configurations are up and running");
			writer.println("Hibernate has added your data to DB");
			
		}
		
		else {
			writer.println("Could not complete the hibernate configuration set up");
		}
		
	}

}
