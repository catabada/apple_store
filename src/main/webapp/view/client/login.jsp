<%--
  Created by IntelliJ IDEA.
  User: Huy
  Date: 6/22/2022
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/base.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/header_nav.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/components/login.css"/>
    <link rel="shortcut icon" type="image/png" href="${pageContext.request.contextPath}/assets/img/apple-brand-white.png">
    <title>Login</title>
</head>

<body>
<div class="main">
    <div id="header" class="header container-fluid">
        <!-- Begin navigation -->
        <div class=" header-navbar">
            <div class="header-nav__mobile-menu">
                <i class="fas fa-list"></i>
                Menu
            </div>
            <div class="header-nav__mobile--wrapper-modal">
                <ul class="header-nav__mobile-list">
                    <li class="header-nav__mobile-item"><a href="" class="header-nav__mobile-item-link">Home</a>
                    </li>
                    <li class="header-nav__mobile-item"><a href="" class="header-nav__mobile-item-link">iMac</a>
                    </li>
                    <li class="header-nav__mobile-item"><a href="" class="header-nav__mobile-item-link">iPhone</a>
                    </li>
                    <li class="header-nav__mobile-item"><a href="" class="header-nav__mobile-item-link">iPad</a>
                    </li>
                    <li class="header-nav__mobile-item"><a href="" class="header-nav__mobile-item-link">Air Pod</a>
                    </li>
                    <li class="header-nav__mobile-item"><a href="" class="header-nav__mobile-item-link">Air Tag</a>
                    </li>
                    <li class="header-nav__mobile-item"><a href="" class="header-nav__mobile-item-link">Watch</a>
                    </li>
                </ul>
            </div>
            <a href="/" class="header-navbar__brand">
                <img src="../../assets/img/apple-brand-white.png" alt="" class="header-navbar__brand-img">
            </a>
            <!-- Begin List Navigation -->
            <ul class="header-navbar__list ">
                <li class="header-navbar__item header-navbar__item--white">
                    <img src="../../assets/img/light.png" alt="" class="header-navbar__item-hover">
                    <a href="" class="header-navbar__link">
                        Mac
                    </a>
                </li>
                <li class="header-navbar__item header-navbar__item--white">
                    <img src="../../assets/img/light.png" alt="" class="header-navbar__item-hover">
                    <a href="IPhone.html" class="header-navbar__link">
                        iPhone
                    </a>
                </li>
                <li class="header-navbar__item header-navbar__item--white">
                    <img src="../../assets/img/light.png" alt="" class="header-navbar__item-hover ">
                    <a href="" class="header-navbar__link">
                        iPad
                    </a>
                </li>
                <li class="header-navbar__item header-navbar__item--white">
                    <img src="../../assets/img/light.png" alt="" class="header-navbar__item-hover">
                    <a href="" class="header-navbar__link">
                        AirPod
                    </a>
                </li>
                <li class="header-navbar__item header-navbar__item--white">
                    <img src="../../assets/img/light.png" alt="" class="header-navbar__item-hover">
                    <a href="" class="header-navbar__link">
                        AirTag
                    </a>
                </li>
                <li class="header-navbar__item header-navbar__item--white">
                    <img src="../../assets/img/light.png" alt="" class="header-navbar__item-hover">
                    <a href="" class="header-navbar__link">
                        Watch
                    </a>
                </li>
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
                </div>
                <a href="./components/Login.html" class="header-navbar__icon header-navbar__icon--user">
                    <i class="fa fa-user"></i>
                </a>
            </div>

        </div>
        <!-- End Navigation -->
    </div>
    <div class="body-login row">
        <!-- Sign in -->

        <form id="signin_form"
              method="POST"
              enctype="multipart/form-data"
              novalidate="novalidate"
                class="body-login__form body-login__form--sign-in offset-xxl-8 offset-xl-8 offset-lg-6 offset-md-6 col-xxl-4 col-xl-4 col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <h2 class="body-login__form-heading">Please sign in</h2>
            <div class="body-login__form-input">
                <input type="text" class="" placeholder="Username" alt="Username" name="username" required/>
                <div class="body-login__form-input--span-placeholder">Username</div>
            </div>
            <div class="body-login__form-input">
                <input type="password" class="" placeholder="Password" alt="Password" name="password" required/>
                <div class="body-login__form-input--span-placeholder">Password</div>
            </div>
            <p class="body-login__form-note">
                Your Username is the email address you use to sign in to iTunes, the
                App Store, and ICloud.
            </p>
            <input type="button" id="signin_submit" onclick="signIn()" value="Sign in" class="body-login__form-btn">
            <a href="" class="body-login__form-link body-login__form-link--forgot-password">Forgot your Apple ID or
                password?</a>
            <a href="" class="body-login__form-link body-login__form-link--sign-up">Don't have an Apple ID? Create
                one now.</a>
        </form>

        <!-- Forgot Password -->

        <form
                class="body-login__form body-login__form--forgot-password offset-xxl-8 offset-xl-8 offset-lg-6 offset-md-6 col-xxl-4 col-xl-4 col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <img src="../../assets/img/back_button.png"
                 class="body-login__form--btn-back body-login__form--btn-back--forgot-password"/>
            <h2 class="body-login__form-heading">Forgot password</h2>
            <div class="body-login__form-input">
                <input type="email" class="" placeholder="Email" alt="Email" name="email" required/>
                <div class="body-login__form-input--span-placeholder">Email</div>
            </div>
            <p class="body-login__form-note">
                After enter your email, you will receive password in your email, please check your email
            </p>
            <input type="submit" value="Change Password" class="body-login__form-btn">
        </form>

        <!-- Sign up -->
        <form id="signup_form"
              method="POST"
              enctype="multipart/form-data"
              novalidate="novalidate"
                class="body-login__form body-login__form--sign-up offset-xxl-8 offset-xl-8 offset-lg-6 offset-md-6 col-xxl-4 col-xl-4 col-lg-6 col-md-6 col-sm-12 col-xs-12">
            <img src="../../assets/img/back_button.png"
                 class="body-login__form--btn-back body-login__form--btn-back--sign-up"/>
            <h2 class="body-login__form-heading">Please sign up</h2>
            <div class="body-login__form-input">
                <input type="text" class="" placeholder="Username" alt="Username" name="username" required/>
                <div class="body-login__form-input--span-placeholder">Username</div>
            </div>
            <div class="body-login__form-input">
                <input type="text" class="" placeholder="FirstName" alt="FirstName" name="firstName" required/>
                <div class="body-login__form-input--span-placeholder">FirstName</div>
            </div>
            <div class="body-login__form-input">
                <input type="text" class="" placeholder="LastName" alt="LastName" name="lastName" required/>
                <div class="body-login__form-input--span-placeholder">LastName</div>
            </div>
            <div class="body-login__form-input">
                <input type="password" class="" placeholder="Password" alt="Password" name="password" required/>
                <div class="body-login__form-input--span-placeholder">Password</div>
            </div>
            <div class="body-login__form-input">
                <input type="password" class="" placeholder="Confirm Password" alt="Confirm Password"
                       name="confirm-password" required/>
                <div class="body-login__form-input--span-placeholder">
                    Confirm Password
                </div>
            </div>
            <div class="body-login__form-input">
                <input type="text" class="" placeholder="Email" alt="Email" name="email" required/>
                <div class="body-login__form-input--span-placeholder">Email</div>
            </div>
            <input type="button" onclick="signUp()"  id="signup-submit" value="Sign up" class="body-login__form-btn">
        </form>
    </div>
</div>
<script src="${pageContext.request.contextPath}/assets/js/navigation.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/login.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/2.9.2/umd/popper.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.0/js/bootstrap.min.js"></script>
<!-- Swal -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
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
