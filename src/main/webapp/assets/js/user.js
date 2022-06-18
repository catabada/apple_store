(checkValueBlur = () => {
    $.map($(".body-login__form-input"), (item, index) => {
        $(item).find("input").on("blur", (e) => {
            if ($(e.currentTarget).val() === "") {
                $(e.currentTarget).css({
                    backgroundColor: "#fef0f0",
                    border: "1px solid #de071c",
                    outline: "#de071c"
                })
                $(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                    color: "#de071c"
                })
                $(item).next(".notice-error").show();
                console.log($(e.currentTarget).attr("id"))
            } else {
                if ($(e.currentTarget).attr("id") === "sign-up-password" && $(e.currentTarget).val().length < 8) {
                    $(e.currentTarget).css({
                        backgroundColor: "#fef0f0",
                        border: "1px solid #de071c",
                        outline: "#de071c"
                    })
                    $(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                        color: "#de071c"
                    })
                    $(item).next(".notice-error").html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Password is not 8 characters`);
                    $(item).next(".notice-error").show();
                } else if ($(e.currentTarget).attr("id") === "sign-up-email" && !$(e.currentTarget).val().toLowerCase()
                    .match(
                        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
                    )) {
                    $(e.currentTarget).css({
                        backgroundColor: "#fef0f0",
                        border: "1px solid #de071c",
                        outline: "#de071c"
                    })
                    $(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                        color: "#de071c"
                    })
                    $(item).next(".notice-error").html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Incorrect email format`);
                    $(item).next(".notice-error").show();
                } else {
                    $(e.currentTarget).css({
                        backgroundColor: "#fff",
                        border: "1px solid #d2d2d7",
                        outline: "#000"
                    })
                    $(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                        color: "#6e6e73"
                    })
                    $(item).next(".notice-error").html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
                    $(item).next(".notice-error").hide();
                }
            }
        })
    })

})();
(checkValueInput = () => {
    $.map($(".body-login__form-input"), (item, index) => {
        $(item).find("input").on("input", (e) => {
            if ($(e.currentTarget).val() === "") {
                $(e.currentTarget).css({
                    backgroundColor: "#fef0f0",
                    border: "1px solid #de071c",
                    outline: "#de071c"
                })
                $(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                    color: "#de071c"
                })
                $(item).next(".notice-error").show();
            } else {
                $(e.currentTarget).css({
                    backgroundColor: "#fff",
                    border: "1px solid #d2d2d7",
                    outline: "#000"
                })
                $(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                    color: "#6e6e73"
                })
                $(item).next(".notice-error").hide();
            }
        })
    })

})();
(checkLengthStringInput = () => {
    $("#sign-up-password").on("input", (e) => {
        if ($(e.currentTarget).val().length < 8 && $(e.currentTarget).val() !== "") {
            $(e.currentTarget).css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            $(e.currentTarget).next().css({
                color: "#de071c"
            });
            $($(e.currentTarget).parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Password is not 8 characters`);
            $($(e.currentTarget).parents(".body-login__form-input")).next().show();
        } else {
            $(e.currentTarget).css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            $(e.currentTarget).next().css({
                color: "#6e6e73"
            })
            $($(e.currentTarget).parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
            $($(e.currentTarget).parents(".body-login__form-input")).next().hide();
        }
    })
    $("#sign-up-email").on("input", (e) => {
        if (!$(e.currentTarget).val().toLowerCase()
            .match(
                /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            )) {
            $(e.currentTarget).css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            $(e.currentTarget).next().css({
                color: "#de071c"
            });
            $($(e.currentTarget).parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Incorrect email format`);
            $($(e.currentTarget).parents(".body-login__form-input")).next().show();
        } else {
            $(e.currentTarget).css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            $(e.currentTarget).next().css({
                color: "#6e6e73"
            })
            $($(e.currentTarget).parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
            $($(e.currentTarget).parents(".body-login__form-input")).next().hide();
        }
    })

})();
checkValueSubmit = () => {
    $.map($(".body-login__form-input input"), (item, index) => {
        if ($(item).val() === "") {
            $(item).css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            $(item).siblings(".body-login__form-input--span-placeholder").css({
                color: "#de071c"
            })
            $(item).parent(".body-login__form-input").next().show();
        } else {
            $(item).css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            $(item).siblings(".body-login__form-input--span-placeholder").css({
                color: "#6e6e73"
            })
            $(item).parent(".body-login__form-input").next().hide();
        }
        if ($("#sign-up-password").val().length < 8 && $("#sign-up-password").val() !== "") {
            $("#sign-up-password").css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            $("#sign-up-password").next().css({
                color: "#de071c"
            });
            $($("#sign-up-password").parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Password is not 8 characters`);
            $($("#sign-up-password").parents(".body-login__form-input")).next().show();
        } else {
            $("#sign-up-password").css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            $("#sign-up-password").next().css({
                color: "#6e6e73"
            })
            $($("#sign-up-password").parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
            $($("#sign-up-password").parents(".body-login__form-input")).next().hide();
        }
        if (!$("#sign-up-email").val().toLowerCase()
            .match(
                /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            )) {
            $("#sign-up-email").css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            $("#sign-up-email").next().css({
                color: "#de071c"
            });
            $($("#sign-up-email").parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Incorrect email format`);
            $($("#sign-up-email").parents(".body-login__form-input")).next().show();
        } else {
            $("#sign-up-email").css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            $("#sign-up-email").next().css({
                color: "#6e6e73"
            })
            $($("#sign-up-email").parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
            $($("#sign-up-email").parents(".body-login__form-input")).next().hide();
        }
    })
};


(signIn = () => {
    $(".body-login__form--sign-in").find(".body-login__form-btn").on("click", (e) => {
        e.preventDefault();
        let data = $(".body-login__form--sign-in").serializeArray();
        let username = data[0]["value"];
        let password = data[1]["value"];
        checkValueSubmit()
        if (username === "" || password === "") {
            return false;
        }
        $.ajax({
            type: "POST",
            url: "/sign-in",
            data: {
                username: username,
                password: password
            },
            success: (data) => {
                if (data === 'true') {
                    Swal.fire({
                        icon: 'success',
                        title: 'You have been sign in successfully',
                        showConfirmButton: false,
                        timer: 1000
                    })
                    setTimeout(() => {
                        window.location.href = "/home";
                    }, 500);
                } else {
                    $(".error__sign-in").show();
                }
            }
        })
    });
})();

(signUp = () => {
    $(".body-login__form--sign-up").find(".body-login__form-btn").on("click", (e) => {
        e.preventDefault();

        let data = $(".body-login__form--sign-up").serializeArray();
        let first = data[0]["value"];
        let last = data[1]["value"];
        let username = data[2]["value"];
        let password = data[3]["value"];
        let email = data[4]["value"];

        checkValueSubmit();
        if (username === "" || password.length < 8 || first === "" || last === "" || !email.toLowerCase()
            .match(
                /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            )) {
            return false;
        }

        $.ajax({
            type: "POST",
            url: "/sign-up",
            data: {
                first: first,
                last: last,
                username: username,
                password: password,
                email: email
            },
            success: (data) => {
                if (data === 'false') {
                    $(".error__account-exist").show();
                } else {
                    Swal.fire({
                        icon: 'success',
                        title: 'You have been sign up successfully',
                        showConfirmButton: false,
                        timer: 2500
                    })
                    setTimeout(() => {
                        window.location.href = "/login.jsp";
                    }, 1500);
                }
            }
        })
    });
})();