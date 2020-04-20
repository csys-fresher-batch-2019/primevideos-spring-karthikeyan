<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register</title>
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
	<div class="gfg">SignUp</div>
	<form action="SignUpServlet" method="post">
		<label for="username">UserName</label> <br> <input type="text"
			name="username" size=25 placeholder="UserName" /> <br> <label
			for="email">MailId</label> <br /> <input type="email" name="email"
			placeholder="EmailId" size=25 required autofocus /> <br> <label
			for="npass">Password</label> <br> <input type="password"
			name="npass" id="npass" size=25 placeholder="Password"
			pattern=".{8,}" title="Must contain at least 8 or more characters"
			required /> <br /> <label for="npass">Conform Password</label> <br>
		<input type="password" name="npass" id="npass" size=25
			placeholder="Conform Password" pattern=".{8,}"
			title="Must contain at least 8 or more characters" required
			oninput="check(this)" /> <br> <br> <input type="submit"
			value="Continue" class="btn btn-success" /> <br> <br>
		<%
			String result = (String) request.getParameter("result");
			if (result != null) {
				out.println("<centre> Alert :" + result + "</centre>");
			}
		%>
		<script type="text/javascript">
			function check(input) {
				if (input.value != document.getElementById('npass').value) {
					input.setCustomValidity('Password Did Not Match');
				} else {
					// input is valid -- reset the error message
					input.setCustomValidity('')
				}
			}
		</script>
	</form>
	<a href="LoginMailId.jsp"><button type="submit" class="button">Go
			to Login</button></a>
</body>
</html>