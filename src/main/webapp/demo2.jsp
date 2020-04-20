<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.primevideos.model.PrimeRelease"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Demo2</title>
</head>
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
		ArrayList<PrimeRelease> list = (ArrayList) request.getAttribute("movies");
	%>

	<div>
		<%
			if (list != null) {
		%>
		<%
			for (PrimeRelease cd1 : list) {
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
					<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Search Movies</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {

	box-sizing: border-box;
	margin : auto;
}

.button {
	border-radius: 4px;
	background-color: #f4511e;
	border: none;
	color: #FFFFFF;
	text-align: center;
	font-size: 28px;
	padding: 20px;
	width: 200px;
	transition: all 0.5s;
	cursor: pointer;
	margin: 5px;
}

.button span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

.button span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

.button:hover span {
	padding-right: 25px;
}

.button:hover span:after {
	opacity: 1;
	right: 0;
}

input[type=text] {
	width: 80%;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
	font-size: 16px;
	background-color: white;
	background-image: url('asserts/maxresdefault.jpg');
	background-position: 10px 10px;
	background-repeat: no-repeat;
	padding: 12px 20px 12px 40px;
}

input[type=text1] {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 2px solid #ccc;
	border-radius: 4px;
}

.form-inline {
	display: flex;
	flex-flow: row wrap;
	align-items: center;
}

/* Add some margins for each label */
.form-inline label {
	margin: 5px 10px 5px 0;
}

/* Style the input fields */
.form-inline input {
	vertical-align: middle;
	margin: 5px 10px 5px 0;
	padding: 10px;
	background-color: #fff;
	border: 1px solid #ddd;
}


.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 40px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
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
	<jsp:include page="Index1.jsp"></jsp:include>
	<div class="gfg">Prime Video Search</div>
	<form action="SearchServlet">

		<div class="container">


			<div class="row">
				<div class="col">

					<label for="searchterm"><centre>Search Term</centre></label> <br>
					<input type="text" name="searchterm" placeholder="Search Term"
						size=125 requied autofocus />
					<button class="button">
						<span>Search </span>
					</button>
					<br> <br> Categorys: <select id="categorys"
						name="categorys">
						<option value="0">ALL</option>
						<option value=1>TVShows</option>
						<option value=2>Movies</option>
						<option value=3>Kids</option>
					</select>
					<tr>
					<td>Enter doctor id:
					<td><select id="doctorlist" name="doctorid">

							<c:forEach items="${docid}" var="s">
								<option value="${s}">${s}</option>
							</c:forEach>
					</select>
				</tr> 
					Genre: <select id="genre" name="genre">
						<option value="">ALL</option>
						<c:forEach items="${genre}" var="s">
								<option value="${s}">${s}</option>
							</c:forEach>
					</select> IMDB RATING : <select id="imdbrating" name="imdbrating">
						<option value="0">ALL</option>
						<option value=1>1</option>
						<option value=2>2</option>
						<option value=3>3</option>
						<option value=4>4</option>
						<option value=5>5</option>
						<option value=6>6</option>
						<option value=7>7</option>
						<option value=8>8</option>
						<option value=9>9</option>
						<option value=10>10</option>

					</select> Language : <select id="language" name="language">
						<option value="">ALL</option>
						<option value="Bengali">Bengali</option>
						<option value="Chinese">chinese</option>
						<option value="English">English</option>
						<option value="Hindi">Hindi</option>
						<option value="Kannadam">kannadam</option>
						<option value="Malayalam">Malayalam</option>
						<option value="Tamil">Tamil</option>
						<option value="Telungu">Telungu</option>
						<option value="Spanish">spanish</option>

					</select> <br> <br> <label for="Director">Director</label> <input
						type="text1" name="Director" placeholder="Director" size=25 /> <label
						for="Actor">Actor</label> <input type="text1" name="Actor"
						placeholder="Actor" size=25 /> <label> <input
						type="checkbox" name="originals"> Prime Originals
					</label>
				</div>
			</div>
		</div>
	</form>
</body>		
						</div>
						<div class="gfg">
							<h6>
								<em class="fa fa-thumbs-o-up"><%=cd1.getTlikes()%></em> 
								<em class="fa fa-thumbs-o-down"><%=cd1.getTdislikes()%></em>
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