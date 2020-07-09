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

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

<meta charset="windows-1255">
<title>Expenses</title>
</head>
<body>
	
	<div class="jumbotron text-center">
	  <h1>Costs Manager</h1>
	  <h3>Expenses:</h3>
	</div>
	
	<div class="container">
		
		<form method="post" action="">
			<div class="form-group text-center">
			  <div class="form-row">
			  
			    <div class="form-group col-md-2">
		        <input placeholder="Name" type="text" name="costName" required/>
		        </div>
		        
		        <div class="form-group col-md-3">
		        <select class="custom-select" required>
			   		<option selected>Choose Type</option>
					<option value="1">One</option>
					<option value="2">Two</option>
					<option value="3">Three</option>
				</select>
		        </div>
		        
		        <div class="form-group col-md-2">
		        <input placeholder="Cost" type="number" name="costCost" required/>
		        </div>
		        
		        <div class="form-group col-md-2">
		        <input placeholder="Date" type="date" name="costDate" required/>
		        </div>
		        
		        <div class="form-group col-md-2">
		        <button type="submit" class="btn btn-primary">Add</button>
	            </div>
	          </div>
	        </div>
	    </form>
		
	</div>
	
	<div class="container">
	  <p>table:</p>            
	  <table class="table table-hover">
	    <thead>
	      <tr>
	        <th>Name</th>
	        <th>Type</th>
	        <th>Cost</th>
	        <th>Date</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr>
	        <td>tipol 10000</td>
	        <td>Car</td>
	        <td>350</td>
	        <td>2.7.20</td>
	      </tr>
	      <tr>
	        <td>Rent</td>
	        <td>House</td>
	        <td>1600</td>
	        <td>1.7.20</td>
	      </tr>
	      <tr>
	        <td>Hamborger at Vetrina</td>
	        <td>Food</td>
	        <td>110</td>
	        <td>5.7.20</td>
	      </tr>
	    </tbody>
	  </table>
	</div>

</body>
</html>