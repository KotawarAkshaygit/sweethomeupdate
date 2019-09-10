package com.sweethome.calculatebill;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.seethome.db.DBconnection;


/**
 * Servlet implementation class CalculateBill
 */
public class CalculateBill extends HttpServlet {
	
static Logger logger=LogManager.getLogger();
static Connection con=null;
static PreparedStatement pt=null;
static ResultSet rs=null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ids[]=new int[5];
		String customerName=request.getParameter("cname");
		String contact=request.getParameter("contact");
		 int i=0;
		 int j=0;
		HttpSession session=request.getSession();
		session.setAttribute("customerName", customerName);
		session.setAttribute("contact", contact);
		int laddukgs=(Integer)session.getAttribute("laddukgs");
		int gulabkgs=(Integer)session.getAttribute("gulabkgs");
		int jelebikgs=(Integer)session.getAttribute("jelebikgs");
		int basundhikgs=(Integer)session.getAttribute("basundhikgs");
		
		int arr[]=new int[4];
		int idsto[]=new int[5];
		int l=0;
		
		try {
			 con=DBconnection.getConnection();
			System.out.println(con);
			String query1="select item_id from items";
			 pt=con.prepareStatement(query1);
			 rs=pt.executeQuery();
		
			while(rs.next())
			{
				 idsto[l]=rs.getInt(1);
				l++;
			}
		}catch(Exception d)
		{
			System.out.println(d);
		}
		
		int id1=0;
		int id2=0;
		int id3=0;
		int id4=0;
		if(laddukgs>0)
		{
			 id1=idsto[0];
			 session.setAttribute("id1", id1);
		}
		 if(gulabkgs>0)
		 {
			id2=idsto[1];
			session.setAttribute("id2", id2);
		 }
		 if(jelebikgs>0)
		 {
			id3=idsto[2];
			session.setAttribute("id3", id3);
		 }
		 if(basundhikgs>0)
		 {
			id4=idsto[3];
			session.setAttribute("id4", id4);
		 
		 }
			try {
		  con=DBconnection.getConnection();
			System.out.println(con);
			String query="select item_id,item_price from items where item_id= ? or item_id=? or item_id=? or item_id=?";
			 pt=con.prepareStatement(query);

			pt.setInt(1, id1);
			pt.setInt(2, id2);
			pt.setInt(3, id3);
			pt.setInt(4, id4);
			 rs=pt.executeQuery();
		
			while(rs.next())
			{
					ids[i]=rs.getInt(1);
					arr[j]=rs.getInt(2);
			
						i++;
						j++;
			}
			}catch(Exception e)
			{
				System.out.println(e);
			}
			
			int rl=0;
			int rg=0;
			int rj=0;
			int rb=0;
			int finals=0;
		for(int a=0;a<4;a++)
		{
			if(ids[a]==id1)
			{
				rl=rl+arr[a]*laddukgs;
				session.setAttribute("rl", rl);
			}
			
			else if(ids[a]==id2)
			{
				rg=rg+arr[a]*gulabkgs;
				session.setAttribute("rg", rg);
			}
			
			else if(ids[a]==id3)
			{
				rj=rj+arr[a]*jelebikgs;
				session.setAttribute("rj", rj);
			}
				
			else if(ids[a]==id4)
			{
				rb=rb+arr[a]*basundhikgs;
				session.setAttribute("rb", rb);
			}
		}
		
		finals=(rl+rg+rj+rb);
		logger.info("Laddu total is"+rl);
		logger.info("gulab total is"+rg);
		logger.info("jelebi total is"+rj);
		logger.info("basundhi total is"+rb);
		logger.info("Total is "+finals);
		session.setAttribute("finallist", finals);
		
		response.sendRedirect("InsertToDB");
		
	}
}

