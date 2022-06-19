<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Color</title>
    <link rel="shortcut icon" type="image/png" href="../assets/img/admin.png">
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/fontawesome-free/css/all.min.css">
    <!-- DataTables -->
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini dark-mode">
<div class="wrapper">
    <c:import url="layout/navigation.jsp"/>
    <c:import url="layout/sidebar.jsp"/>

    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Product Color Page</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Product Color Page</li>
                        </ol>
                    </div>
                </div>
            </div><!-- /.container-fluid -->
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-header">
                                <h3 class="card-title">DataTable with default features</h3>
                            </div>
                            <!-- /.card-header -->
                            <div class="card-body">
                                <button id="btn-add" class="btn btn-success float-left" type="button"
                                        data-toggle="modal"
                                        data-target="#modal-add">Add
                                </button>
                                <table id="product-color" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th data-priority="1">ID</th>
                                        <th data-priority="2">Product</th>
                                        <th data-priority="3">Color</th>
                                        <th>Background Image</th>
                                        <th>Detail Images</th>
                                        <th data-priority="4"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>

                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th data-priority="1">ID</th>
                                        <th data-priority="2">Product</th>
                                        <th data-priority="3">Color</th>
                                        <th>Background Image</th>
                                        <th>Detail Images</th>
                                        <th data-priority="4"></th>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                            <!-- /.card-body -->
                        </div>
                        <!-- /.card -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </section>

        <form class="modal fade"
              id="modal-add"
              enctype="multipart/form-data"
              novalidate="novalidate">

            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Add Product Color</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <div class="card-tools">
                                        <button type="button" class="btn btn-tool" data-card-widget="collapse"
                                                title="Collapse">
                                            <i class="fas fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="addProductId">Product</label>
                                        <select id="addProductId" name="addProductId"
                                                class="form-control custom-select">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="addColorId">Color</label>
                                        <select id="addColorId" name="addColorId" class="form-control custom-select">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="addBgImage">Background Image</label>
                                        <input type="file" id="addBgImage" name="addBgImage" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="addDeImages">Detail Images</label>
                                        <input type="file" id="addDeImages" name="addDeImages" class="form-control">
                                    </div>

                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" id="add-submit" class="btn btn-primary" value="Add"/>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </form>
        <form class="modal fade"
              id="modal-update"
              enctype="multipart/form-data"
              novalidate="novalidate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Update Product Color</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="col-md-12">
                            <div class="card card-primary">
                                <div class="card-header">
                                    <div class="card-tools">
                                        <button type="button" class="btn btn-tool" data-card-widget="collapse"
                                                title="Collapse">
                                            <i class="fas fa-minus"></i>
                                        </button>
                                    </div>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="updateProductId">Product</label>
                                        <select id="updateProductId" name="updateProductId"
                                                class="form-control custom-select">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="updateColorId">Color</label>
                                        <select id="updateColorId" name="updateColorId" class="form-control custom-select">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="updateBgImage">Background Image</label>
                                        <input type="file" id="updateBgImage" name="updateBgImage" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateDeImages">Detail Images</label>
                                        <input type="file" id="updateDeImages" name="updateDeImages" class="form-control">
                                    </div>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" id="update-submit" class="btn btn-primary" value="Update"/>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </form>
        <!-- /.modal -->
        <!-- /.content -->
    </div>
    <c:import url="layout/footer.jsp"/>
    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/assets/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- DataTables  & Plugins -->
    <script src="${pageContext.request.contextPath}/assets/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/jszip/jszip.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/pdfmake/pdfmake.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/pdfmake/vfs_fonts.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/datatables-buttons/js/buttons.html5.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/datatables-buttons/js/buttons.print.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
    <!-- AdminLTE App -->
    <script src="${pageContext.request.contextPath}/assets/dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="${pageContext.request.contextPath}/assets/dist/js/demo.js"></script>
    <!-- Swal -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- Validate jquery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.4/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.4/additional-methods.min.js"></script>
    <!-- Firebase js -->

    <script>
        jQuery(function () {
            let table = jQuery("#product-color").DataTable({
                "responsive": true, "lengthChange": false, "autoWidth": false,
                "columnDefs": [
                    {
                        targets: 5,
                        orderable: false,
                        searchable: false,
                        render: function (data, type, row, meta) {
                            return '<div class="d-flex justify-content-around align-middle">' +
                                '<button type="button" onclick="getData(' + data + ')" class="btn-update btn btn-info btn-sm p-2" data-toggle="modal" data-target="#modal-update" ><i class="fas fa-edit"></i></button>' +
                                '<button type="button" onclick="deleteData(' + data + ')" class="btn-delete btn btn-danger btn-sm p-2"> <i class="fas fa-trash"></i></button>'
                                + '</div>';
                        }
                    },
                    // {
                    //     targets: 3,
                    //     searchable: false,
                    //     render: function (data, type, row, meta) {
                    //         return '<img src="' + data + '" width="50px" height="50px" alt="">';
                    //     }
                    // },
                ],
                initComplete: function () {
                    table.buttons().container().appendTo('.col-md-6:eq(0)', table.table().container());
                },
                "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"],
                ajax: {
                    url: `/api/product-color`,
                    dataSrc: "data"
                },
                columns: [
                    {data: "id"},
                    {data: "product.name"},
                    {data: "color.name"},
                    {data: "bgImage"},
                    {data: "deImages"},
                    {data: "id"}
                ],
            });
            // $('#example2').DataTable({
            //     "paging": true,
            //     "lengthChange": false,
            //     "searching": false,
            //     "ordering": true,
            //     "info": true,
            //     "autoWidth": false,
            //     "responsive": true,
            // });

        });

        jQuery("#btn-add").on("click", function (e) {
            jQuery.ajax({
                url: "/api/product",
                type: "GET",
                success: function (data) {
                    jQuery.map(data.data, (type, i) => {
                        if (i === 0)
                            jQuery("#addProductId").append('<option selected value="' + type.id + '">' + type.name + '</option>');
                        else
                            jQuery("#addProductId").append('<option value="' + type.id + '">' + type.name + '</option>');
                    });
                }
            })
            jQuery.ajax({
                url: "/api/color",
                type: "GET",
                success: function (data) {
                    jQuery.map(data.data, (type, i) => {
                        if (i === 0)
                            jQuery("#addColorId").append('<option selected value="' + type.id + '">' + type.name + '</option>');
                        else
                            jQuery("#addColorId").append('<option value="' + type.id + '">' + type.name + '</option>');
                    });
                }
            })
        })

        function reloadData() {
            jQuery('#product-color').DataTable().ajax.reload();
        }

        function getData(id) {
            jQuery.ajax({
                url: `/api/product-color/` + id,
                type: 'GET',
                success: function (data) {
                    reloadData();
                    jQuery('#updateBgImage').val(data.data.bgImage);
                    jQuery('#updateDeImages').val(data.data.deImages);
                }
            });
            jQuery.ajax({
                url: "/api/product",
                type: "GET",
                success: function (data) {
                    jQuery("#updateProductId").empty();
                    jQuery.map(data.data, (type, i) => {
                        if (id === type.id)
                            jQuery("#updateProductId").append('<option selected value="' + type.id + '">' + type.name + '</option>');
                        else
                            jQuery("#updateProductId").append('<option value="' + type.id + '">' + type.name + '</option>');
                    });
                }
            })
            jQuery.ajax({
                url: "/api/color",
                type: "GET",
                success: function (data) {
                    jQuery("#updateColorId").empty();
                    jQuery.map(data.data, (type, i) => {
                        if (id === type.id)
                            jQuery("#updateColorId").append('<option selected value="' + type.id + '">' + type.name + '</option>');
                        else
                            jQuery("#updateColorId").append('<option value="' + type.id + '">' + type.name + '</option>');
                    });
                }
            })

        }

        function deleteData(id) {
            Swal.fire({
                title: 'Are you sure?',
                text: "You won't be able to revert this!",
                icon: 'warning',
                showCancelButton: true,
                confirmButtonColor: '#3085d6',
                cancelButtonColor: '#d33',
                confirmButtonText: 'Yes, delete it!'
            }).then((result) => {
                if (result.value) {
                    jQuery.ajax({
                        url: `/api/product-color/` + id,
                        type: 'DELETE',
                        success: function (data) {
                            Swal.fire(
                                'Deleted!',
                                'Your file has been deleted.',
                                'success'
                            ).then(function () {
                                reloadData();
                            });
                        }
                    });
                }
            })
        }

        function setInputDefault(idName) {
            jQuery.map(jQuery("#modal-add").find("input"), (item, i) => {
                jQuery(item).val("");
            })

        }

        jQuery("#add-submit").on("click", function (e) {
            e.preventDefault();
            let valid = jQuery("#modal-add").valid();

            // let urlImage = "";
            // const ref = firebase.storage().ref();
            // const file = document.querySelector("#inputImage").files[0];
            // console.log(file)
            // const name = file.name;
            // const metadata = {
            //     contentType: file.type
            // };
            // const task = ref.child("apple-store/image/product-color/" + Date.now() + name).put(file, metadata);
            // task
            //     .then(snapshot => snapshot.ref.getDownloadURL())
            //     .then(url => {
            //         console.log(url)
            //     })
            //     .catch(console.error);
            if (valid) {
                let data = new FormData(jQuery("#modal-add")[0]);
                $.ajax({
                    type: "POST",
                    url: `/api/product-color`,
                    processData: false,
                    contentType: false,
                    data: data,
                    success: function (data) {
                        reloadData();
                        if (data.success) {
                            reloadData();
                            Swal.fire({
                                icon: 'success',
                                title: 'SUCCESS',
                                text: data.message,
                                showConfirmButton: false,
                                timer: 2000
                            })
                            jQuery("#type-product").trigger("reset");
                            jQuery('#modal-add').modal('hide');
                            setInputDefault("#modal-add");
                        } else {
                            Swal.fire({
                                icon: 'error',
                                title: 'ERROR',
                                text: data.message,
                                showConfirmButton: false,
                                timer: 2000
                            })
                        }

                    }

                });
            }
        })
        jQuery("#update-submit").on("click", function (e) {
            e.preventDefault();
            let valid = jQuery("#modal-update").valid();
            if (valid) {
                let data = new FormData(jQuery("#modal-update")[0]);
                let id = data.get("updateId");
                $.ajax({
                    type: "PUT",
                    url: `/api/product-color/` + id,
                    processData: false,
                    contentType: false,
                    data: data,
                    success: function () {
                        reloadData();
                        if (data.success) {
                            reloadData();
                            Swal.fire({
                                icon: 'success',
                                title: 'SUCCESS',
                                text: data.message,
                                showConfirmButton: false,
                                timer: 2000
                            })
                        } else {
                            Swal.fire({
                                icon: 'error',
                                title: 'ERROR',
                                text: data.message,
                                showConfirmButton: false,
                                timer: 2000
                            })
                        }
                    }
                });
            }
        })

        jQuery("#update-btn").on("click", function (e) {
            e.preventDefault();
            jQuery.ajax({
                type: "PUT",
                url: '${pageContext.request.contextPath}/api/product-color?id=' + jQuery(this).attr("pid"),
                success: function (data) {
                    jQuery("#modal-update").show();
                    jQuery("#updateName").val(data.name);
                    jQuery("#updatePrice").val(data.price);
                    jQuery("#updateRate").val(data.rate);
                    jQuery("#updateDiscount").val(data.discount);
                    jQuery("#updateQuantityImport").val(data.quantityImport);
                    jQuery("#updateQuantityStock").val(data.quantityStock);
                    jQuery("#updateActive").val(data.active);
                    jQuery("#updateDateImport").val(data.dateImport);
                    jQuery("#updateId").val(data.id);
                    jQuery("#updateImage").attr("src", data.urlImage);
                }
            });
        })

    </script>
    <script src="https://www.gstatic.com/firebasejs/7.7.0/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/7.7.0/firebase-storage.js"></script>

    <script>
        const firebaseConfig = {
            apiKey: "AIzaSyDRv2MGm8bxypVKGbXG8PHuY5csg9LXGWY",
            authDomain: "apple-store-4ddc4.firebaseapp.com",
            projectId: "apple-store-4ddc4",
            storageBucket: "apple-store-4ddc4.appspot.com",
            messagingSenderId: "745731993980",
            appId: "1:745731993980:web:06c029e7a5c1e305ed74f9"
        };
        // Initialize Firebase
        firebase.initializeApp(firebaseConfig);

        function uploadImage() {

        }

    </script>

</div>
</body>
</html>
