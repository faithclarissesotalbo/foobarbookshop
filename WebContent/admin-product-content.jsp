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
<title>Foobar Bookshop: Admin &mdash;€” View Product: ${p.title}</title>
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
			<div class="row single">
				<div class="det">
				  <div class="single_left">
					<div class="grid images_3_of_2">
						<div class="flexslider">
							        <!-- FlexSlider -->
										<script src="js/imagezoom.js"></script>
										  <script defer="" src="assets/js/jquery.flexslider.js"></script>
										<link rel="stylesheet" href="assets/css/flexslider.css" type="text/css" media="screen">

										<script>
										// Can also be used with $(document).ready()
										$(window).load(function() {
										  $('.flexslider').flexslider({
											animation: "slide",
											controlNav: "thumbnails"
										  });
										});
										</script>
									<!-- //FlexSlider-->

							  
							
						<div class="flex-viewport" style="overflow: hidden; position: relative;"><ul class="slides" style="width: 1200%; transition-duration: 0.6s; transform: translate3d(-864px, 0px, 0px);"><li data-thumb="assets/img/thumbs/placeholder.jpg" class="clone" aria-hidden="true" style="width: 288px; float: left; display: block;">
								   <div class="thumb-image"> <img src="assets/img/thumbs/placeholder.jpg" data-imagezoom="true" class="img-responsive" draggable="false"> </div>
								</li>
								
							  </ul></div><ul class="flex-direction-nav"><li class="flex-nav-prev"><a class="flex-prev" href="#">Previous</a></li><li class="flex-nav-next"><a class="flex-next" href="#">Next</a></li></ul></div>
				  </div>
				  <div class="desc1 span_3_of_2">
					<h3>${p.title}</h3>
					<span class="code">Synopsis/Summary: </span>
					<p>${p.description}</p>
						<div class="price">
							<span class="text">Price:</span>
							<span class="price-new">&#8369;${p.price}</span>
						</div>
					<div class="btn_form">
						<c:if test="${role == 'prdctmgr'}"><a href="Redirect?mode=edit&productid=${p.productid}&type=${p.type}">Edit</a>
						<a href="Redirect?mode=delete&productid=${p.productid}&type=${p.type}">Delete</a></c:if>
					</div>
			   	 </div>
          	    <div class="clearfix"></div>         	    
          	   </div>
	       </div>	       	
	  </div>
       	<div class="single-bottom1" style="text-align: left;">
			<h6>Reviews (${totalreviews})</h6>
			<c:forEach items="${reviews}" var="r">
				<a a href="#"><strong>${r.customerID}</strong></a><br>
				<small><strong>Date: </strong>${r.timestamp} | <strong>Rating: </strong>${r.rating} </small><br>
				<p>${r.comment}</p>
				<c:if test="${role == 'admin'}"><button type="submit" class="btn btn-danger" onclick="window.location='DeleteReview?id=${r.reviewID}&title=${p.productid}'">Delete Review</button></c:if>
				<hr>
			</c:forEach> 
		</div> 		
	<!-- end content -->
<%@ include file="admin-sidebar.jsp" %>
</body>
</html>