<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <meta name="Description" content="Enter your description here"/>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/login.css"/>
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/assets/img/apple-brand-white.png">
    <title>Login</title>
</head>
<body>
<div class="main">
    <c:import url="layout/header.jsp"/>
    <div class="body-login">
        <!-- Sign in -->

        <form id="signin_form"
              enctype="multipart/form-data"
              novalidate="novalidate"
                autocomplete="off"
              class="body-login__form body-login__form--sign-in offset-xxl-8 offset-xl-8 offset-lg-6 offset-md-6 col-xxl-4 col-xl-4 col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <h2 class="body-login__form-heading">Please sign in</h2>
            <div class="error__sign-in">
                Username or password is wrong. Please try again!
            </div>
            <div class="body-login__form-input">
                <input autocomplete="off" type="text" class="" alt="Username" name="username"
                       required/>
                <div class="body-login__form-input--span-placeholder">Username</div>
            </div>

            <div class="notice-error"><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty</div>
            <div class="body-login__form-input">
                <input autocomplete="off" type="password" class="" alt="Password" name="password" required/>
                <div class="body-login__form-input--span-placeholder">Password</div>
            </div>
            <div class="notice-error"><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty</div>
            <p class="body-login__form-note">
                Your Username is the email address you use to sign in to iTunes, the
                App Store, and ICloud.
            </p>
            <input type="button"  onclick="signIn()" value="Sign in" class="body-login__form-btn">
            <a href="" class="body-login__form-link body-login__form-link--forgot-password">Forgot your username or
                password?</a>
            <a href="" class="body-login__form-link body-login__form-link--sign-up">Don't have an account? Create
                one now.</a>
        </form>

        <!-- Forgot Password -->

        <form  method="post"
              class="body-login__form body-login__form--forgot-password offset-xxl-8 offset-xl-8 offset-lg-6 offset-md-6 col-xxl-4 col-xl-4 col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <img src="${pageContext.request.contextPath}/assets/img/back_button.png"
                 class="body-login__form--btn-back body-login__form--btn-back--forgot-password"/>
            <h2 class="body-login__form-heading">Forgot password</h2>
            <div class="body-login__form-input">
                <input type="email" class="" alt="Email" name="email" required/>
                <div class="body-login__form-input--span-placeholder">Email</div>
            </div>
            <div class="notice-error"><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty</div>
            <p class="body-login__form-note">
                After enter your email, you will receive password in your email, please check your email
            </p>
            <input type="submit" value="Change Password" class="body-login__form-btn">
        </form>

        <!-- Sign up -->
        <form id="signup_form"
              enctype="multipart/form-data"
              novalidate="novalidate"
                class="body-login__form body-login__form--sign-up offset-xxl-8 offset-xl-8 offset-lg-6 offset-md-6 col-xxl-4 col-xl-4 col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <img src="${pageContext.request.contextPath}/assets/img/back_button.png"
                 class="body-login__form--btn-back body-login__form--btn-back--sign-up"/>
            <h2 class="body-login__form-heading">Please sign up</h2>
            <div class="body-login__form-input">
                <input type="text" class="" alt="First Name" name="firstName" required/>
                <div class="body-login__form-input--span-placeholder">First Name</div>
            </div>
            <div class="notice-error"><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty</div>
            <div class="body-login__form-input">
                <input type="text" class="" alt="Last Name" name="lastName" required/>
                <div class="body-login__form-input--span-placeholder">Last Name</div>
            </div>
            <div class="notice-error"><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty</div>
            <div class="error__account-exist">
                Account already exist!
            </div>
            <div class="body-login__form-input">
                <input type="text" class="" alt="Username" name="username" required/>
                <div class="body-login__form-input--span-placeholder">Username</div>
            </div>
            <div class="notice-error"><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty</div>
            <div class="body-login__form-input">
                <input type="password" class="" alt="Password" name="password" id="sign-up-password" required/>
                <div class="body-login__form-input--span-placeholder">Password</div>
            </div>
            <div class="notice-error"><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty</div>
            <div class="body-login__form-input">
                <input type="email" class="" alt="Email" name="email" id="sign-up-email" required/>
                <div class="body-login__form-input--span-placeholder">Email</div>
            </div>
            <div class="notice-error"><i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty</div>
            <input type="button" onclick="signUp()" value="Sign up" class="body-login__form-btn">
        </form>
    </div>
    <jsp:include page="layout/footer.jsp"/>
</div>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="${pageContext.request.contextPath}/assets/js/user.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/navigation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/login.js"></script>
<!-- Swal -->
<script>
    function signUp() {
        let data = new FormData(jQuery("#signup_form")[0]);

        jQuery.ajax({
            url: "/apple-store/sign-up",
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
                    }).then(
                        function (){
                            window.location.href= "${pageContext.request.contextPath}/apple-store/login";
                        }
                    )
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'ERROR',
                        text: data.message,
                        showConfirmButton: false,
                        timer: 2000
                    })
                }
            },
        });
    }
    function signIn(){
        let data = new FormData(jQuery("#signin_form")[0]);

        jQuery.ajax({
            url: "/apple-store/sign-in",
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
                    }).then(
                        function (){
                            window.location.href= "${pageContext.request.contextPath}/apple-store";
                        }
                    )
                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'ERROR',
                        text: data.message,
                        showConfirmButton: false,
                        timer: 2000
                    })
                }
            },
        });
    }

</script>
</body>
</html>
