<%@page import="com.chainsys.primevideos.imp.PrimeReleasesDAOImp"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.primevideos.method.PrimeReleases"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CSS Website Layout</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
}

/* Style the header */
.header {
  background-color: WHITE;
  padding: 20px;
  text-align: center;
}
 .gfg1 { 
                font-size:30px; 
                color:Green; 
                font-weight:bold; 
                text-align:centre; 
            } 
 .gfg { 
                font-size:20px; 
                color:Red; 
                font-weight:bold; 
                text-align:left; 
            } 
            .column {
  float: left;
  width: 33.33%;
  padding: 15px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width:600px) {
  .column {
    width: 100%;
  }
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
}
body {
  background-image: url('asserts/download.png');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</style>
</head>
<body>
<form>
<%ArrayList<PrimeReleases> cd= (ArrayList) request.getAttribute("details"); 
	for(PrimeReleases as : cd){%>
<div class="header">
  <div class = "gfg1">
  <h1><%=as.getNameofVideo()%></h1>
  </div>
</div>	
<div class="row">
  <div class="leftcolumn">
  <div class="card">
  <div class="card" style="width: 10rem; height: 15rem">
  <img src="asserts/<%=as.getNameofVideo()%>.jpg" class="card-img-top" alt="<%=as.getNameofVideo()%>">
  </div></div></div>
  </div><div></div>
  <div class="column">
  <div class = "gfg" ><h6><%=as.getPrimeId() %></h6>
  <h6><%=as.getCategoryId() %></h6>
  <h6><%=as.getGenre() %></h6>
  <h6><%=as.getAudioLanguages() %></h6>
  <h6><%=as.getDirector() %></h6>
  <h6><%=as.getCasting() %></h6>
  <h6><%=as.getAudioLanguages() %></h6>
  <h6><%=as.getImdbRating() %></h6>
  <h6><%=as.getBoxofficecollectionuinmillions() %></h6>
  <h6><%=as.getDescriptionofvideo() %></h6></div>
    </div>
	</div>
	<%}%>
	

</form>
</body>
</html>