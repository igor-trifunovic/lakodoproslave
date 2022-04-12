package controllers;

import classes.*;
import models.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = null;
		ManageAdmins admin = new ManageAdmins();
		ManageClients client = new ManageClients();
		ManageManagers manager = new ManageManagers();
		UserAuth userAuth = new UserAuth();
		
		try {
			user = userAuth.authenticateUser(username, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if (user != null) {
			
			session.setAttribute("username", user.getUsername());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("roleName", user.getRoleName());
			
			if (user.getRoleName().equals("client")) {
				session.setAttribute("client", client);
				session.setMaxInactiveInterval(2 * 60 * 60);
				response.sendRedirect("HomeClient.jsp");
			}
			if (user.getRoleName().equals("manager")) {
				session.setAttribute("manager", manager);
				session.setMaxInactiveInterval(2 * 60 * 60);
				request.getRequestDispatcher("HomeManager.jsp").forward(request, response);
			}
			if (user.getRoleName().equals("admin")) {
				session.setAttribute("admin", admin);
				session.setMaxInactiveInterval(2 * 60 * 60);
				request.getRequestDispatcher("HomeAdmin.jsp").forward(request, response);
			}
			
		} else {
			request.setAttribute("poruka", "Neispravno uneti podaci, pokušajte ponovo.");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}