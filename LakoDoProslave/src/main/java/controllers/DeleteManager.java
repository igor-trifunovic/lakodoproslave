package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.ManagerDAO;

/**
 * Servlet implementation class DeleteManager
 */
@WebServlet("/DeleteManager")
public class DeleteManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	ManagerDAO managers = new ManagerDAO();
	
    public DeleteManager() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		managers.deleteManagerByUsername(request.getParameter("username"));
		response.sendRedirect("HomeAdmin.jsp");
	}

}
