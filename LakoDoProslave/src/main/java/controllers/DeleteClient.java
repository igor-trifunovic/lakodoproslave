package controllers;

import classes.ClientDAO;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class DeleteClient
 */
@WebServlet("/DeleteClient")
public class DeleteClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ClientDAO clients = new ClientDAO();
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
    	clients.deleteClientByUserName(username);
    	request.getRequestDispatcher("HomeAdmin.jsp").forward(request, response);
	}

}