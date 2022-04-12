<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="classes.*" %>    
<%@page import="models.*" %>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
    <title>Rezervacija proslave</title>
</head>
<body>
    <div class="topNav">
    	<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light" role="navigation">
            <div class="container">
                <a class="navbar-brand" id="title" href="#">LAKO DO PROSLAVE</a>
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="HomeClient.jsp">Početna strana</a>
                    </li>
                </ul>
                <form action="Logout" method="POST">
            		<button type="submit" class="btn navbar-btn btn-danger btn-sm navbar-right pull-right" id="odjava">Odjavi se</button>
            	</form>
            </div>
        </nav>
    </div><br>
    <div class="res-container" id="res-container">
        <div class="header">
            <h2 class="text-center">REZERVACIJA</h2>
            <h6 class="text-center">Ovde možete rezervisati proslavu.</h6>
        </div>
        <form action="ReservationServlet" method="POST" class="signup-form" id="signup-form">
        	<% if (request.getAttribute("poruka") != null) { %> 
       			<h5 class="registration_error text-center"> <%=request.getAttribute("poruka") %></h5>  
  			<% } %>
            <div class="form-control">
                <label>Ime i prezime</label>
                <input type="text" name="name" id="name">
            </div>
            <div class="form-control">
                <label>Telefon</label>
                <input type="text" name="phone" id="phone">
            </div>
            <div class="form-control">
                <label>Email</label>
                <input type="email" name="email" id="email">
            </div>
            <div class="form-control">
            	<label>Datum</label>
            	<input type="date" name="date" id="date">
            </div>
            <div class="form-control">
            	<label>Početak</label>
            	<input type="time" min="15:00" max="19:00" name="start_time" id="start_time">
            </div>
            <div class="form-control">
            	<label>Kraj</label>
            	<input type="time" min="17:00" max="22:00" id="end_time">
            </div>
            <hr>
            <div class="form-check form-control">
                <label class="label-check" id="label-check">Igraonica
                    <input type="checkbox" value="true" name="gameRoom" id="gameRoom">
                    <span class="checkmark"></span>
                </label>
            </div>
            <div class="form-check form-control">
                <label class="label-check" id="label-check">Diskoteka
                    <input type="checkbox" value="true" name="disco" id="disco">
                    <span class="checkmark"></span>
                </label>
            </div>
            <div class="form-check form-control">
                <label class="label-check" id="label-check">Animator
                    <input type="checkbox" value="true" name="animator" id="animator">
                    <span class="checkmark"></span>
                </label>
            </div>
            <div class="input-drink form-control">
                <label>Piće:</label>
                <input type="text" name="drinks" id="drinks">
                <label>litara</label>
            </div>
            <div class="input-food form-control">
                <label>Hrana:</label>
                <input type="text" name="food" id="food">
                <label>kg</label>
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit">Rezerviši</button>
            </div>
        </form>
    </div>
</body>
</html>