package org.servlet.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.servlet.util.LogUtils;

/**
 * 
 * @author amiransari
 * created at 11/04/2020
 * this is a just demo class to explain the life cycle
 * of servlet that how it works
 * 
 */
public class ServletLifeCycle implements Servlet{
	
	private LogUtils log = new LogUtils(ServletLifeCycle.class.getSimpleName());
	private ServletConfig config = null;
	

	
	@Override
	public void init(ServletConfig config) throws ServletException {
       this.config = config;
       log.info("servlet is initialized");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("<b>hello simple servlet</b>");  
		out.print("</body></html>");		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "copyright 2020-04-11";
	}

	@Override
	public void destroy() {
		log.info("servlet is destroyed");
		
	}
	
	

	
	
}
