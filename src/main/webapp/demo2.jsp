<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.primevideos.model.PrimeReleases"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/like-dislike.js"></script>
</head>

<style>

<style>
.left{
float:left;
padding-left: 20px;
padding-right: 20px;
padding-top: 20px;
padding-bottom: px;
}
.cent{
float:
padding-left: 20px;
padding-right: 20px;
padding-top: 20px;
padding-bottom: 60px;
}
.right{
float:right;

* {
	box-sizing: border-box;
}
/* CSS property for header section */
.header {
	background-color: orange;
	padding: 15px;
	text-align: center;
}
.header1 {
	background-color: transparent;
	text-align: center;
	padding: 10px;
	font-size: 10px;
}
/* CSS property for nevigation menu */
.nav_menu {
	overflow: hidden;
	background-color: tomato;
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
.gfg {
	font-size: 40px;
	color: Green;
	font-weight: bold;
	text-align: center;
}
.gfg3 {
	font-size: 20px;
	color: Green;
	font-weight: bold;
	text-align: center;
}
.left {
	float: left;
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: px;
}
.cent {
	float: padding-left: 20px;
	padding-right: 20px;
	padding-top: 20px;
	padding-bottom: 60px;
}
.right {
	float: right;
}
h6 {
	color: green;
	text-align: centre;
	font-size: 40%;
}
body {
	background-image: url('asserts/back.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}
.like, .dislike {
	display: inline-block;
	margin-bottom: 0;
	font-weight: normal;
	text-align: center;
	vertical-align: right;
	cursor: pointer;
	background: transparent;
	border: 1px solid transparent;
	white-space: nowrap;
	padding: 6px 12px;
	font-size: 14px;
	line-height: 1.428571429;
	border-radius: 4px;
}
.qty1, .qty2 {
	border: none;
	width: 20px;
	background: transparent;
}
</style>
<body>
	<jsp:include page="search.jsp"></jsp:include>

	<%
		ArrayList<PrimeReleases> list = (ArrayList) request.getAttribute("movies");
	%>

	<div>
		<%
			if (list != null) {
		%>
		<%
			for (PrimeReleases cd1 : list) {
		%>
		<div class="left">
			<div class="card-desk" class="left">
				<div class="card" style="width: 15rem; height: 30rem">
					<a href="ViewMoviesServlet?id=<%=cd1.getPrimeId()%>"> <img
						src="asserts/<%=cd1.getNameofVideo()%>.jpg" class="card-img-top"
						alt="<%=cd1.getNameofVideo()%>"></a>
					<div class="card-body">
						<div class="gfg">
							<h6 class="card-text">
								<centre>PrimeId:<%=cd1.getPrimeId()%></centre>
							</h6>
							
						</div>
						<div class="gfg">
							<h6 class="card-text">
								<centre>Genre:<%=cd1.getGenre()%></centre>
							</h6>
							
						</div>
						<div class="gfg">
							<h6 class="card-number">
							<centre>IMDB:<%=cd1.getImdbRating()%></centre>
							</h6>
							
						</div>
						<div class="gfg">
							<h6>
								<i class="fa fa-thumbs-o-up"><%=cd1.getTlikes()%></i> 
								<i class="fa fa-thumbs-o-down"><%=cd1.getTdislikes()%></i>
							</h6>
							

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
		}
	%>
	<%
		}
	%>
	</div>
	</form>
</body>
</html>