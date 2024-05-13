<%@ page import="com.gestion.Categorie" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Check if the user is logged in by verifying the session attribute
    Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
    if (loggedIn == null || !loggedIn) {
        // Redirect back to the login page if not logged in
        response.sendRedirect("login.jsp");
    }
%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Categorie List</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .editable-row:hover,
        .editing {
            background-color: #f0f0f0;
        }

        .edit-btn,
        .update-btn,
        .delete-btn {
            margin-right: 5px;
        }
    </style>
    <meta content="Coderthemes" name="author" />

    <!-- App favicon -->
    <link rel="shortcut icon" href="assets/images/favicon.ico">

    <!-- Theme Config Js -->
    <script src="assets/js/config.js"></script>

    <!-- App css -->
    <link href="assets/css/app.min.css" rel="stylesheet" type="text/css" id="app-style" />

    <!-- Icons css -->
    <link href="assets/css/icons.min.css" rel="stylesheet" type="text/css" />
</head>

<body>
<!-- Begin page -->
<div class="wrapper">

    <!-- ========== Topbar Start ========== -->
    <div class="navbar-custom">
        <div class="topbar container-fluid">
            <div class="d-flex align-items-center gap-lg-2 gap-1">

                <!-- Topbar Brand Logo -->
                <div class="logo-topbar">
                    <!-- Logo light -->
                    <a href="index.jsp" >
                            <span >
                            </span>

                    </a>

                    <!-- Logo Dark -->
                    <a href="index.jsp" >
                            <span >

                            </span>

                    </a>
                </div>

                <!-- Sidebar Menu Toggle Button -->
                <button class="button-toggle-menu">
                    <i class="ri-menu-2-fill"></i>
                </button>
            </div>

            <ul class="topbar-menu d-flex align-items-center gap-3">

                <li class="d-none d-sm-inline-block">
                    <div class="nav-link" id="light-dark-mode">
                        <i class="ri-moon-line fs-22"></i>
                    </div>
                </li>

                <li class="nav-link"><span class="badge bg-success fs-16">v1.0</span></li>
            </ul>
        </div>
    </div>
    <!-- ========== Topbar End ========== -->

    <!-- ========== Left Sidebar Start ========== -->
    <div class="leftside-menu">

        <!-- Brand Logo Light -->
        <a href="index.jsp" class="logo logo-light">
                <span class="logo-lg">
                    <h3>Gestion de stock</h3>
                </span>
            <span class="logo-sm">
                   <h3>G_S</h3>
                </span>
        </a>

        <!-- Brand Logo Dark -->
        <a href="index.jsp" class="logo logo-dark">
                <span class="logo-lg">
                    <img src="assets/images/logo-dark.png" alt="dark logo">
                </span>
            <span class="logo-sm">
                    <img src="assets/images/logo-sm.png" alt="small logo">
                </span>
        </a>

        <!-- Sidebar Hover Menu Toggle Button -->
        <div class="button-sm-hover" data-bs-toggle="tooltip" data-bs-placement="right" title="Show Full Sidebar">
            <i class="ri-checkbox-blank-circle-line align-middle"></i>
        </div>

        <!-- Full Sidebar Menu Close Button -->
        <div class="button-close-fullsidebar">
            <i class="ri-close-fill align-middle"></i>
        </div>

        <!-- Sidebar -left -->
        <div class="h-100" id="leftside-menu-container" data-simplebar>
            <!-- Leftbar User -->
            <div class="leftbar-user">
                <a href="pages-profile.html">
                    <img src="assets/images/users/avatar-1.jpg" alt="user-image" height="42" class="rounded-circle shadow-sm">
                    <span class="leftbar-user-name mt-2">Tosha Minner</span>
                </a>
            </div>

            <!--- Sidemenu -->
            <ul class="side-nav">
                <li class="side-nav-title">Getting Started</li>

                <li class="side-nav-item">
                    <a href="FournisseurServlet" class="side-nav-link">
                        <i class="ri-honour-line"></i>
                        <span> Fournisseur </span>
                    </a>
                </li>

                <li class="side-nav-item">
                    <a href="ProductServlet" class="side-nav-link">
                        <i class="ri-tools-fill"></i>
                        <span> Product </span>
                    </a>
                </li>

                <li class="side-nav-item">
                    <a href="CategorieServlet" class="side-nav-link">
                        <i class="ri-tools-fill"></i>
                        <span> Categorie </span>
                    </a>
                </li>

                <!-- Add Logout Link -->
                <li class="side-nav-item">
                    <a href="LogoutServlet" class="side-nav-link">
                        <i class="ri-logout-box-line"></i>
                        <span> Logout </span>
                    </a>
                </li>
            </ul>

            <!--- End Sidemenu -->

            <div class="help-box text-white text-center d-none">
                <a href="javascript: void(0);" class="float-end close-btn text-white">
                    <i class="mdi mdi-close"></i>
                </a>
                <img src="assets/images/svg/help-icon.svg" height="90" alt="Helper Icon Image">
                <h5 class="mt-3">Unlimited Access</h5>
                <p class="mb-3">Upgrade to plan to get access to unlimited reports</p>
                <a href="javascript: void(0);" class="btn btn-secondary btn-sm">Buy Now</a>
            </div>

            <div class="clearfix"></div>
        </div>
    </div>
    <!-- ========== Left Sidebar End ========== -->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">




                <!--  Dir code dyalek hna ozid dak chi li 3endek f head-->

                <div class="container mt-4">
                    <div class="row">
                        <div class="col">
                            <h1>Gestion de Stock</h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <h2 class="mb-4">Categorie List</h2>
                            <%
                                List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");

                                if (categories != null && !categories.isEmpty()) {
                                    System.out.println("Number of categories: " + categories.size());
                            %>
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Libelle</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>
                                <%
                                    for (int i = 0; i < categories.size(); i++) {
                                        Categorie categorie = categories.get(i);
                                        String rowClass = "editable-row";
                                %>
                                <tr class="<%= rowClass %>" id="row_<%= i %>">
                                    <td><%= categorie.getId() %></td>
                                    <td contenteditable="false" id="libelle_<%= i %>"><%= categorie.getLibelle() %></td>
                                    <td>
                                        <button type="button" class="btn btn-primary btn-sm edit-btn"
                                                onclick="enableEditing('<%= i %>')">Edit</button>
                                        <button type="button" class="btn btn-warning btn-sm update-btn"
                                                onclick="updateCategorie('<%= categorie.getId() %>', '<%= i %>')">Update</button>
                                        <button type="button" class="btn btn-danger btn-sm delete-btn"
                                                onclick="deleteCategorie('<%= categorie.getId() %>')">Delete</button>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </table>
                            <%
                                } else {
                                    System.out.println("No categories available.");
                                }
                            %>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col">
                            <h2 class="mt-4">Add Categorie</h2>
                            <form action="CategorieServlet" method="post">
                                <div class="mb-3">
                                    <label for="libelle">Libelle:</label>
                                    <input type="text" name="libelle" class="form-control" required>
                                </div>
                                <input type="hidden" name="action" value="add">
                                <button type="submit" class="btn btn-success">Add Categorie</button>
                            </form>
                        </div>
                    </div>
                </div>






            </div>
            </footer>
            <!-- end Footer -->

        </div>

        <!-- ============================================================== -->
        <!-- End Page content -->
        <!-- ============================================================== -->

    </div>
    <!-- END wrapper -->
    <script>
        function enableEditing(index) {
            document.getElementById("libelle_" + index).contentEditable = "true";
            document.getElementById("row_" + index).classList.add("editing");
        }

        function updateCategorie(id, index) {
            var libelle = document.getElementById("libelle_" + index).innerText;

            var form = document.createElement("form");
            form.setAttribute("method", "post");
            form.setAttribute("action", "CategorieServlet");

            var idInput = document.createElement("input");
            idInput.setAttribute("type", "hidden");
            idInput.setAttribute("name", "id");
            idInput.setAttribute("value", id);

            var libelleInput = document.createElement("input");
            libelleInput.setAttribute("type", "hidden");
            libelleInput.setAttribute("name", "libelle");
            libelleInput.setAttribute("value", libelle);

            var actionInput = document.createElement("input");
            actionInput.setAttribute("type", "hidden");
            actionInput.setAttribute("name", "action");
            actionInput.setAttribute("value", "update");

            form.appendChild(idInput);
            form.appendChild(libelleInput);
            form.appendChild(actionInput);

            document.body.appendChild(form);
            form.submit();
        }

        function deleteCategorie(id) {
            if (confirm("Are you sure you want to delete this categorie?")) {
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "CategorieServlet");

                var idInput = document.createElement("input");
                idInput.setAttribute("type", "hidden");
                idInput.setAttribute("name", "id");
                idInput.setAttribute("value", id);

                var actionInput = document.createElement("input");
                actionInput.setAttribute("type", "hidden");
                actionInput.setAttribute("name", "action");
                actionInput.setAttribute("value", "delete");

                form.appendChild(idInput);
                form.appendChild(actionInput);

                document.body.appendChild(form);
                form.submit();
            }
        }
    </script>

    <!-- Vendor js -->
    <script src="assets/js/vendor.min.js"></script>

    <!-- App js -->
    <script src="assets/js/app.min.js"></script>
    <!-- Bootstrap JS and Popper.js -->

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>


</body>

</html>
