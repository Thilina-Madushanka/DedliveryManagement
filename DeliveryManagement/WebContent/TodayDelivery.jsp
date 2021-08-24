<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

<style>
body {
  background-color: #33ff33;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}

h2{

	text-align:center;
	font:tahoma,genava,sans-serif;
	font-style: oblique;
	colour:#33cc33;

}

</style>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


</head>
<body>

 <h2>Delivery Details</h2><br><br>

<div style="overflow-x:auto;">
<table border = 1>
<c:forEach var = "delv" items ="${DelDetails}">

<tr>
<th>Delivery Id</th>
<th>Delivery Date</th>
<th>Delivery Name</th>
<th>Delivery Address</th>
<th>Delivery TP</th>
</tr>
	
<tr>

<td>${delv.id}</td>
<td>${delv.date}</td>
<td>${delv.name}</td>
<td>${delv.address}</td>
<td>${delv.TP}</td>
</tr>
	


</c:forEach>

</table><br>
</div>
<form method = "post" action="<%= request.getContextPath() %>/DriverServlet">
<center>
<a href="driver-form.jsp">Add Drivers</a>	
</center>
</form>


</body>
</html>