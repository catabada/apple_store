<%@ page import="vn.edu.hcmuaf.fit.dao.user.UserDAO" %>
<%@ page import="vn.edu.hcmuaf.fit.model.user.User" %>
<%@ page import="vn.edu.hcmuaf.fit.dao.impl.user.UserDAOImpl" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
        integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<link rel="shortcut icon" type="image/png" href="./${pageContext.request.contextPath}/assets/img/apple-brand-white.png">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/header_nav.css">

<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="header" class="header container-fluid">
    <!-- Begin navigation -->
    <div class=" header-navbar">
        <div class="header-nav__mobile-menu">
            <div class="bar__mobile--wrapper">
                <div class="up-bar bar__mobile "></div>
                <div class="down-bar bar__mobile "></div>
            </div>
            <div class="header-navbar__mobile-menu__text">
                Menu
            </div>
            <ul class="header-navbar__mobile-menu-list">
                <div class="header-navbar__mobile-menu__search">
                    <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg"
                         xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 512 512"
                         style="enable-background:new 0 0 512 512;" xml:space="preserve">
                                <g>
                                    <g>
                                        <path d="M503.847,432.949l-89.897-89.897c-0.002-0.002-0.003-0.003-0.006-0.006s-0.003-0.003-0.006-0.006l-32.135-32.135
			c-10.855-10.856-28.522-10.86-39.381,0l-3.939,3.939l-13.571-13.571c26.587-31.878,42.607-72.861,42.607-117.519
			C367.517,82.432,285.085,0,183.762,0S0.009,82.432,0.009,183.754s82.43,183.754,183.753,183.754
			c44.658,0,85.641-16.02,117.519-42.606l13.571,13.57l-3.94,3.94c-10.854,10.857-10.854,28.523,0.002,39.381l122.043,122.043
			c10.881,10.883,28.499,10.886,39.383,0.001l31.506-31.506C514.705,461.474,514.705,443.808,503.847,432.949z M183.762,334.091
			c-82.896,0-150.337-67.441-150.337-150.337S100.866,33.417,183.762,33.417S334.1,100.858,334.1,183.754
			S266.658,334.091,183.762,334.091z M338.482,362.103l23.629-23.629l16.388,16.388l-23.629,23.629L338.482,362.103z
			 M452.649,476.269l-74.15-74.15l23.629-23.629l74.15,74.15L452.649,476.269z"/>
                                    </g>
                                </g>
                        <g>
                            <g>
                                <path d="M183.76,66.835c-9.228,0-16.709,7.481-16.709,16.709c0,9.228,7.481,16.709,16.709,16.709
			c46.045,0,83.505,37.457,83.505,83.5c0,9.228,7.481,16.709,16.709,16.709c9.228,0,16.709-7.481,16.709-16.709
			C300.683,119.284,248.231,66.835,183.76,66.835z"/>
                            </g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                        <g>
                        </g>
                            </svg>
                    <input type="text" class="header-navbar__mobile-menu__search__input"
                           placeholder="Search...">
                </div>
                <li class="header-navbar__mobile-menu-item">
                    <img src="${pageContext.request.contextPath}/assets/img/imac-icon-mobile.png" alt=""
                         class="header-navbar__mobile-menu-item__img">
                    <a href="" class="header-navbar__mobile-menu-item-link">iMac</a>
                </li>
                <li class="header-navbar__mobile-menu-item">
                    <img src="${pageContext.request.contextPath}/assets/img/smartphone-icon-mobile.png" alt=""
                         class="header-navbar__mobile-menu-item__img">
                    <a href="" class="header-navbar__mobile-menu-item-link">iPhone</a>
                </li>
                <li class="header-navbar__mobile-menu-item ">
                    <img src="${pageContext.request.contextPath}/assets/img/ipad-icon-mobile.png" alt=""
                         class="header-navbar__mobile-menu-item__img">
                    <a href="" class="header-navbar__mobile-menu-item-link">iPad</a>
                </li>
                <li class="header-navbar__mobile-menu-item">
                    <img src="${pageContext.request.contextPath}/assets/img/headphones-icon-mobile.png" alt=""
                         class="header-navbar__mobile-menu-item__img">
                    <a href="" class="header-navbar__mobile-menu-item-link">Air Pod</a>
                </li>
                <li class="header-navbar__mobile-menu-item">
                    <img src="${pageContext.request.contextPath}/assets/img/airtag-icon-mobile.png" alt=""
                         class="header-navbar__mobile-menu-item__img">
                    <a href="" class="header-navbar__mobile-menu-item-link">Air Tag</a>
                </li>
                <li class="header-navbar__mobile-menu-item">
                    <img src="${pageContext.request.contextPath}/assets/img/watch-icon-mobile.png" alt=""
                         class="header-navbar__mobile-menu-item__img">
                    <a href="" class="header-navbar__mobile-menu-item-link">Watch</a>
                </li>
            </ul>
        </div>
        <div class="header-nav__mobile--wrapper">
            <div class="header-nav__mobile__modal"></div>

        </div>
        <a href="/apple-store" class="header-navbar__brand">
            <img src="${pageContext.request.contextPath}/assets/img/apple-brand-white.png" alt=""
                 class="header-navbar__brand-img">
        </a>
        <!-- Begin List Navigation -->
        <ul class="header-navbar__list" id="category">
            <%--            <%--%>
            <%--                HttpSession ss = request.getSession();--%>
            <%--                request.setAttribute("ss", ss);--%>
            <%--                if (ss.getAttribute("listType") == null) {--%>
            <%--                    Helper.getListTypeProduct(request);--%>
            <%--                }--%>
            <%--                request.setAttribute("imageDao", ImageDAO.getInstance());--%>
            <%--                request.setAttribute("productDao", ProductDAO.getInstance());--%>
            <%--                request.setAttribute("colorDao", ColorDAO.getInstance());--%>
            <%--                request.setAttribute("proOptionDao", ProductOptionDAO.getInstance());--%>
            <%--                request.setAttribute("cartItemDao", CartItemDAO.getInstance());--%>
            <%--                request.setAttribute("productColorDao", ProductColorDAO.getInstance());--%>
            <%--            %>--%>
            <%--            <jsp:useBean id="listType" scope="session" type="java.util.List"/>--%>
            <%--            <c:forEach var="item" items="${listType}">--%>
            <%--                <li class="header-navbar__item header-navbar__item--white">--%>
            <%--                    <img src="../${pageContext.request.contextPath}/assets/img/light.png" alt=""--%>
            <%--                         class="header-navbar__item-hover">--%>
            <%--                    <a href="/category?id=${item.id}" class="header-navbar__link">--%>
            <%--                            ${item.name}--%>
            <%--                    </a>--%>
            <%--                </li>--%>
            <%--            </c:forEach>--%>
        </ul>
        <!-- End List Navigation -->
        <div class="header-navbar__search">
            <div class="header-navbar__search-icon">
                <i class="fa fa-search"></i>
            </div>
            <input spellcheck="false" type="text" class="header-navbar__search-input"
                   placeholder="Search apple.com" autofocus>
            <div class="header-navbar__search-icon header-navbar__search-icon--close">
                <i class="fa fa-times"></i>
            </div>
            <div class="header-navbar__search--modal">
                <div class="header-navbar__search-history">
                    <ul class="header-navbar__search-history__list">
                        <div class="header-navbar__search-history__list-title">
                            Quick Link
                        </div>
                        <li class="header-navbar__search-history__item">
                            <a href="" class="header-navbar__search-history__item-link">
                                Visiting an Apple Store FAQ
                            </a>
                        </li>
                        <li class="header-navbar__search-history__item">
                            <a href="" class="header-navbar__search-history__item-link">
                                Shop Apple Store Online
                            </a>
                        </li>
                        <li class="header-navbar__search-history__item">
                            <a href="" class="header-navbar__search-history__item-link">
                                Accessories
                            </a>
                        </li>
                        <li class="header-navbar__search-history__item">
                            <a href="" class="header-navbar__search-history__item-link">
                                AirPods
                            </a>
                        </li>
                        <li class="header-navbar__search-history__item">
                            <a href="" class="header-navbar__search-history__item-link">
                                AirTag
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="header-navbar__icons">
            <div class="header-navbar__icon header-navbar__icon--search">
                <i class="fa fa-search header-navbar__icon--search"></i>
            </div>
            <div class="header-navbar__icon header-navbar__icon--cart">
                <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                <span class="header__navbar__cart--amount">
