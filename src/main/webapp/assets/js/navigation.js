$(document).ready(function () {
    $(".header-navbar__icon--search").click(() => {
        $(".header-navbar__list").hide("slide");
        $(".header-navbar__icons").hide("slide");
        $(".header-navbar__brand").hide("slide");
        setTimeout(() => {
            $(".header-navbar__search").show("slide");
            document.querySelector(".header-navbar__search").style.display = "flex";
        }, 500)
        $(".header-nav__mobile-menu").hide("slide");
        document.querySelector(".header-nav__mobile-menu").style.display = "none";
    })

    $(".header-navbar__search-icon--close").click(() => {
        $(".header-navbar__search").hide("slide");
        setTimeout(() => {
            if (window.innerWidth > 1100) {
                $(".header-navbar__list").show("slide");
                $(".header-navbar__list").css("display", "flex");
            }
            $(".header-navbar__icons").show("slide");
            $(".header-navbar__brand").show("slide");
        }, 500)
        document.querySelector(".header-navbar__search-input").value = "";
        if (window.innerWidth < 1100)
            $(".header-nav__mobile-menu").show("slide");
    })
    $(".header-navbar__search--modal").click(() => {
        document.querySelector(".header-navbar__search-input").value = "";
        $(".header-navbar__search").hide("slide");
        setTimeout(() => {
            if (window.innerWidth > 1100)
                $(".header-navbar__list").show("slide");
            $(".header-navbar__icons").show("slide");
            $(".header-navbar__brand").show("slide");
        }, 500)
        if (window.innerWidth < 1100)
            $(".header-nav__mobile-menu").show("slide");
    })

    $(".bar__mobile--wrapper").on("click", () => {
        $(".bar__mobile--wrapper").toggleClass("bar__mobile--wrapper--active");
        setTimeout(() => {
            $(".up-bar").toggleClass("up-bar--active");
            $(".down-bar").toggleClass("down-bar--active");
            // Open
        }, 250)
    })
    var count = 0;
    $(".bar__mobile--wrapper").on("click", () => { 
        setTimeout(() => {
            if (count % 2 == 0) {
                $(".header-nav__mobile__modal").show();
                $(".header-nav__mobile--wrapper").show();
                $(".header-navbar__mobile-menu-list").css({
                    "display": "flex",
                    "height": "100%",
                });
                setTimeout(() => {
                    $(".header-navbar__mobile-menu-item").addClass("header-navbar__mobile-menu-item--animate");
                },260);
                count++;
            } else {
                $(".header-navbar__mobile-menu-item").removeClass("header-navbar__mobile-menu-item--animate");
                setTimeout(() => {
                    $(".header-nav__mobile__modal").hide();
                },500)
                $(".header-navbar__mobile-menu-list").css({
                    "height": "0%",
                });
    
                count++;
            }
            // Close
        },250)

    });
    $(".header-nav__mobile__modal").click(() => {
        setTimeout(() => {
            $(".header-nav__mobile__modal").hide();
            $(".header-navbar__mobile-menu-list").css({
                "height": "0%",
            });
        },250)
        $(".bar__mobile--wrapper").toggleClass("bar__mobile--wrapper--active");
        setTimeout(() => {
            $(".up-bar").toggleClass("up-bar--active");
            $(".down-bar").toggleClass("down-bar--active");
            // Open
        }, 250)
        $(".header-navbar__mobile-menu-item").removeClass("header-navbar__mobile-menu-item--animate");
        count++;

    })

})