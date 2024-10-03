package com.Registration;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class saveStudent extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Service Method Called");
		
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String adr = req.getParameter("adr");
		String email = req.getParameter("email");
		
		System.out.println("Firstname = "+fname);
		System.out.println("Lastname = "+lname);
		System.out.println("address = "+adr);
		System.out.println("Email = "+email);
		
		//insert into students Insert into Student (FirstName, LastName, Address, Email) values ('Aditya', 'P', 'Chennai', 'ap@gmail.com');
		
		String query = "Insert into student (FirstName, LastName, Address, Email) values ('"+fname+"', '"+lname+"', '"+adr+"', '"+email+"')";
				
		DbConnection db = new DbConnection();
		try {
			db.saveStudent(query);
		}catch(Exception e) {
			e.printStackTrace();
			resp.getWriter().println("Some issue occured during save");
		}
			
		System.out.println("Query is = "+query);
		
		resp.getWriter().println("User got saved into the database");
	}
}