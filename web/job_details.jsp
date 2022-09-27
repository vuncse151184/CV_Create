<%-- 
    Document   : about
    Created on : Jun 18, 2022, 7:03:42 PM
    Author     : tungn
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" /><!doctype html>
<c:set var="jobDetails" value="${requestScope.DETAILS_RESULT}"/>
<!--If job details existed-->
<c:if test="${not empty jobDetails}">
    <c:set var="companyDetails" value="${jobDetails.company}"/>
</c:if>

<html class="no-js" lang="zxx">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <c:if test="${not empty jobDetails}">
            <title>${companyDetails.companyName} đang tuyển dụng ${jobDetails.jobName}</title>
        </c:if>
        <c:if test="${empty jobDetails}">
            <title>Job Error</title>
        </c:if>
        
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
        <link rel="stylesheet" href="Doc/css/font-awesome.min.css">

        <!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/slicknav.css">
        <link rel="stylesheet" href="assets/css/price_rangs.css">
        <link rel="stylesheet" href="assets/css/animate.min.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/slick.css">
        <link rel="stylesheet" href="assets/css/nice-select.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
    </head>

    <body>
        <!--Variables-->
        <c:url var="jobListingAll" value="MainController">
            <c:param name="btnAction" value="Find Job"/>
            <c:param name="searchJobValue" value=""/>
            <c:param name="selectJob" value=""/>
        </c:url>


        <!-- Preloader Start -->
        <div id="preloader-active">
            <div class="preloader d-flex align-items-center justify-content-center">
                <div class="preloader-inner position-relative">
                    <div class="preloader-circle"></div>
                    <div class="preloader-img pere-text">
                        <img src="assets/img/logo/logo1.png" alt="">
                    </div>
                </div>
            </div>
        </div>
        <!-- Preloader Start -->
        <header>
            <!-- Header Start -->
            <div class="header-area header-transparrent">
                <div class="headder-top header-sticky">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-lg-3 col-md-2">
                                <!-- Logo -->
                                <!-- <div class="logo">
                                    <a href="index.jsp"><img src="assets/img/logo/logo.png" alt=""></a>
                                </div>   -->
                                <a href="index.jsp" i class="fa fa-home" style="font-size:30px; color: #fb246a;"></a>
                            </div>
                            <div class="col-lg-9 col-md-9">
                                <div class="menu-wrapper">
                                    <!-- Main-menu -->
                                    <div class="main-menu">
                                        <nav class="d-none d-lg-block">
                                            <ul id="navigation">
                                                <li><a href="index.jsp">Home</a></li>
                                                <li>
                                                    <a href="${jobListingAll}">Find Jobs </a>
                                                </li>
                                                <!-- <li><a href="about.jsp">About</a></li> -->
                                                <li><a href="#">Page</a>
                                                    <ul class="submenu">
                                                        <li><a href="blog.jsp">Blog</a></li>
                                                        <li><a href="single-blog.jsp">Blog Details</a></li>

                                                    </ul>
                                                </li>
                                                <li><a href="contact.jsp">Contact us</a></li>
                                            </ul>
                                        </nav>
                                    </div>          
                                    <!-- Header-btn -->
                                    <c:set var="account" value="${sessionScope.USER}"/>
                                    <%--not empty means there is an account, check for admin role --%>
                                    <c:if test="${not empty account}">
                                        Welcome, ${account.email}        
                                        <c:url var="logoutAccount" value="MainController">
                                            <c:param name="btnAction" value="Logout"/>
                                        </c:url>
                                        <a href="${logoutAccount}" class="btn head-btn2">Logout</a>
                                    </c:if>
                                    
                                    <%--Guest section --%>        
                                    <c:if test="${empty account}">
                                        <div class="header-btn d-none f-right d-lg-block">
                                            <a  style="color: black" class="btn w-100 btn-lg btn-outline-dark"
                                                href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/StudentCV/LoginGoogleController&response_type=code&client_id=367863869149-p52rvo311i3dh3oolbjcimig62rh97af.apps.googleusercontent.com&approval_prompt=force">
                                                Login With Google                                               
                                            </a>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <!-- Mobile Menu -->
                            <div class="col-12">
                                <div class="mobile_menu d-block d-lg-none"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header End -->
        </header>
        <!-- ================ contact section start ================= -->
        <section class="contact-section">
            <div class="container">
                <!--If job details existed-->
                <c:if test="${not empty jobDetails}">
                    <div class="row">
                        <div class="col-12">
                            <h2 class="contact-title">${jobDetails.jobName}</h2>
                        </div>
                        <div class="col-lg-8">
                            <h3>Job Overview</h3>
                            <div class="col-sm-10">
                                <jsp:useBean id="String" class="java.lang.String" />
                                <p>Job Type: ${jobDetails.jobType}</p>
                                <p>Job Salary ${String.format("%.02f", jobDetails.salary)} VND / Month</p> 
                                <p>Experience: ${jobDetails.jobExperience} years</p> 
                                <p>Working location: <br/>
                                    ${jobDetails.jobLocation}
                                </p>
                                <c:set var="days" value="${requestScope.days_until}"/>
                                <c:if test="${days ge 0}">
                                    <p>${days} days left until closed</p>
                                </c:if>
                                <c:if test="${days lt 0}">
                                    <p>This job offer had closed</p>
                                </c:if>
                            </div>
                            <h3>Job Requirements</h3>
                            <div class="col-sm-10"><p>${jobDetails.jobReq}</p></div>

                            <h3>Description</h3>
                            <div class="col-sm-10"><p>${jobDetails.jobDescription}</p></div>
                            

                        </div>
    
                        <div class="col-lg-3 offset-lg-1">
                            <!--This part for contact info-->
                            <h3>${companyDetails.companyName}</h3> <br />
                            <div class="media contact-info">
                                <span class="contact-info__icon"><i class="ti-home"></i></span>
                                <div class="media-body">
                                    <h3>Headquarter</h3>
                                    <p>${companyDetails.addr}</p>
                                </div>
                            </div>
                            <div class="media contact-info">
                                <span class="contact-info__icon"><i class="ti-tablet"></i></span>
                                <div class="media-body">
                                    <h3>Phone number</h3>
                                    <p>(+84)${companyDetails.phoneNumber}</p>
                                </div>
                            </div>
                            <div class="media contact-info">
                                <span class="contact-info__icon"><i class="ti-email"></i></span>
                                <div class="media-body">
                                    <h3>${companyDetails.email}</h3>
                                </div>
                            </div>
                        </div>
                        <!--End job info-->
                    </div>
                </c:if>


                <c:if test="${empty jobDetails}">
                    <div class="row">
                        <div class="col-12">
                            <p>There is not such job, please try again or go back to job listing page at 
                                <a href="${jobListingAll}" style="color:blue">here</a>
                            </p>
                        </div>
                    </div>
                </c:if>
            </div>
        </section>
        <!-- ================ contact section end ================= -->
        <footer>
            <!-- Footer Start-->
            <div class="footer-area footer-bg footer-padding">
                <div class="container">
                    <div class="row d-flex justify-content-between">
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <div class="single-footer-caption mb-50">
                                <div class="single-footer-caption mb-30">
                                    <div class="footer-tittle">
                                        <h4>About Us</h4>
                                        <div class="footer-pera">
                                            <p>The webpage created by FPT University students to help students to create your CV and find jobs.</p>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-5">
                            <div class="single-footer-caption mb-50">
                                <div class="footer-tittle">
                                    <h4>Contact Info</h4>
                                    <ul>
                                        <li>
                                            <p> FPT University HCMC <br /> 
                                                Address: <br />
                                                Lô E2a-7, Đường D1, Khu Công nghệ cao, P.Long Thạnh Mỹ, Tp. Thủ Đức, TP.HCM.
                                            </p>
                                        </li>
                                        <li><a href="#">Phone : (028) 7300 5588</a></li>
                                        <li><a href="mailto:daihoc.hcm@fpt.edu.vn">Email : daihoc.hcm@fpt.edu.vn</li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-5">
                            <div class="single-footer-caption mb-50">
                                <div class="footer-tittle">
                                    <h4>Important Link</h4>
                                    <ul>
                                        <li><a href='view/index.jsp'>Home</a></li>
                                        <li><a href="#">Contact Us</a></li>
                                        <li><a href="#">Support</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!--  -->
                    <div class="row footer-wejed justify-content-between">
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <!-- logo -->
                            <!-- <div class="footer-logo mb-20">
                            <a href="index.jsp"><img src="assets/img/logo/logo2_footer.png" alt=""></a>
                            </div> -->
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-5">
                            <div class="footer-tittle-bottom">
                                <span>5000+</span>
                                <p>Jobs updated regularly</p>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-5">
                            <div class="footer-tittle-bottom">
                                <span>451</span>
                                <p>CV uploaded</p>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-5">
                            <!-- Footer Bottom Tittle -->
                            <div class="footer-tittle-bottom">
                                <span>668</span>
                                <p>Jobs found</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- footer-bottom area -->
            <div class="footer-bottom-area footer-bg">
                <div class="container">
                    <div class="footer-border">
                        <div class="row d-flex justify-content-between align-items-center">
                            <div class="col-xl-10 col-lg-10 ">
                                <div class="footer-copy-right">
                                    <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://www.facebook.com/Student-CV-Jobs-Upload-Resume-102969615781584" target="_blank">StudentCV Team</a>
                                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                                </div>
                            </div>
                            <div class="col-xl-2 col-lg-2">
                                <div class="footer-social f-right">
                                    <a href="https://www.facebook.com/Student-CV-Jobs-Upload-Resume-102969615781584"><i class="fab fa-facebook-f"></i></a>
                                    <a href="#"><i class="fab fa-twitter"></i></a>
                                    <a href="#"><i class="fas fa-globe"></i></a>
                                    <a href="#"><i class="fab fa-behance"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Footer End-->
        </footer>

        <!-- JS here -->

        <!-- All JS Custom Plugins Link Here here -->
        <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>
        <!-- Jquery, Popper, Bootstrap -->
        <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="./assets/js/popper.min.js"></script>
        <script src="./assets/js/bootstrap.min.js"></script>
        <!-- Jquery Mobile Menu -->
        <script src="./assets/js/jquery.slicknav.min.js"></script>

        <!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="./assets/js/owl.carousel.min.js"></script>
        <script src="./assets/js/slick.min.js"></script>
        <script src="./assets/js/price_rangs.js"></script>

        <!-- One Page, Animated-HeadLin -->
        <script src="./assets/js/wow.min.js"></script>
        <script src="./assets/js/animated.headline.js"></script>
        <script src="./assets/js/jquery.magnific-popup.js"></script>

        <!-- Scrollup, nice-select, sticky -->
        <script src="./assets/js/jquery.scrollUp.min.js"></script>
        <script src="./assets/js/jquery.nice-select.min.js"></script>
        <script src="./assets/js/jquery.sticky.js"></script>

        <!-- contact js -->
        <script src="./assets/js/contact.js"></script>
        <script src="./assets/js/jquery.form.js"></script>
        <script src="./assets/js/jquery.validate.min.js"></script>
        <script src="./assets/js/mail-script.js"></script>
        <script src="./assets/js/jquery.ajaxchimp.min.js"></script>

        <!-- Jquery Plugins, main Jquery -->	
        <script src="./assets/js/plugins.js"></script>
        <script src="./assets/js/main.js"></script>

    </body>
</html>