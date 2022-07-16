(checkOutSubmit = () => {
    jQuery(".body__cart__btn").on("click", (e) => {
        e.preventDefault();
        let fullname = jQuery("input[name = 'fullname']").val();
        let email = jQuery("input[name = 'email']").val();
        let phoneNumber = jQuery("input[name = 'phone-number']").val();
        let address = jQuery("input[name = 'address']").val();
        jQuery.ajax({
            type: "POST",
            url: "/order-success",
            data: {
                fullname: fullname,
                email: email,
                phoneNumber: phoneNumber,
                address: address
            },
            success: (data) => {
                Swal.fire({
                    icon: 'success',
                    title: 'Successfully!...',
                    text: 'Your order has been successfully placed',
                    confirmButtonText: 'Back to homepage!',
                    footer: '<a id="go-to-profile" href="/profile">Go to profile to check orders history</a>'
                }).then((result => {
                    if (result.isConfirmed) {
                        window.location.href = "/home";
                    }
                }))
            }
        })
    })
})()