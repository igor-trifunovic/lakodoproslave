package controllers;

import classes.ManageAgencies;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteAgency
 */
@WebServlet("/DeleteAgency")
public class DeleteAgency extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManageAgencies agencies = new ManageAgencies();
	
    public DeleteAgency() {
        super();
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String agencyID = request.getParameter("agencyID");
    	agencies.deleteAgencyByID(Integer.parseInt(agencyID));
    	request.getRequestDispatcher("AgenciesList.jsp").forward(request, response);
	}

}