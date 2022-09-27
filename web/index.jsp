<%-- 
Document   : about
Created on : Jun 18, 2022, 7:03:42 PM
Author     : tungn
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Student CV [Find & Upload]</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">


        <link rel="stylesheet" href="Doc/css/font-awesome.min.css">


        <!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/flaticon.css">
        <link rel="stylesheet" href="assets/css/price_rangs.css">
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
                                <!-- <a href="index.jsp"><i class="fa fa-home fa-fw"></i> Home</a> -->

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
                                                    <c:url var="jobListingAll" value="MainController">
                                                        <c:param name="btnAction" value="Find Job"/>
                                                        <c:param name="searchJobValue" value=""/>
                                                        <c:param name="selectJob" value=""/>
                                                    </c:url>
                                                    <a href="${jobListingAll}">Find Jobs </a>
                                                </li>
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

            <!-- slider Area Start-->
            <div class="slider-area ">
                <!-- Mobile Menu -->
                <div class="slider-active">
                    <div class="single-slider slider-height d-flex align-items-center" data-background="assets/img/hero/imghuy.jpg">
                        <div class="container">
                            <div class="row">
                                <div class="col-xl-6 col-lg-9 col-md-10">
                                    <div class="hero__caption">
                                        <h1 class="">Upload your resume now</h1>
                                    </div>
                                </div>
                            </div>
                            <!-- Search Box -->
                            <div class="row">
                                <div class="col-xl-8">
                                    <!-- form -->
                                    <form action="MainController" class="search-box">
                                        <div class="input-form">
                                            <input type="text" name="searchJobValue"placeholder="Job Title">
                                        </div>
                                        <div class="select-form">
                                            <select name="selectJob">
                                                <option>Full Time</option>
                                                <option>Part Time</option>
                                            </select>
                                        </div>
                                        <div class="search-form">
                                            <input type="submit" name="btnAction" value="Find Job"/>
                                        </div>
                                    </form>	
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- slider Area End-->
            <!-- Our Services Start -->
            <div class="our-services section-pad-t30">
                <div class="container">
                    <!-- Section Tittle -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section-tittle text-center">
                                <span>Jobs need to be offered!</span>
                                <h2>Browse Top Categories </h2>
                            </div>
                        </div>
                    </div>
                    <div class="row d-flex justify-contnet-center">
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <div class="single-services text-center mb-30">
                                <div class="services-ion">
                                    <span class="flaticon-tour"></span>
                                </div>
                                <div class="services-cap">
                                    <h5><a href="job_listing.jsp">Java positions</a></h5>
                                    <span>(653)</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <div class="single-services text-center mb-30">
                                <div class="services-ion">
                                    <span class="flaticon-cms"></span>
                                </div>
                                <div class="services-cap">
                                    <h5><a href="job_listing.jsp">JavaScript positions</a></h5>
                                    <span>(658)</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <div class="single-services text-center mb-30">
                                <div class="services-ion">
                                    <span class="flaticon-report"></span>
                                </div>
                                <div class="services-cap">
                                    <h5><a href="job_listing.jsp">PHP positions</a></h5>
                                    <span>(658)</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <div class="single-services text-center mb-30">
                                <div class="services-ion">
                                    <span class="flaticon-app"></span>
                                </div>
                                <div class="services-cap">
                                    <h5><a href="job_listing.jsp">React JS positions</a></h5>
                                    <span>(658)</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <div class="single-services text-center mb-30">
                                <div class="services-ion">
                                    <span class="flaticon-helmet"></span>
                                </div>
                                <div class="services-cap">
                                    <h5><a href="job_listing.jsp">Python positions</a></h5>
                                    <span>(658)</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <div class="single-services text-center mb-30">
                                <div class="services-ion">
                                    <span class="flaticon-high-tech"></span>
                                </div>
                                <div class="services-cap">
                                    <h5><a href="job_listing.jsp">FullStack positions</a></h5>
                                    <span>(658)</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <div class="single-services text-center mb-30">
                                <div class="services-ion">
                                    <span class="flaticon-real-estate"></span>
                                </div>
                                <div class="services-cap">
                                    <h5><a href="job_listing.jsp">iOS developers positions</a></h5>
                                    <span>(658)</span>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
                            <div class="single-services text-center mb-30">
                                <div class="services-ion">
                                    <span class="flaticon-content"></span>
                                </div>
                                <div class="services-cap">
                                    <h5><a href="job_listing.jsp">Android developers positions</a></h5>
                                    <span>(658)</span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- More Btn -->
                    <!-- Section Button -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="browse-btn2 text-center mt-50">
                                <a href="job_listing.jsp" class="border-btn2">Browse All Available Jobs</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Our Services End -->
            <!-- Online CV Area Start -->
            <div class="online-cv cv-bg section-overly pt-90 pb-120"  data-background="${contextPath}/assets/img/gallery/imghuy2.jpg">
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-xl-10">
                            <div class="cv-caption text-center">
                                <p class="pera1">Create a free CV</p>
                                <p class="pera2"> Make a Difference with Your Online Resume!</p>
                                <a href="signin.jsp" class="border-btn2 border-btn4">Upload your CV</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Online CV Area End-->
            <!-- Featured_job_start -->
            <section class="featured-job-area feature-padding">
                <div class="container">
                    <!-- Section Tittle -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section-tittle text-center">
                                <span>Recent Job</span>
                                <h2>Featured Jobs</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row justify-content-center">
                        <div class="col-xl-10">
                            <!-- single-job-content -->
                            <div class="single-job-items mb-30">
                                <div class="job-items">
                                    <div class="company-img">
                                        <a href="job_details.jsp"><img src="assets/img/icon/job-list1.png" alt=""></a>
                                    </div>
                                    <div class="job-title">
                                        <a href="job_details.jsp"><h4>Java intern</h4></a>
                                        <ul>
                                            <li>FPT Software</li>
                                            <li><i class="fas fa-map-marker-alt"></i>Danang, Vietnam</li>
                                            <li>5.000.000 VND/month</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="items-link f-right">
                                    <a href="job_details.jsp">Full Time</a>
                                    <span>19 hours ago</span>
                                </div>
                            </div>
                            <!-- single-job-content -->
                            <div class="single-job-items mb-30">
                                <div class="job-items">
                                    <div class="company-img">
                                        <a href="job_details.jsp"><img src="assets/img/icon/job-list2.png" alt=""></a>
                                    </div>
                                    <div class="job-title">
                                        <a href="job_details.jsp"><h4>Python senior</h4></a>
                                        <ul>
                                            <li>HP Vietnam</li>
                                            <li><i class="fas fa-map-marker-alt"></i>Hanoi, Vietnam</li>
                                            <li>17.000.000 VND/month</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="items-link f-right">
                                    <a href="job_details.jsp">Full Time</a>
                                    <span>12 hours ago</span>
                                </div>
                            </div>
                            <!-- single-job-content -->
                            <div class="single-job-items mb-30">
                                <div class="job-items">
                                    <div class="company-img">
                                        <a href="job_details.jsp"><img src="assets/img/icon/job-list3.png" alt=""></a>
                                    </div>
                                    <div class="job-title">
                                        <a href="job_details.jsp"><h4>React JS senior</h4></a>
                                        <ul>
                                            <li>Samsung Vietnam</li>
                                            <li><i class="fas fa-map-marker-alt"></i>Ho Chi Minh City, Vietnam</li>
                                            <li>29.000.000 VND/month</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="items-link f-right">
                                    <a href="job_details.jsp">Part Time</a>
                                    <span>14 hours ago</span>
                                </div>
                            </div>
                            <!-- single-job-content -->
                            <div class="single-job-items mb-30">
                                <div class="job-items">
                                    <div class="company-img">
                                        <a href="job_details.jsp"><img src="assets/img/icon/job-list4.png" alt=""></a>
                                    </div>
                                    <div class="job-title">
                                        <a href="job_details.jsp"><h4>Software tester</h4></a>
                                        <ul>
                                            <li>Thegioididong</li>
                                            <li><i class="fas fa-map-marker-alt">Danang, Vietnam</i></li>
                                            <li>22.000.000 VND/month</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="items-link f-right">
                                    <a href="job_details.jsp">Full Time</a>
                                    <span>7 hours ago</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Featured_job_end -->
            <!-- How  Apply Process Start-->
            <div class="apply-process-area apply-bg pt-150 pb-150" data-background="${contextPath}/assets/img/gallery/how-applybg.png">
                <div class="container">
                    <!-- Section Tittle -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section-tittle white-text text-center">
                                <span>Apply process</span>
                                <h2> How it works</h2>
                            </div>
                        </div>
                    </div>
                    <!-- Apply Process Caption -->
                    <div class="row">
                        <div class="col-lg-4 col-md-6">
                            <div class="single-process text-center mb-30">
                                <div class="process-ion">
                                    <span class="flaticon-search"></span>
                                </div>
                                <div class="process-cap">
                                    <h5>1. Search a job</h5>
                                    <p>Type the jobs you want to be in. Choose your favorite company. </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="single-process text-center mb-30">
                                <div class="process-ion">
                                    <span class="flaticon-curriculum-vitae"></span>
                                </div>
                                <div class="process-cap">
                                    <h5>2. Upload your CV</h5>
                                    <p>Fill in the CV: your personal information, your skills & experiences. </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="single-process text-center mb-30">
                                <div class="process-ion">
                                    <span class="flaticon-tour"></span>
                                </div>
                                <div class="process-cap">
                                    <h5>3. Get your job</h5>
                                    <p>The recruiter will call you after reviewing your resume. Good luck to you.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- How  Apply Process End-->
            <!-- Testimonial Start -->
            <div class="testimonial-area testimonial-padding">
                <div class="container">
                    <!-- Testimonial contents -->
                    <div class="row d-flex justify-content-center">
                        <div class="col-xl-8 col-lg-8 col-md-10">
                            <div class="h1-testimonial-active dot-style">
                                <!-- Single Testimonial -->
                                <div class="single-testimonial text-center">
                                    <!-- Testimonial Content -->
                                    <div class="testimonial-caption ">
                                        <!-- founder -->
                                        <div class="testimonial-founder  ">
                                            <div class="founder-img mb-30">
                                                <img src="assets/img/testmonial/testimonial-founder.png" alt="">
                                                <span>Margaret Lawson</span>
                                                <p>Creative Director</p>
                                            </div>
                                        </div>
                                        <div class="testimonial-top-cap">
                                            <p>?We always welcome young people who with great passion to join our company, we are the friendliest company in 2 consecutive years  .?</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- Single Testimonial -->
                                <div class="single-testimonial text-center">
                                    <!-- Testimonial Content -->
                                    <div class="testimonial-caption ">
                                        <!-- founder -->
                                        <div class="testimonial-founder  ">
                                            <div class="founder-img mb-30">
                                                <img src="assets/img/testmonial/testimonial-founder.png" alt="">
                                                <span>Margaret Lawson</span>
                                                <p>Creative Director</p>
                                            </div>
                                        </div>
                                        <div class="testimonial-top-cap">
                                            <p>?I am at an age where I just want to be fit and healthy our bodies are our responsibility! So start caring for your body and it will care for you. Eat clean it will care for you and workout hard.?</p>
                                        </div>
                                    </div>
                                </div>
                                <!-- Single Testimonial -->
                                <div class="single-testimonial text-center">
                                    <!-- Testimonial Content -->
                                    <div class="testimonial-caption ">
                                        <!-- founder -->
                                        <div class="testimonial-founder  ">
                                            <div class="founder-img mb-30">
                                                <img src="assets/img/testmonial/testimonial-founder.png" alt="">
                                                <span>Margaret Lawson</span>
                                                <p>Creative Director</p>
                                            </div>
                                        </div>
                                        <div class="testimonial-top-cap">
                                            <p>?I am at an age where I just want to be fit and healthy our bodies are our responsibility! So start caring for your body and it will care for you. Eat clean it will care for you and workout hard.?</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Testimonial End -->
            <!-- Support Company Start-->
            <div class="support-company-area support-padding fix">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-xl-6 col-lg-6">
                            <div class="right-caption">
                                <!-- Section Tittle -->
                                <div class="section-tittle section-tittle2">
                                    <span>What we are doing</span>
                                    <h2>More jobs recruited in post-covid era.</h2>
                                </div>
                                <div class="support-caption">
                                    <p class="pera-top">We always welcome young people with a little experiences and young fresher graduate students. This is the place where you will feel like your home. </p>
                                    <p>Post your jobs you need to recruit below and we will do the rest.</p>
                                    <a href="about.jsp" class="btn post-btn">Post a job</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6">
                            <div class="support-location-img">
                                <img src="assets/img/service/support-img.jpg" alt="">
                                <div class="support-img-cap text-center">
                                    <p>Since</p>
                                    <span>2022</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Support Company End-->
            <!-- Blog Area Start -->
            <div class="home-blog-area blog-h-padding">
                <div class="container">
                    <!-- Section Tittle -->
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section-tittle text-center">
                                <span>Our latest blog</span>
                                <h2>The ongoing recruiments</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xl-6 col-lg-6 col-md-6">
                            <div class="home-blog-single mb-30">
                                <div class="blog-img-cap">
                                    <div class="blog-img">
                                        <img src="assets/img/blog/home-blog1.jpg" alt="">
                                        <!-- Blog date -->
                                        <div class="blog-date text-center">
                                            <span>24</span>
                                            <p>September</p>
                                        </div>
                                    </div>
                                    <div class="blog-cap">
                                        <p>FPT Software recruited:</p>
                                        <h3><a href="single-blog.jsp">Fresher with background in JavaScript</a></h3>
                                        <a href="#" class="more-btn">Read more �</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-6 col-lg-6 col-md-6">
                            <div class="home-blog-single mb-30">
                                <div class="blog-img-cap">
                                    <div class="blog-img">
                                        <img src="assets/img/blog/home-blog2.jpg" alt="">
                                        <!-- Blog date -->
                                        <div class="blog-date text-center">
                                            <span>15</span>
                                            <p>July</p>
                                        </div>
                                    </div>
                                    <div class="blog-cap">
                                        <p>Viettel Cooperation recruited:</p>
                                        <h3><a href="single-blog.jsp">Junior in Python</a></h3>
                                        <a href="#" class="more-btn">Read more �</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Blog Area End -->

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
                                        <li><a href="index.jsp">Home</a></li>
                                        <li><a href="#">Contact Us</a></li>
                                        <li><a href="#">Support</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!-- <div class="col-xl-3 col-lg-3 col-md-4 col-sm-5">
                            <div class="single-footer-caption mb-50">
                                <div class="footer-tittle">
                                    <h4>Newsletter</h4>
                                    <div class="footer-pera footer-pera2">
                                     <p>Get notifications about new jobs</p>
                                 </div>
                                 <!- Form -->
                        <!-- <div class="footer-form" >
                            <div id="mc_embed_signup">
                                <form target="_blank" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                method="get" class="subscribe_form relative mail_part">
                                    <input type="email" name="email" id="newsletter-form-email" placeholder="Email Address"
                                    class="placeholder hide-on-focus" onfocus="this.placeholder = ''"
                                    onblur="this.placeholder = ' Email Address '">
                                    <div class="form-icon">
                                        <button type="submit" name="submit" id="newsletter-submit"
                                        class="email_icon newsletter-submit button-contactForm"><img src="assets/img/icon/form.png" alt=""></button>
                                    </div>
                                    <div class="mt-10 info"></div>
                                </form>
                            </div>
                        </div>
                       </div>
                   </div>
               </div> -->
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
