package controllers;

import java.io.IOException;
import models.Agency;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewProgramme
 */
@WebServlet("/ViewProgramme")
public class ViewProgramme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Agency agency = new Agency();
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession sesija = request.getSession();
    	sesija.setAttribute("agency", agency);
    	response.sendRedirect("ProgrammeDetails.jsp");
	}

}
