<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.primevideos.model.PrimeReleases"%>
<%@page import="com.chainsys.primevideos.imp.PrimeReleasesDAOImp"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<head>
<style>
:root { -
	-crsl-bg: transparent; -
	-box-bg: #1e272e; -
	-box-shadow: #0000001c; -
	-box-shadow-border: #0000000f; -
	-box-border: #fff;
}

html, body {
	padding: 0;
	margin: 0;
	width: 100%;
	height: 100%;
	background: #2f3539;
	background: -moz-radial-gradient(circle, #2f3539 0%, #1e272e 100%);
	background: -webkit-radial-gradient(circle, #2f3539 0%, #1e272e 100%);
	background: radial-gradient(circle, #2f3539 0%, #1e272e 100%);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr="#2f3539",
		endColorstr="#1e272e", GradientType=1);
}

html *, body * {
	font-family: 'Source Sans Pro', sans-serif;
}

html>p, body>p {
	font-size: .95em;
	font-weight: bold;
	position: absolute;
	top: 7.5%;
	width: 100%;
	letter-spacing: 4px;
	text-transform: uppercase;
	text-align: center;
	color: white;
	user-select: none;
}

html>.carousel, body>.carousel {
	padding-top: 125px;
}

.carousel {
	position: relative;
	display: block;
	width: 100%;
	box-sizing: border-box;
}

.carousel__prev, .carousel__next {
	position: absolute;
	bottom: -15%;
	transition: transform 0.25s ease;
}

.carousel__prev i, .carousel__next i {
	font-size: 60px;
	color: var(- -box-border);
	cursor: pointer;
}

.carousel__prev:hover, .carousel__next:hover {
	transform: scale(1.25);
}

.carousel__prev {
	left: 40%;
}

.carousel__next {
	right: 40%;
}

.carousel__body {
	width: 100%;
	padding: 20px 0 50px 0;
	overflow: hidden;
}

.carousel__body .carousel__slider {
	position: relative;
	transition: transform 1s ease-in-out;
	background: var(- -crsl-bg);
}

.carousel__body .carousel__slider__item {
	position: relative;
	display: block;
	float: left;
	box-sizing: border-box;
	margin-left: 20px;
	margin-right: 20px;
}

.carousel__body .carousel__slider__item .item__3d-frame {
	position: relative;
	width: 100%;
	height: 100%;
	transition: transform 1s ease-in-out;
	-webkit-transform-style: preserve-3d;
	transform-style: preserve-3d;
}

.carousel__body .carousel__slider__item .item__3d-frame:after {
	content: '';
	position: absolute;
	bottom: -15%;
	width: 100%;
	height: 40px;
	background: var(- -box-shadow);
	box-shadow: 0px 0px 5px 5px var(- -box-shadow);
	transform: rotateX(90deg) translate3d(0px, -20px, 0px);
	opacity: 0.85;
}

.carousel__body .carousel__slider__item .item__3d-frame__box {
	display: flex;
	align-items: center;
	vertical-align: middle;
	text-align: center;
	position: absolute;
	width: 100%;
	height: 100%;
	box-sizing: border-box;
	border-color: var(- -box-border);
	background: var(- -box-bg);
	border-width: 3px;
	border-style: solid;
}

.carousel__body .carousel__slider__item .item__3d-frame__box h1 {
	font-size: 7em;
	width: 100%;
	color: var(- -box-border);
}

.carousel__body .carousel__slider__item .item__3d-frame__box--right,
	.carousel__body .carousel__slider__item .item__3d-frame__box--left {
	top: 0;
	width: 40px;
	backface-visibility: hidden;
}

.carousel__body .carousel__slider__item .item__3d-frame__box--left {
	left: 0;
	border-left-width: 5px;
	transform: translate3d(1px, 0, -40px) rotateY(-90deg);
	transform-origin: 0%;
}

.carousel__body .carousel__slider__item .item__3d-frame__box--right {
	right: 0;
	border-right-width: 5px;
	transform: translate3d(-1px, 0, -40px) rotateY(90deg);
	transform-origin: 100%;
}
</style>
</head>
<body>

	<%
		ArrayList<PrimeReleases> list = (ArrayList) request.getAttribute("imdbslide");
	%>
	<%
		if (list != null) {
	%>
	<%
		for (PrimeReleases cd1 : list) {
	%>

	<div class="carousel">

		<p>CSS 3D Carousel/Slider!</p>
		<div class="carousel">
			<div class="carousel__body">
				<div class="carousel__prev">
					<i class="far fa-angle-left"></i>
				</div>
				<div class="carousel__next">
					<i class="far fa-angle-right"></i>
				</div>
				<div class="carousel__slider">
					<div class="carousel__slider__item">
						<div class="item__3d-frame">
							<div class="item__3d-frame__box item__3d-frame__box--front">
								<a href="ViewMoviesServlet?id=<%=cd1.getPrimeId()%>"> <img
									src="asserts/<%=cd1.getNameofVideo()%>.jpg"
									class="card-img-top" alt="<%=cd1.getNameofVideo()%>"></a>

							</div>

							<div class="item__3d-frame__box item__3d-frame__box--left"></div>
							<div class="item__3d-frame__box item__3d-frame__box--right">
							</div>

						</div>
					</div>

				</div>

			</div>
			<%
				}
				}
			%>
		</div>
	</div>

	<script>
(function() {
	  "use strict";

	  var carousel = document.getElementsByClassName('carousel')[0],
	      slider = carousel.getElementsByClassName('carousel__slider')[0],
	      items = carousel.getElementsByClassName('carousel__slider__item'),
	      prevBtn = carousel.getElementsByClassName('carousel__prev')[0],
	      nextBtn = carousel.getElementsByClassName('carousel__next')[0];
	  
	  var width, height, totalWidth, margin = 20,
	      currIndex = 0,
	      interval, intervalTime = 4000;
	  
	  function init() {
	      resize();
	      move(Math.floor(items.length / 2));
	      bindEvents();
	    
	      timer();
	  }
	  
	  function resize() {
	      width = Math.max(window.innerWidth * .25, 275),
	      height = window.innerHeight * .5,
	      totalWidth = width * items.length;
	    
	      slider.style.width = totalWidth + "px";
	    
	      for(var i = 0; i < items.length; i++) {
	          let item = items[i];
	          item.style.width = (width - (margin * 2)) + "px";
	          item.style.height = height + "px";
	      }
	  }
	  
	  function move(index) {
	    
	      if(index < 1) index = items.length;
	      if(index > items.length) index = 1;
	      currIndex = index;
	    
	      for(var i = 0; i < items.length; i++) {
	          let item = items[i],
	              box = item.getElementsByClassName('item__3d-frame')[0];
	          if(i == (index - 1)) {
	              item.classList.add('carousel__slider__item--active');
	              box.style.transform = "perspective(1200px)"; 
	          } else {
	            item.classList.remove('carousel__slider__item--active');
	              box.style.transform = "perspective(1200px) rotateY(" + (i < (index - 1) ? 40 : -40) + "deg)";
	          }
	      }
	    
	      slider.style.transform = "translate3d(" + ((index * -width) + (width / 2) + window.innerWidth / 2) + "px, 0, 0)";
	  }
	  
	  function timer() {
	      clearInterval(interval);    
	      interval = setInterval(() => {
	        move(++currIndex);
	      }, intervalTime);    
	  }
	  
	  function prev() {
	    move(--currIndex);
	    timer();
	  }
	  
	  function next() {
	    move(++currIndex);    
	    timer();
	  }
	  
	  
	  function bindEvents() {
	      window.onresize = resize;
	      prevBtn.addEventListener('click', () => { prev(); });
	      nextBtn.addEventListener('click', () => { next(); });    
	  }




	  
	  init();
	  
	})();
</script>
</body>
</html>
