<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Verify OTP</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style>
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

.gfg1 {
	font-size: 20px;
	color: black;
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
<body style="text-align: center">
	<div class="gfg">PrimeVideos</div>
	<div class="geeks">Destination For Entertainment</div>
	<div class="gfg">Prime Assitance</div>
	<h2>Enter the One-Time Password Send To Your MailID</h2>
	<div class="gfg1">
		<p>${MailIdRegister}</p>
	</div>
	<form action="OtpServlet" method="post">
		<label for="otp">Enter OTP</label> <br /> <input type="OTP"
			name="otpuser" placeholder="One Time Password" required autofocus />
		<br> <br> <input type="submit" value="Register"
			class="btn btn-success" /> <br>
		<%
			String result = (String) request.getParameter("result1");
			if (result != null) {
				out.println("<centre> Alert :" + result + "</centre>");
			}
		%>
	</form>
</body>
</html>

