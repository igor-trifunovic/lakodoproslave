<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="classes.*"%>
<%@page import="models.*"%>
<% ManageReservations manageRes = new ManageReservations(); %>
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
<div class="container" style="margin-top: 100px">
    <div class="card-body">
        <div class="table-title">
            <h6 class="card-title" id="naslov">REZERVACIJE</h6>
        </div>
        <table class="table table-striped table-dark table-hover table-bordered">
            <thead>
                <tr>
                	<th scope="col">Ime</th>
                    <th scope="col">Datum</th>
                    <th scope="col">Početak</th>
                    <th scope="col">Kraj</th>
                    <th scope="col">Piće</th>
                    <th scope="col">Hrana</th>
                    <th scope="col">OPCIJE</th>
                </tr>
            </thead>
            <% for (Reservation r : manageRes.getAllReservations()) { %>
            <tbody>
                <tr>
                	<td><%=r.getName()%></td>
                    <td><%=r.getDate()%></td>
                    <td><%=r.getStartTime()%></td>
                    <td><%=r.getEndTime()%></td>
                    <td><%=r.getDrinks()%> l</td>
                    <td><%=r.getFood()%> kg</td>
                    <td>
                    	<button type="reset" class="btn badge-danger" data-toggle="modal" data-target="#deleteReservationModal">OTKAŽI</button>
                    	<button type="submit" class="btn badge-warning" data-toggle="modal" data-target="#editReservationModal">IZMENI</button>
                    </td>
                </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>