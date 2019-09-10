package com.sweethome.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class retrivebyidFilter
 */
public class retrivebyidFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest req=(HttpServletRequest) request;
		PrintWriter out=response.getWriter();
		int ase=Integer.parseInt(request.getParameter("rname"));
		if(ase<0)
		{
			out.println("Please Provide Positive Integer");
			RequestDispatcher rd=request.getRequestDispatcher("retrivebyname.jsp");
			rd.include(request, response);
		}
		else
		{
		chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
