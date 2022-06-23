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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/category.css">
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/assets/img/apple-brand-white.png">
    <title>Title</title>
</head>
<body>
<div class="main" id="on-top">
    <jsp:include page="layout/header.jsp"/>
    <div class="body">
        <div class="container body-container">
            <div class="body-filter">
                <h1 class="body-filter__heading">
                    Filter
                    <div class="body-filter__btn-reset">
                        Reset
                    </div>
                </h1>
<%--                <c:forEach var="proFilter" items="${listProFilter}">--%>
<%--                    <div class="body-filter__option">--%>
<%--                        <div class="body-filter__option-heading">--%>
<%--                                ${filterDao.get(proFilter.idFilter).type}--%>
<%--                        </div>--%>
<%--                        <ul class="body-filter__option-list">--%>
<%--                            <c:forEach var="detail" items="${filterDetailDao.getListFilterByIdProFilter(proFilter.id)}">--%>
<%--                                <li class="body-filter__option-item">--%>
<%--                                    <a href=""--%>
<%--                                       class="body-filter__option-item-link body-filter__option-version-item-link">--%>
<%--                                            ${detail.name}--%>
<%--                                    </a>--%>
<%--                                </li>--%>
<%--                            </c:forEach>--%>
<%--                        </ul>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>

            </div>
            <div class="body-all-product">
                <div class="body-all-product__sort">
                    <div class="body-all-product__sort-heading">
                        Sorted by
                    </div>
                    <ul class="body-all-product__sort-list">
                        <li class="body-all-product__sort-item">
                            <a href="" class="body-all-product__sort-item-link">Sales</a>
                        </li>
                        <li class="body-all-product__sort-item">
                            <a href="" class="body-all-product__sort-item-link">Best Seller</a>
                        </li>
                        <li class="body-all-product__sort-item">
                            <a href="" class="body-all-product__sort-item-link">New</a>
                        </li>
                        <li class="body-all-product__sort-item">
                            <a href="" class="body-all-product__sort-item-link">Price up</a>
                        </li>
                        <li class="body-all-product__sort-item">
                            <a href="" class="body-all-product__sort-item-link">Price down</a>
                        </li>
                    </ul>
                </div>
                <div class="body-all-product__products">
                    <div class="body-all-product__products-row row">
                        <c:forEach var="product" items="${listProduct}">
                            <a href="${pageContext.request.contextPath}/apple-store/detail-product?id=${product.id}"
                               class="body-all-product__products-item col-xxl-3 col-xl-3 col-lg-4 col-md-6 col-sm-6 col-xs-12">
                                <div class="body-all-product__products-item__img body-all-product__products-item__img--active"
                                     style="background-image: url(${pageContext.request.contextPath}/image/${product.urlImage})">
                                </div>

                                <div class="body-all-product__products-item__detail">
                                    <div class="body-all-product__products-item__name">
                                            ${product.name}
                                    </div>
                                    <div class="body-all-product__products-item__rate">
                                        <div class="body-all-product__products-item__rate-stars">
                                            <c:set var="rate" scope="session" value="${product.rate}"/>
                                            <c:forEach var="i" begin="1" end="${rate}">
                                                <i class="fa fa-star"></i>
                                            </c:forEach>
                                            <c:forEach var="i" begin="1" end="${5 - rate}">
                                                <i class="far fa-star"></i>
                                            </c:forEach>
                                        </div>
                                        <div class="body-all-product__products-item__rate_sale">
                                            <fmt:parseNumber var="discount" value="${product.discount * 100}"
                                                             type="number" integerOnly="true"/>
                                            Sale ${discount}%
                                        </div>
                                    </div>
                                    <div class="body-all-product__products-item__price body-all-product__products-item__price--active">
                                        <c:set var="newPrice"
                                               value="${product.sales()}"/>
                                        <div class="body-all-product__products-item__price--old">$${product.price}</div>
                                        <div class="body-all-product__products-item__price--new">$${newPrice}</div>
                                    </div>
                                </div>
                                <input type="button" class="body-all-product__products-item__btn" value="See more...">
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%--    <jsp:include page="layout/footer.jsp"/>--%>
    <a href="#on-top" class="button-on-top">
        <i class="fas fa-chevron-up"></i>
    </a>
</div>

<script src="${pageContext.request.contextPath}/assets/js/navigation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/scroll.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/filter.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>
</body>
</html>
