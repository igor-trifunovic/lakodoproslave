package controllers;

import classes.ReservationDAO;
import models.Reservation;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

/**
 * Servlet implementation class HomeManager
 */
@WebServlet("/HomeManager")
public class HomeManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ReservationDAO manageRes = new ReservationDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		if (session.getAttribute("manager") != null) {
			try {
				List<Reservation> reservations = manageRes.getAllReservations();
				request.setAttribute("reservations", reservations);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("HomeManager.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}