package com.bitwise.ServletMovieTicket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// @WebServlet("/AddMoviesShow")
public class AddMoviesShow extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddMoviesShow() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		InputValidation in=new InputValidation();
		String movieName = request.getParameter("mname");
		String theatreName = request.getParameter("tname");
		
		String seats = request.getParameter("seats");
		int totalSeats = Integer.parseInt(seats);
		
		String startTime = request.getParameter("st");
		String endTime = request.getParameter("et");
		
		PrintWriter out = response.getWriter();

		if (in.validate_str(movieName) && in.validate_str(theatreName) && startTime != null && endTime != null && in.validate_time(startTime, endTime)) 
		{
			if (((MoviesInfo) request.getSession(false).getAttribute("mo")).moviesData(movieName, theatreName,
					totalSeats, startTime, endTime)) {
				out.write("SuccessFully Added");
				response.setContentType("text/html");
				request.getRequestDispatcher("add.jsp").include(request, response);

			} else {
				out.write("Reached Maximum Limit Cannot be added");
				response.setContentType("text/html");
				//request.getRequestDispatcher("DisplayMoviesShow").include(request, response);
				request.getRequestDispatcher("add.jsp").include(request, response);
			}  
		} else {
			out.println("<br><font>Invalid Data !!!</font><br>");
			response.setContentType("text/html");
			request.getRequestDispatcher("addMoviesShow.html").include(request, response);

		}
	}

}
