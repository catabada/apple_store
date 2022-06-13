<%@ page import="java.io.File" %><%--
  Created by IntelliJ IDEA.
  User: huynh
  Date: 2/14/2022
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product</title>
    <link rel="shortcut icon" type="image/png" href="../assets/img/admin.png">
    <!-- Google Font: Source Sans Pro -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="plugins/fontawesome-free/css/all.min.css">
    <!-- DataTables -->
    <link rel="stylesheet" href="plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
    <link rel="stylesheet" href="plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
    <link rel="stylesheet" href="plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="dist/css/adminlte.min.css">
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
                        <h1>Product Page</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Product Page</li>
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
                                <table id="product" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th data-priority="1">ID</th>
                                        <th>Sku</th>
                                        <th data-priority="2">Name</th>
                                        <th>Image</th>
                                        <th>Type</th>
                                        <th>Price</th>
                                        <th>Rate</th>
                                        <th>Discount</th>
                                        <th>Viewed</th>
                                        <th>Created</th>
                                        <th>Updated</th>
                                        <th>Active</th>
                                        <th data-priority="3"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>

                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th data-priority="1">ID</th>
                                        <th>Sku</th>
                                        <th data-priority="2">Name</th>
                                        <th>Image</th>
                                        <th>Type</th>
                                        <th>Price</th>
                                        <th>Rate</th>
                                        <th>Discount</th>
                                        <th>Viewed</th>
                                        <th>Created</th>
                                        <th>Updated</th>
                                        <th>Active</th>
                                        <th data-priority="3"></th>
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
                        <h4 class="modal-title">Add Product</h4>
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
                                        <label for="addImage">Image</label>
                                        <input type="file" id="addImage" name="addImage" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="addSku">Sku</label>
                                        <input type="text" id="addSku" name="addSku" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="addName">Name</label>
                                        <input type="text" id="addName" name="addName" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="addTypeId">Type</label>
                                        <select id="addTypeId" name="addTypeId" class="form-control custom-select">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="addPrice">Price</label>
                                        <input type="text" id="addPrice" name="addPrice" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="addDiscount">Discount</label>
                                        <input type="text" id="addDiscount" name="addDiscount" class="form-control">
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
                        <h4 class="modal-title">Update Product</h4>
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
                                        <label for="updateImage">Image</label>
                                        <input type="file" id="updateImage" name="updateImage" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateSku">Sku</label>
                                        <input type="text" id="updateSku" name="updateSku" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateName">Name</label>
                                        <input type="text" id="updateName" name="updateName" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateTypeId">Type</label>
                                        <select id="updateTypeId" name="updateTypeId"
                                                class="form-control custom-select">

                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="updatePrice">Price</label>
                                        <input type="text" id="updatePrice" name="updatePrice" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateRate">Rate</label>
                                        <input type="text" id="updateRate" name="updateRate" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateDiscount">Discount</label>
                                        <input type="text" id="updateDiscount" name="updateDiscount"
                                               class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateActive">Active</label>
                                        <select id="updateActive" name="updateActive"
                                                class="form-control custom-select">
                                            <option id="option-true" value="1">True</option>
                                            <option id="option-false" value="0">False</option>
                                        </select>
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
    <script src="plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap 4 -->
    <script src="plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- DataTables  & Plugins -->
    <script src="plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
    <script src="plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
    <script src="plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
    <script src="plugins/datatables-buttons/js/dataTables.buttons.min.js"></script>
    <script src="plugins/datatables-buttons/js/buttons.bootstrap4.min.js"></script>
    <script src="plugins/jszip/jszip.min.js"></script>
    <script src="plugins/pdfmake/pdfmake.min.js"></script>
    <script src="plugins/pdfmake/vfs_fonts.js"></script>
    <script src="plugins/datatables-buttons/js/buttons.html5.min.js"></script>
    <script src="plugins/datatables-buttons/js/buttons.print.min.js"></script>
    <script src="plugins/datatables-buttons/js/buttons.colVis.min.js"></script>
    <!-- AdminLTE App -->
    <script src="dist/js/adminlte.min.js"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="dist/js/demo.js"></script>
    <!-- Swal -->
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <!-- Validate jquery -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.4/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.4/additional-methods.min.js"></script>
    <!-- Firebase js -->

    <script>
        jQuery(function () {
            let table = jQuery("#product").DataTable({
                "responsive": true, "lengthChange": false, "autoWidth": false,
                "columnDefs": [
                    {
                        targets: 12,
                        orderable: false,
                        searchable: false,
                        render: function (data, type, row, meta) {
                            return '<div class="d-flex justify-content-around align-middle">' +
                                '<button type="button" onclick="getData(' + data + ')" class="btn-update btn btn-info btn-sm p-2" data-toggle="modal" data-target="#modal-update" ><i class="fas fa-edit"></i></button>' +
                                '<button type="button" onclick="deleteData(' + data + ')" class="btn-delete btn btn-danger btn-sm p-2"> <i class="fas fa-trash"></i></button>'
                                + '</div>';
                        }
                    },
                    {
                        targets: 3,
                        searchable: false,
                        render: function (data, type, row, meta) {
                            return '<img src="' + data + '" width="50px" height="50px" alt="">';
                        }
                    },
                ],
                initComplete: function () {
                    table.buttons().container().appendTo('.col-md-6:eq(0)', table.table().container());
                },
                "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"],
                ajax: {
                    url: `/api/product`,
                    dataSrc: "data"
                },
                columns: [
                    {data: "id"},
                    {data: "sku"},
                    {data: "name"},
                    {data: "urlImage"},
                    {data: "typeProduct.name"},
                    {data: "price"},
                    {data: "rate"},
                    {data: "discount"},
                    {data: "viewed"},
                    {data: "dateCreated"},
                    {data: "lastUpdated"},
                    {data: "active"},
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
                url: "/api/type-product",
                type: "GET",
                success: function (data) {
                    jQuery.map(data.data, (type, i) => {
                        if (i === 0)
                            jQuery("#addTypeId").append('<option selected value="' + type.id + '">' + type.name + '</option>');
                        else
                            jQuery("#addTypeId").append('<option value="' + type.id + '">' + type.name + '</option>');
                    });
                }
            })
        })

        function reloadData() {
            jQuery('#product').DataTable().ajax.reload();
        }

        function getData(id) {
            jQuery.ajax({
                url: `/api/product/` + id,
                type: 'GET',
                success: function (data) {
                    reloadData();
                    jQuery('#updateSku').val(data.data.sku);
                    jQuery('#updateName').val(data.data.name);
                    jQuery('#updatePrice').val(data.data.price);
                    jQuery('#updateRate').val(data.data.rate);
                    jQuery('#updateDiscount').val(data.data.discount);
                    jQuery('#updateViewed').val(data.data.viewed);
                    if (data.data.active) {
                        jQuery('#option-true').prop('selected', true);
                        jQuery('#option-false').prop('selected', false);

                    } else {
                        jQuery('#option-true').prop('selected', false);
                        jQuery('#option-false').prop('selected', true);
                    }
                }
            });
            jQuery.ajax({
                url: "/api/type-product",
                type: "GET",
                success: function (data) {
                    jQuery.map(data.data, (type, i) => {
                        console.log(type.id)
                        if (id === type.id)
                            jQuery("#updateTypeId").append('<option selected value="' + type.id + '">' + type.name + '</option>');
                        else
                            jQuery("#updateTypeId").append('<option value="' + type.id + '">' + type.name + '</option>');
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
                        url: `/api/product/` + id,
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
            // const task = ref.child("apple-store/image/product/" + Date.now() + name).put(file, metadata);
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
                    url: `/api/product`,
                    processData: false,
                    contentType: false,
                    data: data,
                    success: function () {
                        reloadData();
                        Swal.fire({
                            icon: 'success',
                            title: 'Product is existed in your cart so amount will be extra 1.',
                            showConfirmButton: false,
                            timer: 1500
                        })
                        jQuery("#modal-add").removeClass("show");
                        jQuery(".modal-backdrop").removeClass("show");

                    }

                });
            }
        })
        jQuery("#modal-add").validate({
            rules: {
                addSku: {
                    required: true,
                    minlength: 3,
                    maxlength: 20
                },
                addName: {
                    required: true,
                    minlength: 3,
                    maxlength: 20
                },
                addPrice: {
                    number: true,
                    required: true,
                    min: 0
                },
                addDiscount: {
                    number: true,
                    required: true,
                    min: 0,
                    max: 1
                },
                addType: {
                    required: true
                },
                addImage: {
                    required: true,
                    accept: "image/*"
                }
            },
            messages: {
                addSku: {
                    required: "Please enter sku",
                    minlength: "Sku must be at least 3 characters long",
                    maxlength: "Sku cannot be more than 20 characters long"
                },
                addName: {
                    required: "Please enter name",
                    minlength: "Name must be at least 3 characters long",
                    maxlength: "Name cannot be more than 20 characters long"
                },
                addPrice: {
                    number: "Price must be a number",
                    required: "Please enter price",
                    min: "Price must be greater than 0"
                },
                addType: {
                    required: "Please enter type"
                },
                addDiscount: {
                    number: "Discount must be a number",
                    required: "Please enter discount",
                    min: "Discount must be greater than 0",
                    max: "Discount must be less than 1"
                },
                addImage: {
                    required: "Please enter image",
                    accept: "Image must be in png, jpg, jpeg or gif format"

                }
            },
            errorElement: 'span',
            errorPlacement: function (error, element) {
                error.addClass('invalid-feedback');
                element.closest('.form-group').append(error);
            },
            highlight: function (element, errorClass, validClass) {
                jQuery(element).addClass('is-invalid');
            },
            unhighlight: function (element, errorClass, validClass) {
                jQuery(element).removeClass('is-invalid');
            }
        })

        jQuery("#update-btn").on("click", function (e) {
            e.preventDefault();
            jQuery.ajax({
                type: "PUT",
                url: '${pageContext.request.contextPath}/api/product?id=' + jQuery(this).attr("pid"),
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
