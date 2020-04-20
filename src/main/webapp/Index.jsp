<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Index Page</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"	>
<link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
/* CSS property for nevigation menu */
.nav_menu {
	overflow: hidden;
	background-color: LightGrey;
}

.nav_menu a {
	float: left;
	display: block;
	color: blue;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.nav_menu a:hover {
	background-color: MediumSeaGreen;
	color: green;
}

.gfg {
	font-size: 40px;
	color: green;
	font-weight: bold;
	text-align: center;
}

.geeks {
	font-size: 17px;
	text-align: center;
	margin-bottom: 20px;
}

body {
	background-image: url('asserts/download.png');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}

</style>
<body style="text-align: centre">

	<div class="header">

		<div class="gfg">PrimeVideos</div>
		<div class="geeks">Destination For Entertainment</div>
	</div>


	<div class="nav_menu">
		<a href="#"><button class="btn"><em class="fa fa-home"></em> Home	</button></a> 
		<a href="LoginMailId.jsp"><button class="btn">SignIn</button></a> 
		<a href="Register.jsp"><button class="btn">SignUp</button></a> 
		<a href="search.jsp"><button class="btn"><em class="fa fa-search"></em>Search</button></a> 
		<a href="WatchedListServlet"><button class="btn">Watched Movies</button></a> 
		<a href="WatchLaterServlet"><button class="btn">WatchLater Movies</button></a> 
		<a href="ForgetPassword.jsp"><button class="btn">Change	Password</button></a> 
		<a href="PlanServlet"><button class="btn">Plans</button></a> 
		<a href="LogoutServlet"><button class="btn">SignOut</button></a>

	</div>
</body>
</html>
