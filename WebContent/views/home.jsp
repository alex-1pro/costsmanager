<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255" import="il.ac.hit.costmanager.controller.*"
    import="il.ac.hit.costmanager.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<meta charset="windows-1255">
<title>Home Page</title>
</head>
<body>	
	
	<% User user = (User) session.getAttribute("user");
	
	// --- To TEST the expense with fake user ----
		if (user == null){
	
		}
	// -------------------------------------------
	%>
	
	
      <!--Navbar-->
      <nav class="navbar navbar-expand-lg navbar-dark bg-secondary fixed-top scrolling-navbar">
        <div class="container">
            <a class="navbar-brand" href="http://localhost:8080/CostManager/controller/home">
			  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQeBhhqCJKc3UhLgcs9mea8V-orz3ZcMS8fyw&usqp=CAU" width="30" height="30" class="d-inline-block align-top" alt="">
			  Cost Manager
			</a>
			<div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/CostManager/controller/expenses">Expenses<span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/CostManager/controller/reports">Reports<span class="sr-only">(current)</span></a>
              </li>
            </ul>
		    <a class="btn btn-outline text-white" href="http://localhost:8080/CostManager/controller/login/logOut">Log Out</a>
            </div>
        </div>
      </nav>
      <!-- Navbar -->
	
	
	<div class="jumbotron text-center">
	  <h3>Welcome <%= user.getUserName() %>!</h3>
	</div>
	
	<div class="view" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/architecture.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
	
	<div class="container text-center">
	<a href="http://localhost:8080/CostManager/controller/expenses" class="btn btn-primary btn-lg">Expenses</a>
	</div>
	<br></br>
	<div class="container text-center">
	<a href="http://localhost:8080/CostManager/controller/reports" class="btn btn-info btn-lg">Monthly Report</a>
	</div>
	
	</div>
	
</body>

<footer>
	<div class="jumbotron text-center">
		<a href="http://localhost:8080/CostManager/controller/login/logOut">Log Out</a>
	</div>
</footer>

</html>