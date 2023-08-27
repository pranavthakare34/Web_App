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
@WebServlet("/Log")
public class Log_In extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email=req.getParameter("em");
		String ps=req.getParameter("ps");
		
	
		PrintWriter out=resp.getWriter();
		boolean b=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt=con.prepareStatement("select * from dhamaka.tabl1");
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				if(rs.getString(3).equals(email)) {
					b=true;
				}
			}
			if (b==true) {
				out.println("<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "    <meta charset=\"UTF-8\">\r\n"
						+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
						+ "    <title>options</title>\r\n"
						+ "    <link rel=\"stylesheet\" href=\"./style2.css\">\r\n"
						+ "</head>\r\n"
						+ "<body bgcolor=\"cyan\">\r\n"
						+ "    \r\n"
						+ "<div id=\"container\">\r\n"
						+ "    <form action=\"vali\" >\r\n"
						+ " <input type=\"submit\" name=\"bt1\" value=\"Youtube\"> <br> <br>\r\n"
						+ "\r\n"
						+ " <input type=\"submit\" name=\"bt2\" value=\"instagram\"><br> <br>\r\n"
						+ "\r\n"
						+ " <input type=\"submit\" name=\"bt3\" value=\"chrome\" ><br> <br>\r\n"
						+ "</form>\r\n"
						+ "</div>\r\n"
						+ "\r\n"
						+ "    \r\n"
						+ "</body>\r\n"
						+ "</html>");
				
				
				
			} else {
				out.println("<html><body bgcolor='red'><h1>Unsuccsfull</h1></body></html>");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
