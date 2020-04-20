<%@page import="com.chainsys.primevideos.model.Plan"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Plans</title>
</head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.gfg {
	font-size: 40px;
	color: green;
	font-weight: bold;
	text-align: center;
}

#plan {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#plan td, #customers th {
	border: 1px solid #ddd;
	padding: 8px;
}

#plan tr:nth-child(even) {
	background-color: #f2f2f2;
}

#plan tr:hover {
	background-color: #ddd;
}

#plan th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>

<body>
	<jsp:include page="Index1.jsp"></jsp:include>
	<div class="gfg">Prime Videos Plans</div>

	<table id=plan>
		<thead>
			<tr>
				<th>S.No</th>
				<th>Plan Id</th>
				<th>Plan Amount</th>
				<th>Plan Duration(Days)</th>
				<th>Screens Count</th>
				<th>Discount Amount</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${plans}" var="l" varStatus="i">
				<tr>
					<td>${i.index+1}</td>
					<td>${l.planId}</td>
					<td>${l.planAmount}</td>
					<td>${l.planDuration}</td>
					<td>${l.noOfScreens}</td>
					<td>${l.discountAmount}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>