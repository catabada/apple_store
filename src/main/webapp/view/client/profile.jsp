<%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 1/12/2022
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/profile.css">
    <title>Title</title>
</head>
<body>
<div class="main" id="on-top">
    <!-- Begin header -->
    <c:import url="layout/header.jsp"/>
    <!-- End  Header -->
    <div class="container body-profile">
        <div class="main-body">
            <div class="row body-profile__detail">
                <div class="col-lg-4">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center">
                                <img src="https://ui-avatars.com/api/?name=${user.firstName}+${user.lastName}"
                                     alt="Admin" class="rounded-circle p-1 bg-primary" width="110">
                                <div class="mt-3">
                                    <h1>${user.firstName} ${user.lastName}</h1>
                                    <p class="text-secondary mb-1">Customer</p>
                                </div>
                            </div>
                            <hr class="my-4">
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="card">
                        <form id="profile-form"
                              enctype="multipart/form-data"
                              novalidate="novalidate"
                              class="card-body">
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">First Name</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input id="firstName" type="text" class="form-control" name="firstName"
                                           value="${user.firstName}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Last Name</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input id="lastName" type="text" class="form-control" name="lastName"
                                           value="${user.lastName}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Email</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input id="email" type="text" class="form-control" name="email"
                                           value="${user.email}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Phone number</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input id="phone" type="text" class="form-control" name="phone"
                                           value="${user.phone}">
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Address</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    <input id="address" type="text" class="form-control" name="address"
                                           value="${user.address}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-sm-3"></div>
                                <div class="col-sm-9 text-secondary">
                                    <input type="button" onclick="updateProfile()" class="btn btn-primary px-4"
                                           id="save-changes" value="Save Changes">
                                </div>
                            </div>
                        </form>
                    </div>

                </div>

            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <div class="card">
                    <div class="card-body">
                        <h3 class="d-flex align-items-center mb-3">Orders History</h3>
                        <div class="limiter">
                            <div class="container-table100">
                                <div class="wrap-table100">
                                    <div class="table100 ver1">
                                        <div class="wrap-table100 js-pscroll">
                                            <div class="table100-nextcols">
                                                <table>
                                                    <thead>
                                                    <tr class="row100 head">
                                                        <th class="cell100 column1">#</th>
                                                        <th class="cell100 column2">Full Name</th>
                                                        <%--                                                        <th class="cell100 column2">Phone number</th>--%>
                                                        <th class="cell100 column3">Email</th>
                                                        <th class="cell100 column3">Address</th>
                                                        <th class="cell100 column2">Payment</th>
                                                        <th class="cell100 column2">Price</th>
                                                        <th class="cell100 column2">Status</th>
                                                        <th class="cell100 column2">Date Order</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody>
                                                    <%--&lt;%&ndash;                                                    <c:set var="i" value="0"/>&ndash;%&gt;--%>
                                                    <%--&lt;%&ndash;                                                    <c:forEach var="itemOrder" items="${listOrder}" >&ndash;%&gt;--%>
                                                    <%--&lt;%&ndash;                                                        <c:set var="i" value="${i + 1}"/>&ndash;%&gt;--%>
                                                    <%--                                                        <tr class="row100 body">--%>
                                                    <%--                                                            <td class="cell100 column1">${i}</td>--%>
                                                    <%--                                                            <td class="cell100 column2">${itemOrder.fullname}</td>--%>
                                                    <%--                                                            <td class="cell100 column2">${itemOrder.phoneNumber}</td>--%>
                                                    <%--                                                            <td class="cell100 column3">${itemOrder.email}</td>--%>
                                                    <%--                                                            <td class="cell100 column3">${itemOrder.address}</td>--%>
                                                    <%--                                                            <td class="cell100 column2">${orderDao.getTypePayment(itemOrder.idTypePay)}</td>--%>
                                                    <%--                                                            <td class="cell100 column2">$${itemOrder.price}</td>--%>
                                                    <%--                                                            <td class="cell100 column2">${itemOrder.status}</td>--%>
                                                    <%--                                                            <td class="cell100 column2">${itemOrder.date}</td>--%>
                                                    <%--                                                        </tr>--%>
                                                    <%--&lt;%&ndash;                                                    </c:forEach>&ndash;%&gt;--%>
                                                    </tbody>
                                                </table>
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
    </div>
    <!-- Footer -->
    <jsp:include page="layout/footer.jsp"/>
    <a href="#on-top" class="button-on-top">
        <i class="fas fa-chevron-up"></i>
    </a>
</div>
<script>
    function updateProfile() {
        let data = new FormData(jQuery("#profile-form")[0]);

        jQuery.ajax({
            url: "/apple-store/profile?id=${user.id}",
            type: "POST",
            data: data,
            processData: false,
            contentType: false,
            success: function (response) {
                let data = JSON.parse(response);
                if (data.success) {
                    Swal.fire({
                            icon: 'success',
                            title: 'SUCCESS',
                            text: data.message,
                            showConfirmButton: false,
                            timer: 2000
                        }
                    );

                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'ERROR',
                        text: data.message,
                        showConfirmButton: false,
                        timer: 2000
                    })
                }
            }
            ,
        });
    }
</script>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${pageContext.request.contextPath}/assets/js/profile.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>
</body>
</html>
