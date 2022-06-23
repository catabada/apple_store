$(document).ready(function () {
    var btnSignUp = document.querySelector(".body-login__form-link--sign-up");

    btnSignUp.onclick = function (e) {
        e.preventDefault();
        document.querySelector(".body-login__form--sign-in").style.animation = "fadeOutLogin linear .5s";
        setTimeout(function () {
            document.querySelector(".body-login__form--sign-in").style.display = "none";
            document.querySelector(".body-login__form--sign-up").style.animation = "fadeInLogin linear .5s";
        }, 500)
        setTimeout(function () {
            document.querySelector(".body-login__form--sign-up").style.display = "flex";
        }, 500)
    }
    var backBtnSignUp = document.querySelector(".body-login__form--btn-back.body-login__form--btn-back--sign-up");
    backBtnSignUp.onclick = () => {
        document.querySelector(".body-login__form--sign-up").style.animation = "fadeOutLogin linear .5s";
        setTimeout(function () {
            document.querySelector(".body-login__form--sign-up").style.display = "none";
            document.querySelector(".body-login__form--sign-in").style.animation = "fadeInLogin linear .5s";
        }, 500)
        setTimeout(function () {
            document.querySelector(".body-login__form--sign-in").style.display = "flex";
        }, 500)
    }
    var btnForgotPass = document.querySelector(".body-login__form-link--forgot-password");

    btnForgotPass.onclick = function (e) {
        e.preventDefault();
        document.querySelector(".body-login__form--sign-in").style.animation = "fadeOutLogin linear .5s";
        setTimeout(function () {
            document.querySelector(".body-login__form--sign-in").style.display = "none";
            document.querySelector(".body-login__form--forgot-password").style.animation = "fadeInLogin linear .5s";
        }, 500)
        setTimeout(function () {
            document.querySelector(".body-login__form--forgot-password").style.display = "flex";
        }, 500)
    }
    var backBtnForgotPass = document.querySelector(".body-login__form--btn-back.body-login__form--btn-back--forgot-password");
    backBtnForgotPass.onclick = () => {
        document.querySelector(".body-login__form--forgot-password").style.animation = "fadeOutLogin linear .5s";
        setTimeout(function () {
            document.querySelector(".body-login__form--forgot-password").style.display = "none";
            document.querySelector(".body-login__form--sign-in").style.animation = "fadeInLogin linear .5s";
        }, 500)
        setTimeout(function () {
            document.querySelector(".body-login__form--sign-in").style.display = "flex";
        }, 500)
    }


});

(clickSpan = () => {
    $.map($(".body-login__form-input--span-placeholder"), (item, index) => {
        $(item).on("click", (e) => {
            $(item).siblings("input").focus();
        })
    })
})();

(spanPlaceHolder = () => {
    $.map($(".body-login__form-input"), (item, index) => {
        $(item).find("input").on("focus", (e) => {
            $(item).find(".body-login__form-input--span-placeholder").css({
                animation: "spanFocus linear .1s",
                top: "24%",
                fontSize: "1.2rem"
            })
        })
        $(item).find("input").on("input", (e) => {
            $(item).find(".body-login__form-input--span-placeholder").css({
                animation: "spanFocus linear .1s",
                top: "24%",
                fontSize: "1.2rem"
            })
        })
        $(item).find("input").on("blur", (e) => {
            if ($(e.currentTarget).val() === "") {
                $(item).find(".body-login__form-input--span-placeholder").css({
                    animation: "spanBlur linear .1s",
                    top: "45%",
                    fontSize: "1.7rem"

                })
            }
        })
    })
})()