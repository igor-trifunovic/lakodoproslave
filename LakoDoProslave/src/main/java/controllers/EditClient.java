package controllers;

import classes.*;
import models.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EditClient")
public class EditClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Client client = null;
	ManageClients clients = new ManageClients();
	
	public EditClient() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("roleName") != null) {
			if (session.getAttribute("roleName").toString().equals("admin")) {
				try {
					client = clients.getClientByUsername(request.getParameter("username"));
					request.setAttribute("client", client);
				} catch (Exception e) {
					
					e.printStackTrace();
				} 
				
				request.getRequestDispatcher("EditClient.jsp").forward(request, response);
			}
			else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		if (session.getAttribute("roleName") != null) {
			if (session.getAttribute("roleName").toString().equals("admin")) {
				if (username != "" && name != "" && email != "" && phone != "") 
				{
					try 
					{
						client.setUsername(username);
						client.setName(name);
						client.setEmail(email);
						client.setPhone(phone);
						
						clients.updateClient(client);
						request.getRequestDispatcher("HomeAdmin.jsp").forward(request, response);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else 
				{
					request.setAttribute("poruka", "Niste popunili sva polja.");
					request.setAttribute("client", client);
					request.getRequestDispatcher("EditManager.jsp");
				}
			}
			else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

}
