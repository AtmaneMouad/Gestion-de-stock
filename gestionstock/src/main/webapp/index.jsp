<%@ page import="com.gestion.CategorieDAO" %>
<%@ page import="com.gestion.FournisseurDAO" %>
<%@ page import="com.gestion.ProductDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Check if the user is logged in by verifying the session attribute
    Boolean loggedIn = (Boolean) session.getAttribute("loggedIn");
    if (loggedIn == null || !loggedIn) {
        // Redirect back to the login page if not logged in
        response.sendRedirect("login.jsp");
    }
%>
<%
    // Fetch counts from the database
    CategorieDAO categorieDAO = new CategorieDAO();
    int categoryCount = categorieDAO.getCategoryCount();

    ProductDAO productDAO = new ProductDAO();
    int productCount = productDAO.getProductCount();

    FournisseurDAO fournisseurDAO = new FournisseurDAO();
    int fournisseurCount = fournisseurDAO.getFournisseurCount();
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
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
                        <a href="index.html" >
                            <span >
                            </span>

                        </a>

                        <!-- Logo Dark -->
                        <a href="index.html" >
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
            <a href="index.html" class="logo logo-light">
                <span class="logo-lg">
                    <h3 style="padding-top: 10px">Gestion de stock</h3>
                </span>
                <span class="logo-sm">
                   <h3>G_S</h3>
                </span>
            </a>

            <!-- Brand Logo Dark -->
            <a href="index.html" class="logo logo-dark">
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
                <div class="container-fluid" style="margin-top: 12px">




                    <!--  Dir code dyalek hna ozid dak chi li 3endek f head-->
                    <div class="container-fluid">


                        <div class="row">
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Category Count</h4>
                                        <p class="card-text"><%= categoryCount %></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Product Count</h4>
                                        <p class="card-text"><%= productCount %></p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Fournisseur Count</h4>
                                        <p class="card-text"><%= fournisseurCount %></p>
                                    </div>
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

    <!-- Vendor js -->
    <script src="assets/js/vendor.min.js"></script>

    <!-- App js -->
    <script src="assets/js/app.min.js"></script>

</body>

</html>