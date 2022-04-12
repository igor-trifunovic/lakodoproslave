package controllers;

import classes.ClientDAO;
import classes.UserAuth;
import models.Client;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		ClientDAO manageClients = new ClientDAO();
		UserAuth userAuth = new UserAuth();
		
		try {
			manageClients.createConnection();
			if (name != "" && username != "" && email != "" && phone != "") {
				
				String password = request.getParameter("password");
				String password2 = request.getParameter("password2");
				
				if (!userAuth.checkIfUsernameExists(username)) {
					if (!manageClients.checkIfEmailExists(email)) {
						if (password.equals(password2)) {
							Client client = new Client(username, password, "client", name, email, phone);
							if (manageClients.insertClient(client)) {
								request.setAttribute("uspeh", "Uspešna registracija, možete se ulogovati na sistem.");
								request.getRequestDispatcher("index.jsp").forward(request, response);
							} else {
								request.setAttribute("greška", "Niste ispravno uneli sve podatke, pokušajte ponovo.");
								request.getRequestDispatcher("Registration.jsp").forward(request, response);
							}
						} else {
							request.setAttribute("greška", "Šifre moraju da se poklapaju.");
							request.getRequestDispatcher("Registration.jsp").forward(request, response);
						}
					} else {
						request.setAttribute("greška", "Email adresa već postoji u bazi, unesite drugu.");
						request.getRequestDispatcher("Registration.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("greška", "Korisničko ime već postoji, unesite drugo.");
					request.getRequestDispatcher("Registration.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("greška", "Niste popunili sva polja.");
				request.getRequestDispatcher("Registration.jsp").forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}