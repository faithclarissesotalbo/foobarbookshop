<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Template: Metronic Frontend Freebie - Responsive HTML Template Based On Twitter Bootstrap 3.3.4
Version: 1.0.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase Premium Metronic Admin Theme: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- Head BEGIN -->
<head>
  <meta charset="utf-8">
  <title>Foobar Bookshop &mdash; Shopping Cart</title>
    <%@ include file="shop-template-css.jsp" %>
</head>
	<%@ include file="shop-header.jsp" %>

    <div class="main">
      <div class="container">
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
          <!-- BEGIN CONTENT -->
          <div class="col-md-12 col-sm-12">
            <h1>Shopping cart</h1>
            <div class="goods-page" ng-app="">
              <div class="goods-data clearfix">
                <div class="table-wrapper-responsive">
                <table summary="Shopping cart">
                  <tr>
                    <th class="goods-page-image">Image</th>
                    <th class="goods-page-description">Description</th>
                    <th class="goods-page-quantity">Quantity</th>
                    <th class="goods-page-price">Unit price</th>
                    <th class="goods-page-total" colspan="2">Total</th>
                  </tr>
                  <c:forEach items="${cart}" var="p" varStatus="MyIndex">
	                  <tr>
	                    <td class="goods-page-image">
	                      <a href="javascript:;"><img src="assets/img/thumbs/placeholder.jpg" alt="Berry Lace Dress"></a>
	                    </td>
	                    <td class="goods-page-description">
	                      <h3><a href="javascript:;">${p.title}</a></h3>
	                      <em>${p.description}</em>
	                    </td>
	                    <td class="goods-page-quantity">
	                      <div class="col-md-5">
	                          <input readonly class="qty" type="number" min="1" value="${p.qty}" class="form-control input-sm">
	                      </div>
	                    </td>
	                    <td class="goods-page-price">
	                      <strong><span>&#8369;</span></strong><input class="uprice" type="hidden" value="${p.price}"><strong>${p.price}</strong>
	                    </td>
	                    <td class="goods-page-total">
	                      <div class="price"><strong><span>&#8369;</span></strong><strong>${p.price}</strong></div>
	                    </td>
	                    <td class="del-goods-col">
	                      <a class="del-goods" href="RemoveItem?id=${p.productid}">&nbsp;</a>
	                    </td>
	                  </tr>
	              </c:forEach>
                </table>
                </div>

                <div class="shopping-total">
                  <ul>
                    <li class="shopping-total-price">
                      <em>Total</em>
                      <strong><span>&#8369;</span></strong><strong id="totalprice"></strong>
                    </li>
                  </ul>
                </div>
              </div>
              <button class="btn btn-default" onclick="window.location.href='DisplayAllProducts?type=book';" type="submit">Continue shopping <i class="fa fa-shopping-cart"></i></button>
              <button class="btn btn-primary" onclick="window.location.href='CheckSession?type=checkout';" type="submit">Checkout<i class="fa fa-check"></i></button>
            </div>
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>

	<%@ include file="shop-footer.jsp" %>
	<script>
		var total = 0;
		var i = 0;
		
		for (var i = 0; i < $(".price").size(); i++) {
			total += $(".price").get(i);
			console.log(total);
		}

		$(".qty").bind('keyup mouseup', function () {
			i = $(".qty").index(this);
			//alert();
			//$("#price").text($(".uprice").get(i).value * $(".qty").get(i).value);            
		});
 		
	/* $("#price").text(${p.price} * $("#qty").val());  */
	</script>
<!-- END BODY -->
</html>