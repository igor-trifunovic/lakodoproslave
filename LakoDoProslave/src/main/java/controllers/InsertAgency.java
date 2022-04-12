package controllers;

import classes.*;
import models.*;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/InsertAgency")
public class InsertAgency extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AgencyDAO agencies = new AgencyDAO();
	ProgrammeDAO programmes = new ProgrammeDAO();
	Programme programme = null;
	Agency agency = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}