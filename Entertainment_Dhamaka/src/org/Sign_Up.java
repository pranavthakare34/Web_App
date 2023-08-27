package org;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/page1")
public class Sign_Up extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String a1=req.getParameter("nm");
		String a2=req.getParameter("ag");
		String a3=req.getParameter("em");
		PrintWriter out=resp.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
		         PreparedStatement pstmt=con.prepareStatement("insert into dhamaka.tabl1 values(?,?,?)");
		         pstmt.setString(1, a1);
		         pstmt.setString(2, a2);
		         pstmt.setString(3, a3);
		         pstmt.executeUpdate();
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("<html><body><h1>Succesfully registerd PLZ sign in</h1></body></html>");
		
		RequestDispatcher rd=req.getRequestDispatcher("sign.html");
		rd.forward(req, resp);
		
		
		
		
		
	}
}
