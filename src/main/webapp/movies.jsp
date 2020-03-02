<%@page import="com.chainsys.primevideos.model.PrimeReleases"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.gfg {
	font-size: 40px;
	color: green;
	font-weight: bold;
	text-align: center;
}

#customers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#customers td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#customers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#customers tr:hover {
	background-color: #ddd;
}

#customers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>


<title>Movies</title>

</head>
<body>
	<%
		ArrayList<PrimeReleases> list = (ArrayList) request.getAttribute("movies");
	%>
	<div class="gfg">
		<centre>Movies</centre>
	</div>

	<center>
		<table id=customers>
			<thead>
				<tr>
					<th>S.No</th>
					<th>Name of Video</th>
					<th>Prime Id</th>
				</tr>
				<%
					int i = 1;
					for (PrimeReleases obj : list) {
				%>
				<tr>
					<td><%=i++%></td>
					<td><%=obj.getNameofVideo()%></td>
					<td><%=obj.getPrimeId()%></td>
				</tr>


				<%
					}
				%>
			</thead>
		</table>
	</center>
	</br>

	</form>
</body>
</html>