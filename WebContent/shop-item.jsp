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
  <title>Foobar Bookshop &mdash; ${p.title} </title>
    <%@ include file="shop-template-css.jsp" %>
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
	<%@ include file="shop-header.jsp" %>
    
    <div class="main">
      <div class="container">
        <ul class="breadcrumb">
            <li><a href="index.html">Home</a></li>
            <li><a href="">Store</a></li>
            <li class="active">Product</li>
        </ul>
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40" ng-app="">
          <!-- BEGIN CONTENT -->
          <form action="AddtoCart" method="GET">
          <!-- para makauha -->
          <input type="hidden" value="${p.productid}" name="title">
          <div class="col-md-12 col-sm-12">
            <div class="product-page">
              <div class="row">
                <div class="col-md-6 col-sm-6">
                  <div class="product-main-image">
                    <img src="assets/img/thumbs/placeholder.jpg" alt="Cool green dress with red bell" class="img-responsive" data-BigImgsrc="assets/img/thumbs/placeholder.jpg">
                  </div>
                  <div class="product-other-images">
                    <a href="assets/img/thumbs/placeholder.jpg" class="fancybox-button" rel="photos-lib"><img alt="Berry Lace Dress" src="assets/img/thumbs/placeholder.jpg"></a>
                    <a href="assets/img/thumbs/placeholder.jpg" class="fancybox-button" rel="photos-lib"><img alt="Berry Lace Dress" src="assets/img/thumbs/placeholder.jpg"></a>
                    <a href="assets/img/thumbs/placeholder.jpg" class="fancybox-button" rel="photos-lib"><img alt="Berry Lace Dress" src="assets/img/thumbs/placeholder.jpg"></a>
                  </div>
                </div>
                <div class="col-md-6 col-sm-6">
                  <h1>${p.title }</h1>
                  <div class="price-availability-block clearfix">
                    <div class="price">
                      <strong><span>&#x20B1;</span></strong><strong id="price">${p.price}</strong>
                    </div>
                    <div class="availability">
                      Availability: <strong>${p.stock} left</strong>
                    </div>
                  </div>
                  <div class="description">
                    <p>${p.description }</p>
                  </div>
                  <div class="product-page-cart">
                  <div class="col-md-3" >
                        <input id="qty" name="qty" value="1" type="number" min="1" max="${p.stock}" class="form-control input-sm">
                  </div>
                     <input class="btn btn-primary" <c:if test="${empty member}"> data-toggle="tooltip" data-placement="Please sign in to have this feature." disabled </c:if> type="submit" value="Add to cart">
                  </div>
                  </form>
                  <div class="review">
                    <input type="range" value="4" step="0.25" id="backing4">
                    <div class="rateit" data-rateit-backingfld="#backing4" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5">
                    </div>
                    <a href="#Reviews">${totalreviews} reviews</a>&nbsp;&nbsp;|&nbsp;&nbsp;<c:if test="${status == true}"><a href="#ReviewSection">Write a review</a></c:if>
                  </div>
                  <ul class="social-icons">
                    <li><a class="facebook" data-original-title="facebook" href="javascript:;"></a></li>
                    <li><a class="twitter" data-original-title="twitter" href="javascript:;"></a></li>
                    <li><a class="googleplus" data-original-title="googleplus" href="javascript:;"></a></li>
                    <li><a class="evernote" data-original-title="evernote" href="javascript:;"></a></li>
                    <li><a class="tumblr" data-original-title="tumblr" href="javascript:;"></a></li>
                  </ul>
                </div>

                <div class="product-page-content"> 
                  <ul id="myTab" class="nav nav-tabs">
                    <li class="active"><a href="#Reviews" id="Reviews" data-toggle="tab">Reviews (${totalreviews}) </a></li>
                  </ul>
                  <div id="myTabContent" class="tab-content">
                    <div class="tab-pane fade in active">
                      <c:if test="${totalreviews == 0}"><p>There are no reviews for this product. Be the first one to review!</p></c:if>
                      <c:if test="${totalreviews > 0}"> 
                      	<c:forEach items="${reviews}" var="r">
	                      <div class="review-item clearfix">
	                        <div class="review-item-submitted">
	                          <strong>${r.customerID}</strong>
	                          <em>${r.timestamp}</em>
	                          <div class="rateit" data-rateit-value="${r.rating}" data-rateit-ispreset="true" data-rateit-readonly="true"></div>
	                        </div>                                              
	                        <div class="review-item-content">
								<p>${r.comment}</p>
	                        </div>
	                      </div>
	                    </c:forEach>
					  </c:if>
                      <!-- BEGIN FORM-->
                      <c:if test="${status == true}">
	                      <form action="AddReview" class="reviews-form" role="form" id="ReviewSection">
	                        <h2>Write a review</h2>
	                        <div class="form-group">
	                          <label for="email">Rating</label>
	                          <input type="range" name="rating" value="4" step="0.25" id="backing5">
	                          <div class="rateit" data-rateit-backingfld="#backing5" data-rateit-resetable="false"  data-rateit-ispreset="true" data-rateit-min="0" data-rateit-max="5">
	                          </div>
	                        </div>	                        
	                        <div class="form-group">
	                          <label for="review">Review <span class="require">*</span></label>
	                          <br>No special characters allowed.
	                          <textarea class="form-control" required rows="8" id="review" name="comment"></textarea>
	                        </div>
	                        <div class="padding-top-20">                  
	                          <button type="submit" class="btn btn-primary">Send</button>
	                        </div>
	                        <input type="hidden" value="${p.productid}" name="productid">
	                      </form>
                      </c:if>
                      <!-- END FORM--> 
                    </div>
                  </div>
                </div>

                <div class="sticker sticker-sale"></div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>

<%@ include file="shop-footer.jsp" %>
	<script>
		$("#qty").bind('keyup mouseup', function () {
		   $("#price").text(${p.price} * $("#qty").val());            
		});

	</script>
</body>
<!-- END BODY -->
</html>