<%--                    ${listCartDetail.size()}--%>
                    0
                </span>
                <div class="header__navbar__cart">
                    <div class="header__navbar__cart__none">
                        <img src="${pageContext.request.contextPath}/assets/img/box-none.png" alt="">
                        Your Bag is empty.
                    </div>
                    <div class="header__navbar__cart__list--wrapper">
                        <div class="header__navbar__cart__list">
<%--                            <c:forEach var="item" items="${listCartDetail}">--%>
<%--                                <c:set var="idProduct" value="${cartItemDao.get(item.idCartItem).idProduct}"/>--%>
<%--                                <c:set var="idColor" value="${cartItemDao.get(item.idCartItem).idColor}"/>--%>
<%--                                <c:set var="idProOption" value="${cartItemDao.get(item.idCartItem).idProOption}"/>--%>
<%--                                <div class="header__navbar__cart__item">--%>
<%--                                    <input hidden type="text" value="${idProduct}">--%>
<%--                                    <input hidden type="text" value="${idColor}">--%>
<%--                                    <input hidden type="text" value="${idProOption}">--%>
<%--                                    <div class="header__navbar__cart__item__img">--%>
<%--                                        <img src="${imageDao.get(productColorDao.getByIdProAndIdColor(idProduct,idColor).idImg).url}"--%>
<%--                                             alt="">--%>
<%--                                    </div>--%>
<%--                                    <div class="header__navbar__cart__item__name">--%>
<%--                                            ${productDao.get(idProduct).name}--%>
<%--                                        <br>--%>
<%--                                            ${colorDao.get(idColor).name}--%>
<%--                                        <br>--%>
<%--                                        <c:if test="${idProOption != '-1'}">--%>
<%--                                            ${proOptionDao.get(idProOption).nameOptions}--%>
<%--                                        </c:if>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </c:forEach>--%>
                        </div>
                        <a href="/cart" class="header__navbar__cart__btn-check">
                            Check out
                        </a>
                    </div>
                </div>
            </div>
                     <%;
                            if (session.getAttribute("userId") != null) {
                                Long userId = (Long) session.getAttribute("userId");
                                request.setAttribute("user", UserDAOImpl.getInstance().findById(userId).orElse(null));
                                System.out.println(UserDAOImpl.getInstance().findById(userId).orElse(null).getUsername());
                            }
                        %>
                        <c:if test="${user == null}">
                            <a href="/apple-store/login" class="header-navbar__icon header-navbar__icon--user">
                                <i class="fa fa-user"></i>
                            </a>
                        </c:if>
                        <c:if test="${user != null}">
                            <div class="header-navbar__icon header-navbar__icon--user">
                                <canvas class="avatar black" style="background-color: #000;border-radius: 50%; display:none"
                                        id="avatar-canvas1" width="35"
                                        height="35">${fn:substring(user.firstName.toUpperCase(),0,1)}${fn:substring(user.lastName.toUpperCase(),0,1)}
                                </canvas>
                                <canvas class="avatar white" style="background-color: #fff;border-radius: 50%;" id="avatar-canvas2"
                                        width="35"
                                        height="35">${fn:substring(user.firstName.toUpperCase(),0,1)}${fn:substring(user.lastName.toUpperCase(),0,1)}
                                </canvas>
                                <div class="header-navbar__icon__list">
                                    <a href="/apple-store/profile" class="header-navbar__icon__profile"><i class="fa fa-user"></i> Profile</a>
                                    <a href="/apple-store/sign-out" class="header-navbar__icon__signout"><i class="fas fa-sign-out-alt"></i>
                                        Sign out</a>
                                </div>
                            </div>
                        </c:if>
        </div>

    </div>
    <!-- End Navigation -->
