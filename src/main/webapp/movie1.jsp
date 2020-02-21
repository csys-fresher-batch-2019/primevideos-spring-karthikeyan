<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.primevideos.imp.PrimeReleasesDAOImp"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.primevideos.method.PrimeReleases"%>

<!DOCTYPE html> 
<html> 
    <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     
        <title> 
            MoviesReview 
        </title> 
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
            .columnA{ 
                float: left; 
                width: 30%; 
                padding: 15px; 
                text-align:justify; 
            } 
             .columnB{ 
                float: left; 
                width: 50%; 
                padding: 15px; 
                text-align:justify; 
            }
            .columnc{ 
                float: left; 
                width: 20%; 
                padding: 15px; 
                text-align:justify; 
            }  
            h2 { 
                color:green; 
                text-align:center; 
            } 
            h6{
            color: Black;
            text-align : left;
            font-size : 80%;
            }
              
            /* Media query to set website layout  
            according to screen size */ 
            @media screen and (max-width:600px) { 
                .columnA, .columnB{ 
                    width: 50%; 
                } 
            } 
            @media screen and (max-width:400px) { 
                .columnA, .columnB{ 
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
    </head> 
      
    <body> 
    <%ArrayList<PrimeReleases> cd= (ArrayList) request.getAttribute("details"); 
	for(PrimeReleases as : cd){%>
        <div class = "header"> 
            <h2 style = "color:white;font-size:200%"> 
                Prime Videos 
            </h2> 
        </div> 
          
        <div class = "nav_menu"> 
            <a href = "#"><button class="btn"><i class="fa fa-home"></i> Home</button></a> 
            <a href = "search.jsp"><button class="btn"><i class="fa fa-search"></i>Search</button></a> 
        	<a href = "WatchedListServlet"><button class="btn">Watched Movies</button></a>
        	<a href = "WatchLaterServlet"><button class="btn">WatchLater Movies</button></a>
       		<a href = "plan.jsp"><button class = "btn">Prime Plans</button></a>
        </div> 
        <div class = "header1"> 
            <h2 style = "color:white;font-size:200%"> 
                <%=as.getNameofVideo()%>
            </h2> 
        </div>
          
        <div class = "row"> 
              
            <div class = "columnA"> 
                 <img src="asserts/<%=as.getNameofVideo()%>.jpg"   width="300" height="300" alt="<%=as.getNameofVideo()%>">
            </div>  
              
            <div class = "columnB"> 
              <p>Prime ID :<%=as.getPrimeId() %></p>
  <p>Category Type :<%=as.getCategoryId() %></p>
  <p>Genre :<%=as.getGenre() %></p>
  <p>Language :<%=as.getAudioLanguages() %></p>
  <p>Director :<%=as.getDirector() %></p>
  <p>Cast :<%=as.getCasting() %></p>
  <p>IMDB Rating :<%=as.getImdbRating() %></p>
  <p>Release Date :<%=as.getReleaseDate() %></p>
  <p>Prime Release Date :<%=as.getPrimereleaseDate() %></p>
  <p>Box Office :<%=as.getBoxofficecollectionuinmillions() %></p>
  <p><%=as.getDescriptionofvideo() %></p>
            </div> 
            <div class = "columnC"> 
            <p><a href = "Watchinterface?decide=1&movieid=<%=as.getPrimeId()%>&movien=<%=as.getNameofVideo()%>">
            <button class="btn success"><span>Watch Movie </span></button></a></p>
            <p>
            <p><a href = "Watchinterface?decide=2&movieid=<%=as.getPrimeId()%>&movien=<%=as.getNameofVideo()%>">
            <button class="btn success"><span>Watch Later </span></button></a></p>
            </div>           
        </div> 
    </body> 
</html> 
<%}%>