<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Foobar Bookshop: Admin &mdash; User Management</title>
  <%@ include file="admin-template-css.jsp" %>

</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
	<div class="left-content">
	   <div class="inner-content">
			<%@ include file="admin-header.jsp" %>
				
				<!--content-->
			<div class="content">
<div class="women_main">
	<!-- start content -->
	<div class="catalog">				
			<div id="tabs" class="tabs">
					
						<div class="graph">
							<nav>
								<ul>
									<form action="FindAccount" method="GET">
										<div class="form-group search">
												<input name="username" type="text" value="" placeholder="Search username">
												<input type="submit" value="">
										</div>
									</form>
								</ul>
							</nav>
								<div class="content tab">
									<section id="section-1" class="content-current">
										<!-- hidden field for category -->
										<form action="UpdateAccount" method="GET">
											<input type="hidden" name="type" value="book">
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Account ID</label>
													<div class="col-sm-4 ctl">
														<input type="text" name="accountid" class="form-control1" id="focusedinput" disabled value="${u.accountid}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>													
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Username</label>
													<div class="col-sm-4 ctl">
														<input type="text" name="username" class="form-control1" id="focusedinput" value="${u.username}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>											
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Password</label>
													<div class="col-sm-4 ctl">
														<input type="password" name="password" class="form-control1" id="focusedinput" value="${u.password}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">First Name</label>
													<div class="col-sm-3 ctl">
														<input type="text" name="firstname" class="form-control1" id="focusedinput" value="${u.firstname}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Last Name</label>
													<div class="col-sm-4 ctl">
														<input type="text" name="lastname" class="form-control1" id="focusedinput" value="${u.lastname}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Middle Initial</label>
													<div class="col-sm-1 ctl">
														<input type="text" name="midinitial" class="form-control1" id="focusedinput" value="${u.midinitial}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>	
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Email Address</label>
													<div class="col-sm-4 ctl">
														<input type="text" name="email" class="form-control1" id="focusedinput" value="${u.email}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>			
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Billing Address</label>
													<div class="col-sm-8 ctl">
														<input type="text" class="form-control1" id="focusedinput" value="">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>																							
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Delivery Address</label>
													<div class="col-sm-8 ctl">
														<input type="text" class="form-control1" id="focusedinput" value="">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>	
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Credit Card Number</label>
													<div class="col-sm-4 ctl">
														<input type="number" class="form-control1" id="focusedinput" value="">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>																						
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Credit Card Type</label>
													<div class="col-sm-4 ctl">
														<input type="text" class="form-control1" id="focusedinput" value="">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>		
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Credit Card Expiration</label>
													<div class="col-sm-3 ctl">
														<input type="date" class="form-control1" id="focusedinput" value="">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>		
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Role</label>
													<div class="form-group col-sm-3 ctl">
														<select name="accountype" id="field-2" required="true" class="form-control">
															<option value="customer" ${u.type == 'customer' ? 'selected="selected"' : ''}>Customer</option>
															<option value="accntmgr" ${u.type == 'accntmgr' ? 'selected="selected"' : ''}>Accounting Manager</option>
															<option value="prdctmgr" ${u.type == 'prdctmgr' ? 'selected="selected"' : ''}>Product Manager</option>
															<option value="admin" ${u.type == 'admin' ? 'selected="selected"' : ''}>Administrator</option>
														</select>
													</div>
													<div class="clearfix"></div>
												</div>
											</div>						
											<input type="hidden" name="status" value="${u.status}">																						
											<p align="center">
												<input type="submit" name="sub-1" value="Update User Profile" class="btn btn-primary">
											</form>	
											
											<form method="GET" action="ChangeStatusAccount">
												<input type="hidden" name="husername" value="${u.username}">
												<input type="hidden" name="hstatus" value="${u.status}">
												<input type="hidden" name="haccountid" value="${u.accountid}">
												<c:if test="${u.status == 'unlocked'}">
													<input type="submit" name="sub-1" value="Lock Account" class="btn btn-danger">
												</c:if>
												<c:if test="${u.status == 'locked'}">
													<input type="submit" name="sub-1" value="Unlock Account" class="btn btn-danger">
												</c:if>												
											</form>
											</p>	
																		
									</section>							
								</div><!-- /content -->
						</div>
												<!-- /tabs -->
											</div>	
								<script src="js/cbpFWTabs.js"></script>
									<script>
										new CBPFWTabs( document.getElementById( 'tabs' ) );
									</script>
											
	</div>

	<!-- end content -->
<%@ include file="admin-sidebar.jsp" %>
</body>
</html>