<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

<link rel="stylesheet" type="text/css" href="login.css">

<meta charset="windows-1255">
<title>Register</title>
</head>
<body>

    <!--Navbar-->
    <nav class="navbar navbar-expand-lg navbar-dark bg-secondary fixed-top scrolling-navbar">
        <div class="container">
            <a class="navbar-brand" href="#">
			  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQeBhhqCJKc3UhLgcs9mea8V-orz3ZcMS8fyw&usqp=CAU" width="30" height="30" class="d-inline-block align-top" alt="">
			  Cost Manager
			</a>
			<div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto"></ul>
            <a class="btn btn-outline text-white" href="http://localhost:8080/CostManager/controller/login">Login</a>
            </div>
        </div>
    </nav>
    <!-- Navbar -->
	
	<header>
	
	<div class="view" style="background-image: url('https://mdbootstrap.com/img/Photos/Others/architecture.jpg'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
	
	<div class="container ph-2">

	    <!--Grid-->
	    <div class="row">
	    <div class="col-12">
	    
	    
	<div class="card mt-2 mb-5">
	<div class="card-body">
	
		<div class="text-center">
			<h3 class="text-primary">Register</h3>
			<hr class="hr-light">
		</div>
	
		<form method="post" action="http://localhost:8080/CostManager/controller/register/tryToRegister">
			<div class="form-group text-center">
		        <input placeholder="User Name" class="form-control" type="text" name="userName" required/>
		        <input placeholder="Password" class="form-control mt-3" type="password" name="password" required/>
		        <button type="submit" class="btn btn-info mt-3">Register</button>
		        
		        <%
				    Boolean succsess= (Boolean)request.getAttribute("succsess");
		        
		        
				       if(succsess!=null){
				    	  
				  			if(!succsess)
				  			
				  				out.println("<h4 class='text-center text-danger mt-3'>Please chose another user name</h4>");
				          	else if(succsess){  
				          		 
				          		out.println("<h4 class='text-center text-success mt-3'>User created succsessfuly<br/>");
				          	  	out.print("Click to "
				                         + "<a href="+"http://localhost:8080/CostManager/controller/login"+">login</a></h4>");
				          	
						         

				           		
				          	}
				       }
				      
				       
				    %>
		        
	        </div>
	    </form>	
	</div>
	</div>
	

    
    </div>
    </div>
    </div>
    
	</header>

    <main>
	<div class="d-flex flex-column justify-content-between">
		<div class="jumbotron text-center">
			<p class="text-muted">Made by Jacob Graham & Alexey Belogurov</p>
		</div>
	</div>
	</main>
    
</body>
</html>