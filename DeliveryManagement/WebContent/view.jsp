<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
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
           
      h3{
      
      text-align:center;
	font:tahoma,genava,sans-serif;
	font-style: oblique;
	colour:red;
      
      
      
      }    
           
  </style>
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
        </head>

        <body>

            <header>

                   
                
            </header>
            <br>

        
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                
                    <h3>Finalize deliveries</h3>
                   <img src="images/loginF.jpg" width="50px" height="50px">
                    <div class="container text-left">
                        <a href="<%=request.getContextPath()%>/list" class="nav-link">ALL DELIVERIES</a>
                        <a href="<%=request.getContextPath()%>/newassigning" class="btn btn-success">Assign driver to a delivery</a>
                 
                    <br>
                     <hr>
                    <center>
                    
                    <div style="overflow-x:auto;">
                    <table >
                        <thead >
                            <tr >
                                <th><h2>deliveryid</h2></th>
                                <th><h2>drivername</h2></th>
                                <th><h2>time</h2></th>
                                
                             
                                <th><h2>Edit staff</h2></th>
                                 <th><h2>Delete staff</h2></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="assign" items="${listUser}">

                                <tr >
                                    <td>
                                        <c:out value="${assign.deliveryid}" />
                                    </td>
                                    <td>
                                        <c:out value="${assign.drivername}" />
                                    </td>
                                    <td>
                                        <c:out value="${assign.time}" />
                                    </td>
                                   
                                   
                                      <td class="edit" ><a href="edit?deliveryid=<c:out value='${assign.deliveryid}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; </button></td>
                                    </td>
                                    <td class ="delete"><a href="delete?deliveryid=<c:out value='${assign.deliveryid}' />">Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                    
                    </div>
                    </center>
                </div>
            
        </body>

        </html>/html>