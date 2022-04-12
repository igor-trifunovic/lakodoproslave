<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="classes.*" %>
<%@page import="models.*" %>

<%
	Agency agency = (Agency)session.getAttribute("agency");
%>

<%
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);
	
	if (session.getAttribute("client") == null) {
		response.sendRedirect("ErrorPage.jsp");
	}
%>
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
    <link href="<%=request.getContextPath()%>/style.css" rel="stylesheet" type="text/css"/>
    <title>Detalji ponude agencije</title>
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
        <%
        ProgrammeDAO mp = new ProgrammeDAO(); 
                	Programme programme = mp.getProgrammeByAgencyID(agency);
        %>
	<div class="programme_container" id="programme_container" style="margin-top: 100px">
        <div class="header">
            <h2 class="text-center">DETALJI PONUDE</h2>
        </div>
        <div class="modal-body">
            <p>Soba za igru: <%=programme.getGameRoom()%> din.</p>
            <p>Animator: <%=programme.getAnimator()%> din.</p>
            <p>Diskoteka: <%=programme.getDisco()%> din.</p>
            <p>Piće: <%=programme.getDrinks()%> din po litru.</p>
            <p>Hrana: <%=programme.getFood()%> din po kg.</p>
        </div>
        <p class="text-center">Nemate nalog? Registrujte se <a href="Registration.jsp" style="color: #0ba596;"><b>ovde</b></a>.</p>
    </div>
</body>
</html>