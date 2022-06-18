<%@ page import="java.io.File" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Product Option</title>
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
                        <h1>Product Option Page</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Product Option Page</li>
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
                                <table id="product-option" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th data-priority="1">ID</th>
                                        <th>Sku</th>
                                        <th>Product</th>
                                        <th>Option</th>
                                        <th>Name</th>
                                        <th data-priority="2"></th>
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
                                        <th>Product</th>
                                        <th>Option</th>
                                        <th>Name</th>
                                        <th data-priority="2"></th>
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
                        <h4 class="modal-title">Add Product Option</h4>
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
                                        <select onchange="changeOptionByProductAdd()" id="addProductId"
                                                name="addProductId"
                                                class="form-control custom-select">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="addOptionId">Option</label>
                                        <select id="addOptionId" name="addOptionId"
                                                class="form-control custom-select">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="addSku">Sku</label>
                                        <input type="text" id="addSku" name="addSku" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="addName">Name</label>
                                        <input type="text" id="addName" name="addName" class="form-control">
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
                        <h4 class="modal-title">Update Product Option</h4>
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
                                        <label hidden for="updateId"></label>
                                        <input hidden type="text" id="updateId"
                                               name="updateId"
                                               class="form-control"
                                               placeholder="Ex: PH, PA,..">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateProductId">Product</label>
                                        <select onchange="changeOptionByProductUpdate()" id="updateProductId" name="updateProductId"
                                                class="form-control custom-select">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="updateOptionId">Option</label>
                                        <select id="updateOptionId"
                                                name="updateOptionId"
                                                class="form-control custom-select">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="updateSku">Sku</label>
                                        <input type="text" id="updateSku" name="updateSku" class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateName">Name</label>
                                        <input type="text" id="updateName" name="updateName" class="form-control">
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
            let table = jQuery("#product-option").DataTable({
                "responsive": true, "lengthChange": false, "autoWidth": false,
                "columnDefs": [
                    {
                        targets: 5,
                        width: 100,
                        orderable: false,
                        searchable: false,
                        render: function (data, type, row, meta) {
                            let productOption = data;
                            return '<div class="d-flex justify-content-around align-middle">' +
                                '<button type="button" onclick="getData(' + productOption.id + ', ' + productOption.product.id + ', ' + productOption.option.id + ')"  class="btn-update btn btn-info btn-sm p-2" data-toggle="modal" data-target="#modal-update" ><i class="fas fa-edit"></i></button>' +
                                '<button type="button" onclick="deleteData(' + productOption.id + ')" class="btn-delete btn btn-danger btn-sm p-2"> <i class="fas fa-trash"></i></button>'
                                + '</div>';
                        }
                    },
                    {
                        targets: 1,
                        render: function (data, type, row, meta) {
                            let product = data;
                            return '<div class="productId" value="' + product.id + '">' + product.name + '</div>';
                        }
                    },
                    {
                        targets: 2,
                        render: function (data, type, row, meta) {
                            let option = data;
                            return '<div class="optionId" value="' + option.id + '">' + option.name + '</div>';
                        }
                    },
                ],
                initComplete: function () {
                    table.buttons().container().appendTo('.col-md-6:eq(0)', table.table().container());
                },
                "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"],
                ajax: {
                    url: `/api/product-option`,
                    dataSrc: "data"
                },
                columns: [
                    {data: "id"},
                    {data: "product"},
                    {data: "option"},
                    {data: "sku"},
                    {data: "name"},
                    {data: {}},
                ],
            });

        });

        jQuery("#btn-add").on("click", function (e) {
            jQuery.ajax({
                url: "/api/product",
                type: "GET",
                success: function (data) {
                    jQuery("#addProductId").empty();
                    jQuery.map(data.data, (product, i) => {
                        if (i === 0)
                            jQuery("#addProductId").append('<option selected value="' + product.id + '">' + product.name + '</option>');
                        else
                            jQuery("#addProductId").append('<option value="' + product.id + '">' + product.name + '</option>');
                    });
                }
            }).done(function () {
                let productId = jQuery("#addProductId").val();
                jQuery.ajax({
                    url: "/api/option/listByTypeProductId" + productId,
                    type: "GET",
                    success: function (data) {
                        jQuery("#addOptionId").empty();
                        jQuery.map(data.data, (option, i) => {
                            if (i === 0)
                                jQuery("#addOptionId").append('<option selected value="' + option.id + '">' + option.name + '</option>');
                            else
                                jQuery("#addOptionId").append('<option value="' + option.id + '">' + option.name + '</option>');
                        });
                    }
                })
            })
        })

        function reloadData() {
            jQuery('#product-option').DataTable().ajax.reload();
        }

        function getData(id, productId, optionId) {
            jQuery.ajax({
                url: `/api/product-option/` + id,
                type: 'GET',
                success: function (data) {
                    reloadData();
                    jQuery('#updateId').val(data.data.id);
                    jQuery('#updateSku').val(data.data.sku);
                    jQuery('#updateName').val(data.data.name);
                }
            });
            jQuery.ajax({
                url: "/api/product",
                type: "GET",
                success: function (data) {
                    jQuery("#updateProductId").empty();
                    jQuery.map(data.data, (product, i) => {
                        if (productId == product.id)
                            jQuery("#updateProductId").append('<option selected value="' + product.id + '">' + product.name + '</option>');
                        else
                            jQuery("#updateProductId").append('<option value="' + product.id + '">' + product.name + '</option>');
                    });
                }
            }).done(function () {
                let productIdUpdate = jQuery("#updateProductId").val();
                jQuery.ajax({
                    url: "/api/option/listByTypeProductId" + productIdUpdate,
                    type: "GET",
                    success: function (data) {
                        jQuery("#updateOptionId").empty();
                        jQuery.map(data.data, (option, i) => {
                            if (optionId == option.id)
                                jQuery("#updateOptionId").append('<option selected value="' + option.id + '">' + option.name + '</option>');
                            else
                                jQuery("#updateOptionId").append('<option value="' + option.id + '">' + option.name + '</option>');
                        });
                    }
                })
            });


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
                        url: `/api/product-option/` + id,
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

        function changeOptionByProductAdd() {
            let productId = jQuery("#addProductId").val();
            jQuery.ajax({
                url: "/api/option/listByTypeProductId" + productId,
                type: "GET",
                success: function (data) {
                    jQuery("#addOptionId").empty();
                    jQuery.map(data.data, (option, i) => {
                        if (i === 0)
                            jQuery("#addOptionId").append('<option selected value="' + option.id + '">' + option.name + '</option>');
                        else
                            jQuery("#addOptionId").append('<option value="' + option.id + '">' + option.name + '</option>');
                    });
                }
            })

        }

        function changeOptionByProductUpdate() {
            let productId = jQuery("#updateProductId").val();
            jQuery.ajax({
                url: "/api/option/listByTypeProductId" + productId,
                type: "GET",
                success: function (data) {
                    jQuery("#updateOptionId").empty();
                    jQuery.map(data.data, (option, i) => {
                        jQuery("#updateOptionId").append('<option value="' + option.id + '">' + option.name + '</option>');
                    });
                }
            })

        }

        jQuery("#add-submit").on("click", function (e) {
            e.preventDefault();
            let valid = jQuery("#modal-add").valid();

            if (valid) {
                let data = new FormData(jQuery("#modal-add")[0]);
                $.ajax({
                    type: "POST",
                    url: `/api/product-option`,
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
                            jQuery("#product-option").trigger("reset");
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
                    url: `/api/product-option/` + id,
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
                            }).then(function () {
                                jQuery('#modal-update').modal('hide');
                                jQuery('#product-option').trigger("reset");
                            });
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
        jQuery("#modal-add").validate({
            rules: {
                addSku: {
                    required: true,
                    minlength: 1,
                    maxlength: 3
                },
                addName: {
                    required: true,
                    minlength: 3,
                    maxlength: 20
                },
                addType: {
                    required: true
                },
            },
            messages: {
                addSku: {
                    required: "Please enter sku",
                    minlength: "Sku must be at least 1 characters long",
                    maxlength: "Sku cannot be more than 3 characters long"
                },
                addName: {
                    required: "Please enter name",
                    minlength: "Name must be at least 3 characters long",
                    maxlength: "Name cannot be more than 20 characters long"
                },
                addType: {
                    required: "Please enter type"
                },
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


    </script>
    <script src="https://www.gstatic.com/firebasejs/7.7.0/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/7.7.0/firebase-storage.js"></script>


</div>
</body>
</html>
