$(document).ready(function () {
    $.map($(".body__item__detail__option__remove"), (item, index) => {
        $(item).on("click", (e) => {
            let idPro = $($(item).parents(".body__item")).find($("input#idPro")).val();
            let idColor = $($(item).parents(".body__item")).find($("input#idColor")).val();
            let idProOption = $($(item).parents(".body__item")).find($("input#idProOption")).val();
            console.log(idPro, idColor, idProOption)
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                font: "",
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.isConfirmed) {
                    Swal.fire(
                        'Deleted!',
                        'Your file has been deleted.',
                        'success'
                    )
                    $(item).parents(".body__item").remove();
                    $.map($(".header__navbar__cart__item"), (cartItem) => {
                        let html = $(cartItem).html();
                        console.log(html)
                        if (html.indexOf(idPro) !== -1 && html.indexOf(idColor) !== -1 && html.indexOf(idProOption) !== -1) {
                            $(cartItem).remove();
                        }
                    })
                    let idCartItem = $(item).siblings(".id-cart-item").val()
                    $.ajax({
                        type: "POST",
                        url: "/cart-crud?action=remove",
                        data: {
                            idCartItem: idCartItem
                        }
                    })
                    totalPrice()

                    var numOfList = Number.parseInt($(".header__navbar__cart--amount").text());
                    numOfList -= 1;
                    $(".header__navbar__cart--amount").text(numOfList)
                    if(numOfList === 0) {
                        $(".header__navbar__cart--amount").hide();
                        $(".header__navbar__cart__list--wrapper").hide();
                        $(".header__navbar__cart__none").show();
                    }
                }
            })

        })
    })
    $.map($(".body__item__detail__amount"), (item, index) => {
        $(item).find(".amount-product").on("change", (e) => {
            let idCartItem = $(item).siblings(".body__item__detail__option").find(".id-cart-item").val();
            let amount = $(e.target).val();
            let price = $(item).find(".price-product").val();
            $(item).siblings(".body__item__detail__option")
                .find(".body__item__detail__option__price")
                .text("$" + Math.round(Number.parseFloat(price) * amount));
            $.ajax({
                type: "POST",
                url: "/cart-crud?action=update",
                data: {
                    idCartItem: idCartItem,
                    amount: amount
                }
            })
            totalPrice()
        })
    })

    let totalPrice = () => {
        let totalPrice = 0;
        $.map($(".body__item__detail__amount"), (item) => {
            let amount = $(item).find(".amount-product").val();
            let price = $(item).find(".price-product").val();
            totalPrice += price * amount;
        })
        $(".total-price-cart").text(totalPrice);
    }
})
