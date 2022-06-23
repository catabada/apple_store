(checkValueBlur = () => {
    jQuery.map(jQuery(".body-login__form-input"), (item, index) => {
        jQuery(item).find("input").on("blur", (e) => {
            if (jQuery(e.currentTarget).val() === "") {
                jQuery(e.currentTarget).css({
                    backgroundColor: "#fef0f0",
                    border: "1px solid #de071c",
                    outline: "#de071c"
                })
                jQuery(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                    color: "#de071c"
                })
                jQuery(item).next(".notice-error").show();
                console.log(jQuery(e.currentTarget).attr("id"))
            } else {
                if (jQuery(e.currentTarget).attr("id") === "sign-up-password" && jQuery(e.currentTarget).val().length < 8) {
                    jQuery(e.currentTarget).css({
                        backgroundColor: "#fef0f0",
                        border: "1px solid #de071c",
                        outline: "#de071c"
                    })
                    jQuery(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                        color: "#de071c"
                    })
                    jQuery(item).next(".notice-error").html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Password is not 8 characters`);
                    jQuery(item).next(".notice-error").show();
                } else if (jQuery(e.currentTarget).attr("id") === "sign-up-email" && !jQuery(e.currentTarget).val().toLowerCase()
                    .match(
                        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))jQuery/
                    )) {
                    jQuery(e.currentTarget).css({
                        backgroundColor: "#fef0f0",
                        border: "1px solid #de071c",
                        outline: "#de071c"
                    })
                    jQuery(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                        color: "#de071c"
                    })
                    jQuery(item).next(".notice-error").html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Incorrect email format`);
                    jQuery(item).next(".notice-error").show();
                } else {
                    jQuery(e.currentTarget).css({
                        backgroundColor: "#fff",
                        border: "1px solid #d2d2d7",
                        outline: "#000"
                    })
                    jQuery(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                        color: "#6e6e73"
                    })
                    jQuery(item).next(".notice-error").html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
                    jQuery(item).next(".notice-error").hide();
                }
            }
        })
    })

})();
(checkValueInput = () => {
    jQuery.map(jQuery(".body-login__form-input"), (item, index) => {
        jQuery(item).find("input").on("input", (e) => {
            if (jQuery(e.currentTarget).val() === "") {
                jQuery(e.currentTarget).css({
                    backgroundColor: "#fef0f0",
                    border: "1px solid #de071c",
                    outline: "#de071c"
                })
                jQuery(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                    color: "#de071c"
                })
                jQuery(item).next(".notice-error").show();
            } else {
                jQuery(e.currentTarget).css({
                    backgroundColor: "#fff",
                    border: "1px solid #d2d2d7",
                    outline: "#000"
                })
                jQuery(e.currentTarget).siblings(".body-login__form-input--span-placeholder").css({
                    color: "#6e6e73"
                })
                jQuery(item).next(".notice-error").hide();
            }
        })
    })

})();
(checkLengthStringInput = () => {
    jQuery("#sign-up-password").on("input", (e) => {
        if (jQuery(e.currentTarget).val().length < 8 && jQuery(e.currentTarget).val() !== "") {
            jQuery(e.currentTarget).css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            jQuery(e.currentTarget).next().css({
                color: "#de071c"
            });
            jQuery(jQuery(e.currentTarget).parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Password is not 8 characters`);
            jQuery(jQuery(e.currentTarget).parents(".body-login__form-input")).next().show();
        } else {
            jQuery(e.currentTarget).css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            jQuery(e.currentTarget).next().css({
                color: "#6e6e73"
            })
            jQuery(jQuery(e.currentTarget).parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
            jQuery(jQuery(e.currentTarget).parents(".body-login__form-input")).next().hide();
        }
    })
    jQuery("#sign-up-email").on("input", (e) => {
        if (!jQuery(e.currentTarget).val().toLowerCase()
            .match(
                /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))jQuery/
            )) {
            jQuery(e.currentTarget).css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            jQuery(e.currentTarget).next().css({
                color: "#de071c"
            });
            jQuery(jQuery(e.currentTarget).parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Incorrect email format`);
            jQuery(jQuery(e.currentTarget).parents(".body-login__form-input")).next().show();
        } else {
            jQuery(e.currentTarget).css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            jQuery(e.currentTarget).next().css({
                color: "#6e6e73"
            })
            jQuery(jQuery(e.currentTarget).parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
            jQuery(jQuery(e.currentTarget).parents(".body-login__form-input")).next().hide();
        }
    })

})();
checkValueSubmit = () => {
    jQuery.map(jQuery(".body-login__form-input input"), (item, index) => {
        if (jQuery(item).val() === "") {
            jQuery(item).css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            jQuery(item).siblings(".body-login__form-input--span-placeholder").css({
                color: "#de071c"
            })
            jQuery(item).parent(".body-login__form-input").next().show();
        } else {
            jQuery(item).css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            jQuery(item).siblings(".body-login__form-input--span-placeholder").css({
                color: "#6e6e73"
            })
            jQuery(item).parent(".body-login__form-input").next().hide();
        }
        if (jQuery("#sign-up-password").val().length < 8 && jQuery("#sign-up-password").val() !== "") {
            jQuery("#sign-up-password").css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            jQuery("#sign-up-password").next().css({
                color: "#de071c"
            });
            jQuery(jQuery("#sign-up-password").parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Password is not 8 characters`);
            jQuery(jQuery("#sign-up-password").parents(".body-login__form-input")).next().show();
        } else {
            jQuery("#sign-up-password").css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            jQuery("#sign-up-password").next().css({
                color: "#6e6e73"
            })
            jQuery(jQuery("#sign-up-password").parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
            jQuery(jQuery("#sign-up-password").parents(".body-login__form-input")).next().hide();
        }
        if (!jQuery("#sign-up-email").val().toLowerCase()
            .match(
                /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))jQuery/
            )) {
            jQuery("#sign-up-email").css({
                backgroundColor: "#fef0f0",
                border: "1px solid #de071c",
                outline: "#de071c"
            })
            jQuery("#sign-up-email").next().css({
                color: "#de071c"
            });
            jQuery(jQuery("#sign-up-email").parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Incorrect email format`);
            jQuery(jQuery("#sign-up-email").parents(".body-login__form-input")).next().show();
        } else {
            jQuery("#sign-up-email").css({
                backgroundColor: "#fff",
                border: "1px solid #d2d2d7",
                outline: "#000"
            })
            jQuery("#sign-up-email").next().css({
                color: "#6e6e73"
            })
            jQuery(jQuery("#sign-up-email").parents(".body-login__form-input")).next().html(`<i class="fa fa-exclamation-circle" aria-hidden="true"></i> Not be empty`);
            jQuery(jQuery("#sign-up-email").parents(".body-login__form-input")).next().hide();
        }
    })
};
