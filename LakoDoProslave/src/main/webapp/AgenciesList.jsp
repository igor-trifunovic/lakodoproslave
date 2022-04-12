<%@page import="classes.ManageClients"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="classes.ManageAgencies"%>
<%@page import="classes.ManageProgrammes"%>
<%@page import="java.util.ArrayList" %>
<%@page import="models.Agency" %>
<%@page import="models.Programme" %>
<%
	Agency a = new Agency();
	ManageAgencies agencies = new ManageAgencies();
	ManageProgrammes programmes = new ManageProgrammes();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Lista svih agencija</title>
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Varela+Round">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<div class="topNav">
        <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light" role="navigation">
            <div class="container">
                <a class="navbar-brand" id="title">LAKO DO PROSLAVE</a>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="HomeAdmin.jsp">Korisnici</a>
                    </li>
                </ul>
                <form action="Logout" method="POST">
            		<button type="submit" class="btn navbar-btn btn-danger btn-sm navbar-right pull-right" id="odjava">Odjavi se</button>
            	</form>
            </div>
        </nav>
    </div>
	<div class="container" style="margin-top: 100px">
        <div class="card-body">
            <div class="table-title">
                <h6 class="card-title" id="naslov">AGENCIJE</h6>
                <a class="btn badge-success" data-target="#addAgencyModal" data-toggle="modal" id="dodaj">
                    <em class="fa fa-plus"></em>
                    <span>Unesi novu agenciju</span>
                </a>
            </div>
            <table class="table table-striped table-dark table-hover table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Naziv</th>
                        <th scope="col">Grad</th>
                        <th scope="col">Adresa</th>
                        <th scope="col">Opis</th>
                        <th scope="col">OPCIJE</th>
                    </tr>
                </thead>
                <% for (Agency ag : agencies.getAllAgencies()) { %>
                <tbody>
                    <tr>
                        <td><%=ag.getName()%></td>
                        <td><%=ag.getCity()%></td>
                        <td><%=ag.getAddress()%></td>
                        <td><%=ag.getAbout()%></td>
                        <td>
                        	<form action="DeleteAgency" method="POST">
                        		<input type="hidden" value="<%=ag.getAgencyID()%>" name="username">
                        		<button type="submit" class="btn badge-danger">OBRIŠI</button>
                       		</form>
                        	<form action="EditAgency" method="GET">
                        		<input type="hidden" value="<%=ag.getAgencyID()%>" name="username">
                        		<button type="submit" class="btn badge-warning">IZMENI</button>
                       		</form>
                        </td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>