<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 6/27/2022
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/error/404.css">
    <title>404</title>
</head>

<body>
<h1>404 Error Page</h1>
<p class="zoom-area"><b>Ê vô đây làm gì thoát ra hộ cái nha </b></p>
<section class="error-container">
    <span class="four"><span class="screen-reader-text">4</span></span>
    <span class="zero"><span class="screen-reader-text">0</span></span>
    <span class="four"><span class="screen-reader-text">4</span></span>
</section>
<div class="link-container">
    <a href="${pageContext.request.contextPath}/apple-store"
       class="more-link">Back to home</a>
</div>
</body>

</html>
