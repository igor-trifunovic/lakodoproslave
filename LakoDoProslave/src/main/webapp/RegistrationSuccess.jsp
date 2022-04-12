<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=yes">
	<title>LAKO DO PROSLAVE</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <link href="<%=request.getContextPath()%>/style1.css" rel="stylesheet" type="text/css"/>
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
            <h2 class="text-center">Registracija uspešna!</h2>
        </div>
        <p class="text-center" style="font-size: 20px; margin-top: 20px">Vratite se na <a href="HomeClient.jsp" style="text-decoration: underline">glavnu stranu</a>.</p>
    </div>
</body>
</html>