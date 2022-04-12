package controllers;

import classes.*;
import models.*;
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Programme programme = null;
	ProgrammeDAO programmes = new ProgrammeDAO();
	String agencyID = "";
	
	public ReservationServlet() { }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			programme = programmes.getByProgrammeID(request.getParameter("programmeID").toString());
			agencyID = request.getParameter("agencyID").toString();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("Reservation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("programme", programme);
		request.setAttribute("agencyID", agencyID);
		
		request.getRequestDispatcher("ReservationSuccess.jsp").forward(request, response);
	}

}