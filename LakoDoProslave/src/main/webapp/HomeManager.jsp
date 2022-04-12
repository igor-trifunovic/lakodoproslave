<%@page import="models.Reservation"%>
<%@page import="classes.ManageReservations"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% ManageReservations reservations = new ManageReservations(); %>
<%
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader("Expires", 0);

	if (session.getAttribute("manager") == null) {
		response.sendRedirect("ErrorPage.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
    <title>Početna strana</title>
</head>
<body>
    <!--<div class="topNav">
        <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light" role="navigation">
            <div class="container">
                <a class="navbar-brand" href="#" id="title">LAKO DO PROSLAVE</a>
                <form action="Logout" method="POST">
            		<button type="submit" class="btn navbar-btn btn-danger btn-sm navbar-right pull-right" id="odjava">Odjavi se</button>
            	</form>
            </div>
        </nav>
    </div> -->
    <div class="topNav">
        <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light" role="navigation">
            <div class="container">
                <a class="navbar-brand" id="title" href="#">LAKO DO PROSLAVE</a>
                <form action="Logout" method="POST">
            		<button type="submit" class="btn navbar-btn btn-danger btn-sm navbar-right pull-right" id="odjava">Odjavi se</button>
            	</form>
            </div>
        </nav>
    </div>
    <div class="container" style="margin-top: 100px">
        <div class="card-body">
            <div class="table-title">
                <h6 class="card-title" id="naslov">REZERVACIJE</h6>
            </div>
            <table class="table table-striped table-dark table-hover table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Rezervacija ID</th>
                        <th scope="col">Datum</th>
                        <th scope="col">Početak</th>
                        <th scope="col">Kraj</th>
                        <th scope="col">Agencija</th>
                        <th scope="col">OPCIJE</th>
                    </tr>
                </thead>
                <% for (Reservation r : reservations.getAllReservations()) { %>
                <tbody>
                    <tr>
                        <td><%=r.getReservationID()%></td>
                        <td><%=r.getDate()%></td>
                        <td><%=r.getStartTime()%></td>
                        <td><%=r.getEndTime()%></td>
                        <td><%=r.getAgencyID()%></td>
                        <td>
                        	<button type="reset" class="btn badge-danger" data-toggle="modal" data-target="#editReservationModal">OBRIŠI</button>
                        	<button type="submit" class="btn badge-warning" data-toggle="modal" data-target="#deleteReservationModal">IZMENI</button>
                        </td>
                    </tr>
                <% } %>
                </tbody>
            </table>
        </div>
    </div>
    <div id="editReservationModal" class="modal fade" role="modal">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="EditReservation" method="POST">
                    <div class="modal-header">
                        <h4 class="modal-title">Izmena podataka o rezervaciji</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <div class="form-control">
                            <label>Ime</label>
                            <input type="text" name="name" required>
                        </div>
                        <div class="form-control">
                            <label>Username</label>
                            <input type="text" name="username" required>
                        </div>
                        <div class="form-control">
                            <label>Šifra</label>
                            <input type="text" name="password" required>
                        </div>
                        <div class="form-control">
                            <label>Email</label>
                            <input type="email" name="email" required>
                        </div>
                        <div class="form-control">
                            <label>Telefon</label>
                            <input type="text" name="phone" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-danger" data-dismiss="modal" value="Otkaži">
                        <input type="submit" class="btn btn-success" value="Izmeni">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div id="deleteReservationModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="DeleteReservation" method="POST">
                    <div class="modal-header">
                        <h4 class="modal-title">Brisanje rezervacije</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    </div>
                    <div class="modal-body">
                        <p>Da li ste sigurni da želite da obrišete izabranu rezervaciju?</p>
                    </div>
                    <div class="modal-footer">
                        <input type="button" class="btn btn-default" data-dismiss="modal" value="Otkaži">
                        <input type="submit" class="btn btn-danger" value="Obriši">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="js/script.js"></script>
</body>