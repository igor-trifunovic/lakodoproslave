<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>Greška!</title>
</head>
<body>
	<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light" role="navigation">
        <div class="container">
            <a class="navbar-brand" id="title" href="index.jsp">Početna strana</a>
        </div>
    </nav>
	<div class="error-container">
        <div class="error-header">
            <h2 class="text-center">GREŠKA!</h2>
        </div>
        <p class="text-center" style="font-size: 30px;">Morate biti ulogovani da biste posetili ovu stranu.</p>
        <p class="text-center" style="font-size: 20px;">Za logovanje kliknite <a href="index.jsp">ovde</a>.</p>
    </div>
</body>
</html>