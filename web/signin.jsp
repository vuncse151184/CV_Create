<%-- 
    Document   : about
    Created on : Jun 18, 2022, 7:03:42 PM
    Author     : tungn
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

        <link rel="stylesheet" href="fonts/icomoon/style.css">

        <link rel="stylesheet" href="css/owl.carousel.min.css">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <!-- Style -->
        <link rel="stylesheet" href="assets/css/style.css">

        <title>Login #2</title>
    </head>
    <body>


        <div class="d-lg-flex half">
            <div class="bg order-1 order-md-2" style="background-image: url('images/bg_2.jpg');"></div>
            <div class="contents order-2 order-md-1">

                <div class="container">
                    <div class="row align-items-center justify-content-center">
                        <div class="col-md-7">
                            <h3>Login to <strong>StudentCV</strong></h3>
                            <p class="mb-4">A dedicated well-made webpage helps you to create your resume as quickly as possible.</p>
                            <form action="#" method="post">
                                <div class="form-group first">
                                    <label for="username">Username</label>
                                    <input type="text" class="form-control" placeholder="your-email@mail.com" id="username">
                                </div>

                                <div class="form-group mb-3">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" placeholder="Your Password" id="password">
                                </div>



                                <div class="d-flex mb-5 align-items-center">
                                    <!-- <label class="control control--checkbox mb-0"><span class="caption">Remember me</span>
                                      <input type="checkbox" checked="checked"/>
                                      <div class="control__indicator"></div>
                                    </label> -->
                                    <span class="ml-auto"><a href="signup.jsp" class="forgot-pass"><strong>Sign up for free</strong></a></span> 
                                </div>

                                <input type="submit" value="Log In" class="btn btn-block btn-primary">

                            </form>
                        </div>
                    </div>
                </div>
            </div>


        </div>



        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/main.js"></script>
    </body>
</html>