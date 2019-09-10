package com.sweethome.retrivebyname;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seethome.db.DBconnection;

/**
 * Servlet implementation class RetriveByName
 */
public class RetriveByName extends HttpServlet {
	
	static Connection con=null;
	static PreparedStatement pt=null;
	static ResultSet rs=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rid=Integer.parseInt(request.getParameter("rname"));
		int sum=0;
		try
		{
		con=DBconnection.getConnection();
		System.out.println(con);
		String query="select sum(amount) from log where user_id=?";
		pt=con.prepareStatement(query);
		pt.setInt(1, rid);
		rs=pt.executeQuery();
		 sum=0;
		while(rs.next())
		{
			 sum=rs.getInt(1);
			System.out.println(sum);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		request.setAttribute("cname",rid);
		RequestDispatcher rd=request.getRequestDispatcher("successretrivename.jsp?amount="+sum);
		rd.forward(request, response);
	}

}
