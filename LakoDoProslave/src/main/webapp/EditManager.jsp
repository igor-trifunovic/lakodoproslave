<%@page import="classes.ManageManagers"%>
<%@page import="classes.ManageAgencies"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@page import="models.*"%>
<%@page import="java.util.*"%>  
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css">
    <title>Izmena podataka o menadžeru</title>
</head>
<body>
    <nav class="navbar fixed-top navbar-default navbar-expand-lg navbar-light bg-light" role="navigation">
        <div class="container">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a href="HomeAdmin.jsp" class="nav-link" id="title">Početna strana</a>
                </li>
                <li class="nav-item active">
                    <a href="#" class="nav-link" id="top-link" style="font-weight: bold;">Vrh strane</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="reg-container" id="reg-container">
        <div class="header">
            <h2 class="text-center">IZMENA MENADŽERA</h2>
            <h6 class="text-center">Ovde možete izmeniti podatke o menadžeru.</h6>
        </div>
        <form action="EditManager" method="POST" class="signup-form" id="signup-form">
        	<% if (request.getAttribute("poruka") != null) { %> 
       			<h5 class="registration_error text-center"> <%=request.getAttribute("poruka") %></h5>  
  			<% } %>
  			<% Manager manager = (Manager) request.getAttribute("manager"); %>
  			<div class="form-control">
                <label>Ime</label>
                <input type="text" name="name" id="name" value="<%=manager.getName()%>">
            </div>
            <div class="form-control">
                <label>Korisničko ime</label>
                <input type="text" name="username" id="username" value="<%=manager.getUsername()%>">
            </div>
            <div class="form-control">
                <label>Email</label>
                <input type="email" name="email" id="email" value="<%=manager.getEmail()%>">
            </div>
            <div class="form-control">
                <label>Telefon</label>
                <input type="text" name="phone" id="phone" value="<%=manager.getPhone()%>">
            </div>
            <% ManageAgencies agencies = new ManageAgencies(); %>
            <div class="form-control">
                <label>Agencija</label>
                <select id="agencyID" name="agencyID" class="custom-select">
                	<option selected value="none">Izaberite agenciju</option>
	               	<% for (Agency ag : agencies.getAllAgencies()) { %>
	                   	<option value="<%=ag.getAgencyID()%>"><%=ag.getName()%></option>
	                <% } %>    
               </select>
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit">Izmeni</button>
            </div>
        </form>
    </div>
</body>    