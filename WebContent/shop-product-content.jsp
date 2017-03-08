<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div id="product-pop-up" style="display: none; width: 700px;">
            <div class="product-page product-pop-up">
              <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-3">
                  <div class="product-main-image">
                    <img src="assets/img/thumbs/placeholder.jpg" alt="${p.title }" class="img-responsive">
                  </div>
                  <div class="product-other-images">
                    <a href="javascript:;" class="active"><img alt="Berry Lace Dress" src="assets/img/thumbs/placeholder.jpg"></a>
                    <a href="javascript:;"><img alt="Berry Lace Dress" src="assets/img/thumbs/placeholder.jpg"></a>
                    <a href="javascript:;"><img alt="Berry Lace Dress" src="assets/img/thumbs/placeholder.jpg"></a>
                  </div>
                </div>
                <div class="col-md-6 col-sm-6 col-xs-9">
                  <h1>${p.title }</h1>
                  <div class="price-availability-block clearfix">
                    <div class="price">
                      <strong><span>&#x20B1;</span>${p.price }</strong>
                    </div>
                    <div class="availability">
                      Availability: <strong>${p.stock }</strong>
                    </div>
                  </div>
                  <div class="description">
                    <p>${p.description }</p>
                  </div>
                  <div class="product-page-cart">
                    <div class="product-quantity">
                        <input id="product-quantity" type="text" value="1" readonly name="product-quantity" class="form-control input-sm">
                    </div>
                    <button class="btn btn-primary" type="submit">Add to cart</button>
                    <a href="shop-item.html" class="btn btn-default">More details</a>
                  </div>
                </div>

                <div class="sticker sticker-sale"></div>
              </div>
            </div>
    </div>
</body>
</html>