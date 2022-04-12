<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<%@page import="models.*" %>
<%@page import="classes.*"%>
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
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
    <title>Admin strana</title>
</head>
<body>
	<nav class="navbar navbar-default navbar-expand-lg navbar-light bg-light" role="navigation">
        <div class="container">
            <a href="#" class="navbar-brand" id="title">LAKO DO PROSLAVE</a>
            <ul class="navbar-nav mr-auto">
            	<li class="nav-item active">
                    <a class="nav-link" href="AgenciesList.jsp">Agencije</a><span class="sr-only">(current)</span>
                </li>
            </ul>
            <form action="Logout" method="POST">
            	<button type="submit" class="btn navbar-btn btn-danger btn-sm navbar-right pull-right" id="odjava">Odjavi se</button>
            </form>
        </div>
    </nav>
    <div class="container" style="margin-top: 100px">
        <div class="card-body">
            <div class="table-title">
                <h6 class="card-title" id="naslov">KLIJENTI</h6>
            </div>
            <table class="table table-striped table-dark table-hover table-bordered">
                <thead>
                    <tr>
                        <th scope="col">Username</th>
                        <th scope="col">Ime i prezime</th>
                        <th scope="col">Email</th>
                        <th scope="col">Telefon</th>
                        <th scope="col">OPCIJE</th>
                    </tr>
                </thead>
                <%
                ClientDAO clients = new ClientDAO();
                %>
				<tbody>
					<% for (Client c : clients.getAllClients()) { %>
                    <tr>
                    	<td><%=c.getUsername()%></td>
                        <td><%=c.getName()%></td>
                        <td><%=c.getEmail()%></td>
                        <td><%=c.getPhone()%></td>
                        <td>
                        	<form action="DeleteClient" method="POST">
                        		<input type="hidden" value="<%=c.getUsername()%>" name="username">
                        		<button type="submit" class="btn badge-danger">OBRIŠI</button>
                       		</form>
                        	<form action="EditClient" method="GET">
                        		<input type="hidden" value="<%=c.getUsername()%>" name="username">
                        		<button type="submit" class="btn badge-warning">IZMENI</button>
                       		</form>
                        </td>
                    </tr>
                	<% } %>
                </tbody>
            </table>
        </div>
    </div>
    <br>
    <div class="container">
        <div class="card-body">
            <div class="table-title">
                <h6 class="card-title" id="naslov">MENADŽERI</h6>
                <a href="InsertManager.jsp" class="btn badge-success" id="dodaj">
                    <em class="fa fa-plus"></em>
                    <span>Unesi novog menadžera</span>
                </a>
            </div>
            <table class="table table-striped table-dark table-hover table-bordered">
                <thead>
                    <tr>
                        <th>Username</th>
                        <th>Ime i prezime</th>
                        <th>Email</th>
                        <th>Telefon</th>
                        <th>Agencija ID</th>
                        <th>OPCIJE</th>
                    </tr>
                </thead>
                <%
                ManagerDAO managers = new ManagerDAO();
                %>
                <tbody>
                	<% for (Manager m : managers.getAllManagers()) { %>
                    <tr>
                        <td><%=m.getUsername()%></td>
                        <td><%=m.getName()%></td>
                        <td><%=m.getEmail()%></td>
                        <td><%=m.getPhone()%></td>
                        <td><%=m.getAgencyID()%></td>
                        <td>
                        	<form action="DeleteManager" method="POST">
                        		<input type="hidden" value="<%=m.getUsername()%>" name="username">
                        		<button class="btn badge-danger" type="submit">OBRIŠI</button>
                        	</form>
                            <form action="EditManager" method="GET">
                            	<input type="hidden" value="<%=m.getUsername()%>" name="username">
                            	<button class="btn badge-warning" type="submit">IZMENI</button>
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