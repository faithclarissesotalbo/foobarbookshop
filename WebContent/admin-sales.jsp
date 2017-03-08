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
<title>Foobar Bookshop: Admin &mdash;€” Sales Information</title>
  <%@ include file="admin-template-css.jsp" %>

<!-- Controller -->
<script src="assets/js/controller/controller.js"></script>

</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
	<div class="left-content">
	   <div class="inner-content">
			<%@ include file="admin-header.jsp" %>
				
				<!--content-->
			<div class="content">		
				<div class="col-md-12 women_main">
					<h2>Sales per Product</h2>
					<table class="table">
					<thead>
					  <tr>
					    <th>Product Name</th>
					    <th>Price</th>
					    <th>Total Sales (&#8369;)</th>
					  </tr>
					</thead>
					<tbody>
					  <c:forEach items="${salesperproduct}" var="p">
					  <tr>
					    <td>${p.title}</td>
					    <td>${p.price}</td>
					    <td>${p.qty}</td>
					  </tr>
					  </c:forEach>

					</tbody>
					</table>

					<hr>
					<h2>Sales per Product Type</h2>
					<table class="table">
					<thead>
					  <tr>
					    <th>Product Type</th>
					    <th>Total Sales (&#8369;)</th>
					  </tr>
					</thead>
					<tbody>
					  <c:forEach items="${producttype}" var="p">
					  <tr>
					    <td>${p.type}</td>
					    <td>${p.price}</td>
					  </tr>
					  </c:forEach>
					</tbody>
					</table>		

					<hr>
					<h2>Total Sales: &#8369; ${totalsales}</h2>
				</div>
							
		<div class="content-top">
		</div>
		<div class="clearfix"> </div>
<%@ include file="admin-sidebar.jsp" %>

</body>
</html>