var nameHtml = window.location.pathname;
var numberScroll = 0;
// if (nameHtml.endsWith("IPhone.html") || nameHtml.endsWith("detail.html") || nameHtml.endsWith("Cart.html"))
//     numberScroll = 0;
if (nameHtml.endsWith("home")) {
    numberScroll = 800;
}
else{
    numberScroll = 0;
}
window.addEventListener("scroll", () => {
    var header = document.querySelector(".header");
    document.querySelector(".button-on-top").classList.toggle("button-on-top--show", window.scrollY > 150);

    if (window.scrollY > numberScroll && window.innerWidth > 1100) {
        $(".avatar.white").hide();
        $(".avatar.black").show();
        header.classList.add("header--scroll");
        for (item of document.querySelectorAll(".header-navbar__icon")) {
            item.style.color = "#000";
        }
        for (item of document.querySelectorAll(".header-navbar__search-icon")) {
            item.style.color = "#000";
        }
        $(".header-navbar__icon__list").css({
            "background-color": "#000"
        });
        $(".header-navbar__icon__signout").css({
            "color": "#fff"
        });
        $(".header-navbar__icon__profile").css({
            "color": "#fff"
        });
        document.querySelector(".header-navbar__brand-img").src = "../assets/img/apple-brand-black.png";
        document.querySelector(".header-navbar__search-input").style.color = "#000";
        document.querySelector(".header-nav__mobile-menu").style.color = "#000";
        for (item of document.querySelectorAll(".header-navbar__link")) {
            item.style.color = `#000`;
        }
        for (item of document.querySelectorAll(".header-navbar__item")) {
            item.classList.remove("header-navbar__item--white");
        }
        $(".bar__mobile").css("background-color","black");
    } else {
        $(".avatar.white").show();
        $(".avatar.black").hide();
        header.classList.remove("header--scroll");
        for (item of document.querySelectorAll(".header-navbar__icon")) {
            item.style.color = "#fff";
        }
        for (item of document.querySelectorAll(".header-navbar__search-icon")) {
            item.style.color = "#fff";
        }
        $(".header-navbar__icon__list").css({
            "background-color": "#fff"
        });
        $(".header-navbar__icon__signout").css({
           "color": "#000"
        });
        $(".header-navbar__icon__profile").css({
           "color": "#000"
        });
        document.querySelector(".header-navbar__brand-img").src = "../assets/img/apple-brand-white.png";
        document.querySelector(".header-navbar__search-input").style.color = "#fff";
        document.querySelector(".header-nav__mobile-menu").style.color = "#fff";
        for (item of document.querySelectorAll(".header-navbar__link")) {
            item.style.color = "rgb(88,88,88)";
        }
        for (item of document.querySelectorAll(".header-navbar__item")) {
            item.classList.add("header-navbar__item--white");
        }
        $(".bar__mobile").css("background-color","white");
    }
})