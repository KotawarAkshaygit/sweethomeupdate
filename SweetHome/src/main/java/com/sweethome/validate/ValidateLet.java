package com.sweethome.validate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * Servlet implementation class ValidateLet
 */
public class ValidateLet extends HttpServlet {
       

    int laddukgs;
    int jelebikgs;
    int gulabkgs;
    int basundhikgs;
	static  Logger logger=(Logger) LogManager.getLogger();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String laddu=request.getParameter("laddu");
		String gulab=request.getParameter("gulab");
		String jelebi=request.getParameter("jelebi");
		String basundhi=request.getParameter("basundhi");

		HttpSession session=request.getSession();
		
		 if(laddu.isEmpty())
		 laddukgs=0;
	     else
	    	 laddukgs=Integer.parseInt(laddu);
		 	session.setAttribute("laddukgs", laddukgs);
		 
		 	if(jelebi.isEmpty())
			  jelebikgs=0;
		     else
		    	 jelebikgs=Integer.parseInt(jelebi);
		 session.setAttribute("jelebikgs",jelebikgs);
		
		 if(gulab.isEmpty())
			 gulabkgs =0;
		     else
		    gulabkgs=Integer.parseInt(gulab);
		 session.setAttribute("gulabkgs", gulabkgs);
		
		 
		 if(basundhi.isEmpty())
			  basundhikgs=0;
		     else
		    	 basundhikgs=Integer.parseInt(basundhi);;
		    	 session.setAttribute("basundhikgs", basundhikgs);
		
		PrintWriter out=response.getWriter();
		if(laddukgs<0 && gulabkgs<0 && jelebikgs<0 && basundhikgs<0)
		{
			out.println("<center>Give The Valid Number<center>");
			logger.error("Invalid Details");
			RequestDispatcher rds=request.getRequestDispatcher("index.jsp");
			rds.include(request, response);
			
		}
		else
		{
			logger.info("redirecting to userdetails jsp");
			RequestDispatcher rd=request.getRequestDispatcher("userDetails.jsp");
			rd.forward(request, response);
		}
	
	}

}
