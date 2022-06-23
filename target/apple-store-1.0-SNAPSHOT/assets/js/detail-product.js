$(document).ready(function () {
    $(".body__another-product__list").slick({
        dots: true,
        infinite: false,
        speed: 300,
        slidesToShow: 5,
        slidesToScroll: 5,
        responsive: [
            {
                breakpoint: 1200,
                settings: {
                    slidesToShow: 4,
                    slidesToScroll: 4,
                    infinite: true,
                    dots: true
                }
            },
            {
                breakpoint: 1024,
                settings: {
                    slidesToShow: 3,
                    slidesToScroll: 3,
                    infinite: true,
                    dots: true
                }
            },
            {
                breakpoint: 800,
                settings: {
                    slidesToShow: 2,
                    slidesToScroll: 2
                }
            },
            {
                breakpoint: 480,
                settings: {
                    slidesToShow: 1,
                    slidesToScroll: 1
                }
            }
            // You can unslick at a given breakpoint now by adding:
            // settings: "unslick"
            // instead of a settings object
        ]
    });
    $(".slick-next").hide();
    $(".slick-prev").hide();
    $(".slick-dots").hide();


    // Tabs color
    document.querySelectorAll(".body__images--wrapper")[0].classList.add("body__images--active");
    document.querySelectorAll(".body__details__choose-colors__item")[0].classList.add("body__details__choose-colors__item--active");
    document.querySelectorAll(".body__details__detail__name-color")[0].classList.add("body__details__detail__name-color--active");
    $.map($(".body__details__choose-colors__item--wrapper"), (tab, index) => {
        $(tab).on("click", (e) => {
            $.map($(".body__details__detail__name-color"), (nameColor) => {
                $(nameColor).removeClass("body__details__detail__name-color--active")
            })
            var colorName = document.querySelectorAll(".body__details__detail__name-color")[index];
            colorName.classList.add("body__details__detail__name-color--active");


            $.map($(".body__details__choose-colors__item"), (color) => {
                $(color).removeClass("body__details__choose-colors__item--active")
            })
            var colorChoose = document.querySelectorAll(".body__details__choose-colors__item")[index];
            colorChoose.classList.add("body__details__choose-colors__item--active");


            $.map($(".body__images--wrapper"), (image) => {
                $(image).removeClass("body__images--active");
            })
            var images = document.querySelectorAll(".body__images--wrapper")[index];
            images.classList.add("body__images--active");

            $(`#name-color-${index}`).prop('checked', true);
        })
    })
    // Tabs Option
    document.querySelectorAll(".body__details__detail__name-option")[0].classList.add("body__details__detail__name-option--active");
    document.querySelectorAll(".body__details__choose-capacity__item--wrapper")[0].classList.add("body__details__choose-capacity__item--active");
    document.querySelectorAll(".breadcrumb__price-product")[0].classList.add("breadcrumb__price-product--active");
    document.querySelectorAll(".body__details__summary__heading__price")[0].classList.add("body__details__summary__heading__price--active");
    $.map($(".body__details__choose-capacity__item--wrapper"), (tab, index) => {
        $(tab).on("click", (e) => {
            $.map($(".body__details__choose-capacity__item--wrapper"), (option) => {
                $(option).removeClass("body__details__choose-capacity__item--active")
            })
            var optionChoose = document.querySelectorAll(".body__details__choose-capacity__item--wrapper")[index];
            optionChoose.classList.add("body__details__choose-capacity__item--active");

            $.map($(".body__details__detail__name-option"), (nameOption) => {
                $(nameOption).removeClass("body__details__detail__name-option--active")
            })
            var optionName = document.querySelectorAll(".body__details__detail__name-option")[index];
            optionName.classList.add("body__details__detail__name-option--active");


            $.map($(".breadcrumb__price-product"), (price) => {
                $(price).removeClass("breadcrumb__price-product--active")
            })
            var priceOption = document.querySelectorAll(".breadcrumb__price-product")[index];
            priceOption.classList.add("breadcrumb__price-product--active");


            $.map($(".body__details__summary__heading__price"), (price) => {
                $(price).removeClass("body__details__summary__heading__price--active")
            })
            var priceOption = document.querySelectorAll(".body__details__summary__heading__price")[index];
            priceOption.classList.add("body__details__summary__heading__price--active");

            $(`#name-option-${index}`).prop('checked', true);

        })
    })


})
existProInCart = (idPro, idColor, idProOption) => {
    let html = $(".header__navbar__cart__list").html();
    console.log(html.indexOf(idPro), html.indexOf(idColor), html.indexOf(idProOption))
    return !!(html.indexOf(idPro) !== -1 && html.indexOf(idColor) !== -1 && html.indexOf(idProOption) !== -1);

}
addProduct = () => {
    const listProductCart = $(".header__navbar__cart__list");

    const idPro = $("input.idPro").val();
    const namePro = $("#name-product").val();

    const idColor = $("input[name ='radio-color']:checked").val();
    const nameColor = $('input[name="name-color"]:checked').val();

    const idProOption = $("input[name ='radio-option']:checked").val();
    let nameOption = $('input[name="name-option"]:checked').val();
    if (typeof (nameOption) === 'undefined') {
        nameOption = "";
    }
    var url = $(".body__images--active").find("#image-product").val();
    var html = `<div class="header__navbar__cart__item">
                          <input hidden type="text" value="${idPro}">
                          <input hidden type="text" value="${idColor}">
                          <input hidden type="text" value="${idProOption}">
                          <div class="header__navbar__cart__item__img">
                               <img src='${url}' alt="">
                                        </div>
                                        <div class="header__navbar__cart__item__name">
                                                ${namePro}
                                            <br>
                                                ${nameColor}
                                            <br>
                                                ${nameOption}
                                        </div>
                                    </div>`;
    listProductCart.append(html);
}
