<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>

<div class="footer">
					<div class="clearfix"> </div>
						<p>© 2016 Gretong. All Rights Reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
			</div>
</div>
</div>
			<!--content-->
		</div>
</div>
	<!--//content-inner-->
<!--/sidebar-menu-->
	<div class="sidebar-menu">
		<header class="logo1">
			<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> 
		</header>
			<div style="border-top:1px ridge rgba(255, 255, 255, 0.15)"></div>
                        <div class="menu">
						<ul id="menu" >
							<li><a href="admin-index.jsp"><i class="fa fa-tachometer"></i> <span>Home</span></a></li>

						<li><a href="#"><i class="fa fa-file-text-o"></i> <span>Products</span> <span class="fa fa-angle-right" style="float: right"></span></a>
						  <ul>
						  	<c:if test="${role == 'prdctmgr'}"><li><a href="admin-add-product.jsp"><span><b>Add Product</b></span></a></li></c:if>
							<li><a href="DisplayAllProducts?type=book"></i> <span>Books</span></a></li>
							<li><a href="DisplayAllProducts?type=magazine"></i> <span>Magazines</span></a></li>
							<li><a href="DisplayAllProducts?type=audiocd"></i> <span>Audio CDs</span></a></li>
							<li><a href="DisplayAllProducts?type=dvd"></i> <span>DVDs</span></a></li>
						</ul>
						</li>
						<c:if test="${role == 'admin'}"><li id="menu-academico" ><a href="admin-users.jsp"><i class="lnr lnr-users"></i> <span>User Management</span></a></li></c:if>		
						<c:if test="${role == 'accntmgr'}"><li id="menu-academico" ><a href="DisplaySales"><i class="lnr lnr-chart-bars"></span></i> <span>Sales Information</span></a></li></c:if>	
						<li id="menu-academico" ><a href="LogoutAccount?id=${member.accountid}"><i class="lnr lnr-exit"></span></i> <span><strong>Logout</strong></span></a></li>									
					  </ul>
					</div>
				  </div>
				  <div class="clearfix"></div>		
				</div>
				<script>
				var toggle = true;
							
				$(".sidebar-icon").click(function() {                
				  if (toggle)
				  {
					$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
					$("#menu span").css({"position":"absolute"});
				  }
				  else
				  {
					$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
					setTimeout(function() {
					  $("#menu span").css({"position":"relative"});
					}, 400);
				  }
								
								toggle = !toggle;
							});
				</script>
		
</body>
</html>