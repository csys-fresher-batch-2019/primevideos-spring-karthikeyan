<html>
<head>
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
	font-size: 30px;
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
<body style="text-align: center">
	<div class="gfg">PrimeVideos</div>
	<div class="geeks">Destination For Entertainment</div>
	<div class="gfg1">Login</div>
	<form action="LogInMail">
		<br /> EmailId : <input type="email" name="email"
			placeholder="EmailId" required autofocus /> <br> <br>
		<button type="submit" class="button">Continue</button>
		<br>
		<%
			String result = (String) request.getParameter("result");
			if (result != null) {
				out.println("<centre> Alert :" + result + "</centre>");
			}
		%>
	</form>
	<a href="Register.jsp"><button type="submit" class="button">NewUser</button></a>
</body>
</html>