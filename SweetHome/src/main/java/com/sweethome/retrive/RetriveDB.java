package com.sweethome.retrive;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seethome.db.DBconnection;

/**
 * Servlet implementation class RetriveDB
 */
public class RetriveDB extends HttpServlet {
	
	static Connection con=null;
	static PreparedStatement pt=null;
	static ResultSet rs=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	String pdate=request.getParameter("pdate");
	String pdate1=request.getParameter("pdate1");
	
	if(pdate1.isEmpty())
	{

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		 pdate = simpleDateFormat.format(new Date(pdate));
			
	}
	else
	{
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		 pdate = simpleDateFormat.format(new Date(pdate));
		 pdate = pdate+" 00:00:01";
		
	     pdate1 = simpleDateFormat.format(new Date(pdate1));
		 pdate1 = pdate1+" 23:59:59";
			
	}
	
    if(pdate1.isEmpty())
    {
	int sum=0;
		try
		{
		pdate=pdate+"%";
		con=DBconnection.getConnection();
		System.out.println(con);
		String query="select sum(amount) from log where date_added between ";
		 pt=con.prepareStatement(query);
		pt.setString(1, pdate);
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
		request.setAttribute("resultset", sum);
		request.setAttribute("pdate1", pdate);
		RequestDispatcher rd=request.getRequestDispatcher("successRetrive.jsp");
		rd.forward(request, response);
	}
	

	else
	{
		int sum1=0;
		try
		{
		con=DBconnection.getConnection();
		System.out.println(con);
		String query="select sum(amount) from log where date_added between ? and ?";
		 pt=con.prepareStatement(query);
		 pt.setString(1, pdate);
		 pt.setString(2, pdate1);
		 rs=pt.executeQuery();
		 sum1=0;
		 while(rs.next())
		 {
			 sum1=rs.getInt(1);
			System.out.println("sum1:"+sum1);
		 }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		request.setAttribute("resultset", sum1);
		request.setAttribute("pdate", pdate);
		request.setAttribute("pdate1", pdate1);
		RequestDispatcher rd=request.getRequestDispatcher("successRetrive.jsp");
		rd.forward(request, response);
	}
	}
	}

