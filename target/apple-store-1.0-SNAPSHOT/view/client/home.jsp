<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="shortcut icon" type="image/png" href="./${pageContext.request.contextPath}/assets/img/apple-brand-white.png">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/home/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/home/responsive.css">

</head>
<body>
<div class="main" id="on-top">
    <!-- Begin header -->
<%--    <c:import url="layout/header.jsp" />--%>
    <!-- End  Header -->

    <!-- Begin Slider -->
    <a href="" class="slider container-fluid">
        <div class="slider-banner">
            <div class="slider-banner__labels">
                <label id="label-1" class="slider-banner__label">
                    <label class="slider-banner__label--active"></label>
                </label>
                <label id="label-2" class="slider-banner__label"></label>
                <label id="label-3" class="slider-banner__label"></label>
                <label id="label-4" class="slider-banner__label"></label>
                <label id="label-5" class="slider-banner__label"></label>
                <label id="label-6" class="slider-banner__label"></label>
            </div>
            <div class="slides">
                <div class="slide slide__first">
                    <img class="slide__img " src="./${pageContext.request.contextPath}/assets/img/banner_slider/iphone_banner.png" alt="">
                </div>
                <div class="slide">
                    <img class="slide__img" src="./${pageContext.request.contextPath}/assets/img/banner_slider/imac_banner.png" alt="">
                </div>
                <div class="slide">
                    <img class="slide__img" src="./${pageContext.request.contextPath}/assets/img/banner_slider/ipad_banner.png" alt="">
                </div>
                <div class="slide">
                    <img class="slide__img" src="./${pageContext.request.contextPath}/assets/img/banner_slider/airtag_banner.png" alt="">
                </div>
                <div class="slide">
                    <img class="slide__img" src="./${pageContext.request.contextPath}/assets/img/banner_slider/apple_watch_banner.png" alt="">
                </div>
                <div class="slide">
                    <img class="slide__img" src="./${pageContext.request.contextPath}/assets/img/banner_slider/airpod_banner.png" alt="">
                </div>
            </div>
        </div>
    </a>
    <!-- End Slider -->


    <!-- Begin Body -->
    <div class="body">

        <!-- Begin Advertisement count down -->
        <div class="body-advertisement-cd container">
            <div class="body-advertisement-cd--wrapper">
                <div class="row body-advertisement-cd-row">
                    <div
                            class="col-xxl-4 col-xl-4 col-lg-5 col-md-6 col-sm-12 offset-xl-2 offset-xxl-2 offset-lg-1 offset-md-0 offset-sm-0 body-advertisement-cd-col-detail">
                        <div class="body-advertisement-cd__heading">
                            Deal of the Day
                        </div>
                        <div class="body-advertisement-cd__detail">
                            <div class="body-advertisement-cd__name">
                                iPad Air 4 (10.9")
                            </div>
                            <div class="body-advertisement-cd__price">
                                <div class="body-advertisement-cd__price--new">$499.00</div>
                                <div class="body-advertisement-cd__price--old">$599.00</div>
                            </div>
                        </div>
                        <div class="body-advertisement-cd__count-down">
                            <div class="body-advertisement-cd__count-down-time">
                                <div id="hour" class="body-advertisement-cd__count-down-time-num">9</div>
                                <div class="body-advertisement-cd__count-down-time-unit">Hour</div>
                            </div>
                            <div class="body-advertisement-cd__count-down-time">
                                <div id="minute" class="body-advertisement-cd__count-down-time-num">59</div>
                                <div class="body-advertisement-cd__count-down-time-unit">Minute</div>
                            </div>
                            <div class="body-advertisement-cd__count-down-time">
                                <div id="second" class="body-advertisement-cd__count-down-time-num">9</div>
                                <div class="body-advertisement-cd__count-down-time-unit">Second</div>
                            </div>
                        </div>
                        <div class="body-advertisement-cd__btn-buy">
                            <a class="body-advertisement-cd__btn-buy-link">
                                Buy Now
                            </a>
                        </div>
                    </div>
                    <div class="col-xxl-4 col-xl-4 col-lg-5 col-md-6 col-sm-12 body-advertisement-cd-col-img">
                        <img src="${pageContext.request.contextPath}/assets/img/home/av1.png" alt="" class="body-advertisement-cd__img">
                    </div>
                </div>
            </div>
        </div>
        <!-- End Advertisement count down -->

        <!-- Begin Hot Product -->
        <div class="body__hot-product">
            <div class="container">
                <div class="body__hot-product__heading">
                    Selected products
                </div>
                <div class="body__hot-product__tab">
                    <div class="body__hot-product__tab-item">New Arrivals</div>
                    <div class="body__hot-product__tab-item">Best Seller</div>
                    <div class="body__hot-product__tab-item">Trending Item</div>
                </div>
                <div class="body__hot-product__banners row">
                    <a href=""
                       class="body__hot-product__banners-item col-xxl-5 col-xl-5 col-lg-5 col-md-12">
                        <div class="body__hot-product__banners-item__title">
                            New Arrival
                        </div>
                        <div class="body__hot-product__banners-item__name">
                            iPhone 13 Pro
                        </div>
                        <div class="body__hot-product__banners-item__price">
                            From $999.00 or $41.62/month for 24 month before trade in*
                        </div>
                        <img src="${pageContext.request.contextPath}/assets/img/home/av2.png" alt="" class="body__hot-product__banners-item__img">
                    </a>
                    <div class="body__hot-product__banners-item col-xxl-7 col-xl-7 col-lg-7 col-md-12">
                        <div class="body__hot-product__banners-item__sub">
                            <div class="body__hot-product__banners-item__sub-item">
                                <div class="body__hot-product__banners-item__sub-item__detail col-xxl-6 col-xs-8">
                                    <div class="body__hot-product__banners-item__sub-item__detail-title">
                                        ipad mini
                                    </div>
                                    <div class="body__hot-product__banners-item__sub-item__detail-name">
                                        Mega power. Mini sized
                                    </div>
                                    <div class="body__hot-product__banners-item__sub-item__detail-price">
                                        From $499 or $41.58/mo. for 12 mo.
                                    </div>
                                </div>
                                <div
                                        class="col-xxl-6 col-xs-4 body__hot-product__banners-item__sub-item__img--wrapper ">
                                    <img src="${pageContext.request.contextPath}/assets/img/home/ipad-mini-gallery1-202109.png" alt=""
                                         class="body__hot-product__banners-item__sub-item__img">
                                </div>
                            </div>
                            <div class="body__hot-product__banners-item__sub-item">
                                <div class="body__hot-product__banners-item__sub-item__list">
                                    <div class="body__hot-product__banners-item__sub-item__item">
                                        <div class="body__hot-product__banners-item__sub-item__item-img"
                                             style="background-image: url(${pageContext.request.contextPath}/assets/img/home/apple-watch-series-6-gps-cellular-2.png)">

                                        </div>
                                        <div class="body__hot-product__banners-item__sub-item__item-detail">
                                            <div class="body__hot-product__banners-item__sub-item__item-name">
                                                Apple Watch Series 6
                                            </div>
                                            <div class="body__hot-product__banners-item__sub-item__item-rate">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <div class="body__hot-product__banners-item__sub-item__item-prices">
                                                <div class="body__hot-product__banners-item__sub-item__item-price">
                                                    $399
                                                </div>
                                                <a href=""
                                                   class="body__hot-product__banners-item__sub-item__item-btn-add">
                                                    Add to cart
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="body__hot-product__banners-item__sub-item__item">
                                        <div class="body__hot-product__banners-item__sub-item__item-img"
                                             style="background-image: url(${pageContext.request.contextPath}/assets/img/home/iphone-13-mini-blue-2-600x600.png)">

                                        </div>
                                        <div class="body__hot-product__banners-item__sub-item__item-detail">
                                            <div class="body__hot-product__banners-item__sub-item__item-name">
                                                iPhone 13
                                            </div>
                                            <div class="body__hot-product__banners-item__sub-item__item-rate">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <div class="body__hot-product__banners-item__sub-item__item-prices">
                                                <div class="body__hot-product__banners-item__sub-item__item-price">
                                                    $699
                                                </div>
                                                <a href=""
                                                   class="body__hot-product__banners-item__sub-item__item-btn-add">
                                                    Add to cart
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="body__hot-product__banners-item__sub-item__item">
                                        <div class="body__hot-product__banners-item__sub-item__item-img"
                                             style="background-image: url(${pageContext.request.contextPath}/assets/img/home/macbook-pro-14-inch-2021-1.png)">

                                        </div>
                                        <div class="body__hot-product__banners-item__sub-item__item-detail">
                                            <div class="body__hot-product__banners-item__sub-item__item-name">
                                                MacBook Pro 13 inch
                                            </div>
                                            <div class="body__hot-product__banners-item__sub-item__item-rate">
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                                <i class="fa fa-star"></i>
                                            </div>
                                            <div class="body__hot-product__banners-item__sub-item__item-prices">
                                                <div class="body__hot-product__banners-item__sub-item__item-price">
                                                    $1299
                                                </div>
                                                <a href=""
                                                   class="body__hot-product__banners-item__sub-item__item-btn-add">
                                                    Add to cart
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Hot Product -->


        <!-- Begin advertisement -->
        <div class="body-advertisement">
            <div class="container">
                <div class="body-advertisement__detail col-xxl-12">
                    <div class="body-advertisement__heading">
                        10% off
                    </div>
                    <div class="body-advertisement__name">
                        iPhone 12 Green 128GB
                    </div>
                    <a href="" class="body-advertisement__btn-buy">
                        Buy Now
                    </a>
                </div>
                <img src="${pageContext.request.contextPath}/assets/img/home/apple-iphone-12-4.png" alt="" class="body-advertisement__img">
            </div>
        </div>
        <!-- End advertisement -->

        <!-- Begin iphones product  -->
        <div class="body-iphones col-xxl-11 col-xl-11 col-lg-11 col-md-12 col-sm-12">
            <div class="body-iphones--wrapper ">
                <div class="body-iphones__list">
                    <c:forEach var="item" items="${listIphone}">
                        <div class="body-iphones__item">
                            <div class="body-iphones__item-img "
                                 style="background-image: url(${imageDao.get(item.idImg).url})">
                            </div>
                            <div class="body-iphones__item-detail">
                                <div class="body-iphones__item-name">
                                        ${item.name}
                                </div>
                                <div class="body-iphones__item-rate">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="body-iphones__item-prices">
                                    <div class="body-iphones__item-price">
                                        $${item.price}0
                                    </div>
                                    <a href="/detail-product?id=${item.id}" class="body-iphones__item-btn-add">Add
                                        to cart</a>
                                </div>
                            </div>

                        </div>
                    </c:forEach>

                </div>
            </div>
            <div class="body-iphones--wrapper-btn">
                <a href="./components/IPhone.html" class="body-iphones__btn-view-all">
                    View All
                </a>
            </div>
        </div>

        <!-- End iphones product-->


        <!-- Begin Hot collection -->
        <div class="body-hot-collection">
            <div class="container">
                <div class="body-hot-collection__list ">
                    <div class="body-hot-collection__item ">
                        <div class="body-hot-collection__item-title">
                            #Hot Collections
                        </div>
                        <div class="body-hot-collection__item-name">
                            AirPod
                        </div>
                        <a href="" class="body-hot-collection__item-btn">
                            View All
                        </a>
                        <img src="./${pageContext.request.contextPath}/assets/img/home/airpot.png" alt="" class="body-hot-collection__item-img">
                    </div>
                    <div class="body-hot-collection__item">
                        <div class="body-hot-collection__item-title">
                            #Hot Collections
                        </div>
                        <div class="body-hot-collection__item-name">
                            AirTag
                        </div>
                        <a href="" class="body-hot-collection__item-btn">
                            View All
                        </a>
                        <img src="${pageContext.request.contextPath}/assets/img/home/airtag.png" alt="" class="body-hot-collection__item-img">
                    </div>
                    <div class="body-hot-collection__item ">
                        <div class="body-hot-collection__item-title">
                            #Hot Collections
                        </div>
                        <div class="body-hot-collection__item-name">
                            Apple Watch
                        </div>
                        <a href="" class="body-hot-collection__item-btn">
                            View All
                        </a>
                        <img src="${pageContext.request.contextPath}/assets/img/home/apple-watch.png" alt="" class="body-hot-collection__item-img">
                    </div>
                </div>
            </div>

        </div>
        <!-- End Hot Collection -->

        <!-- Begin community -->
        <div class="body-community container-fluid ">
            <div class="row">
                <div
                        class="body-community--wrapper col-xxl-10 col-xl-10 col-lg-10 col-md-12 col-sm-12 col-xs-12 offset-xxl-1 offset-xl-1 offset-lg-1 offset-md-0">
                    <div class="body-community__detail col-xxl-6 col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <div class="body-community__detail-heading">
                            Community
                        </div>
                        <div class="body-community__detail-des">
                            <p>
                                All of your devices.
                            </p>
                            <p>
                                One seamless experience.
                            </p>
                        </div>
                        <a href="" class="body-community__detail-link">
                            Learn more >
                        </a>
                    </div>
                    <div class="body-community-img col-xxl-6 col-xl-6 col-lg-6 col-md-6 col-sm-12">
                        <img src="${pageContext.request.contextPath}/assets/img/home/community-bg.png" alt="">
                    </div>
                </div>
                <div class="col-xxl-1 col-xl-1 col-lg-1 col-md-0 body-community--space">

                </div>
            </div>
        </div>
        <!-- End community -->

        <!-- Begin IMac products -->
        <div class="body-imacs container-fluid">
            <div class="row">
                <div class="body-imacs--wrapper col-xxl-11 col-xl-11 col-lg-11 col-md-12 col-sm-12 col-xs-12">
                    <div class="col-xxl-3 col-xl-3 col-lg-3 col-md-3 col-sm-12 col-xs-12 body-imacs__name--wrapper">
                        <div class="body-imacs__name-product">
                            iMac
                        </div>
                        <a class="body-imacs__btn-view-all">
                            View All
                        </a>
                    </div>
                    <div class="body-imacs__list col-xxl-9 col-xl-9 col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div class="body-imacs__item">
                            <div class="body-imacs__item-img--wrapper">
                                <div class="body-imacs__item-img"
                                     style="background-image: url(${pageContext.request.contextPath}/assets/img/home/macbook-air.png);">
                                </div>
                            </div>
                            <div class="body-imacs__item-detail">
                                <div class="body-imacs__item-detail__name">
                                    MacBook Air 13''
                                </div>
                                <div class="body-imacs__item-detail__rate">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="body-imacs__item-detail__prices">
                                    <div class="body-imacs__item-detail__price">
                                        $1249.00
                                    </div>
                                    <a class="body-imacs__item-detail__btn-add">
                                        Add to cart
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="body-imacs__item ">
                            <div class="body-imacs__item-img--wrapper">
                                <div class="body-imacs__item-img"
                                     style="background-image: url(${pageContext.request.contextPath}/assets/img/home/macbook-pro-m1.png);">
                                </div>
                            </div>
                            <div class="body-imacs__item-detail">
                                <div class="body-imacs__item-detail__name">
                                    MacBook Pro M1 13''
                                </div>
                                <div class="body-imacs__item-detail__rate">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="body-imacs__item-detail__prices">
                                    <div class="body-imacs__item-detail__price">
                                        $1299.00
                                    </div>
                                    <a class="body-imacs__item-detail__btn-add">
                                        Add to cart
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="body-imacs__item">
                            <div class="body-imacs__item-img--wrapper">
                                <div class="body-imacs__item-img"
                                     style="background-image: url(${pageContext.request.contextPath}/assets/img/home/macbook-pro-16.png);">
                                </div>
                            </div>
                            <div class="body-imacs__item-detail">
                                <div class="body-imacs__item-detail__name">
                                    MacBook Pro 16''
                                </div>
                                <div class="body-imacs__item-detail__rate">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="body-imacs__item-detail__prices">
                                    <div class="body-imacs__item-detail__price">
                                        $2399.00
                                    </div>
                                    <a href="" class="body-imacs__item-detail__btn-add">
                                        Add to cart
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End IMac products -->


        <!-- Begin IPad product -->
        <div class="body-ipads container-fluid">
            <div class="body-ipads--wrapper col-xxl-11 col-xl-11 col-lg-11 col-md-12 col-sm-12 col-xs-12">
                <div class="body-ipads__list col-xxl-9 col-xl-9 col-lg-9 col-md-9 col-sm-12 col-xs-12">
                    <div class="body-ipads__item">
                        <div class="body-ipads__item-img--wrapper">
                            <div class="body-ipads__item-img"
                                 style="background-image: url(${pageContext.request.contextPath}/assets/img/home/ipad-mini-6.png);">
                            </div>
                        </div>
                        <div class="body-ipads__item-detail">
                            <div class="body-ipads__item-detail__name">
                                iPad mini 6
                            </div>
                            <div class="body-ipads__item-detail__rate">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="body-ipads__item-detail__prices">
                                <div class="body-ipads__item-detail__price">
                                    $1249.00
                                </div>
                                <div class="body-ipads__item-detail__btn-add">
                                    Add to cart
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="body-ipads__item ">
                        <div class="body-ipads__item-img--wrapper">
                            <div class="body-ipads__item-img"
                                 style="background-image: url(${pageContext.request.contextPath}/assets/img/home/ipad-air-11.png);">
                            </div>
                        </div>
                        <div class="body-ipads__item-detail">
                            <div class="body-ipads__item-detail__name">
                                iPad Air 10.9''
                            </div>
                            <div class="body-ipads__item-detail__rate">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="body-ipads__item-detail__prices">
                                <div class="body-ipads__item-detail__price">
                                    $1249.00
                                </div>
                                <div class="body-ipads__item-detail__btn-add">
                                    Add to cart
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="body-ipads__item">
                        <div class="body-ipads__item-img--wrapper">
                            <div class="body-ipads__item-img"
                                 style="background-image: url(${pageContext.request.contextPath}/assets/img/home/ipad-pro-13.png);">
                            </div>
                        </div>
                        <div class="body-ipads__item-detail">
                            <div class="body-ipads__item-detail__name">
                                iPad Pro 12.9''
                            </div>
                            <div class="body-ipads__item-detail__rate">
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                            <div class="body-ipads__item-detail__prices">
                                <div class="body-ipads__item-detail__price">
                                    $1249.00
                                </div>
                                <div class="body-ipads__item-detail__btn-add">
                                    Add to cart
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-xxl-3 col-xl-3 col-lg-3 col-md-3 col-sm-12 col-xs-12 body-ipads__name--wrapper">
                    <div class="body-ipads__name-product">
                        IPad
                    </div>
                    <a class="body-ipads__btn-view-all">
                        View All
                    </a>
                </div>
            </div>
        </div>
        <!-- End IPad product -->

        <!-- Begin Mac product-->
        <div class="body-macs container-fluid">
            <div class="row">
                <div class="body-macs--wrapper col-xxl-11 col-xl-11 col-lg-11 col-md-12 col-sm-12 col-xs-12">
                    <div class="col-xxl-3 col-xl-3 col-lg-3 col-md-3 col-sm-12 col-xs-12 body-macs__name--wrapper">
                        <div class="body-macs__name-product">
                            Mac
                        </div>
                        <a class="body-macs__btn-view-all">
                            View All
                        </a>
                    </div>
                    <div class="body-macs__list col-xxl-9 col-xl-9 col-lg-9 col-md-9 col-sm-12 col-xs-12">
                        <div class="body-macs__item">
                            <div class="body-macs__item-img--wrapper">
                                <div class="body-macs__item-img"
                                     style="background-image: url(${pageContext.request.contextPath}/assets/img/home/macbook-air.png);">
                                </div>
                            </div>
                            <div class="body-macs__item-detail">
                                <div class="body-imacs__item-detail__name">
                                    MacBook Air 13''
                                </div>
                                <div class="body-macs__item-detail__rate">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="body-macs__item-detail__prices">
                                    <div class="body-imacs__item-detail__price">
                                        $1249.00
                                    </div>
                                    <a class="body-macs__item-detail__btn-add">
                                        Add to cart
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="body-macs__item ">
                            <div class="body-imacs__item-img--wrapper">
                                <div class="body-macs__item-img"
                                     style="background-image: url(${pageContext.request.contextPath}/assets/img/home/macbook-pro-m1.png);">
                                </div>
                            </div>
                            <div class="body-macs__item-detail">
                                <div class="body-macs__item-detail__name">
                                    MacBook Pro M1 13''
                                </div>
                                <div class="body-macs__item-detail__rate">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="body-macs__item-detail__prices">
                                    <div class="body-macs__item-detail__price">
                                        $1299.00
                                    </div>
                                    <a class="body-macs__item-detail__btn-add">
                                        Add to cart
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="body-macs__item">
                            <div class="body-macs__item-img--wrapper">
                                <div class="body-macs__item-img"
                                     style="background-image: url(${pageContext.request.contextPath}/assets/img/home/macbook-pro-16.png);">
                                </div>
                            </div>
                            <div class="body-macs__item-detail">
                                <div class="body-macs__item-detail__name">
                                    MacBook Pro 16''
                                </div>
                                <div class="body-macs__item-detail__rate">
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                </div>
                                <div class="body-macs__item-detail__prices">
                                    <div class="body-macs__item-detail__price">
                                        $2399.00
                                    </div>
                                    <a href="" class="body-macs__item-detail__btn-add">
                                        Add to cart
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Mac product-->

    </div>

    <!-- Footer -->
<%--    <jsp:include page="layout/footer.jsp"/>--%>
    <a href="#on-top" class="button-on-top">
        <i class="fas fa-chevron-up"></i>
    </a>
</div>
<script src="${pageContext.request.contextPath}/assets/js/navigation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/scroll.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/slider.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/count_down.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>