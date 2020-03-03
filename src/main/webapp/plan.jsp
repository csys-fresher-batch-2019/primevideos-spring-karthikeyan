<%@page import="com.chainsys.primevideos.service.ServicePlans"%>
<%@page import="com.chainsys.primevideos.model.Plan"%>
<%@page import="com.chainsys.primevideos.model.PrimeReleases"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<%
		ServicePlans as = new ServicePlans();
			ArrayList<Plan> list  = as.list();
	%>
	<div class="gfg">
		Prime Videos Plans
	</div>
	<center>
		<table id=customers>
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
				<c:set var="list" value="<%=list%>" ></c:set>
				<c:forEach items="${list}" var="l" varStatus="i">				
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
	</center>
</body>
</html>