<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.servlet.http.HttpSession"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
@media (max-width: 800px) {
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
                font-size:40px; 
                color:green; 
                font-weight:bold; 
                text-align:center; 
            } 
            .geeks { 
                font-size:17px; 
                text-align:center; 
                margin-bottom:20px; 
            } 
           

body {
  background-image: url('asserts/download.png');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: cover;
}
</head>
</style>
<body style = "text-align:centre">

<div class = "header"> 
            
            <div class = "gfg">PrimeVideos</div> 
       <div class = "geeks">Destination For Entertainment</div> 
        </div> 
              
          
        <div class = "nav_menu"> 
            <a href = "#"><button class="btn"><i class="fa fa-home"></i> Home</button></a> 
            <a href = "search.jsp"><button class="btn"><i class="fa fa-search"></i>Search</button></a> 
        	<a href = "WatchedListServlet"><button class="btn">Watched Movies</button></a>
        	<a href = "WatchLaterServlet"><button class="btn">WatchLater Movies</button></a>
        	<a href = "ForgetPassword.jsp"><button class = "btn">Change Password</button></a>
        	<a href = "plan.jsp"><button class = "btn">Prime Plans</button></a>
        	<a href = "LogoutServlet"><button class = "btn">LogOut</button></a>
        	
        </div> 
    </body>
    </html>
   