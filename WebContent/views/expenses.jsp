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

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/design.css">

<meta charset="windows-1255">
<title>Expenses</title>
</head>
<body>
	
	<% 
	User user = (User) session.getAttribute("user");
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
                <a class="nav-link text-warning" href="http://localhost:8080/CostManager/controller/expenses">Expenses<span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/CostManager/controller/reports">Reports<span class="sr-only">(current)</span></a>
              </li>
            </ul>

            <h5 class="text-light font-italic pt-1">Hello <%= user.getUserName() %></h5>
		    <a class="btn btn-outline text-white" href="http://localhost:8080/CostManager/controller/login/logOut">Log Out</a>
            </div>
        </div>
      </nav>
      <!-- Navbar -->
       
    <header>
          
	<div class="view" style="background-image: url('https://medatech.com/wp-content/uploads/2017/11/Website-Background.png'); background-repeat: no-repeat; background-size: cover; background-position: center center;">
		
	<div class="container pt-2">
	
		<div class="card">
			<div class="card-body">	
		
		<form class="form-inline" method="post" action="http://localhost:8080/CostManager/controller/expenses/addExpense">
		
			<div class="form-group text-center">
			  <div class="form-row">
			  
		        <input class="form-control" placeholder="Name" type="text" name="expenseDescription" id="expenseDescription" required/>
		        
		        <select class="custom-select form-control ml-2" name="expenseType" id="expenseType" required>
			   		<option selected value="">Choose Type</option>
					<option value="Food">Food</option>
					<option value="Car">Car</option>
					<option value="House">House</option>
					<option value="University">University</option>
					<option value="Other">Other</option>
				</select>
		        
		        <input class="form-control ml-2" placeholder="Cost" type="number" step="0.01" name="expenseCost" id="expenseCost" required/>
		        
		        <select class="custom-select form-control ml-2" name="expenseMonth" id="expenseMonth" required>
			   		<option selected value="">Choose Month</option>
		            <option value="January">January</option>
		            <option value="February">February</option>
		            <option value="March">March</option>
		            <option value="April">April</option>
		            <option value="May">May</option>
		            <option value="June">June</option>
		            <option value="July">July</option>
		            <option value="August">August</option>
		            <option value="September">September</option>
		            <option value="October">October</option>
		            <option value="November">November</option>
		            <option value="December">December</option>
				</select>
		        
		        <button type="submit" class="btn btn-primary ml-5">
		          Add <i class="fa fa-plus-circle"></i>
		        </button>
		        
	          </div>
	        </div>
	    </form>
		
		</div>
		</div>
		
	</div>

	<div class="container mt-4">          
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>Description</th>
	        <th>Type</th>
	        <th>Cost</th>
	        <th>Month</th>
	      </tr>
	    </thead>
	    <tbody>
	    
	    <%
	    
	    Expense[] expenses = (Expense[])(request.getAttribute("expenses"));
		
	    if( expenses!= null){
	    
		for(Expense ex:expenses){
		 
            String type = ex.getType();
            double cost = ex.getCost();
            String description = ex.getDescription();
            String month = ex.getMonth();
			
			%>
			<tr>
			<td><%= description %></td>
            <td><%= type %></td>
            <td><%= String.valueOf(cost) %></td>
            <td><%= month %></td>
       		</tr>
			<%
			
		 }
		
	    }
	    
	    %>
	    </tbody>
	  </table>
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