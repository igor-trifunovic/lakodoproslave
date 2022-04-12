<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<%
	response.setHeader("Cache-Control","no-cache");
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragma","no-cache");
	response.setDateHeader ("Expires", 0);

	if (session.getAttribute("client") == null) {
		response.sendRedirect("ErrorPage.jsp");
	}
--%>    
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
    <title>Rezervacija uspešna!</title>
</head>
<body>
	<nav class="navbar fixed-top navbar-default navbar-expand-lg navbar-light bg-light" role="navigation">
        <div class="container">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a href="index.jsp" class="nav-link" id="title">Početna strana</a>
                </li>
            </ul>
        </div>
    </nav>
	<div class="success-container">
        <div class="success-header">
            <h2 class="text-center">Rezervacija uspešna!</h2>
        </div>
        <p class="text-center" style="font-size: 20px; margin-top: 20px">Vratite se na <a href="HomeClient.jsp" style="text-decoration: underline">glavnu stranu</a>.</p>
    </div>
</body>
</html>