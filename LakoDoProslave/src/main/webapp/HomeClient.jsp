<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="models.*"%>
<%@page import="classes.*"%>
<%  ManageAgencies agencies = new ManageAgencies(); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="bootstrap-grid.css">
    <link rel="stylesheet" href="bootstrap-grid.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
    <title>Dobrodošli!</title>
</head>
<body>
    <div class="topNav">
        <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light" role="navigation">
            <div class="container">
                <a class="navbar-brand" id="title" href="#">LAKO DO PROSLAVE</a>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active"><a class="nav-link" href="ReservationsList.jsp">Moje rezervacije</a></li>
                </ul>
                <form action="Logout" method="POST">
            		<button type="submit" class="btn navbar-btn btn-danger btn-sm navbar-right pull-right" id="odjava">Odjavi se</button>
            	</form>
            </div>
        </nav>
    </div>
    <div class="title-container">
        <h1 class="display-3">DOBRODOŠLI! &#128522;</h1>
        <h2 class="display-4">Vršimo rezervacije proslava rođendana.</h2><br>
        <h5 style="color: black">U nastavku možete pogledati dostupne agencije.</h5>
    </div>
    <div class="agency-container">
	        <% for (Agency ag : agencies.getAllAgencies()) { %>
	        <div class="card mb-3 mx-auto" style="width: 1200px;">
	            <div class="row no-gutters">
	                <div class="col-md-4">
	                    <img src="img/<%=ag.getImage()%>" class="card-img-top" id="agency_photo">
	                </div>
	                <div class="col-md-4" style="background-color: #b8ebf1">
	                    <div class="card-body">
	                        <h5 class="card-title"><%=ag.getName()%></h5>
	                        <p class="card-text"><%=ag.getAbout()%></p>
	                        <p class="card-text text-primary font-weight-bold"><%=ag.getAddress()%>, <%=ag.getCity()%></p>
	                        <p class="card-text"><b>Broj telefona:</b> <%=ag.getPhone()%></p>
	                    </div>
	                    <form action="ReservationServlet" method="GET">
	                    	<input type="hidden" value="<%=ag.getAgencyID()%>" name="agencyID"> 
							<input type="hidden" value="<%=ag.getProgrammeID()%>" name="programmeID">
						    <input type="submit" id="res_button" class="btn btn-info font-weight-bold" value="Idi na rezervaciju">
	                    </form>
	                </div>
	                <%  ManageProgrammes programmes = new ManageProgrammes(); 
	                	programmes.createConnection();
	                	Programme programme = programmes.getProgrammeByAgencyID(ag);
	                %>
	                <div class="col-md-4" id="ponuda" style="background-color: #f6eec3">
	                	<div class="modal-body">
	                		<h4 class="modal-title" style="text-decoration: underline"><b>PONUDA</b></h4><br>
	                        <p>Soba za igru: <%=programme.getGameRoom()%> din.</p>
	                        <p>Animator: <%=programme.getAnimator()%> din.</p>
	                        <p>Diskoteka: <%=programme.getDisco()%> din.</p>
	                        <p>Piće: <%=programme.getDrinks()%> din po litru.</p>
	                        <p>Hrana: <%=programme.getFood()%> din po kg.</p>
	                    </div>
	                </div>
	            </div>
	        </div><br>
	   		<% } %>
    </div>
    <script src="js/script.js"></script>
</body>
</html>