<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Color</title>
    <link rel="shortcut icon" type="image/png" href="../dist/img/admin.png">
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
<!-- Site wrapper -->
<div class="wrapper">
    <!-- Navbar -->
    <c:import url="layout/navigation.jsp"/>
    <!-- /.navbar -->

    <!-- Main Sidebar Container -->
    <c:import url="layout/sidebar.jsp"/>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <div class="container-fluid">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1>Type Product Page</h1>
                    </div>
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item"><a href="#">Home</a></li>
                            <li class="breadcrumb-item active">Color Page</li>
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
                            <!-- /.card-header -->
                            <div class="card-body">
                                <button class="btn btn-success float-left" type="button" data-toggle="modal"
                                        data-target="#modal-add">Add
                                </button>
                                <table id="color" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th>Id</th>
                                        <th>Sku</th>
                                        <th>Name</th>
                                        <th>Hex</th>
                                        <th></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <th>Id</th>
                                        <th>Sku</th>
                                        <th>Name</th>
                                        <th>Hex</th>
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
              method="POST"
              enctype="multipart/form-data"
              novalidate="novalidate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Add Color</h4>
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
                                        <label for="addSku">Sku</label>
                                        <input type="text" id="addSku"
                                               name="addSku"
                                               class="form-control"
                                               placeholder="Ex: BA, BU,..">
                                    </div>
                                    <div class="form-group">
                                        <label for="addName">Name</label>
                                        <input type="text"
                                               id="addName"
                                               name="addName"
                                               placeholder="Ex: Black, Blue,.."
                                               class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="addHex">Hex</label>
                                        <input type="text"
                                               id="addHex"
                                               name="addHex"
                                               placeholder="Ex: 111111, cc11cc,.."
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
                        <button type="submit" class="btn btn-primary" id="add-submit">Add</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </form>
        <form class="modal fade"
              id="modal-update"
              method="POST"
              enctype="multipart/form-data"
              novalidate="novalidate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Update Color</h4>
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
                                               placeholder="Ex: BA, BU,..">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateSku">Sku</label>
                                        <input type="text" id="updateSku"
                                               name="updateSku"
                                               class="form-control"
                                               placeholder="Ex: Black, Blue,..">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateName">Name</label>
                                        <input type="text"
                                               id="updateName"
                                               name="updateName"
                                               placeholder="Ex: IPHONE, IPAD,.."
                                               class="form-control">
                                    </div>
                                    <div class="form-group">
                                        <label for="updateHex">Hex</label>
                                        <input type="text"
                                               id="updateHex"
                                               name="updateHex"
                                               placeholder="Ex: 111111, cc11cc,.."
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
                        <button type="submit" class="btn btn-primary" id="update-submit">Update</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </form>
        <!-- /.modal -->
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <c:import url="layout/footer.jsp"/>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Control sidebar content goes here -->
    </aside>
    <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->

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
<!-- Validate jquery -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.4/jquery.validate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.4/additional-methods.min.js"></script>
<!-- Swal -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<script>
    jQuery(function () {
        let table = jQuery("#color").DataTable({
            "responsive": true, "lengthChange": false, "autoWidth": false,
            "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"],
            ajax: {
                url: `/api/color`,
                dataSrc: "data"
            },
            "columnDefs": [
                {
                    targets: 4,
                    width: 100,
                    orderable: false,
                    searchable: false,
                    render: function (data, type, row, meta) {
                        return '<div class="d-flex justify-content-around align-middle">' +
                            '<button type="button" onclick="getData(' + data + ')" class="btn-update btn btn-info btn-sm p-2" data-toggle="modal" data-target="#modal-update" ><i class="fas fa-edit"></i></button>' +
                            '<button type="button" onclick="deleteData(' + data + ')" class="btn-delete btn btn-danger btn-sm p-2"> <i class="fas fa-trash"></i></button>'
                            + '</div>';
                    }
                },
            ],
            initComplete: function () {
                table.buttons().container().appendTo('.col-md-6:eq(0)', table.table().container());
            },
            columns: [
                {data: "id"},
                {data: "sku"},
                {data: "name"},
                {data: "hex"},
                {data: "id"},
            ],
        });
    });

    function getData(id) {
        jQuery.ajax({
            url: `/api/color/` + id,
            type: 'GET',
            success: function (data) {
                reloadData();
                jQuery('#updateId').val(data.data.id);
                jQuery('#updateSku').val(data.data.sku);
                jQuery('#updateName').val(data.data.name);
                jQuery('#updateHex').val(data.data.hex);
            }
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
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                );

                jQuery.ajax({
                    url: `/api/color/` + id,
                    type: 'DELETE',
                    success: function (data) {
                        reloadData();
                    }
                });
            }
        })
    }

    jQuery("#add-submit").on("click", function (e) {
        e.preventDefault();
        let validate = jQuery("#modal-add").valid();
        if (validate) {
            let data = new FormData(jQuery("#modal-add")[0]);
            jQuery.ajax({
                url: "/api/color",
                type: "POST",
                data: data,
                processData: false,
                contentType: false,
                success: function (data) {
                    if (data.success) {
                        reloadData();
                        Swal.fire({
                            icon: 'success',
                            title: 'SUCCESS',
                            text: data.message,
                            showConfirmButton: false,
                            timer: 2000
                        })
                        jQuery("#color").trigger("reset");
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
                },
            });
        }
    });


    jQuery("#update-submit").on("click", function (e) {
        e.preventDefault();
        let validate = jQuery("#modal-update").valid();
        if (validate) {
            let data = new FormData(jQuery("#modal-update")[0]);
            let id = data.get("updateId");
            jQuery.ajax({
                url: "/api/color/" + id,
                type: "PUT",
                data: data,
                processData: false,
                contentType: false,
                success: function (data) {
                    if (data.success) {
                        reloadData();
                        Swal.fire({
                            icon: 'success',
                            title: 'SUCCESS',
                            text: data.message,
                            showConfirmButton: false,
                            timer: 2000
                        })
                        jQuery("#color").trigger("reset");
                        jQuery('#modal-update').modal('hide');
                    } else {
                        Swal.fire({
                            icon: 'error',
                            title: 'ERROR',
                            text: data.message,
                            showConfirmButton: false,
                            timer: 2000
                        })
                    }
                },
            });
        }
    })

    function setInputDefault(idName) {
        jQuery.map(jQuery("#modal-add").find("input"), (item, i) => {
            jQuery(item).val("");
        })

    }

    function reloadData() {
        jQuery('#color').DataTable().ajax.reload();
    }

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
                maxlength: 50
            },
            addHex: {
                required: true,
                minlength: 1,
                maxlength: 7
            }
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
                maxlength: "Name cannot be more than 50 characters long"
            },
            addHex: {
                required: "Please enter name",
                minlength: "Name must be at least 1 characters long",
                maxlength: "Name cannot be more than 7 characters long"
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

    });
    jQuery("#modal-update").validate({
        rules: {
            updateSku: {
                required: true,
                minlength: 1,
                maxlength: 3
            },
            updateName: {
                required: true,
                minlength: 3,
                maxlength: 50
            },
            updateHex: {
                required: true,
                minlength: 1,
                maxlength: 7
            },
        },
        messages: {
            updateSku: {
                required: "Please enter sku",
                minlength: "Sku must be at least 1 characters long",
                maxlength: "Sku cannot be more than 3 characters long"
            },
            updateName: {
                required: "Please enter name",
                minlength: "Name must be at least 3 characters long",
                maxlength: "Name cannot be more than 50 characters long"
            },
            updateHex: {
                required: "Please enter name",
                minlength: "Name must be at least 1 characters long",
                maxlength: "Name cannot be more than 7 characters long"
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

    });
</script>
</body>
</html>
