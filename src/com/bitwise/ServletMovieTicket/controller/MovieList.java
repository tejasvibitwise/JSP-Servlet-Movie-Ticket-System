package com.bitwise.ServletMovieTicket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieList
 */
@WebServlet("/MovieList")
public class MovieList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		MoviesInfo mi = (MoviesInfo) request.getSession(false).getAttribute("mo");
		ArrayList<Movies> list = (ArrayList<Movies>) mi.getList();
		out.println("<h2><b>Movies Shows</b></h2>");
		out.println("<br>");
		for (Movies m : list) {
			System.out.println("test" + m.getMoviename());
			out.print("<table>");
			out.print("<tr><td>Movie :"+m.getMoviename()+"</td></tr>");
			out.print("<tr><td>Theatre : "+m.getTheatreName()+"</td></tr>");
			out.print("<tr><td>Total Seats : "+m.getTotalSeats()+"</td></tr>");
			out.print("<tr><td>Time : "+m.getStartTime()+" to "+m.getEndTime()+"</td></tr>");
			out.print("</table>");
			out.println("<br><br>");
		
		}
		response.setContentType("text/html");
		request.getRequestDispatcher("actions.jsp").include(request, response);
	}

}
