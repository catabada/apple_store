<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="Description" content="Enter your description here"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/header_nav.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/checkout.css">
    <link rel="shortcut icon" type="image/png"
          href="${pageContext.request.contextPath}/assets/img/apple-brand-white.png">
    <title>Checkout</title>
</head>
<body>
<div class="main" id="on-top">
    <!-- Begin header -->
    <c:import url="layout/header.jsp"/>
    <!-- End  Header -->
    <form class="body">
        <div class="container">
            <div class="row">
                <h1 class="body__title col-xxl-12">
                    Check Out
                </h1>
                <div class="body__form col-xxl-6 ">
                    <div class="body__form_title">
                        User Details
                    </div>
                    <input type="text" class="body__form__input" name="fullname"
                           placeholder="Full Name" value="${user.first} ${user.last}" required>
                    <input type="text" class="body__form__input" name="phone-number" value="${user.phoneNumber}"
                           placeholder="Phone Number" required>
                    <input type="email" class="body__form__input" name="email" placeholder="Email" value="${user.email}"
                           required>
                    <input type="text" class="body__form__input" name="address" placeholder="Address"
                           value="${user.address}"
                           required>
                    <div class="form__item w-100">
                        <div class="body__form_title">
                            Payment Details
                        </div>
                        <div class="form__item__buttons">
                            <div class="form__item__buttons__item form__item__buttons__item--card">
                                <i class="far fa-credit-card"></i>
                                Credit Card
                            </div>
                            <div class="form__item__buttons__item form__item__buttons__item--card">
                                <i class="fab fa-cc-paypal"></i>
                                Paypal
                            </div>
                        </div>
                        <div class="form__item__inputs">
                            <div class="form__item__inputs__item w-100">
                                <div class="form__item__inputs__item__icon">
                                    <i class="fa fa-user" aria-hidden="true"></i>
                                </div>
                                <div class="form__item__inputs__item__input">
                                    <input type="text" placeholder="Card Holder Name">
                                </div>
                            </div>
                            <div class="form__item__inputs__item w-100">
                                <div class="form__item__inputs__item__icon">
                                    <i class="fa fa-credit-card" aria-hidden="true"></i>
                                </div>
                                <div class="form__item__inputs__item__input">
                                    <input type="text" placeholder="Card Number">
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="body__cart col-xxl-5 offset-xxl-1 ">
                    <h2 class="body__cart__tilte">
                        Cart Order
                    </h2>
                    <div class="body__cart--wrapper">
                        <div class="body__cart__list">
                            <c:forEach var="item" items="${listProInCart}">
                                <c:set var="cartItem" value="${cartItemDao.get(item.idCartItem)}"/>
                                <div class="body__cart__item">
                                    <div class="body__cart__item__img">
                                        <img src="${imageDao.get(productColorDao.getByIdProAndIdColor(cartItem.idProduct,cartItem.idColor).idImg).url}"
                                             alt="">
                                    </div>
                                    <div class="body__cart__item__detail">
                                        <div class="body__cart__item__detail__name">
                                                ${productDao.get(cartItem.idProduct).name}-${colorDao.get(cartItem.idColor).name}
                                            <c:set var="proOption"
                                                   value="${proOptionDao.get(cartItem.idProOption).nameOptions}"/>
                                            <c:if test="${proOption != '-1'}">
                                                -${proOption}
                                            </c:if>
                                        </div>
                                        <c:set var="amount" value="${cartItem.amount}"/>
                                        <div class="body__cart__item__detail__price">
                                            $${cartItem.price()}
                                        </div>
                                        <div class="body__cart__item__detail__amount">
                                            Amount: ${amount}
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <hr>
                        <div class="body__cart__total">
                            <div class="body__cart__total__title">
                                Total
                            </div>
                            <div class="body__cart__total__num">
                                $${cartDetailDao.totalPrice(idCart)}
                            </div>
                        </div>
                    </div>
                    <input type="submit" value="Check Out" class="body__cart__btn">
                </div>
            </div>
        </div>
    </form>
    <!-- Begin Footer -->
    <jsp:include page="layout/footer.jsp"/>
    <!-- End Footer -->
</div>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${pageContext.request.contextPath}/assets/js/checkout.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
</body>
</html>
