<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.chainsys.primevideos.model.PrimeRelease"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Display Search Result</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="js/like-dislike.js"></script>

<style>

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
	<c:forEach items="${movies}" var="l">
	<div class="left">
			<div class="card-desk" class="left">
	<div class="card" style="width: 18rem; height: 40rem">
	<a href="ViewMoviesServlet?id=${l.primeId}"> 
  <img src="asserts/${l.nameOfVideo}.jpg"  class="card-img-top"  alt="${l.nameOfVideo}"></a>
  <div class="card-body">
    <p class="card-text">PrimeId:${l.primeId}</p>
    <p class="card-text">Genre:${l.genre}</p>
    <p class="card-text">IMDB:${l.imdbRating}</p>
    <p class="card-text"><em class="fa fa-thumbs-o-up">${l.totalLikes}</em> 
								<em class="fa fa-thumbs-o-down">${l.totalDislikes}</em></p>
  </div>
  </div>
  </div>
</div>
	</c:forEach>
</body>
</html>