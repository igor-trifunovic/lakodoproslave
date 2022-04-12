package controllers;

import classes.*;
import models.*;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/InsertManager")
public class InsertManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ManageAgencies agencies = new ManageAgencies();
	
    public InsertManager() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session = request.getSession();
    	
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		if (session.getAttribute("roleName") != null) {
			if (session.getAttribute("roleName").toString().equals("admin")) {
				
				ManageManagers managers = new ManageManagers();
				UserAuth userAuth = new UserAuth();
				try {
					managers.createConnection();
					if (name != "" && username != "" && email != "" && phone != "" && request.getParameter("agencyID") != "none") 
					{
						if (!userAuth.checkIfUsernameExists(username)) 
						{
							if (password.equals(password2)) 
							{
								Manager manager = new Manager(username, password,
										"manager", name, email, phone, Integer.parseInt(request.getParameter("agencyID")));
								if (managers.insertManager(manager)) 
								{
									response.sendRedirect("HomeAdmin.jsp");
								} else {
									request.setAttribute("poruka", "Neispravno uneti podaci, pokušajte opet.");
									request.getRequestDispatcher("InsertManager.jsp").forward(request, response);
								}
							} else {
								request.setAttribute("poruka", "Šifre se ne poklapaju, pokušajte opet.");
								request.getRequestDispatcher("InsertManager.jsp").forward(request, response);
							}
						} else { 
							request.setAttribute("poruka", "Username već postoji, unesite drugo.");
							request.getRequestDispatcher("InsertManager.jsp").forward(request, response);
						}
					} else {
						request.setAttribute("poruka", "Sva polja moraju biti popunjena.");
						request.getRequestDispatcher("InsertManager.jsp").forward(request, response);
					}

				} catch (Exception e) {
					e.printStackTrace();
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
