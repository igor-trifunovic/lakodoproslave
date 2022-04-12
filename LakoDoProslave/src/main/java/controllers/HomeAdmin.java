package controllers;

import classes.*;
import models.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.util.*;

@WebServlet("/HomeAdmin")
public class HomeAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ManageClients manageClients = new ManageClients();
	ManageManagers manageManagers = new ManageManagers();
	ManageAdmins manageAdmins = new ManageAdmins();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("roleName") != null) {
			if (session.getAttribute("roleName").toString().matches("admin")) {
				
				ManageAgencies manageAgencies = new ManageAgencies();
				ManageClients manageClients = new ManageClients();
				ManageManagers manageManagers = new ManageManagers();

				try {
					manageAgencies.createConnection();
					List<Agency> agencies = manageAgencies.getAllAgencies();
					List<Client> clients = manageClients.getAllClients();
					List<Manager> managers = manageManagers.getAllManagers();

					request.setAttribute("agencies", agencies);
					request.setAttribute("clients", clients);
					request.setAttribute("managers", managers);
				} catch (Exception e) {
					e.printStackTrace();
				}

				RequestDispatcher dispatcher = request.getRequestDispatcher("HomeAdmin.jsp");
				dispatcher.forward(request, response);
			}
			else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}