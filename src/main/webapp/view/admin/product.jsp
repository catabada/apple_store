<%--
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
                                <button class="btn btn-success" type="button" data-toggle="modal"
                                        data-target="#modal-add">Add
                                </button>
                                <table id="product" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th data-priority="1">ID</th>
                                        <th>Image</th>
                                        <th data-priority="2">Name</th>
                                        <th>Type</th>
                                        <th>Price</th>
                                        <th>Rate</th>
                                        <th>Discount</th>
                                        <th>Viewed</th>
                                        <th>Import</th>
                                        <th>Stock</th>
                                        <th>Active</th>
                                        <th>Date</th>
                                        <th data-priority="3"></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <%--<c:forEach var="item" items="${listPro}">
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>
                                            <img src="../${imageDao.get(item.idImg).url}" width="30" height="30"
                                                 alt="">
                                        </td>
                                        <td>${item.name}</td>
                                        <td>${typeDao.get(item.idTypePro)}</td>
                                        <td>$${item.price}</td>
                                        <td>${item.rate}</td>
                                        <td>${item.discount}</td>
                                        <td>${item.viewed}</td>
                                        <td>${item.quantityImport}</td>
                                        <td>${item.quantityStock}</td>
                                        <td>${item.active}</td>
                                        <td>${item.dateImport}</td>
                                        <td style="text-align:center">
                                            <button style="width:30px;height:30px;padding:0"
                                                    id="update-btn"
                                                    pid="${item.id}"
                                                    class="btn btn-warning " type="button">
                                                <i style="font-size:0.8rem;" class="fa fa-edit"
                                                              data-target="#modal-update"
                                                              aria-hidden="true"></i>
                                            </button>
                                            <p></p>
                                            <button style="width:30px;height:30px;padding:0"
                                                    id="delete-btn"
                                                    class="btn btn-danger " type="button"><i
                                                    style="font-size:0.8rem;" class="fa fa-trash"
                                                    aria-hidden="true"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>--%>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>ID</th>
                                        <th>Image</th>
                                        <th>Name</th>
                                        <th>Type</th>
                                        <th>Price</th>
                                        <th>Rate</th>
                                        <th>Discount</th>
                                        <th>Viewed</th>
                                        <th>Import</th>
                                        <th>Stock</th>
                                        <th>Active</th>
                                        <th>Date</th>
                                        <th></th>
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
                                        <label for="inputImage">Image</label>
                                        <input type="file" id="inputImage" name="image" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputName">Name</label>
                                        <input type="text" id="inputName" name="namePro" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputType">Type</label>
                                        <select id="inputType" name="selectType" class="form-control custom-select">
                                            <option selected disabled>Select one type product</option>
                                            <c:forEach var="item" items="${listType}">
                                                <option data-type="${item.id}">${item.id}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPrice">Price</label>
                                        <input type="text" id="inputPrice" name="price" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputRate">Rate</label>
                                        <input type="text" id="inputRate" name="rate" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputDiscount">Discount</label>
                                        <input type="text" id="inputDiscount" name="discount" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputQuantityImport">Quantity Import</label>
                                        <input type="text" id="inputQuantityImport" name="quantityImport"
                                               class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputQuantityStock">Quantity Stock</label>
                                        <input type="text" id="inputQuantityStock" name="quantityStock"
                                               class="form-control">
                                    </div>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" id="add-product" class="btn btn-primary" value="Add"/>
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
                                        <label for="inputImage">Image</label>
                                        <input type="file" id="updateImage" name="image" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputName">Name</label>
                                        <input type="text" id="updateName" name="namePro" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputType">Type</label>
                                        <select id="updateType" name="selectType" class="form-control custom-select">
                                            <option selected disabled>Select one type product</option>
                                            <c:forEach var="item" items="${listType}">
                                                <option data-type="${item.id}">${item.id}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="inputPrice">Price</label>
                                        <input type="text" id="updatePrice" name="price" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputRate">Rate</label>
                                        <input type="text" id="updateRate" name="rate" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputDiscount">Discount</label>
                                        <input type="text" id="updateDiscount" name="discount" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputQuantityImport">Quantity Import</label>
                                        <input type="text" id="updateQuantityImport" name="quantityImport"
                                               class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="inputQuantityStock">Quantity Stock</label>
                                        <input type="text" id="updateQuantityStock" name="quantityStock"
                                               class="form-control">
                                    </div>
                                </div>
                                <!-- /.card-body -->
                            </div>
                            <!-- /.card -->
                        </div>
                    </div>
                    <div class="modal-footer justify-content-between">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <input type="submit" id="update-product" class="btn btn-primary" value="Update"/>
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
        $(function () {
            $("#product").DataTable({
                "responsive": true, "lengthChange": false, "autoWidth": false,
                "columnDefs": [
                    {
                        targets: 12,
                        orderable: false,
                        searchable: false,
                        render: function (data, type, row, meta) {
                            return '<div class="d-flex justify-content-center align-middle">' +
                                '<button type="button" class="btn btn-info btn-sm" pid="' + data + '" data-toggle="modal" data-target="#modal-update" ><i class="fas fa-edit"></i></button>' +
                                '<button type="button" class="btn btn-danger btn-sm" pid="' + data + '"> <i class="fas fa-trash"></i></button>'
                                + '</div>';
                        }
                    },
                    {
                        targets: 1,
                        searchable: false,
                        render: function (data, type, row, meta) {
                            return '<img src="/' + data + '" width="50px" height="50px" alt="">';
                        }
                    },
                    {
                        targets: 7,
                        visible: false
                    },
                ],
                "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"],
                ajax: {
                    url: `${pageContext.request.contextPath}/api/product/IPH1`,
                    dataSrc: ""
                },
                columns: [
                    {data: "id"},
                    {data: "urlImage"},
                    {data: "name"},
                    {data: "type"},
                    {data: "price"},
                    {data: "rate"},
                    {data: "discount"},
                    {data: "viewed"},
                    {data: "quantityImport"},
                    {data: "quantityStock"},
                    {data: "active"},
                    {data: "dateImport"},
                    {data: "id"}
                ],
            }).buttons().container().appendTo('#product_wrapper .col-md-6:eq(0)');
            $('#example2').DataTable({
                "paging": true,
                "lengthChange": false,
                "searching": false,
                "ordering": true,
                "info": true,
                "autoWidth": false,
                "responsive": true,
            });

        });


        jQuery("#add-product").on("click", function (e) {
            e.preventDefault();
            let valid = jQuery("#modal-add").valid();

            let urlImage = "";
            const ref = firebase.storage().ref();
            const file = document.querySelector("#inputImage").files[0];
            console.log(file)
            const name = file.name;
            const metadata = {
                contentType: file.type
            };
            const task = ref.child("apple-store/image/product/" + Date.now() + name).put(file, metadata);
            task
                .then(snapshot => snapshot.ref.getDownloadURL())
                .then(url => {
                    console.log(url)
                })
                .catch(console.error);
            if (valid) {
                let data = new FormData(jQuery("#modal-add")[0]);
                $.ajax({
                    type: "POST",
                    url: `${pageContext.request.contextPath}/api/product/?action=add`,
                    processData: false,
                    contentType: false,
                    data: data,
                    success: function () {
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
                image: {
                    required: true,
                    extension: "jpg|png|jpeg|gif"
                },
                namePro: {
                    required: true,
                    minlength: 3,
                    maxlength: 50
                },
                selectType: {
                    required: true
                },
                price: {
                    required: true,
                    number: true,
                    min: 0
                },
                rate: {
                    required: true,
                    number: true,
                    min: 1,
                    max: 5
                },
                discount: {
                    required: true,
                    number: true,
                    min: 0,
                    max: 1
                },
                quantityImport: {
                    required: true,
                    number: true,
                    min: 0
                },
                quantityStock: {
                    required: true,
                    number: true,
                    min: 0
                }
            },
            messages: {
                image: {
                    required: "Please choose image",
                    extension: "Please choose image with extension jpg, png, jpeg, gif"
                },
                namePro: {
                    required: "Please enter name product",
                    minlength: "Please enter at least 3 characters",
                    maxlength: "Please enter no more than 50 characters"
                },
                selectType: {
                    required: "Please choose type"
                },
                price: {
                    required: "Please enter price",
                    number: "Please enter number",
                    min: "Please enter number greater than 0"
                },
                rate: {
                    required: "Please enter rate",
                    number: "Please enter number",
                    min: "Please enter number greater than 0",
                    max: "Please enter number less than 5"
                },
                discount: {
                    required: "Please enter discount",
                    number: "Please enter number",
                    min: "Please enter number greater than 0",
                    max: "Please enter number less than 1"
                },
                quantityImport: {
                    required: "Please enter quantity import",
                    number: "Please enter number",
                    min: "Please enter number greater than 0"
                },
                quantityStock: {
                    required: "Please enter quantity stock",
                    number: "Please enter number",
                    min: "Please enter number greater than 0"
                }
            },
            errorElement: 'span',
            errorPlacement: function (error, element) {
                error.addClass('invalid-feedback');
                element.closest('.form-group').append(error);
            },
            highlight: function (element, errorClass, validClass) {
                $(element).addClass('is-invalid');
            },
            unhighlight: function (element, errorClass, validClass) {
                $(element).removeClass('is-invalid');
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
