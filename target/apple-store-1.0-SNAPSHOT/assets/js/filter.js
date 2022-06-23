$(document).ready(() => {
    var nameButtonFilterVersion = "";
    // Filter version
    for (item of document.querySelectorAll(".body-filter__option-version-item-link")) {
        item.addEventListener("click", (e) => {
            e.preventDefault();
            nameButtonFilterVersion = e.target.innerHTML.trim();
            console.log(nameButtonFilterVersion)
            for (link of document.querySelectorAll(".body-filter__option-version-item-link")) {
                $(link).removeClass("body-filter__option-item-link--active")
            }
            $(e.target).toggleClass("body-filter__option-item-link--active");

            if (nameButtonFilterVersion === "Standard") {
            } else {
                for (item of document.querySelectorAll(".body-all-product__products-item")) {
                    $(item).toggle($(item).text().toLowerCase().indexOf(nameButtonFilterVersion.toLowerCase()) > -1);
                }
            }
        })
    }
    $(".body-filter__btn-reset").on("click", (e) => {
        $(".body-all-product__products-item").show();
    })

})