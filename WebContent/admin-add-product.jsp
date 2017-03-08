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
<title>Foobar Bookshop: Admin &mdash; Add Product</title>
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
									<li class="tab-current"><a href="#section-1" class="icon-shop"><span>Book</span></a></li>
									<li><a href="#section-2" class="icon-cup"><span>Magazine</span></a></li>
									<li><a href="#section-3" class="icon-food"><span>Audio CD</span></a></li>
									<li><a href="#section-4" class="icon-lab"><span>DVD</span></a></li>
								</ul>
							</nav>
								<div class="content tab">
									<section id="section-1" class="content-current">
										<!-- hidden field for category -->
										<c:if test="${product.productid != null}">
											<form action="UpdateProduct" method="GET">
										</c:if>
										<c:if test="${product.productid == null}">
											<form action="AddProduct" method="GET">
										</c:if>										
											<input type="hidden" name="producttype" value="book">
											<input type="hidden" name="productid" value="${product.productid}">
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Title</label>
													<div class="col-sm-8 ctl">
														<input type="text" name="producttitle" class="form-control1" id="focusedinput" placeholder="The Rock and Roll Destroyer" value="${product.title}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Author</label>
													<div class="col-sm-6 ctl">
														<input type="text" name="productauthor" class="form-control1" id="focusedinput" placeholder="Eldes Gonzales" value="${book.author}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>											
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Synopsis/Summary</label>
													<div class="col-sm-8 ctl">
														<textarea name="productdesc" id="field-4" required="true" class="form-control">${product.description}</textarea>
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Genre</label>
													<div class="col-sm-4 ctl">
														<input type="text" name="productgenre" class="form-control1" id="focusedinput" placeholder="Horror" value="${product.genre}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>													
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Stock</label>
													<div class="col-sm-2 ctl">
														<input type="number" name="productstock" class="form-control1" id="focusedinput" placeholder="1" value="${product.stock}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>																							
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label" type="number" step="any">Price (&#8369;)</label>
													<div class="col-sm-2 ctl">
														<input type="text" name="productprice" class="form-control1" id="focusedinput" placeholder="150.00" value="${product.price}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Acquire Date</label>
													<div class="col-sm-4 ctl">
														<input type="date" name="productacquiredate" class="form-control1" id="focusedinput" value="${product.acquiredate}">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>											
											<p align="center">
												<input type="submit" name="sub-1" value="Submit" class="btn btn-primary">
											</p>	
										</form>									
									</section>
									<section id="section-2">
										<!-- hidden field for category -->
										<c:if test="${product.productid != null}">
											<form action="UpdateProduct" method="GET">
										</c:if>
										<c:if test="${product.productid == null}">
											<form action="AddProduct" method="GET">
										</c:if>	
											<input type="hidden" name="producttype" value="magazine">
											<input type="hidden" name="productid" value="${product.productid}">											
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Title</label>
													<div class="col-sm-8 ctl">
														<input type="text" name="producttitle" class="form-control1" id="focusedinput" placeholder="The Rock and Roll Destroyer">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Synopsis/Summary</label>
													<div class="col-sm-8 ctl">
														<textarea name="productdesc" id="field-4" required="true" class="form-control"></textarea>
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Price (&#8369;)</label>
													<div class="col-sm-2 ctl">
														<input type="text" name="productprice" class="form-control1" id="focusedinput" placeholder="150.00">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<p align="center">
												<input type="submit" name="sub-1" value="Submit" class="btn btn-primary">
											</p>	
										</form>												
									</section>
									<section id="section-3">
										<!-- hidden field for category -->
										<c:if test="${product.productid != null}">
											<form action="UpdateProduct" method="GET">
										</c:if>
										<c:if test="${product.productid == null}">
											<form action="AddProduct" method="GET">
										</c:if>	
											<input type="hidden" name="producttype" value="audio_cd">
											<input type="hidden" name="productid" value="${product.productid}">											
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Title</label>
													<div class="col-sm-8 ctl">
														<input type="text" name="producttitle" class="form-control1" id="focusedinput" placeholder="The Rock and Roll Destroyer">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Synopsis/Summary</label>
													<div class="col-sm-8 ctl">
														<textarea name="productdesc" id="field-4" required="true" class="form-control"></textarea>
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Price (&#8369;)</label>
													<div class="col-sm-2 ctl">
														<input type="text" name="productprice" class="form-control1" id="focusedinput" placeholder="150.00">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<p align="center">
												<input type="submit" name="sub-1" value="Submit" class="btn btn-primary">
											</p>	
										</form>													
									</section>
									<section id="section-4">
										<!-- hidden field for category -->
										<c:if test="${product.productid != null}">
											<form action="UpdateProduct" method="GET">
										</c:if>
										<c:if test="${product.productid == null}">
											<form action="AddProduct" method="GET">
										</c:if>	
											<input type="hidden" name="producttype" value="dvd">
											<input type="hidden" name="productid" value="${product.productid}">											
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Title</label>
													<div class="col-sm-8 ctl">
														<input type="text" name="producttitle" class="form-control1" id="focusedinput" placeholder="The Rock and Roll Destroyer">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Synopsis/Summary</label>
													<div class="col-sm-8 ctl">
														<textarea name="productdesc" id="field-4" required="true" class="form-control"></textarea>
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<div class="fo-top">
												<div class="form-group">
													<label for="focusedinput" class="col-sm-2 control-label">Price (&#8369;)</label>
													<div class="col-sm-2 ctl">
														<input type="text" name="productprice" class="form-control1" id="focusedinput" placeholder="150.00">
													</div>
													<div class="clearfix"></div>
												</div>
											</div>
											<p align="center">
												<input type="submit" name="sub-1" value="Submit" class="btn btn-primary">
											</p>	
										</form>												
									</section>								
								</div><!-- /content -->
						</div>
												<!-- /tabs -->
											</div>	
								<script src="assets/js/cbpFWTabs.js"></script>
									<script>
										new CBPFWTabs( document.getElementById( 'tabs' ) );
									</script>
											
	</div>

	<!-- end content -->
<%@ include file="admin-sidebar.jsp" %>
</body>
</html>