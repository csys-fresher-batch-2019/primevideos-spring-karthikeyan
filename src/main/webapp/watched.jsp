<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {
	box-sizing: border-box;
}

/* CSS property for header section */
.header {
	background-color: transparent;
	padding: 15px;
	text-align: center;
}

.header1 {
	background-color: Transparent;
	text-align: center;
	padding: 10px;
	font-size: 10px;
}

/* CSS property for nevigation menu */
.nav_menu {
	overflow: hidden;
	background-color: Tomato;
}

.nav_menu a {
	float: left;
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.nav_menu a:hover {
	background-color: white;
	color: green;
}

.columnA {
	float: left;
	width: 50%;
	padding: 35px;
	text-align: centre;
}

.columnB {
	float: left;
	width: 50%;
	padding: 50px;
	text-align: justify;
}

h2 {
	color: green;
	text-align: center;
}

h6 {
	color: Black;
	text-align: left;
	font-size: 80%;
}

/* Media query to set website layout  
            according to screen size */
@media screen and (max-width:600px) {
	.columnA, .columnB {
		width: 50%;
	}
}

@media screen and (max-width:400px) {
	.columnA, .columnB {
		width: 100%;
	}
}

img {
	border-radius: 5px;
	max-width: 100%;
	height: auto;
}

body {
	background-image: url('asserts/download.png');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
</
head
>
</style>
<body>
	<jsp:include page="Index1.jsp"></jsp:include>
	<div class="header1">
		<h2 style="color: white; font-size: 200%">Watched Movies</h2>
	</div>
	<c:forEach items="${watchedmovies}" var="l">

		<div class="row">

			<div class="columnA">
				<a href="ViewMoviesServlet?id=${l.primeId}"> <img
					src="asserts/${l.nameofVideo}.jpg" width="300" height="300"
					alt="${l.nameofVideo}"></a>
			</div>

			<div class="columnB">
				<p>Prime ID :${l.primeId}</p>
				<p>Movie :${l.nameofVideo}</p>
			</div>
		</div>
	</c:forEach>

</body>
</html>
