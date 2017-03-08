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
<title>Foobar Bookshop: Admin &mdash; View Products</title>
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
   <div class="w_content">
		<div class="women">
			<a href="#"><h4>${filter} - <span>${total} items</span> </h4></a>
			<ul class="w_nav">
						<li>Sort : </li>
		     			<li><a class="active" href="#">popular</a></li> |
		     			<li><a href="#">new </a></li> |
		     			<li><a href="#">discount</a></li> |
		     			<li><a href="#">price: Low High </a></li> 
		     			<div class="clear"></div>	
		     </ul>
		     <div class="clearfix"></div>	
		</div>
		<!-- grids_of_4 -->	
	<c:forEach items="${products}" var="p">
	 	<div class="grid1_of_4">
			<div class="content_box"><a href="ViewProduct?title=${p.productid}">
		   	   	 <img src="assets/img/thumbs/placeholder.jpg" class="img-responsive" alt="${p.title}">
			   	  </a>
			    <h4><a href="ViewProduct?title=${p.productid}">${p.title}</a></h4>
			     <p>Stocks Left: ${p.stock}</p>		
			     <p>${p.description}</p>
				 <div class="grid_1 simpleCart_shelfItem">
			    
				 <div class="item_add"><span class="item_price"><h6>&#x20B1;${p.price}</h6></span></div>		 
				 </div>
		   	</div>
		</div>
	</c:forEach>
		
	</div>
   <div class="clearfix"></div>
	<!-- end content -->

<%@ include file="admin-sidebar.jsp" %>
</body>
</html>