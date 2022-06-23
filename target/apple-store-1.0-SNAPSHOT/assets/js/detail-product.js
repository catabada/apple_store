jQuery(document).ready(function () {
    // jQuery(".body__another-product__list").slick({
    //     dots: true,
    //     infinite: false,
    //     speed: 300,
    //     slidesToShow: 5,
    //     slidesToScroll: 5,
    //     responsive: [
    //         {
    //             breakpoint: 1200,
    //             settings: {
    //                 slidesToShow: 4,
    //                 slidesToScroll: 4,
    //                 infinite: true,
    //                 dots: true
    //             }
    //         },
    //         {
    //             breakpoint: 1024,
    //             settings: {
    //                 slidesToShow: 3,
    //                 slidesToScroll: 3,
    //                 infinite: true,
    //                 dots: true
    //             }
    //         },
    //         {
    //             breakpoint: 800,
    //             settings: {
    //                 slidesToShow: 2,
    //                 slidesToScroll: 2
    //             }
    //         },
    //         {
    //             breakpoint: 480,
    //             settings: {
    //                 slidesToShow: 1,
    //                 slidesToScroll: 1
    //             }
    //         }
    //         // You can unslick at a given breakpoint now by adding:
    //         // settings: "unslick"
    //         // instead of a settings object
    //     ]
    // });
    // jQuery(".slick-next").hide();
    // jQuery(".slick-prev").hide();
    // jQuery(".slick-dots").hide();


    // Tabs color
    document.querySelectorAll(".body__images--wrapper")[0].classList.add("body__images--active");
    document.querySelectorAll(".body__details__choose-colors__item")[0].classList.add("body__details__choose-colors__item--active");
    document.querySelectorAll(".body__details__detail__name-color")[0].classList.add("body__details__detail__name-color--active");
    // Tabs Option


})
existProInCart = (idPro, idColor, idProOption) => {
    let html = jQuery(".header__navbar__cart__list").html();
    console.log(html.indexOf(idPro), html.indexOf(idColor), html.indexOf(idProOption))
    return !!(html.indexOf(idPro) !== -1 && html.indexOf(idColor) !== -1 && html.indexOf(idProOption) !== -1);

}
addProduct = () => {
    const listProductCart = jQuery(".header__navbar__cart__list");

    const idPro = jQuery("input.idPro").val();
    const namePro = jQuery("#name-product").val();

    const idColor = jQuery("input[name ='radio-color']:checked").val();
    const nameColor = jQuery('input[name="name-color"]:checked').val();

    const idProOption = jQuery("input[name ='radio-option']:checked").val();
    let nameOption = jQuery('input[name="name-option"]:checked').val();
    if (typeof (nameOption) === 'undefined') {
        nameOption = "";
    }
    var url = jQuery(".body__images--active").find("#image-product").val();
    var html = `<div class="header__navbar__cart__item">
                          <input hidden type="text" value="jQuery{idPro}">
                          <input hidden type="text" value="jQuery{idColor}">
                          <input hidden type="text" value="jQuery{idProOption}">
                          <div class="header__navbar__cart__item__img">
                               <img src='jQuery{url}' alt="">
                                        </div>
                                        <div class="header__navbar__cart__item__name">
                                                jQuery{namePro}
                                            <br>
                                                jQuery{nameColor}
                                            <br>
                                                jQuery{nameOption}
                                        </div>
                                    </div>`;
    listProductCart.append(html);
}


