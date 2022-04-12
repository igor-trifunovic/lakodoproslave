<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="classes.*"%>
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
    <title>Izmena podataka o agenciji</title>
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
            <h2 class="text-center">IZMENA AGENCIJE</h2>
            <h6 class="text-center">Ovde možete izmeniti podatke o agenciji.</h6>
        </div>
        <form action="EditClient" method="POST" class="signup-form" id="signup-form">
        	<% if (request.getAttribute("poruka") != null) { %> 
       			<h5 class="registration_error text-center"> <%=request.getAttribute("poruka") %></h5>  
  			<% } %>
  			<% Agency agency = (Agency) request.getAttribute("agency"); %>
  			<div class="form-control">
                <label>Agencija ID</label>
                <input type="text" name="agencyID" id="agencyID" value="<%=agency.getAgencyID()%>">
            </div>
            <div class="form-control">
                <label>Naziv</label>
                <input type="text" name="name" id="name" value="<%=agency.getName()%>">
            </div>
            <div class="form-control">
                <label>Grad</label>
                <input type="text" name="city" id="city" value="<%=agency.getCity()%>">
            </div>
            <div class="form-control">
                <label>Adresa</label>
                <input type="text" name="address" id="address" value="<%=agency.getAddress()%>">
            </div>
            <div class="form-control">
                <label>Telefon</label>
                <input type="text" name="phone" id="phone" value="<%=agency.getPhone()%>">
            </div>
            <div class="form-control">
                <label>Slika</label>
                <input type="text" name="image" id="image" value="<%=agency.getImage()%>">
            </div>
            <div class="form-control">
                <label>Opis</label>
                <input type="text" name="about" id="about" value="<%=agency.getAbout()%>">
            </div>
            <div class="form-control">
                <label>Ponuda</label>
                <input type="text" name="programme" id="programme" value="<%=agency.getProgrammeID()%>">
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit">Izmeni</button>
            </div>
            <hr>
            
        </form>
    </div>
</body>    