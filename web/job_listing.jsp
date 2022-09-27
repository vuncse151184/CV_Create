<%-- Document : about Created on : Jun 18, 2022, 7:03:42 PM Author : tungn --%>

<%@page import="com.studentCV.utils.Utils"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.studentCV.DTO.JobDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html class="no-js" lang="zxx">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Job Lists</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <link rel="stylesheet" href="Doc/css/font-awesome.min.css">

        <!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/price_rangs.css">
        <link rel="stylesheet" href="assets/css/flaticon.css">
        <link rel="stylesheet" href="assets/css/slicknav.css">
        <link rel="stylesheet" href="assets/css/animate.min.css">
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">
        <link rel="stylesheet" href="assets/css/slick.css">
        <link rel="stylesheet" href="assets/css/nice-select.css">
        <link rel="stylesheet" href="assets/css/style.css">
    </head>

    <body>
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

                                <a href="index.jsp" i class="fa fa-home"
                                   style="font-size:30px; color: #fb246a;"></a>
                            </div>
                            <div class="col-lg-9 col-md-9">
                                <div class="menu-wrapper">
                                    <!-- Main-menu -->
                                    <div class="main-menu">
                                        <nav class="d-none d-lg-block">
                                            <ul id="navigation">
                                                <li><a href="index.jsp">Home</a></li>
                                                <li>
                                                    <c:url var="jobListingAll" value="MainController">
                                                        <c:param name="btnAction" value="Find Job"/>
                                                        <c:param name="searchJobValue" value=""/>
                                                        <c:param name="selectJob" value=""/>
                                                    </c:url>
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
        <main>

            <!-- Hero Area Start-->
            <div class="slider-area ">
                <div class="single-slider section-overly slider-height2 d-flex align-items-center"
                     data-background="assets/img/hero/about.jpg">
                    <div class="container">
                        <div class="row">
                            <div class="col-xl-12">
                                <div class="hero-cap">
                                    <h2>Get your job</h2>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-8">
                                <form action="MainController" class="search-box">
                                    <div class="input-form">
                                        <input type="text" name="searchJobValue" value="${param.searchJobValue}"
                                                placeholder="Job Title">
                                    </div>
                                    <div class="select-form">
                                        <select name="selectJob" id="select1">
                                            <option>Full Time</option>
                                            <option>Part Time</option>
                                            <option>All</option>
                                        </select>
                                    </div>
                                    <div class="search-form">
                                        <input type="submit" name="btnAction" value="Find Job" />
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Hero Area End -->
            <!-- Job List Area Start -->
            <div class="job-listing-area pt-120 pb-120">
                <div class="container">
                    <div class="row">
                        <!-- Left content -->
                        <div class="col-xl-3 col-lg-3 col-md-4">
                            <div class="row">
                                <div class="col-12">
                                    <div class="small-section-tittle2 mb-45">
                                        <div class="ion"> <svg xmlns="http://www.w3.org/2000/svg"
                                                               xmlns:xlink="http://www.w3.org/1999/xlink" width="20px"
                                                               height="12px">
                                            <path fill-rule="evenodd" fill="rgb(27, 207, 107)"
                                                  d="M7.778,12.000 L12.222,12.000 L12.222,10.000 L7.778,10.000 L7.778,12.000 ZM-0.000,-0.000 L-0.000,2.000 L20.000,2.000 L20.000,-0.000 L-0.000,-0.000 ZM3.333,7.000 L16.667,7.000 L16.667,5.000 L3.333,5.000 L3.333,7.000 Z" />
                                            </svg>
                                        </div>
                                        <h4>Filter Jobs</h4>
                                    </div>
                                </div>
                            </div>
                            <!-- Job Category Listing start -->
                            <form action="#" method="POST">
                                <div class="job-category-listing mb-50">
                                    <!-- single one -->
                                    <div class="single-listing">
                                        <div class="small-section-tittle2">
                                            <h4>Job Category</h4>
                                        </div>
                                        <!-- Select job items start -->
                                        <div class="select-job-items2">
                                            <select name="selectJob" id="select2">
                                                <option>All Category</option>
                                                <option>Java</option>
                                                <option>JavaScript</option>
                                                <option>React JS</option>
                                                <option>PHP</option>
                                            </select>
                                        </div>
                                        <!--  Select job items End-->
                                        <!-- select-Categories start -->
                                        <div class="select-Categories pt-80 pb-50">
                                            <div class="small-section-tittle2">
                                                <h4>Job Type</h4>
                                            </div>
                                            <label for="filterJobType_FullTime" class="container">Full Time
                                                <input type="checkbox" id="filterJobType_FullTime" name="filterJobType_FullTime" value="Full Time">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label for="filterJobType_PartTime" class="container">Part Time
                                                <input type="checkbox"  id="filterJobType_PartTime" name="filterJobType_PartTime" value="Part Time">
                                                <span class="checkmark"></span>
                                            </label>

                                        </div>
                                        <!-- select-Categories End -->
                                    </div>
                                    <!-- single two -->
                                    <div class="single-listing">
                                        <div class="small-section-tittle2">
                                            <h4>Job Location</h4>
                                        </div>
                                        <!-- Select job items start -->
                                        <div class="select-job-items2">
                                            <select name="selectLoc">
                                                <option>Anywhere</option>
                                                <option>Hồ Chí Minh</option>
                                                <option>Hà Nội</option>
                                                <option>Đà Nẵng</option>
                                                <option>Hải Phòng</option>
                                            </select>
                                        </div>
                                        <!--  Select job items End-->
                                        <!-- select-Categories start -->
                                        <div class="select-Categories pt-80 pb-50">
                                            <div class="small-section-tittle2">
                                                <h4>Experience</h4>
                                            </div>
                                            <label class="container">1-2 Years
                                                <input type="checkbox">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="container">2-3 Years
                                                <input type="checkbox" checked="checked active">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="container">3-6 Years
                                                <input type="checkbox">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="container">6-more..
                                                <input type="checkbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                        <!-- select-Categories End -->
                                    </div>
                                    <!-- single three -->
                                    <div class="single-listing">
                                        <!-- select-Categories start -->
                                        <div class="select-Categories pb-50">
                                            <div class="small-section-tittle2">
                                                <h4>Posted Within</h4>
                                            </div>
                                            <label class="container">All time
                                                <input type="checkbox">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="container">Today
                                                <input type="checkbox" checked="checked active">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="container">Last 2 days
                                                <input type="checkbox">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="container">Last 3 days
                                                <input type="checkbox">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="container">Last 5 days
                                                <input type="checkbox">
                                                <span class="checkmark"></span>
                                            </label>
                                            <label class="container">Last 10 days
                                                <input type="checkbox">
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                        <!-- select-Categories End -->
                                    </div>
                                </div>
                            </form>

                            <!-- Job Category Listing End -->
                        </div>
                        <%
                            ArrayList<JobDTO> jobList = (ArrayList<JobDTO>) request.getAttribute("SEARCHRESULT");
                        %>
                        <!-- Right content -->
                        <div class="col-xl-9 col-lg-9 col-md-8">
                            <!-- Featured_job_start -->
                            <section class="featured-job-area">
                                <div class="container">
                                    <!-- Count of Job list Start -->
                                    <div class="row">
                                        <div class="col-lg-12">
                                            <div class="count-job mb-35">
                                                <% if (jobList != null) {%>
                                                <span><%=jobList.size()%> Jobs found</span> <!-- JOBCOUNT -->
                                                <%    } else if (jobList == null) { %>
                                                <span> No Jobs found</span> <!-- JOBCOUNT -->
                                                <% }
                                                %>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Count of Job list End -->
                                    <%
                                        if (jobList != null) {
                                            for (JobDTO job : jobList) {
                                            String formattedString = String.format("%.02f", job.getSalary());
                                    %>
                                    <!-- single-job-content -->
                                    <div class="single-job-items mb-30">
                                        <div class="job-items">
                                            <c:url var="jobDetails" value="MainController">
                                                <c:param name="btnAction" value="Show Job"/>
                                                <c:param name="jobId" value="<%=Integer.toString(job.getJobId())%>"/>
                                            </c:url>
                                            <div class="company-img">
                                                <a href="${jobDetails}"><img src="<%=job.getCompany().getImg() %>" alt=""></a>
                                            </div>
                                            <div class="job-title job-title2">
                                                <a href="${jobDetails}">
                                                    <h4><%=job.getJobName()%></h4>
                                                </a>
                                                <ul>
                                                    <li><%=job.getCompany().getCompanyName()%></li>
                                                    <li><i class="fas fa-map-marker-alt"></i><%=job.getJobLocation()%></li>
                                                    <li><%=formattedString%> VND/month</li>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="items-link items-link2 f-right">
                                            <a href="${jobDetails}"><%=job.getJobType()%></a>
                                            <%
                                                Utils utils = new Utils();
                                                if (utils.countDate(job.getJobPostDate()) > 0) {%>
                                            <span><%=utils.countDate(job.getJobPostDate())%> days to expired</span>
                                            <% } else { %>
                                            <span>Job was expired</span>    
                                            <% }
                                            %>
                                        </div>
                                    </div>
                                    <%                                            }
                                        }
                                    %>
                                </div>
                            </section>
                            <!-- Featured_job_end -->
                        </div>
                    </div>
                </div>
            </div>
            <!-- Job List Area End -->
            <!-- Pagination Start  -->
            <!-- <div class="pagination-area pb-115 text-center">
        <div class="container">
            <div class="row">
                <div class="col-xl-12">
                    <div class="single-wrap d-flex justify-content-center">
                        <nav aria-label="Page navigation example">
                            <ul class="pagination justify-content-start">
                                <li class="page-item active"><a class="page-link" href="job_listing.jsp">01</a></li>
                                <li class="page-item"><a class="page-link" href="job_listing2.jsp">02</a></li>
                                <li class="page-item"><a class="page-link" href="#">03</a></li>
                            <li class="page-item"><a class="page-link" href="#"><span class="ti-angle-right"></span></a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </div> -->
            <!--Pagination End  -->

        </main>
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
                                            <p>The webpage created by FPT University students to help students
                                                to create your CV and find jobs.</p>
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
                                            <p>Address: FPT University, District 9, HCMC</p>
                                        </li>
                                        <li><a href="#">Phone : +12345678</a></li>
                                        <li><a href="#">Email : huynmse161323@fpt.edu.vn</li>
                                    </ul>
                                </div>

                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-5">
                            <div class="single-footer-caption mb-50">
                                <div class="footer-tittle">
                                    <h4>Important Link</h4>
                                    <ul>
                                        <li><a href="index.jsp">Home</a></li>
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
                                    <p>
                                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                        Copyright &copy;
                                        <script>document.write(new Date().getFullYear());</script> All rights
                                        reserved | This template is made with <i class="fa fa-heart"
                                                                                 aria-hidden="true"></i> by <a
                                                                                 href="https://www.facebook.com/Student-CV-Jobs-Upload-Resume-102969615781584"
                                                                                 target="_blank">StudentCV Team</a>
                                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                                    </p>
                                </div>
                            </div>
                            <div class="col-xl-2 col-lg-2">
                                <div class="footer-social f-right">
                                    <a
                                        href="https://www.facebook.com/Student-CV-Jobs-Upload-Resume-102969615781584"><i
                                            class="fab fa-facebook-f"></i></a>
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