<%--<%@ page import="dao.ProductColorDAO" %>--%>
<%--<%@ page import="model.ProductColor" %>--%>
<%--<%@ page import="java.util.ArrayList" %>--%>
<%--<%@ page import="dao.CartDetailDAO" %>--%>
<%--<%@ page import="helper.Helper" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="Description" content="Enter your description here"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/header_nav.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/detail-product.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/responsive-detail.css">
    <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css"/>
    <title>Apple Store</title>
</head>
<body>
<form class="main" method="post" id="on-top">
    <c:import url="layout/header.jsp"/>

    <div class="breadcrumb">
        <div class="container">
            <div class="breadcrumb--wrapper">
                <%--                <input class="idPro" hidden type="text" name="id-product" value="${productDetail.id}"/>--%>
                <%--                <input hidden type="text" name="" id="name-product" value="${product.name}">--%>

                <div class="breadcrumb__name-product">${product.name}</div>
                <div class="breadcrumb__price-product">
                </div>
                <div class="breadcrumb__price-product breadcrumb__price-product--active" id="breadcrumb-price">
                    <fmt:setLocale value="en_US"/>
                    <c:set var="sales" value="${product.price - product.price * product.discount}"/>
                    <fmt:formatNumber value="${sales}" type="currency"/>
                </div>
            </div>
        </div>
    </div>
    <div class="body">
        <div class="container">
            <div class=" body--wrapper">
                <div class="col-xxl-6 col-xl-6 body__images">
                    <c:forEach var="productColor" items="${listProductColor}">
                        <div class="body__images--wrapper" id="image-color-${productColor.id}">
                            <div class="col-xxl-3 col-xl-3 body__images-list">
                                <c:forTokens items="${productColor.deImages}" delims="_" var="nameImage">
                                    <div class="body__images-item">
                                        <img src="${pageContext.request.contextPath}/image/${nameImage}" alt=""
                                             class="body__images-item-img">
                                    </div>
                                </c:forTokens>
                            </div>
                            <div class="col-xxl-9 col-xl-9 body__images-bg"
                                 style="background-image: url('${pageContext.request.contextPath}/image/${productColor.bgImage}')">
                            </div>
                                <%--                            <input hidden  type="text" name="" id="image-product" value="${imageDao.get(productColorDao.getByIdProAndIdColor(product.id, proColor.idColor).idImg).url}">--%>
                        </div>
                    </c:forEach>

                    <div class="col-xxl-12 col-xl-12 body__images__delivery">
                        <div class="body__images__delivery__list">
                            <div class="body__images__delivery__item">
                                <svg viewBox="0 0 35 35"
                                     class="as-svgicon as-svgicon-shipping as-svgicon-base as-svgicon-shippingbase"
                                     role="img" aria-hidden="true" width="35px" height="35px">
                                    <path fill="none" d="M0 0h35v35H0z"></path>
                                    <path
                                            d="M27.687 10.547l-9-4.852a2.5 2.5 0 00-2.373 0l-9 4.852A2.5 2.5 0 006 12.748v9.471a2.494 2.494 0 001.313 2.2l9 4.852a2.5 2.5 0 002.373 0l9-4.852a2.5 2.5 0 001.314-2.2v-9.471a2.5 2.5 0 00-1.313-2.201zm-10.9-3.971a1.5 1.5 0 011.424 0l9 4.852c.041.022.072.055.11.081l-4.41 2.507-9.628-5.55zm-4.538 2.446l9.651 5.566-4.4 2.5-9.823-5.58c.038-.026.07-.059.111-.081zM7.788 23.539A1.5 1.5 0 017 22.219v-9.471a1.494 1.494 0 01.069-.436L17 17.957v10.516a1.494 1.494 0 01-.212-.082zM28 22.219a1.5 1.5 0 01-.788 1.32l-9 4.851a1.481 1.481 0 01-.212.082V17.957l9.931-5.646a1.5 1.5 0 01.069.436z">
                                    </path>
                                </svg>
                                <div class="body__images__delivery__content">
                                    Get free delivery, or pick up available items at an Apple Store
                                </div>
                            </div>
                            <div class="body__images__delivery__item">
                                <svg viewBox="0 0 35 35"
                                     class="as-svgicon as-svgicon-return as-svgicon-base as-svgicon-returnbase"
                                     role="img" aria-hidden="true" width="35px" height="35px">
                                    <path fill="none" d="M0 0h35v35H0z"></path>
                                    <path
                                            d="M12.249 9.022l-4.461 2.4c-.041.022-.073.055-.111.081l9.823 5.588 4.4-2.5zM27.322 11.507c-.038-.025-.069-.058-.11-.081l-9-4.852a1.5 1.5 0 00-1.424 0l-3.5 1.889 9.628 5.55zM10.8 18.5a.5.5 0 01-.5.5H7v3.219a1.5 1.5 0 00.788 1.32l9 4.852a1.494 1.494 0 00.212.082V17.957l-9.931-5.645a1.494 1.494 0 00-.069.436V18h3.3a.5.5 0 01.5.5zM18 17.957v10.515a1.481 1.481 0 00.212-.082l9-4.851a1.5 1.5 0 00.788-1.32v-9.471a1.5 1.5 0 00-.069-.436z"
                                            fill="none"></path>
                                    <path
                                            d="M27.687 10.547l-9-4.852a2.5 2.5 0 00-2.373 0l-9 4.852A2.5 2.5 0 006 12.748V17h1v-4.252a1.494 1.494 0 01.069-.436L17 17.957v10.516a1.494 1.494 0 01-.212-.082l-9-4.852A1.5 1.5 0 017 22.219V20H6v2.219a2.494 2.494 0 001.313 2.2l9 4.852a2.5 2.5 0 002.373 0l9-4.852a2.5 2.5 0 001.314-2.2v-9.471a2.5 2.5 0 00-1.313-2.201zm-10.9-3.971a1.5 1.5 0 011.424 0l9 4.852c.041.022.072.055.11.081l-4.41 2.507-9.628-5.55zm-9.11 4.932c.038-.026.07-.059.111-.081l4.461-2.4 9.651 5.561-4.4 2.5zM28 22.219a1.5 1.5 0 01-.788 1.32l-9 4.851a1.481 1.481 0 01-.212.082V17.957l9.931-5.646a1.5 1.5 0 01.069.436z">
                                    </path>
                                    <path
                                            d="M2.507 18l1.646-1.646a.5.5 0 00-.707-.707l-2.5 2.5a.5.5 0 000 .707l2.5 2.5a.5.5 0 10.707-.707L2.507 19H6v-1zM10.3 19a.5.5 0 000-1H7v1zM6 18h1v1H6z">
                                    </path>
                                </svg>
                                <div class="body__images__delivery__content">
                                    Free and easy returns
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xxl-6 col-xl-6 body__details">
                    <div class="body__details-detail">
                        <div class="body__details__detail__title">New</div>
                        <div class="body__details__detail__name">${product.name}
                            <span class="body__details__detail__name-color" id="color-name"></span>
                            <span class="body__details__detail__name-option" id="option-name"></span>
                        </div>
                        <div class="body__details__detail__evaluate">
                            <div class="body__details__detail__evaluate__stars">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                        </div>
                    </div>
                    <div class="body__details__choose-colors">
                        <div class="body__details__choose-colors__title">
                            Choose your Color.
                        </div>
                        <div class="body__details__choose-colors__list">
                            <c:set var="count" value="0"/>
                            <c:forEach var="item" items="${listProductColor}">
                                <label for="id-color-${item.id}"
                                       class="body__details__choose-colors__item--wrapper"
                                       onclick="getDataOptionByProductColorId(${item.id})"
                                >
                                    <div class="body__details__choose-colors__item" id="color-${item.id}">
                                        <div class="body__details__choose-colors__item__img-color"
                                             style="background-color:${item.color.hex};">
                                        </div>
                                        <div class="body__details__choose-colors__item__name-color">
                                                ${item.color.name}
                                        </div>
                                    </div>
                                </label>
                                <c:if test="${count == 0}">
                                    <input checked hidden type="radio" name="radio-color" id="id-color-${item.id}"
                                           value="${item.id}">
                                </c:if>
                                <c:if test="${count != 0}">
                                    <input hidden type="radio" name="radio-color" id="id-color-${item.id}"
                                           value="${item.id}">
                                </c:if>
                                <c:set var="count" value="${count + 1}"/>
                            </c:forEach>
                        </div>
                    </div>

                    <div class="body__details__choose-capacity" id="option-choose">

                    </div>
                    <hr class="hr-space">

                    <div class="body__details__summary">
                        <div class="body__details__summary__heading">
                            <div class="body__details__summary__heading__price" id="price-total">

                            </div>
                            <div class="body__details__summary__heading__payment-type">
                                One-time payment
                            </div>
                            <div class="body__details__summary__heading__note">
                                Get 3% Daily Cash with Apple Card
                            </div>
                        </div>
                        <hr>
                        <div class="body__details__summary__body">
                            <div class="body__details__summary__body__list">
                                <div class="body__details__summary__body__item">
                                    <svg viewBox="0 0 25 25"
                                         class="as-svgicon as-svgicon-shipping as-svgicon-reduced as-svgicon-shippingreduced"
                                         role="img" aria-hidden="true" width="25px" height="25px">
                                        <path fill="none" d="M0 0h25v25H0z"></path>
                                        <path
                                                d="M19.69 7.154l-6-3.245a2.5 2.5 0 00-2.38 0l-6 3.245A2.5 2.5 0 004 9.354v6.269a2.5 2.5 0 001.311 2.2l6 3.245a2.5 2.5 0 002.379 0l6-3.245a2.5 2.5 0 001.31-2.2V9.354a2.5 2.5 0 00-1.31-2.2zm-7.9-2.365a1.492 1.492 0 011.427 0l6 3.244a1.454 1.454 0 01.151.11l-2.931 1.665-6.743-3.886zM8.661 6.48l6.768 3.9-2.929 1.666-6.864-3.9a1.456 1.456 0 01.151-.11zM5.787 16.941A1.5 1.5 0 015 15.622V9.354a1.5 1.5 0 01.053-.39L12 12.912v7.358a1.463 1.463 0 01-.213-.083zM20 15.622a1.5 1.5 0 01-.786 1.319l-6 3.245a1.5 1.5 0 01-.214.084v-7.358l6.947-3.949a1.508 1.508 0 01.053.391z">
                                        </path>
                                    </svg>
                                    <div class="body__details__summary__body__item__details">
                                        <div class="body__details__summary__body__item__details__title">
                                            Order today, delivers:
                                        </div>
                                        <div class="body__details__summary__body__item__details__note">
                                            Delivery with Setup — Free
                                        </div>
                                        <div class="body__details__summary__body__item__details__link">
                                            Delivery options for 20147††
                                        </div>
                                    </div>
                                </div>
                                <div class="body__details__summary__body__item">
                                    <svg viewBox="0 0 25 25"
                                         class="as-svgicon as-svgicon-applestorepickup as-svgicon-reduced as-svgicon-applestorepickupreduced"
                                         role="img" aria-hidden="true" width="25px" height="25px">
                                        <path fill="none" d="M0 0h25v25H0z"></path>
                                        <path
                                                d="M18.5 5h-1.775a4.231 4.231 0 00-8.45 0H6.5A2.5 2.5 0 004 7.5v11A2.5 2.5 0 006.5 21h12a2.5 2.5 0 002.5-2.5v-11A2.5 2.5 0 0018.5 5zm-6-3a3.245 3.245 0 013.225 3h-6.45A3.245 3.245 0 0112.5 2zM20 18.5a1.5 1.5 0 01-1.5 1.5h-12A1.5 1.5 0 015 18.5v-11A1.5 1.5 0 016.5 6h12A1.5 1.5 0 0120 7.5z">
                                        </path>
                                        <path
                                                d="M14.4 12.448a1.592 1.592 0 01.738-1.328 1.607 1.607 0 00-1.37-.687c-.52 0-.941.317-1.22.317s-.663-.3-1.129-.3a1.861 1.861 0 00-1.739 2.068 4.32 4.32 0 00.723 2.3c.346.491.648.883 1.084.883s.617-.287 1.144-.287c.55 0 .663.279 1.137.279s.791-.43 1.084-.853a3.24 3.24 0 00.474-.989 1.516 1.516 0 01-.926-1.403zM12.583 10.357a1.346 1.346 0 00.941-.5 1.594 1.594 0 00.361-.974.731.731 0 00-.008-.136 1.5 1.5 0 00-1.016.528 1.547 1.547 0 00-.384.943c0 .053.008.106.008.128.03.004.06.011.098.011z">
                                        </path>
                                    </svg>
                                    <div class="body__details__summary__body__item__details">
                                        <div class="body__details__summary__body__item__details__title">
                                            Pickup:
                                        </div>
                                        <div class="body__details__summary__body__item__details__note">
                                            Currently unavailable at Apple Reston
                                        </div>
                                        <div class="body__details__summary__body__item__details__link">
                                            Check another store
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="body__details__summary__body__add--wrapper">
                                <input type="button" class="body__details__summary__body__btn-add-to-bag"
                                       value="Add to bag"/>
                                <svg viewBox="0 0 35 35" class="body__details__summary__body__love" role="img"
                                     aria-hidden="true" width="35px" height="35px">
                                    <path fill="none" d="M0 1.213h35v35H0z"></path>
                                    <path
                                            d="M17.5 29.263a1.194 1.194 0 01-.85-.352L6.967 19.2a6.531 6.531 0 01.46-9.617 6.708 6.708 0 018.943.647l1.13 1.133 1.13-1.133a6.706 6.706 0 018.943-.647 6.531 6.531 0 01.46 9.617l-9.683 9.711a1.192 1.192 0 01-.85.352zm-6.06-20a5.154 5.154 0 00-3.31 1.167 5.352 5.352 0 00-1.948 3.913 5.424 5.424 0 001.564 4.081l9.684 9.711.53.388-.39-.388 9.684-9.711a5.424 5.424 0 001.564-4.081 5.352 5.352 0 00-1.948-3.913 5.6 5.6 0 00-7.461.577l-1.7 1.7a.3.3 0 01-.425 0l-1.7-1.7a5.89 5.89 0 00-4.144-1.741z">
                                    </path>
                                </svg>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <hr>

            <div class="body__tab">
                <div class="body__tab__list">
                    <div class="body__tab__item--wrapper">
                        <div class="body__tab__item">
                            <div class="body__tab__item__title">
                                Specifications
                            </div>
                            <div class="body__tab__item__icon">
                                <i class="fas fa-chevron-down"></i>
                            </div>
                        </div>
                        <div class="body__tab__sub-list">
                            <div
                                    class="body__tab__sub-list__item--wrapper body__tab__sub-list__item--wrapper--active">
                                <div class="body__tab__sub-list__item">
                                    <div class="body__tab__sub-list__item__title">
                                        Key Specs
                                    </div>
                                    <div class="body__tab__sub-list__item__icon">
                                        <i class="fas fa-chevron-right"></i>
                                    </div>
                                </div>
                                <div class="body__tab__sub-list__table">
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Carrier
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            Verizon
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Wireless Technology
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            4G LTE, 5G
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Operating System
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            Apple iOS 15
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Usage Time(s)
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            Video playback: Up to 28hours
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Internal Memory
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            128 gigabytes
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Screen Size
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            6.1 inches
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Water Resistant
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            Yes
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Processor Brand
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            Apple
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Front-Facing Camera
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            12 megapixels
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Rear-Facing Camera
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            12 megapixels
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Processor Model
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            A15 Bionic chip with next-generation Neural Engine
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Internet Connectable
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            Yes
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Works With
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            Siri
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Series
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            iPhone 13
                                        </div>
                                    </div>
                                    <div class="body__tab__sub-list__table__item">
                                        <div class="body__tab__sub-list__table__item__parameter">
                                            Works With
                                        </div>
                                        <div class="body__tab__sub-list__table__item__data">
                                            iPhone 12 Green 128GB
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <hr>
                </div>
            </div>

            <div class="body__another-product">
                <div class="body__another-product__heading">
                    <div class="body__another-product__heading__title">
                        Recently viewed <span>
                                    (10 items)
                                </span>
                    </div>
                </div>
                <div class="body__another-product__list--wrapper">

                    <div class="body__another-product__list">
                        <%--                        <c:forEach var="item" items="${listProductByViewed}">--%>
                        <%--                            <div--%>
                        <%--                                    class="body__another-product__item">--%>
                        <%--                                <div class="body__another-product__item__img"--%>
                        <%--                                     style="background-image: url(${imageDao.get(item.idImg).url})">--%>
                        <%--                                </div>--%>
                        <%--                                <div class="body__another-product__item__detail">--%>
                        <%--                                    <div class="body__another-product__item__detail__name">--%>
                        <%--                                            ${item.getName()}--%>
                        <%--                                    </div>--%>
                        <%--                                    <div class="body__another-product__item__detail__rate">--%>
                        <%--                                        <div class="body__another-product__item__detail__rate">--%>
                        <%--                                            <c:set var="rate" scope="session" value="${item.rate}"/>--%>
                        <%--                                            <c:forEach var="i" begin="1" end="${rate}">--%>
                        <%--                                                <i class="fa fa-star"></i>--%>
                        <%--                                            </c:forEach>--%>
                        <%--                                            <c:forEach var="i" begin="1" end="${5 - rate}">--%>
                        <%--                                                <i class="far fa-star"></i>--%>
                        <%--                                            </c:forEach>--%>
                        <%--                                        </div>--%>

                        <%--                                        <div class="body__another-product__item__detail__rate__sale">--%>
                        <%--                                            Sales ${Math.round(item.discount * 100)}%--%>
                        <%--                                        </div>--%>
                        <%--                                    </div>--%>
                        <%--                                    <div class="body__another-product__item__detail__prices">--%>
                        <%--                                        <div class="body__another-product__item__detail__price">--%>
                        <%--                                            <c:set var="newPrice"--%>
                        <%--                                                   value="${item.sales()}"/>--%>
                        <%--                                            <div class="body__another-product__item__detail__price--old">--%>
                        <%--                                                $${item.price}--%>
                        <%--                                            </div>--%>
                        <%--                                            <div class="body__another-product__item__detail__price--new">--%>
                        <%--                                                $${newPrice}--%>
                        <%--                                            </div>--%>
                        <%--                                        </div>--%>
                        <%--                                        <a href="/detail-product?id=${item.id}"--%>
                        <%--                                           class="body__another-product__item__detail__btn-add">--%>
                        <%--                                            See more...--%>
                        <%--                                        </a>--%>
                        <%--                                    </div>--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>
                        <%--                        </c:forEach>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="layout/footer.jsp"/>
    <a href="#on-top" class="button-on-top">
        <i class="fas fa-chevron-up"></i>
    </a>
