<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	>
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
	color: tomato;
	font-weight: bold;
	text-align: center;
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
	<div class="gfg">Password Assistance</div>
	<form action="ChangePasswordServlet" method="post">

		<label for="npass">Password</label> <br> <input type="password"
			name="npass" id="npass" size=25 placeholder="Password"
			pattern=".{8,}" title="Must contain at least 8 or more characters"
			required /> <br /> <label for="npass">Conform Password</label> <br>
		<input type="password" name="npass" id="npass" size=25
			placeholder="Conform Password" pattern=".{8,}"
			title="Must contain at least 8 or more characters" required
			oninput="check(this)" /> <br> <br> <input type="submit"
			value="Change Password" class="btn btn-success" /> <br> <br>

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
</body>
</html>