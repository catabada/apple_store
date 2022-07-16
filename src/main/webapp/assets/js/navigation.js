jQuery(document).ready(function () {
    jQuery(".header-navbar__icon--search").click(() => {
        jQuery(".header-navbar__list").hide("slide");
        jQuery(".header-navbar__icons").hide("slide");
        jQuery(".header-navbar__brand").hide("slide");
        setTimeout(() => {
            jQuery(".header-navbar__search").show("slide");
            document.querySelector(".header-navbar__search").style.display = "flex";
        }, 500)
        jQuery(".header-nav__mobile-menu").hide("slide");
        document.querySelector(".header-nav__mobile-menu").style.display = "none";
    })

    jQuery(".header-navbar__search-icon--close").click(() => {
        jQuery(".header-navbar__search").hide("slide");
        setTimeout(() => {
            if (window.innerWidth > 1100) {
                jQuery(".header-navbar__list").show("slide");
                jQuery(".header-navbar__list").css("display", "flex");
            }
            jQuery(".header-navbar__icons").show("slide");
            jQuery(".header-navbar__brand").show("slide");
        }, 500)
        document.querySelector(".header-navbar__search-input").value = "";
        if (window.innerWidth < 1100)
            jQuery(".header-nav__mobile-menu").show("slide");
    })
    jQuery(".header-navbar__search--modal").click(() => {
        document.querySelector(".header-navbar__search-input").value = "";
        jQuery(".header-navbar__search").hide("slide");
        setTimeout(() => {
            if (window.innerWidth > 1100)
                jQuery(".header-navbar__list").show("slide");
            jQuery(".header-navbar__icons").show("slide");
            jQuery(".header-navbar__brand").show("slide");
        }, 500)
        if (window.innerWidth < 1100)
            jQuery(".header-nav__mobile-menu").show("slide");
    })

    jQuery(".bar__mobile--wrapper").on("click", () => {
        jQuery(".bar__mobile--wrapper").toggleClass("bar__mobile--wrapper--active");
        setTimeout(() => {
            jQuery(".up-bar").toggleClass("up-bar--active");
            jQuery(".down-bar").toggleClass("down-bar--active");
            // Open
        }, 250)
    })
    var count = 0;
    jQuery(".bar__mobile--wrapper").on("click", () => { 
        setTimeout(() => {
            if (count % 2 == 0) {
                jQuery(".header-nav__mobile__modal").show();
                jQuery(".header-nav__mobile--wrapper").show();
                jQuery(".header-navbar__mobile-menu-list").css({
                    "display": "flex",
                    "height": "100%",
                });
                setTimeout(() => {
                    jQuery(".header-navbar__mobile-menu-item").addClass("header-navbar__mobile-menu-item--animate");
                },260);
                count++;
            } else {
                jQuery(".header-navbar__mobile-menu-item").removeClass("header-navbar__mobile-menu-item--animate");
                setTimeout(() => {
                    jQuery(".header-nav__mobile__modal").hide();
                },500)
                jQuery(".header-navbar__mobile-menu-list").css({
                    "height": "0%",
                });
    
                count++;
            }
            // Close
        },250)

    });
    jQuery(".header-nav__mobile__modal").click(() => {
        setTimeout(() => {
            jQuery(".header-nav__mobile__modal").hide();
            jQuery(".header-navbar__mobile-menu-list").css({
                "height": "0%",
            });
        },250)
        jQuery(".bar__mobile--wrapper").toggleClass("bar__mobile--wrapper--active");
        setTimeout(() => {
            jQuery(".up-bar").toggleClass("up-bar--active");
            jQuery(".down-bar").toggleClass("down-bar--active");
            // Open
        }, 250)
        jQuery(".header-navbar__mobile-menu-item").removeClass("header-navbar__mobile-menu-item--animate");
        count++;

    })

})