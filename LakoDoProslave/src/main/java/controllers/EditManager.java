package controllers;

import classes.*;
import models.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EditManager")
public class EditManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Manager manager = null;
	ManageAgencies agencies = new ManageAgencies();
	ManageManagers managers = new ManageManagers();
	
	
	
    public EditManager() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if (session.getAttribute("roleName") != null) {
			if (session.getAttribute("roleName").toString().equals("admin")) {
				try {
					agencies.createConnection();
					request.setAttribute("agencies", agencies.getAllAgencies());
					manager = managers.getManagerByUsername(request.getParameter("username"));
					request.setAttribute("manager", manager);
				} catch (Exception e) {
					
					e.printStackTrace();
				} 
				
				request.getRequestDispatcher("EditManager.jsp").forward(request, response);
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
				if (username != "" && name != "" && email != "" && phone != "" && request.getParameter("agencyID") != "") 
				{
					try 
					{
						manager.setUsername(username);
						manager.setName(name);
						manager.setEmail(email);
						manager.setPhone(phone);
						manager.setAgencyID(Integer.parseInt(request.getParameter("agencyID")));
						
						managers.updateManager(manager);
						response.sendRedirect("HomeAdmin.jsp");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				else 
				{
					request.setAttribute("poruka", "Sva polja moraju biti popunjena");
					request.setAttribute("manager", manager);
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
