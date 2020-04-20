<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.primevideos.dao.imp.PrimeReleasesDAOImp"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.primevideos.model.PrimeRelease"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Movie Details</title>
</head>
<link rel="stylesheet"	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
	width: 30%;
	padding: 15px;
	text-align: justify;
}

.columnB {
	float: left;
	width: 50%;
	padding: 15px;
	text-align: justify;
}

.columnc {
	float: left;
	width: 20%;
	padding: 15px;
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

.button {
	background-color: #4CAF50;
	border: none;
	color: white;
	padding: 10px 50px;
	cursor: pointer;
}

.btn {
	border: 2px solid black;
	background-color: white;
	color: black;
	padding: 14px 28px;
	font-size: 16px;
	cursor: pointer;
}

.success {
	border-color: #4CAF50;
	color: green;
}

.success:hover {
	background-color: #4CAF50;
	color: white;
}
</style>


<body>
	<div class="header">
		<h2 style="color: white; font-size: 200%">Prime Videos</h2>
	</div>

	<div class="nav_menu">
		<a href="#"><button class="btn"><em class="fa fa-home"></em> Home	</button></a> 
		<a href="search.jsp"><button class="btn"><em class="fa fa-search"></em>Search</button></a> 
		<a href="WatchedListServlet"><button class="btn">Watched Movies</button></a> 
		<a href="WatchLaterServlet"><button class="btn">WatchLater Movies</button></a> 
		<a href="ForgetPassword.jsp"><button class="btn">Change	Password</button></a> 
		<a href="PlanServlet"><button class="btn">Prime Plans</button></a> 
		<a href="LogoutServlet"><button class="btn">SignOut</button></a>
	</div>
	
	<div class="header1">
		<h2 style="color: white; font-size: 200%">
			${details.nameOfVideo}
		</h2>
	</div>

	<div class="row">

		<div class="columnA">
			<img src="asserts/${details.nameOfVideo}.jpg" width="300"
				height="300" alt="${details.nameOfVideo}">
		</div>

		<div class="columnB">
			<p>
				Prime ID :${details.primeId}</p>
			<p>
				Category Type :${details.categoryId}</p>
			<p>
				Genre :${details.genre}</p>
			<p>
				Language :${details.audioLanguages}</p>
			<p>
				Director :${details.director}</p>
			<p>
				Cast :${details.casting}</p>
			<p>
				IMDB Rating :${details.imdbRating}</p>
			<p>
				Release Date :${details.releaseDate}</p>
			<p>
				Prime Release Date :${details.primeReleaseDate}</p>
			<p>
				Box Office :${details.boxOfficeCollectionInMillions}</p>
			<p>${details.descriptionOfVideo}</p>
		</div>
		<div class="columnC">
			<p>
				<a
					href="Watchinterface?decide=1&movieid=${details.primeId}&movien=${details.nameOfVideo}">
					<button class="btn success">
						<span>Watch Movie </span>
					</button>
				</a>
			</p>
			<p>
			<p>
				<a
					href="Watchinterface?decide=2&movieid=${details.primeId}&movien=${details.nameOfVideo}">
					<button class="btn success">
						<span>Watch Later </span>
					</button>
				</a>
			</p>
			<p>
				<span class="likebtn-wrapper" data-identifier="item_1"> <span
					class="likebtn-wrapper lb-loaded lb-style-white lb-popup-position-top lb-popup-style-light"
					data-identifier="item_1"> <span
						class="likebtn-button lb-like" id="lb-like-0"> <span
							onclick="LikeBtn.vote(1, 0, event);" class="lb-a"
							data-lb_index="0"> <em class="lb-tt lb-tooltip-tt"> <em
									class="lb-tt-lt"></em> <em class="lb-tt-rt"></em> <em
									class="lb-tt-m">I like this</em><em class="lb-tt-mu">Unlike</em> <em
									class="lb-tt-m2"></em> <em class="lb-tt-lb"></em> <em
									class="lb-tt-rb"></em> <em class="lb-tt-a"></em></em> <span
								class="likebtn-icon lb-like-icon">&nbsp;</span> <span
								class="likebtn-label lb-like-label">Like</span></span> <span
							class="lb-count" data-count="2">${details.totalLikes}</span></span> <span
						class="likebtn-button lb-dislike " id="lb-dislike-0"> <span
							onclick="LikeBtn.vote(-1, 0, event);" class="lb-a"
							data-lb_index="0"> <em class="lb-tt lb-tooltip-tt"><em
									class="lb-tt-lt"></em> <em class="lb-tt-rt"></em><em
									class="lb-tt-m">I dislike this</em> <em class="lb-tt-mu">Undislike</em>
									<em class="lb-tt-m2"></em> <em class="lb-tt-lb"></em> <em
									class="lb-tt-rb"></em> <em class="lb-tt-a"></em></em> <span
								class="likebtn-icon lb-dislike-icon">&nbsp;</span></span> <span
							class="lb-count" data-count="0">${details.totalDislikes}</span></span></span>
				</span>
			</p>
		</div>
	</div>
</body>
<script>
	(function(d, e, s) {
		if (d.getElementById("likebtn_wjs"))
			return;
		a = d.createElement(e);
		m = d.getElementsByTagName(e)[0];
		a.async = 1;
		a.id = "likebtn_wjs";
		a.src = s;
		m.parentNode.insertBefore(a, m)
	})(document, "script", "//w.likebtn.com/js/w/widget.js");
</script>

</html>