</form>

<script src="${pageContext.request.contextPath}/assets/js/navigation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/scroll.js"></script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${pageContext.request.contextPath}/assets/js/detail-product.js"></script>
<script>
    <%--$(".body__details__summary__body__btn-add-to-bag").on("click", (e) => {--%>
    <%--    let idPro = $("input.idPro").val();--%>
    <%--    let idColor = $('input[name="radio-color"]:checked').val();--%>
    <%--    var idProOption = $('input[name="radio-option"]:checked').val();--%>
    <%--    if(typeof(idProOption) === 'undefined') idProOption = '-1';--%>
    <%--    let href = "/detail-product?id=" + idPro + "&idColor=" + idColor + "&idProOption=" + idProOption;--%>
    <%--    history.pushState({}, null, href);--%>
    <%--    $.ajax({--%>
    <%--        type: "POST",--%>
    <%--        url: "/cart-crud?action=add",--%>
    <%--        data: {--%>
    <%--            idPro: idPro,--%>
    <%--            idColor: idColor,--%>
    <%--            idProOption: idProOption--%>
    <%--        },--%>
    <%--        success: function () {--%>
    <%--            <% HttpSession ss = request.getSession(); %>--%>
    <%--            <%if(ss.getAttribute("idUser") == null) {%>--%>
    <%--            window.location.href = "/sign-in"--%>
    <%--            <%} else {%>--%>
    <%--            e.preventDefault();--%>
    <%--            <%--%>
    <%--            int idCart = (int) ss.getAttribute("idCart");--%>
    <%--            String idPro = request.getParameter("id");--%>
    <%--            String idColor = request.getParameter("idColor");--%>
    <%--            String idProOption = request.getParameter("idProOption");--%>
    <%--            if(idProOption == null) idProOption = "-1";--%>

    <%--            %>--%>
    <%--            if(!existProInCart(idPro, idColor, idProOption)) {--%>
    <%--                Swal.fire({--%>
    <%--                    icon: 'success',--%>
    <%--                    title: 'Successfully added to cart.',--%>
    <%--                    showConfirmButton: false,--%>
    <%--                    timer: 1500--%>
    <%--                })--%>
    <%--                if($(".header__navbar__cart--amount").text() === '0') {--%>
    <%--                    $(".header__navbar__cart--amount").show();--%>
    <%--                    $(".header__navbar__cart__list--wrapper").show();--%>
    <%--                    $(".header__navbar__cart__none").hide();--%>
    <%--                    $(".header__navbar__cart--amount").text('1');--%>
    <%--                } else {--%>
    <%--                    var numOfList = Number.parseInt($(".header__navbar__cart--amount").text());--%>
    <%--                    numOfList += 1;--%>
    <%--                    $(".header__navbar__cart--amount").text(numOfList)--%>
    <%--                }--%>
    <%--                addProduct()--%>
    <%--            } else {--%>
    <%--                Swal.fire({--%>
    <%--                    icon: 'success',--%>
    <%--                    title: 'Product have added successfully.',--%>
    <%--                    showConfirmButton: false,--%>
    <%--                    timer: 1500--%>
    <%--                })--%>
    <%--                <%}%>--%>
    <%--            }--%>
    <%--        },--%>

    <%--    })--%>
    <%--})--%>

    function clickOption(productOptionId) {
        jQuery.map(jQuery(".body__details__choose-capacity__item--wrapper"), (item, i) => {
            let image = jQuery(item);
            if (image.attr("id") === "product-option-" + productOptionId) {
                image.addClass("body__details__choose-capacity__item--active");
            } else {
                image.removeClass("body__details__choose-capacity__item--active");
            }
        })
        jQuery.ajax({
            url: "/api/product-option/" + productOptionId,
            type: "GET",
            success: function (response) {
                if (response.success) {
                    let productOption = response.data;
                    jQuery("#option-name").empty();
                    jQuery("#option-name").append(productOption.name);
                }
            }

        })
        jQuery.ajax({
            url: "/api/product-detail/listByProductOptionId" + productOptionId,
            type: "GET",
            success: function (response) {
                if (response.success) {
                    let list = response.data;
                    let productColor = jQuery("input[name=radio-color]:checked").val();
                    for (let productDetail of list) {
                        if (productDetail.productColor.id == productColor) {
                            jQuery("#breadcrumb-price").empty();
                            jQuery("#price-total").empty();
                            jQuery("#breadcrumb-price").append("$" + productDetail.price.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,") + ".00");
                            jQuery("#price-total").append("$" + productDetail.price.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,") + ".00");
                        }
                    }
                }
            }

        })
    }

    function getDataOptionByProductColorId(productColorId) {
        jQuery.map(jQuery(".body__images--wrapper"), (item, i) => {
            let image = jQuery(item);
            if (image.attr("id") === "image-color-" + productColorId) {
                image.addClass("body__images--active");
            } else {
                image.removeClass("body__images--active");
            }
        })
        jQuery.map(jQuery(".body__details__choose-colors__item"), (item, i) => {
            let color = jQuery(item);
            if (color.attr("id") === "color-" + productColorId) {
                color.addClass("body__details__choose-colors__item--active");
            } else {
                color.removeClass("body__details__choose-colors__item--active");
            }
        })

        jQuery.ajax({
            url: "/api/product-color/" + productColorId,
            type: "GET",
            success: function (response) {
                if (response.success) {
                    let productColor = response.data;
                    jQuery("#color-name").empty();
                    jQuery("#color-name").append(productColor.color.name);
                }
            }

        })

        jQuery.ajax({
            url: "/api/product-detail/listByProductColorId" + productColorId,
            type: "GET",
            success: function (response) {
                jQuery("#option-choose").empty();
                let productDetailList = response.data;
                let productDetail = productDetailList[0];
                let html = `<hr class="hr-space">
                            <div class="body__details__choose-capacity__title">
                            Choose your ` + productDetail.productOption.option.name +
                    `</div>
                        <div class="body__details__choose-capacity__question">
                            How much ` + productDetail.productOption.option.name + ` is right for you?
                        </div>
                        <div class="body__details__choose-capacity__list">`;
                var i = 0;
                for (let item of productDetailList) {
                    var str = (i === 0) ? "checked" : "";
                    var active = (i === 0) ? "body__details__choose-capacity__item--active" : "";
                    html +=
                        `<label for="id-option-` + item.productOption.id + `" onclick="clickOption(` + item.productOption.id + `)"
                                id="product-option-` + item.productOption.id + `"
                                       class="body__details__choose-capacity__item--wrapper ` + active + `">
                                    <div class="body__details__choose-capacity__item">
                                        <div class="body__details__choose-capacity__item__num">
                                                ` + item.productOption.name + `
                                        </div>
                                    </div>
                                </label>
                                    <input hidden type="radio" name="radio-option" id="id-option-` + item.productOption.id + `"
                                           ` + str + `
                                           value="` + item.productOption.id + `">`

                    i++;
                }
                html.concat(`</div>`);

                jQuery("#option-choose").append(html);
            }
        })
    }

    jQuery(document).ready(function () {
        let productColorId = jQuery("input[name=radio-color]:checked").val();
        jQuery.ajax({
            url: "/api/product-color/" + productColorId,
            type: "GET",
            success: function (response) {
                if (response.success) {
                    let productColor = response.data;
                    jQuery("#color-name").empty();
                    jQuery("#color-name").append(productColor.color.name);
                }
            }

        })
        jQuery.ajax({
            url: "/api/product-detail/listByProductColorId" + productColorId,
            type: "GET",
            success: function (response) {
                jQuery("#option-choose").empty();
                let productDetailList = response.data;
                let productDetail = productDetailList[0];
                let html = `<hr class="hr-space">
                            <div class="body__details__choose-capacity__title">
                            Choose your ` + productDetail.productOption.option.name +
                    `</div>
                        <div class="body__details__choose-capacity__question">
                            How much ` + productDetail.productOption.option.name + ` is right for you?
                        </div>
                        <div class="body__details__choose-capacity__list">`;
                var i = 0;
                for (let item of productDetailList) {
                    var str = (i === 0) ? "checked" : "";
                    var active = (i === 0) ? "body__details__choose-capacity__item--active" : "";
                    html +=
                        `<label for="id-option-` + item.productOption.id + `" onclick="clickOption(` + item.productOption.id + `)"
                                id="product-option-` + item.productOption.id + `"
                                       class="body__details__choose-capacity__item--wrapper ` + active + `">
                                    <div class="body__details__choose-capacity__item">
                                        <div class="body__details__choose-capacity__item__num">
                                                ` + item.productOption.name + `
                                        </div>
                                    </div>
                                </label>
                                    <input hidden type="radio" name="radio-option" id="id-option-` + item.productOption.id + `"
                                           ` + str + `
                                           value="` + item.productOption.id + `">`


                    i++;
                }
                html.concat(`</div>`);

                jQuery("#option-choose").append(html);
            }
        }).then(function () {
            let productOptionId = jQuery("input[name=radio-option]:checked").val();
            jQuery.ajax({
                url: "/api/product-option/" + productOptionId,
                type: "GET",
                success: function (response) {
                    if (response.success) {
                        let productOption = response.data;
                        jQuery("#option-name").empty();
                        jQuery("#option-name").append(productOption.name);
                    }
                }
            })
            jQuery.ajax({
                url: "/api/product-detail/listByProductOptionId" + productOptionId,
                type: "GET",
                success: function (response) {
                    if (response.success) {
                        let list = response.data;
                        let productColor = jQuery("input[name=radio-color]:checked").val();
                        for (let productDetail of list) {
                            if (productDetail.productColor.id == productColor) {
                                jQuery("#breadcrumb-price").empty();
                                jQuery("#price-total").empty();
                                jQuery("#breadcrumb-price").append("$" + productDetail.price.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,") + ".00");
                                jQuery("#price-total").append("$" + productDetail.price.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,") + ".00");
                            }
                        }
                    }
                }

            })
        })
    })

</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>

</body>
</html>
