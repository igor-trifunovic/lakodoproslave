package controllers;

import classes.*;
import models.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/EditAgency")
public class EditAgency extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Agency agency = null;
	Programme programme = null;
	ManageAgencies agencies = new ManageAgencies();
	ManageProgrammes programmes = new ManageProgrammes();
    
	public EditAgency() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String agencyID = request.getParameter("agencyID");
		
		if (session.getAttribute("roleName") != null) {
			if (session.getAttribute("roleName").toString().equals("admin")) {
				agencies.createConnection();
				programmes.createConnection();
					
				request.setAttribute("agency", agencies.getAgencyByAgencyId(agencyID));
				request.setAttribute("programme", programmes.getProgrammeByAgencyID(agencies.getAgencyByAgencyId(agencyID)));
				request.getRequestDispatcher("EditAgency.jsp").forward(request, response);
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
		String agencyID = request.getParameter("agencyID");
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String image = request.getParameter("image");
		String about = request.getParameter("about");
		String programmeID = request.getParameter("programmeID");
		String gameRoom = request.getParameter("gameRoom");
		String animator = request.getParameter("animator");
		String disco = request.getParameter("disco");
		String drinks = request.getParameter("drinks");
		String food = request.getParameter("food");
		
		if (session.getAttribute("role") != null) {
			
			if (session.getAttribute("role").toString().equals("admin")) {
				
				if(agencyID != "" && name != "" && city != "" && address != "" && 
						phone != "" && image != "" && about != "" &&
						programmeID != "" && gameRoom != "" && animator != "" && 
						disco != "" && drinks != "" && food != "") 
				{
					agency = new Agency(Integer.parseInt(agencyID), name, city, address, phone, image, about, Integer.parseInt(programmeID));
					
					programme = new Programme(
						Integer.parseInt(programmeID),
						Integer.parseInt(gameRoom),
						Integer.parseInt(animator),
						Integer.parseInt(disco),
						Integer.parseInt(drinks),
						Integer.parseInt(food)
					);
					
					agencies.updateAgency(agency);
					programmes.updateProgramme(programme);
					request.getRequestDispatcher("HomeAdmin.jsp").forward(request, response);
				}
				else {
					request.setAttribute("poruka", "Nisu sva polja popunjena.");
					request.getRequestDispatcher("EditAgency.jsp").forward(request, response);
				}
			}
			else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}	
	}

}