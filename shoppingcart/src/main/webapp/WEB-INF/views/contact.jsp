<%@ include file="header.jsp" %>
	<section>
	
     <section id="contact-page">
        <div class="container">
        <h2>Contact Us</h2>
        <p> Bellezza<br>
            Building-25, Hiranandani-Andheri,Mumbai
            Maharashtra-522631<br>
            Contact No. 026-7826596315<br>
            Email:bellezzaHouse@gmail.com</p>
            <div class="center">        
                <h3>Drop Your Message</h3>  
            </div> 
            <div class="row contact-wrap"> 
                
                <form:form id="main-contact-form" class="contact-form" name="contact-form" method="post" action="addContact" commandName="contact">
                    <div class="col-sm-5 col-sm-offset-1">
                        <div class="form-group">
                            <label>Name *</label>
                            <form:input path="Name" name="Name" class="form-control" />
                             <form:errors cssStyle="color:ff0000" path="Name"></form:errors>
                        </div>
                        <div class="form-group">
                            <label>Email *</label>
                            <form:input path="email" name="email" class="form-control" required="required" />
                        </div>
                        <div class="form-group">
                            <label>Subject</label>
                            <form:input path="subject" class="form-control" />
                        </div>
                        <div class="form-group">
                            <label>Company Name</label>
                            <form:input path="company" class="form-control" />
                        </div>                        
                    </div>
                    <div class="col-sm-5">
                        <div class="form-group">
                            <label>Phone *</label>
                            <form:input path="mobile" name="mobile" class="form-control" required="required" />
                        </div>
                        <div class="form-group">
                            <label>Message *</label>
                            <form:input path="message" id="message" required="required" class="form-control" />
                        </div>                        
                        <div class="form-group">
                            <button type="submit" name="submit" class="btn btn-primary btn-lg">Submit Message</button>
                        </div>
                    </div>
                </form:form> 
            </div>
        </div>
    </section>

	</section>
	<%@ include file="Footer.jsp" %>