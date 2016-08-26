package com.bitwise.ServletMovieTicket.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/SessionFilter")
public class SessionFilter implements Filter {

    
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
//		PrintWriter out = response.getWriter();
//		HttpServletRequest req = (HttpServletRequest) request;
//		
//			
//		 
//		if (req.getSession(false)==null)
//		{
//			out.print("Session Expired");
//	        	        
//		} 
//		else
//		{
//		
//			chain.doFilter(request, response);
//		}
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String currUri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String redirectUrl = contextPath + "/login";
		
		boolean flag = authUserAgainstCookie(req);
	

		if (!isLoginUrl(currUri, contextPath)) {
			System.out.println("checking for session");
			if (!flag) {
				res.sendRedirect(redirectUrl);
				return;
			}
		}
	

		chain.doFilter(req, res);
	}

	private boolean authUserAgainstCookie(HttpServletRequest req) {
		boolean flag = false;
		Cookie[] cookies = req.getCookies();
		
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (!isSessionExpired(req)) {
					if (cookie.getValue().equals(req.getSession(false).getAttribute("sessID"))) {
						
						flag = true;
					}
				}
			}
		}
		return flag;
	}

	private boolean isSessionExpired(HttpServletRequest req) {
		return req.getSession(false) == null; // return true if not existing
	}

	private boolean isLoginUrl(String currUri, String contextPath) {
		return currUri.equals(contextPath + "/login");
	}

	
	

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