</div>

<script src="${pageContext.request.contextPath}/assets/js/navigation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/scroll.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/canvas.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
    <%--    <%--%>
    <%--        if(ss.getAttribute("idUser") == null) { %>--%>
    <%--    $(".header__navbar__cart__none").show();--%>
    <%--    $(".header__navbar__cart--amount").hide();--%>
    <%--    $(".header__navbar__cart__list--wrapper").hide();--%>

    <%--    <% } else { %>--%>
    <%--    <c:if test="${listCartDetail.size() == 0}">--%>
    <%--    $(".header__navbar__cart--amount").hide();--%>
    <%--    $(".header__navbar__cart__none").show();--%>
    <%--    $(".header__navbar__cart__list--wrapper").hide();--%>
    <%--    </c:if>--%>
    <%--    <c:if test="${listCartDetail.size() != 0}">--%>
    <%--    $(".header__navbar__cart--amount").show();--%>
    <%--    $(".header__navbar__cart__none").hide();--%>
    <%--    $(".header__navbar__cart__list--wrapper").show();--%>
    <%--    </c:if>--%>
    <%--    <% } %>--%>

    jQuery(document).ready(function () {
        jQuery.ajax({
            url: "/api/type-product",
            type: "GET",
            dataType: "json",
            processData: false,
            contentType: false,
            success: function (response) {
                let category = response.data;
                jQuery("#category").empty();
                for (let i = 0; i < category.length; i++) {
                    let id = category[i].id;
                    let name = category[i].name;
                    let html = '<li class="header-navbar__item header-navbar__item--white">' +
                        '<img src="${pageContext.request.contextPath}/assets/img/light.png" alt="" class="header-navbar__item-hover"> ' +
                        '<a href="${pageContext.request.contextPath}/apple-store/category?id=' + id + '" class="header-navbar__link">' + name + '</a>' +
                        '</li>';
                    jQuery("#category").append(html);
                }
            }
        });
    });
</script>
</body>
</html>
