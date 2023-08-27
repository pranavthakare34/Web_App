package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main")
public class main extends HttpServlet {
	

	
	@Override
	protected void doTrace(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String mail=req.getParameter("em");
	String pass=req.getParameter("ps");
	PrintWriter out=resp.getWriter();
	boolean b=false;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		PreparedStatement pstmt=con.prepareStatement("select * from dhamaka.tabl1");
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			
			if(rs.getString(3).equals(mail)) {
				b=true;
			}
		}
		if (b==true) {
			out.println("<html><body><h1>Succesefull</h1></body></html>");
			
			resp.sendRedirect("Log");
			
		} else {
			out.println("<html><body bgcolor='red'><h1>Unsuccsfull</h1></body></html>");

		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
	
	
	}

	
}
