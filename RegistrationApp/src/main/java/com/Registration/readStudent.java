package com.Registration;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.catalina.connector.Response;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class readStudent extends HttpServlet{


	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletConfig config = getServletConfig();
		config.getInitParameter("sadf");
		req.getServletContext();
		
		System.out.println("Read method called");
		
		String query = "select * from student";
		
		DbConnection db = new DbConnection();
		
		ArrayList<Student> sdata = new ArrayList<Student>();
		
		try {
			sdata = db.readStudent(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("stdata", sdata);
		
		resp.sendRedirect("ReadStudent.jsp");
	}
	
}
