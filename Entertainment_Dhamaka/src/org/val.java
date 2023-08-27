package org;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vali")
public class val extends HttpServlet{

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bt1=req.getParameter("bt1");
		String bt2=req.getParameter("bt2");
		String bt3=req.getParameter("bt3");
		
		
		if (bt1!=null) {
			resp.sendRedirect("https://www.youtube.com");
		} else if(bt2!=null){
			resp.sendRedirect("https://www.instagram.com");
		}else if(bt3!=null) {
			resp.sendRedirect("https://www.chrome.com");
		}
		
	}
	
}
