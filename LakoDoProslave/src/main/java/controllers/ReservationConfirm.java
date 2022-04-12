package controllers;

import classes.*;
import models.*;
import java.io.*;
import java.sql.SQLException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/ReservationConfirm")
public class ReservationConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ManageReservations reservations = new ManageReservations();
	Reservation reservation = null;
	
    public ReservationConfirm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		String startTime = request.getParameter("start_date");
		String endTime = request.getParameter("end_time");
		int gameRoom = Integer.parseInt(request.getParameter("gameRoom"));
		int animator = Integer.parseInt(request.getParameter("animator"));
		int disco = Integer.parseInt(request.getParameter("disco"));
		int drinks = Integer.parseInt(request.getParameter("drinks"));
		int food = Integer.parseInt(request.getParameter("food"));
		int agencyID = Integer.parseInt(request.getParameter("agencyID"));
		
		reservation = new Reservation(0, name, phone, email, date, startTime, endTime, gameRoom, animator, disco, drinks, food, agencyID);
		
		try {
			reservations.insert(reservation);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ReservationSuccess.jsp").forward(request, response);
		
	}

}