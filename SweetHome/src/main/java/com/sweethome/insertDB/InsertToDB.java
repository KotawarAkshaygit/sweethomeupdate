package com.sweethome.insertDB;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.seethome.db.DBconnection;


/**
 * Servlet implementation class InsertToDB
 */

public class InsertToDB extends HttpServlet {

	static Logger logger=LogManager.getLogger();
	static Connection con=null;
	static 	PreparedStatement pt=null;
	static ResultSet rs=null;
	static Object name=null;
	static int finalamount=0;
	static 	int finalresult=0;
	int x=0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		int id1=0;
		int id2=0;
		int id3=0;
		int id4=0;
		int id=0;
	
		
		int kgs=0;
		int amounts=0;
		int resultid=0;
		
		int laddukgs=(Integer)session.getAttribute("laddukgs");
		int	 jelebikgs=(Integer)session.getAttribute("jelebikgs");
		int gulabkgs=(Integer)session.getAttribute("gulabkgs");
		int basundhikgs=(Integer)session.getAttribute("basundhikgs");
		
	
		if(laddukgs >0)
		{
			logger.info("laddu is selected");
			 id1=(Integer)session.getAttribute("id1");
		}
		 if(gulabkgs>0)
			{
				logger.info("gulab is selected");
				id2=(Integer)session.getAttribute("id2");
			}
		 if(jelebikgs>0)
		{
			logger.info("jelebi is selected");
		 id3=(Integer)session.getAttribute("id3");
		}
		
		 if(basundhikgs>0)
		{
			logger.info("basundhi is selected");
			 id4=(Integer)session.getAttribute("id4");
			 amounts=(Integer)session.getAttribute("rb");
		}
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("customerName")==null)
			response.sendRedirect("home.jsp");
		
		String customerName=(String)session.getAttribute("customerName");
		String contact=(String) session.getAttribute("contact");
		
		
		try {
			
				boolean status = false;
				con=DBconnection.getConnection();
				System.out.println(con);
				 pt=con.prepareStatement("select user_id from user where user_contact=?") ;
				pt.setString(1, contact);
				rs = pt.executeQuery();
				while(rs.next()) {
				resultid=	rs.getInt("user_id");
				status = rs.first();
				}
				System.out.println("*********************Status ="+status+resultid);
			
			if(status) {
				 
				if(id1>0)
				{
					id=id1;
					kgs=laddukgs;
					amounts=(Integer)session.getAttribute("rl");
					logger.info("in laddu status true");
					 item_select(id,kgs,resultid,amounts);
				}
				if(id2>0)
				{
					
					id=id2;                          
					kgs=gulabkgs;
					 amounts=(Integer)session.getAttribute("rg");
					 logger.info("in gulab status true");
					 x=item_select(id,kgs,resultid,amounts);
				}
				if(id3>0)
				{
					id=id3;
					kgs=jelebikgs;
					 amounts=(Integer)session.getAttribute("rj");
					 logger.info("in jelebi status true");
					x=item_select(id,kgs,resultid,amounts);
				}
				if(id4>0)
				{
					id=id4;
					kgs=basundhikgs;
					 amounts=(Integer)session.getAttribute("rb");
					 logger.info("in basundhi status true");
					x=item_select(id,kgs,resultid,amounts);
				}
				logger.info("redirecting to success jsp");
				response.sendRedirect("Success.jsp");
				
			}
			else
			{
				con=DBconnection.getConnection();
				System.out.println(con);
				pt=con.prepareStatement("insert into user(user_name,user_contact) values(?,?)",Statement.RETURN_GENERATED_KEYS);
				pt.setString(1,customerName);
				pt.setString(2, contact);
				logger.info("connected to prepared statement in insert First");
				pt.executeUpdate();
				rs=pt.getGeneratedKeys();
				System.out.println("rs value is"+rs);
				while(rs.next())
				{
				resultid=rs.getInt(1);
				System.out.println("ResultId is"+resultid);
				
				if(id1>0)
				{
					id=id1;
					kgs=laddukgs;
					 amounts=(Integer)session.getAttribute("rl");
					 logger.info("in laddu status false");
					 item_select(id,kgs,resultid,amounts);
				}
				if(id2>0)
				{
					
					id=id2;                          
					kgs=gulabkgs;
					 amounts=(Integer)session.getAttribute("rg");
					 logger.info("in gulab status false");
					 x=item_select(id,kgs,resultid,amounts);
				}
				if(id3>0)
				{
					id=id3;
					kgs=jelebikgs;
					 amounts=(Integer)session.getAttribute("rj");
					 logger.info("in jelebi status false");
					x=item_select(id,kgs,resultid,amounts);
				}
				if(id4>0)
				{
					id=id4;
					kgs=basundhikgs;
					 amounts=(Integer)session.getAttribute("rb");
					 logger.info("in basundhi status false");
					x=item_select(id,kgs,resultid,amounts);
				}
			
				}
				
				logger.info("redirecting to success jsp");
				response.sendRedirect("Success.jsp");
			}
		}
		catch(Exception f)
		{
			System.out.println(f);
		}
	}
	
	public int item_select(int id,int kgs,int user_id, int amounts)
	{
		try
		{
			con=DBconnection.getConnection();
			pt=con.prepareStatement("insert into log(user_id,item_id,kgs,amount,date_added) values(?,?,?,?,now())");
			pt.setInt(1, user_id);
			pt.setInt(2,id);
			pt.setInt(3, kgs);
			pt.setInt(4, amounts);
			 x=pt.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	
		return x;
	}
}
