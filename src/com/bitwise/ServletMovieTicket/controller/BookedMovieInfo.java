package com.bitwise.ServletMovieTicket.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BookedMovieInfo")
public class BookedMovieInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookedMovieInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		InputValidation in=new InputValidation();
		String customerName = request.getParameter("cname");
		String customerAddress = request.getParameter("caddr");
		String seats = request.getParameter("seat");
		int requiredSeats = Integer.parseInt(seats);
		String movieShow = request.getParameter("addedmovies");
		String date = request.getParameter("date");
		PrintWriter out = response.getWriter();

		try {
			if (in.validate_str(customerName) && in.validate_str(customerAddress)&& in.validate_date(date)) {
				if (((MoviesInfo) request.getSession(false).getAttribute("mo")).bookingData(customerName, customerAddress,
						requiredSeats, movieShow, date)) {
					out.write("SuccessFully Added");
					response.setContentType("text/html");
					//request.getRequestDispatcher("displayBookingHistory.jsp").include(request, response);
					request.getRequestDispatcher("actions.jsp").include(request, response);

				} else {
					out.write(" Seats not available");
					response.setContentType("text/html");
					request.getRequestDispatcher("bookTicket.jsp").include(request, response);
				}
			} else {
				out.println("<br><font>Invalid Data !!!</font><br>");
				response.setContentType("text/html");
				request.getRequestDispatcher("bookTicket.jsp").include(request, response);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
