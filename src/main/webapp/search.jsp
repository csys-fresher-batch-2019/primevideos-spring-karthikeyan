<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="javax.servlet.http.HttpSession"%>
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
	background-color: Tomato;
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

/* Style the submit button */
.form-inline button {
	padding: 10px 20px;
	background-color: dodgerblue;
	border: 1px solid #ddd;
	color: white;
}

.form-inline button:hover {
	background-color: royalblue;
}

/* Add responsiveness - display the form controls vertically instead of horizontally on screens that are less than 800px wide */
@media ( max-width : 800px) {
	.form-inline input {
		margin: 10px 0;
	}
	.form-inline {
		flex-direction: column;
		align-items: stretch;
	}
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
</
head
>
</style>
<body style="text-align: centre">
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="gfg">Prime Video Search</div>
	<form action="searchServlet">
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
					</select> Genre: <select id="genre" name="genre">
						<option value="">ALL</option>
						<option value="Action">Action</option>
						<option value="Adventure">Adventure</option>
						<option value="Animation">Animation</option>
						<option value="Biography">Biography</option>
						<option value="Comedy">Comedy</option>
						<option value="Crime">Crime</option>
						<option value="Documentary">Documentary</option>
						<option value="Drama">Drama</option>
						<option value="Family">Family</option>
						<option value="Fantasy">Fantasy</option>
						<option value="Horror">Horror</option>
						<option value="Musical">Musical</option>
						<option value="Mystery">Mystery</option>
						<option value="Romance">Romance</option>
						<option value="SciFi">Sci-Fi</option>
						<option value="Sport">Sport</option>
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