
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Video Player</title>
</head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {
	box-sizing: border-box;
}

/* CSS property for header section */
.header {
	background-color: green;
	padding: 15px;
	text-align: center;
}

.header1 {
	background-color: Tomato;
	text-align: center;
	padding: 10px;
	font-size: 10px;
}

/* CSS property for nevigation menu */
.nav_menu {
	overflow: hidden;
	background-color: #333;
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

/* CSS property for content section */
.columnA {
	float: left;
	width: 100%;
	padding: 15px;
	text-align: justify;
}

video {
	max-width: 100%;
	height: auto;
}

.btn {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 12px 16px;
	font-size: 16px;
	cursor: pointer;
}

/* Darker background on mouse-over */
.btn:hover {
	background-color: RoyalBlue;
}
</style>
<body>
	<%
		String moviename = (String) request.getParameter("movien");
	%>
	<jsp:include page="Index1.jsp"></jsp:include>
	<div class="header1">
		<h2 style="color: white; font-size: 200%">
			<p><%=moviename %></p>
		</h2>
	</div>

	<div class="row">

		<div class="columnA">
			<video width="1366" controls>
				<source src="asserts/videos/<%=moviename %>.mp4" type="video/mp4">
			<p>Your browser does not support HTML5 video.</p>
			</video>

			<p>
				Video courtesy of <a target="_blank"> Prime Videos</a>.
			</p>
		</div>
		</div>
</body>
</html>