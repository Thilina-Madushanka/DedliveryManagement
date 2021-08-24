<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
 <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body> 

<jsp:forward page="/hello"/> 

<a></a>
<a> Delivery Details</a><br><br>
<table border = 1>

<tr>
<th>Delivery Id</th>
<th>Delivery Date</th>
<th>Delivery Name</th>
<th>Delivery Address</th>
<th>Delivery TP</th>
</tr>

<c:forEach var = "delv" items ="${DelDetails}">

<tr>

<td>${delv.id}</td>
<td>${delv.date}</td>
<td>${delv.name}</td>
<td>${delv.address}</td>
<td>${delv.TP}</td>

</tr>	
</c:forEach>
</table><br>


<a> Driver Details</a><br><br>
<table border = 1>

<tr>
<td>Driver Id</td>
<td>Driver Name</td>
<td>Driver Time</td>
</tr>

<c:forEach var = "dri" items ="${DriDetails}">

<tr>
<td>${dri.id}</td>
<td>${dri.name}</td>
<td>${dri.time}</td>
</tr>

</c:forEach>
</table>

</body>
</html>