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
    <link rel="icon" href=".../img/celebrate.png" type="image/icon">
    <link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css"/>
</head> 
<body>
	<div class="login-container" id="login-container">
        <div class="header">
            <h2 class="text-center">PRIJAVA</h2>
        </div>
        <form action="Login" method="POST" class="login-form" id="login-form">
       		<% if (request.getAttribute("poruka") != null) { %> 
       			<h5 class="login_success text-center"> <%=request.getAttribute("uspeh")%></h5>  
  			<% } %>	
        	<div class="form-control">
                <label>Korisničko ime</label>
                <i class="fa fa-user icon" id="username_icon" style="margin-right: 235px; min-width: 40px; visibility: visible; color: #0ba596"></i>
                <input type="text" name="username" id="login_username">
                <small>Error message</small>
            </div>
            <div class="form-control">
                <label>Šifra</label>
                <i class="fa fa-key icon" id="pass_icon"
                    style="margin-right: 260px; visibility: visible; color: #f3b328"></i>
                <input type="password" name="password" id="login_password">
                <small>Error message</small>
            </div>
            <div class="d-flex justify-content-center">
                <button type="submit" style="color: white; text-decoration: none;">Uloguj se</button>
            </div>
        </form>
        <p class="text-center">Nemate nalog? Registrujte se <a href="Registration.jsp" style="color: #0ba596;"><b>ovde</b></a>.</p>
    </div>
</body>
</html>