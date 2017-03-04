<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shipping Address</title>
</head>
<body>
<div class = fluid-container>
<h1>Shipping Address</h1>

<div class = "form-group">
<label for="" class="control-label col-sm-2">Line1</label>
<div class="col-sm-10">
<form:errors path="line1" class="error"/>
<form:input path="line1" type="text" class="form-control"/>
</div>
</div>
<div class = "form-group">
<label for="" class="control-label col-sm-2">Line2</label>
<div class="col-sm-10">
<form:errors path="line2" class="error"/>
<form:input path="line2" type="text" class="form-control"/>
</div>
</div>
<div class = "form-group">
<label for="" class="control-label col-sm-2">City</label>
<div class="col-sm-10">
<form:errors path="city" class="error"/>
<form:input path="city" type="text" class="form-control" required="true"/>
</div>
</div>
<div class = "form-group">
<label for="" class="control-label col-sm-2">State</label>
<div class="col-sm-10">
<form:errors path="state" class="error"/>
<form:input path="state" type="text" class="form-control" required="true"/>
</div>
</div>
<div class = "form-group">
<label for="" class="control-label col-sm-2">Country</label>
<div class="col-sm-10">
<form:errors path="country" class="error"/>
<form:input path="country" type="text" class="form-control" required="true"/>
</div>
</div>
<div class = "form-group">
<label for="" class="control-label col-sm-2">Zip code</label>
<div class="col-sm-10">
<form:errors path="zipCode" class="error"/>
<form:input path="zipCode" type="text" pattern="^{1,9}"class="form-control"/>
</div>
</div>
<div class="col-md-offset-3">
<input type="submit" name="_eventId_submit" class="btn btn-md btn-success" value="next">
<input type="submit" name="_eventId_cancel" class="btn btn-md btn-danger" value="Cancel"></div>

</div>
</div>
</div>

</body>
</html>