<%@page import="com.chainsys.primevideos.imp.AmazonPlanImplements"%>
<%@page import="com.chainsys.primevideos.method.Plan"%>
<%@page import="com.chainsys.primevideos.method.PrimeReleases"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
 .gfg { 
                font-size:40px; 
                color:green; 
                font-weight:bold; 
                text-align:center; 
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

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

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
<jsp:include page= "nav.jsp"></jsp:include>
	<%
		AmazonPlanImplements as =  new AmazonPlanImplements();
		ArrayList<Plan> list = as.list();
	%>
<div class = "gfg" ><centre>Prime Videos Plans</centre></div>
<center><table id = customers>
		<thead>
			<tr>
				<th>S.No</th>
				<th>Plan Id</th>
				<th>Plan Amount</th>
				<th>Plan Duration(Days)</th>
				<th>Screens Count</th>
				<th>Discount Amount</th>
			</tr>
			<%
				int i = 1;
				for (Plan l : list) {				
			%>
			<tr>
				<td><%=i++%></td>
				<td><%=l.getPlanId()%></td>
				<td><%=l.getPlanAmount()%></td>
				<td><%=l.getPlanDuration()%></td>
				<td><%=l.getNoOfScreens() %></td>
				<td><%=l.getDiscountAmount() %></td>
			</tr>


			<%
				}
			%>
		</thead>
	</table></center></br>
</form>
</body>
</html>