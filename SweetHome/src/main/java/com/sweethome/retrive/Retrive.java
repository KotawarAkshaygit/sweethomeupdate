package com.sweethome.retrive;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Retrive
 */
public class Retrive extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String opt1=request.getParameter("opt1");
		if(opt1.isEmpty() || opt1.contains(" ") || opt1==null)
		{
			
			out.println("Please Provide Valid Option");
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
			rd.include(request, response);
		}
		else {
		//int opt1=Integer.parseInt(request.getParameter("opt1"));
		int opt=Integer.parseInt(opt1);
		switch(opt)
		{
		case 1:
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			break;
			
		case 2:
			RequestDispatcher rd1=request.getRequestDispatcher("retrives.jsp");
			rd1.forward(request, response);
			break;
		case 3:
			RequestDispatcher rd2=request.getRequestDispatcher("retrivebyname.jsp");
			rd2.forward(request,response);
			break;
			default:
				out.println("Please Provide the Valid Option");
				RequestDispatcher rds=request.getRequestDispatcher("home.jsp");
				rds.include(request, response);
			
		}
		
		}
	}

}
