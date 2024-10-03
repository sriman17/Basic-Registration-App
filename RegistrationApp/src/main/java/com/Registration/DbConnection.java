package com.Registration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;


public class DbConnection {
	public void saveStudent(String query) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
      	String JdbcURL = "jdbc:mysql://localhost:3306/RegistrationDb?useSSL=false";

		Connection con = DriverManager.getConnection(JdbcURL, "root", "ksriman17");

		Statement st = (Statement) con.createStatement();
		st.execute(query);
    }

	public ArrayList<Student> readStudent(String query) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
  		String JdbcURL = "jdbc:mysql://localhost:3306/RegistrationDb?useSSL=false";

  		Connection con = DriverManager.getConnection(JdbcURL, "root", "ksriman17");

  		Statement st = (Statement) con.createStatement();
  		ResultSet rs = st.executeQuery(query);
  		
  		ArrayList<Student> sdata = new ArrayList<Student>();	
  		
  		while(rs.next()){
  			String fname = rs.getString("Firstname");
  			String lname = rs.getString("LastName");
  			String address = rs.getString("Address");
  			String email = rs.getString("Email");
  			
  			Student st1 = new Student();
  			st1.setFirstname(fname);
  			st1.setLastName(lname);
  			st1.setAddress(address);
  			st1.setEmail(email);
  			sdata.add(st1);
  			
  			System.out.println(fname + " "+ lname+" "+address+" "+email);
  		}
		return sdata;
    }
		
}

