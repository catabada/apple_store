<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/footer.css">
    <title>Title</title>
</head>
<body>
<div class="footer">
    <div class="container">
        <div class="footer-container">
            <div class="footer-aboutUs">
                <h1 class="footer-aboutUs__title">
                    About us
                </h1>
                <p class="footer-aboutUs__descrip">
                    We are a non-profit organization. We created this website for learning purposes only. If you
                    have any copyright issues, please contact us. We are always ready and willing to deal.
                </p>
            </div>
            <div class="footer-temp"></div>
            <div class="footer-product">
                <h1 class="footer-product__title" >
                    Product
                </h1>
                <div class="footer-product-name">
                    <c:forEach var="type" items="${listType}">
                        <a href="#" id="iphone" class="footer-product__name-text">${type.getName()}</a>
                    </c:forEach>
                </div>
            </div>
            <div class="footer-service">
                <h1 class="footer-service__title" >
                    Service
                </h1>
                <div class="footer-service-list">
                    <a href="#" id="footer-search" class="footer-service__items">Search Terms </a>
                    <a href="#" id="footer-order" class="footer-service__items">Order and Returns </a>
                    <a href="#" id="footer-contact" class="footer-service__items">Contact Us </a>
                </div>
            </div>
            <div class="footer-payment">
                <h1 class="footer-payment__title" >
                    Payment
                </h1>
                <div class="footer-payment__icon-alpha">
                    <img class="payment-img" src="${pageContext.request.contextPath}/assets/img/home/visa.jpg" alt="">
                    <img class="payment-img" src="${pageContext.request.contextPath}/assets/img/home/paypal.png" alt="">
                </div>
                <div class="footer-payment__icon-omega">
                    <img class="payment-img" src="${pageContext.request.contextPath}/assets/img/home/mastercard.png" alt="">
                    <img class="payment-img" src="${pageContext.request.contextPath}/assets/img/home/google.png" alt="">
                </div>
            </div>
        </div>
    </div>
    <div class="author">
        <img src="${pageContext.request.contextPath}/assets/img/apple-brand-white.png" alt="" id="author-icon">
        <p class="author-text">Design By A.H Group</p>
    </div>
</div>
</body>
</html>
