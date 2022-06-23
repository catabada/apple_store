(saveChanges = () => {
    $("#save-changes").on("click", (e) => {
        let first = $("input[name = 'first']").val();
        let last = $("input[name = 'last']").val();
        let email = $("input[name = 'email']").val();
        let phoneNumber = $("input[name = 'phone-number']").val();
        let address = $("input[name = 'address']").val();
        $.ajax({
            type: "POST",
            url: "/edit-profile",
            data: {
                first: first,
                last: last,
                email: email,
                phoneNumber: phoneNumber,
                address: address
            },
            success: (data) => {
                Swal.fire({
                    icon: 'success',
                    title: 'Successfully!...',
                    text: 'Your profile has been changed',
                })

            }
        })
    })
})()