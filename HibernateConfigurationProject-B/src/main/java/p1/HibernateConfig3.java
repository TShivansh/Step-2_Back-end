package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HibernateConfig3
 */
@WebServlet("/HibernateConfig3")
public class HibernateConfig3 extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HibernateManager hm = new HibernateManager();
		PrintWriter writer = response.getWriter();
		boolean b1 = hm.connect();
		boolean b2 = hm.updateData(1,"Shivansh");
		if(b2==true) {
			
			writer.println("Data Updated");
		}
		
		}
	
	}


