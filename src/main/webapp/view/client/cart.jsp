<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="Description" content="Enter your description here"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/cart.css">
    <link rel="shortcut icon" type="image/png"
          href="${pageContext.request.contextPath}/assets/img/apple-brand-white.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
</head>
<body>
<div class="main" id="on-top">
    <jsp:include page="layout/header.jsp"/>
    <fmt:setLocale value="en_US"/>
    <div class="body">
        <div class="container">
            <div class="body__header">
                <div class="body__header__total">
                    Your bag total is
                    <span class="total-price-cart">
                        <fmt:formatNumber value="${totalPrice}" type="currency"/>
                    </span>
                </div>
                <div class="body__header__title">
                    Free delivery and free returns.
                </div>
            </div>
            <hr>
            <div class="body__list" id="cart-item-list">
                <c:forEach var="cartItem" items="${listCartItem}">
                    <div class="body__item ">
                        <div class="body__item__img col-xxl-4 col-xl-4 col-lg-4">
                            <img src="${pageContext.request.contextPath}/image/${cartItem.productDetail.productColor.bgImage}"
                                 alt="">
                        </div>
                        <div class="body__item__detail col-xxl-8 col-xl-8 col-lg-8">
                            <div class="body__item__detail__name">
                                    ${cartItem.productDetail.name}
                            </div>
                            <div class="body__item__detail__amount">
                                <input type="number"
                                       class="amount-product"
                                       name=""
                                       min="1"
                                       onchange="updateQuantity(${cartItem.id}, ${cartItem.cart.id}, this)"
                                       value=${cartItem.quantity}
                                               oninput="validity.valid||(value='')">
                            </div>
                            <div class="body__item__detail__option">
                                <div class="body__item__detail__option__price">
                                    <c:set var="price"
                                           value="${(cartItem.productDetail.price - (cartItem.productDetail.price * cartItem.productDetail.product.discount)) * cartItem.quantity}"/>
                                    <fmt:formatNumber value="${price}" type="currency"/>
                                </div>
                                <a onclick="remove(${cartItem.id}, ${cartItem.cart.id}, this)" class="body__item__detail__option__remove">
                                    Remove
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            <div class="body__checkout offset-xxl-4">
                <div class="body__checkout__sub-total">
                    SubTotal
                    <div class="body__checkout__sub-total__price">
                        <span class="total-price-cart"><fmt:formatNumber value="${totalPrice}" type="currency"/></span>
                    </div>
                </div>
                <div class="body__checkout__shipping">
                    Shipping
                    <div class="body__checkout__shipping__price">
                        FREE
                    </div>
                </div>
                <hr>
                <div class="body__checkout__total">
                    Total
                    <div class="body__checkout__total__price">
                        <span class="total-price-cart"><fmt:formatNumber value="${totalPrice}" type="currency"/></span>
                    </div>
                </div>
                <div class="body__checkout__btn">
                    <div class="body__checkout__btn__title">
                        How would you like to check out?
                    </div>
                    <div class="body__checkout__btn__list">
                        <div class="body__checkout__btn__item">
                            <div class="body__checkout__btn__item__title">
                                Pay in Full
                            </div>
                            <a href="${pageContext.request.contextPath}/apple-store/checkout" id="pay-in-full">Check
                                Out </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="layout/footer.jsp"/>
</div>
<a href="#on-top" class="button-on-top">
    <i class="fas fa-chevron-up"></i>
</a>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${pageContext.request.contextPath}/assets/js/navigation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/scroll.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/cart.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>

<script>
    function updateQuantity(cartItemId, cartId, event) {
        let quantity = event.value;
        let formData = new FormData();
        formData.append("quantity", quantity);
        jQuery.ajax({
            url: "${pageContext.request.contextPath}/api/cart-item/" + cartItemId,
            type: "PUT",
            processData: false,
            contentType: false,
            data: formData,
            success: function (response) {
                if (response.success) {
                    let cartItem = response.data;
                    let price = (cartItem.productDetail.price - (cartItem.productDetail.price * cartItem.productDetail.product.discount)) * cartItem.quantity;
                    jQuery(event).parent().next().children(".body__item__detail__option__price").text("$" + price.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,") + ".00");
                }
            }
        }).then(function () {
            jQuery.ajax({
                url: "${pageContext.request.contextPath}/api/cart-item/totalPriceInCart" + cartId,
                type: "GET",
                success: function (response) {
                    if (response.success) {
                        let totalPrice = response.data;
                        jQuery(".total-price-cart").text("$" + totalPrice.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,") + ".00");
                    }
                }
            })
        })


    }

    function remove(cartItemId, cartId, event) {
        Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.value) {
                jQuery.ajax({
                    url: "${pageContext.request.contextPath}/api/cart-item/" + cartItemId,
                    type: "DELETE",
                    success: function (response) {
                        if (response.success) {
                            Swal.fire(
                                'Deleted!',
                                'Product has been deleted.',
                                'success'
                            ).then(function () {
                                let removeClass = jQuery(event);
                                jQuery(removeClass).parents(".body__item").remove();

                                jQuery.ajax({
                                    url: "/api/cart-item",
                                    type: "GET",
                                    dataType: "json",
                                    processData: false,
                                    contentType: false,
                                    success: function (response) {
                                        if (response.success) {
                                            let listCartItem = response.data;
                                            jQuery("#quantity").text(listCartItem.length);
                                            jQuery("#list-cart-item").empty();
                                            for (let cartItem of listCartItem) {
                                                let html = `<div class="header__navbar__cart__item">
                                    <div class="header__navbar__cart__item__img">
                                        <img src="${pageContext.request.contextPath}/image/` + cartItem.productDetail.productColor.bgImage + `" alt="">
                                    </div>
                                    <div class="header__navbar__cart__item__name">
                                            ` + cartItem.productDetail.name + `
                                           <br>
                                           x` + cartItem.quantity + `
                                    </div>
                                </div>`;
                                                jQuery("#list-cart-item").append(html);
                                            }
                                        }

                                    }
                                });
                                jQuery.ajax({
                                    url: "${pageContext.request.contextPath}/api/cart-item/totalPriceInCart" + cartId,
                                    type: "GET",
                                    success: function (response) {
                                        if (response.success) {
                                            let totalPrice = response.data;
                                            jQuery(".total-price-cart").text("$" + totalPrice.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,") + ".00");
                                        }
                                    }
                                });
                            })

                        } else {
                            Swal.fire(
                                'Error!',
                                'Something went wrong.',
                                'error'
                            )
                        }
                    }
                });

            }
        })
    }


</script>
</body>
</html>
