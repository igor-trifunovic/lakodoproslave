package controllers;

import classes.AgencyDAO;
import models.Agency;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/HomeClient")
public class HomeClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	AgencyDAO ag = new AgencyDAO();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ag.createConnection();;
			
			List<Agency> agencies = ag.getAllAgencies();
			
			request.setAttribute("agencies", agencies);
			request.getRequestDispatcher("HomeClient.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}