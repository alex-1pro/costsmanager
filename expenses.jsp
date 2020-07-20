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
<title>Expenses</title>
</head>
<body>
	
	<% User user = (User) session.getAttribute("user");
	
	// --- To TEST the expense with fake user ----
		if (user == null){
			user = new User(99,"Jacob_TEST","123456");
		}
	// -------------------------------------------
	%>
	
	
      <!--Navbar-->
      <nav class="navbar navbar-expand-lg navbar-dark bg-secondary fixed-top scrolling-navbar">
        <div class="container">
            <a class="navbar-brand" href="http://localhost:8080/CostsManager/controller/home">
			  <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQeBhhqCJKc3UhLgcs9mea8V-orz3ZcMS8fyw&usqp=CAU" width="30" height="30" class="d-inline-block align-top" alt="">
			  Cost Manager
			</a>
			<div class="collapse navbar-collapse" id="navbarText">
            <ul class="navbar-nav mr-auto">
              <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/CostsManager/controller/expenses">Expenses<span class="sr-only">(current)</span></a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="http://localhost:8080/CostsManager/controller/reports">Reports<span class="sr-only">(current)</span></a>
              </li>
            </ul>
		    <a class="btn btn-outline text-white" href="http://localhost:8080/CostsManager/controller/login/logOut">Log Out</a>
            </div>
        </div>
      </nav>
      <!-- Navbar -->
          
          
	<div class="jumbotron text-center">
	  <a class="btn btn-primary btn-lg" href="http://localhost:8080/CostsManager/controller/home" role="button">Back</a>
	  <h1>Costs Manager</h1>
	  <h3><%= user.getUserName() %> Expenses:</h3>
	</div>
	
	<div class="container">
		
		<form method="post" action="http://localhost:8080/CostsManager/controller/expenses/addExpense">
		
			<div class="form-group text-center">
			  <div class="form-row">
			  
			    <div class="form-group col-md-2">
		        <input placeholder="Name" type="text" name="expenseDescription" id="expenseDescription" required/>
		        </div>
		        
		        <div class="form-group col-md-3">
		        <select class="custom-select" name="expenseType" id="expenseType" required>
			   		<option selected>Choose Type</option>
					<option value="1">Food</option>
					<option value="2">Car</option>
					<option value="3">House</option>
				</select>
		        </div>
		        
		        <div class="form-group col-md-2">
		        <input placeholder="Cost" type="number" name="expenseCost" id="expenseCost" required/>
		        </div>
		        
		        <div class="form-group col-md-3">
		        <select class="custom-select" name="expenseMonth" id="expenseMonth" required>
			   		<option selected>Choose Month</option>
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
		        </div>
		        
		        <div class="form-group col-md-2">
		        <button type="submit" class="btn btn-primary">Add</button>
	            </div>
	          </div>
	        </div>
	    </form>
		
	</div>
	
	<div class="container">          
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

</body>

<footer>
	<div class="jumbotron text-center">
		<a href="http://localhost:8080/CostsManager/controller/login/logOut">Log Out</a>
	</div>
</footer>


</html>