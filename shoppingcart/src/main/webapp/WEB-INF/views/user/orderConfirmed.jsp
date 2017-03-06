<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
	
	 <div class="container">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<sf:form class="form-signin" modelAttribute="address">


				
					<div class="row">
						
						<div class="col-md-4">THANK YOU <b>${address.cname}</b></div><br>
						<div class="col-md-4"><b>Your Zip Code is ${address.zipcode} </b> </div><br>
						<div class="col-md-4"> <b>Your phone no is ${address.phone} </b> </div></div><br>
						<div class="row">
						<div class="col-md-4"></div>
						<div class="col-md-8"><b>  YOUR ORDER WILL BE DISPATCH IN ${address.caddress}</b>
						<input class="btn btn-info" name="_eventId_submit" type="submit" value="BACK TO HOME PAGE" />
								
						</div>
						</div>
					</div>
					<br />

				</sf:form>

			</div>
		</div>