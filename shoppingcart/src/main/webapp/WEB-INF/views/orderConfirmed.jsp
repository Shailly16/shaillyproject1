<html>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ include file="./header.jsp" %>
<style>
body
{
    background: url('${pageContext.request.contextPath}/resources/img/background.jpg') fixed;
    background-size: cover;
    padding: 0;
    margin: 0;
}
</style>

	
	 <div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<sf:form class="form-signin" modelAttribute="address">


				
					<div class="row">
						
						<div class="col-md-4"><b>THANK YOU ${address.cname}</b></div><br>
						<div class="col-md-4"><b>Your Zip Code is ${address.zipcode} </b> </div><br>
						<div class="col-md-4"> <b>Your phone no is ${address.phone} </b> </div><br>
						<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-8"><b>  Your Order will be dispatched to address: ${address.caddress} Soon</b>
						<br>
						<br>
						<input class="btn btn-info" name="_eventId_submit" type="submit" value="BACK TO HOME PAGE" />
								
						</div>
						</div>
					</div>
					<br />

				</sf:form>
</div>
			</div>
		</div>
		</html>