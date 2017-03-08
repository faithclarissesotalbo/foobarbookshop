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
<title>Foobar Bookshop: Admin &mdash;€” Home</title>
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
				<div class="col-md-12 women_main">
					<h2>Hello, ${member.firstname}!</h2>
					<p>Please navigate on the left sidebar to continue.</p>
				</div>
							
		<div class="content-top">
		</div>
		<div class="clearfix"> </div>
<%@ include file="admin-sidebar.jsp" %>
</body>
</html>