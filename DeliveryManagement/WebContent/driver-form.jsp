<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
			<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
			<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
			<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
           
 <style>
 
 body{
 
  background-color: #ff99ff;
 
 }
 

   .navbar-nav{
   
   text-align:center;
   colour:blue;
   font-size:18px;
   
   } 
         	          
  .form-control {
        min-height: 41px;
		background: #fff;
		box-shadow: none !important;
		border-color: #e3e3e3;
	}
	.form-control:focus {
		border-color: #70c5c0;
	}
    .form-control, .btn {        
        border-radius: 2px;
    }
	.staff-form {
		width: 350px;
		margin: 0 auto;
		padding: 100px 0 30px;		
	}
	.staff-form form {
		color: #7a7a7a;
		border-radius: 2px;
    	margin-bottom: 15px;
        font-size: 13px;
        background: #ececec;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;	
        position: relative;	
    }
	.staff-form h2 {
		font-size: 22px;
        margin: 35px 0 25px;
    }
	.staff-form .avatar {
		position: absolute;
		margin: 0 auto;
		left: 0;
		right: 0;
		top: -50px;
		width: 95px;
		height: 95px;
		border-radius: 50%;
		z-index: 9;
		background: #70c5c0;
		padding: 15px;
		box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
	}
	.staff-form .avatar img {
		width: 100%;
	}	
    .staff-form input[type="checkbox"] {
        margin-top: 2px;
    }
    .staff-form .btn {        
        font-size: 16px;
        font-weight: bold;
		background: #70c5c0;
		border: none;
		margin-bottom: 20px;
    }
	.staff-form .btn:hover, .login-form .btn:focus {
		background: #50b8b3;
        outline: none !important;
	}    
	.staff-form a {
		color: #fff;
		text-decoration: underline;
	}
	.login-form a:hover {
		text-decoration: none;
	}
	.staff-form form a {
		color: #7a7a7a;
		text-decoration: none;
	}
	.staff-form form a:hover {
		text-decoration: underline;
	}
	
	</style>
        </head>

        <body>
          
            <header>
                <nav class="navbar navbar-expand-md navbar-dark" >
                   
					<center>
                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
                    </ul>
                    <center>
                </nav>
            </header>
            <br>
            <div class="staff-form">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${assign != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${assign == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${assign != null}">
                                    Edit assignform
                                </c:if>
                                <c:if test="${assign == null}">
                                    Assign driver to a delivery
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${assign != null}">
                            <input type="hidden" name="deliveryid" value="<c:out value='${assign.deliveryid}' />" />
                        </c:if>

                        
                            <label>drivername</label> <input type="text" value="<c:out value='${assign.drivername}' />" class="form-control" name="drivername" required="required">
                       

                        
                            <label>time</label> <input type="text" value="<c:out value='${assign.time}' />" class="form-control" name="date">
                       

                       
                            
                     
                         

                        <button type="submit" class="btn btn-success">Assign</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>