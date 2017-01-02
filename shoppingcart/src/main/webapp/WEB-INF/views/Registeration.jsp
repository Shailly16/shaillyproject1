<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registeration Page</title>
<style>
body {
	
  padding-top: 20px;
  padding-bottom: 20px;
}
.header,
.marketing,
.footer {
  padding-right: 15px;
  padding-left: 15px;
}
.header {
  border-bottom: 1px solid #ff0066;
}
.header h3 
{
  padding-bottom: 19px;
  margin-top: 0;
  margin-bottom: 0;
  line-height: 40px;
}
.footer {
  padding-top: 19px;
  color: #777;
  border-top: 1px solid #ff0066;
}



.container-narrow > hr {
  margin: 30px 0;
}

.jumbotron {
  text-align: center;
  border-bottom: 1px solid #e5e5e5;
}
.jumbotron .btn {
  padding: 14px 24px;
  font-size: 21px;
}

.header,
.marketing,
.footer 
  {
    padding-right: 0;
    padding-left: 0;
  }
  
  .header {
    margin-bottom: 30px;
  }
 
  .jumbotron {
    border-bottom: 0;
  }
}

</style>
</head>
<body>
${msg}
<div class="container">
    <h1 class="well">Sign Up</h1>
	<div class="col-lg-12">
	<div class="row">
	<form>
	<div class="row">
	<div class="col-sm-6">
	<label>First Name</label>
	<input type="text"  class="form-control" placeholder="First Name">
	</div>
	<div class="col-sm-6">
    <label>Last Name</label>
	<input type="text"  class="form-control" placeholder="Last Name">
	</div>
	</div>
					
	<div class="form-group">
	<label>Address</label>
    <textarea rows="3" class="form-control" placeholder=" Enter Address"></textarea></div>	
	<div class="row">
	<div class="col-sm-4 ">
	<label>City</label>
	<input type="text"  class="form-control" placeholder=" Enter City">
	</div>	
	<div class="col-sm-4">
	<label>State</label>
	<input type="text"  class="form-control" placeholder="Enter State">
	</div>	
	<div class="col-sm-4">
	<label>Zip</label>
	<input type="text"  class="form-control" placeholder=" Enter Zip code">
	</div>		
	</div>
	
	<div class="form-group">
	<div class="row">
	<div class="col-sm-6 ">
	<label>Phone Number</label>
	<input type="text"  class="form-control" placeholder="Enter Phone Number">
	</div>	
    <div class="col-sm-6 ">
	<label>Mobile</label>
	<input type="text"  class="form-control" placeholder="Enter Mobile">
	</div>	
	</div>	
	<div class="form-group">
	<label>Email Address</label>
	<input type="text"  class="form-control" placeholder="Enter mail">
	</div>	
	<button type="button" class="btn btn-lg btn-info">Submit</button>
	<button type="button" class="btn btn-lg btn-info">Reset</button>					
	</div>
	</form> 
	</div>
	</div>
	</div>
	
    
	
</body>
</html>