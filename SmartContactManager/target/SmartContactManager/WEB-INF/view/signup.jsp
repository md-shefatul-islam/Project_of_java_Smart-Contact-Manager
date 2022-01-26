<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact Manager</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <style>
        * {box-sizing: border-box;}

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .header {
            overflow: hidden;
            background-color: #f1f1f1;
            padding: 10px 10px;
        }

        .header a {
            float: left;
            color: black;
            text-align: center;
            padding: 10px;
            text-decoration: none;
            font-size: 18px;
            line-height: 25px;
            border-radius: 4px;
        }

        .header a.logo {
            font-size: 20px;
            font-weight: bold;
        }

        .header a:hover {
            background-color: #ddd;
            color: black;
        }

        .header a.active {
            background-color: dodgerblue;
            color: white;
        }

        .header-right {
            float: right;
        }

        @media screen and (max-width: 500px) {
            .header a {
                float: none;
                display: block;
                text-align: left;
            }

            .header-right {
                float: none;
            }
        }
    </style>
</head>
<body style="margin: 0; box-sizing: border-box">
<div class="header">
    <a href="#default" class="logo">Smart Contact Manager</a>
    <div class="header-right">
        <a href="${pageContext.request.contextPath}/book/list">ABOUT</a>
        <a href="${pageContext.request.contextPath}/login/login">LOGIN</a>
        <a href="${pageContext.request.contextPath}/user/create">SIGNUP</a>
    </div>
</div>
<hr class="m-0 p-0">
<header>
    <div style="background: skyblue;width: 70%; margin: 0 auto; padding: 20px; alignment: center">
        <c:set var="pass" scope="session" value='<%= session.getAttribute("msg")%>'/>

        <c:if test="${fn:contains(pass, 'success')}">
            <p>Updated <b>Registartion Successful...</b></p>
        </c:if>
        <c:if test="${fn:contains(pass, 'failed')}">
            <p>Update <b>Registartion Failed... Try Again...</b></p>
        </c:if>
                <form:form class="user" action="enter" method="post" modelAttribute="user">
                    <p style="font-size: 30px;">Fill all details</p>

                <div class="form-row">
                    <div class="form-group col-lg-6">
                        <label style="">
                            Name
                        </label>
                        <form:errors path="name" cssClass="error" cssStyle="color: red"/>
                        <form:input class="form-control" type="text" path="name" placeholder="Enter your name..." name="name"/>
                    </div>

                    <div class="form-group col-lg-6">
                        <label>
                            Email
                        </label>
                        <form:errors path="email" cssClass="error" cssStyle="color: red"/>
                        <form:input class="form-control" type="text" path="email" placeholder="Enter email..." name="email"/>
                    </div>
                </div>

                    <div class="form-row">
                        <div class="form-group col-lg-6">
                            <label>
                                Phone
                            </label>
                            <form:errors path="phone" cssClass="error" cssStyle="color: red"/>
                            <form:input class="form-control" type="text" path="phone" placeholder="Enter phone no..." name="phone"/>
                        </div>

                        <div class="form-check col-lg-6">
                            <label>
                                <strong>Gender</strong>
                                <form:errors path="gender" cssClass="error" cssStyle="color: red"/>
                            </label>
                            <div>
                                <form:radiobutton class="form-check-label"  path="gender" value="Male" /><label>Male</label>

                                <form:radiobutton class="form-check-label"  path="gender" value="Feale" /><label>Feale</label>

                            </div>
                        </div>
                    </div>

                    
                    <div class="form-group">
                        <label for="password">Password</label>
                        <form:errors path="password" cssClass="error" cssStyle="color: red"/>
                        <form:input class="form-control" type="password" path="password" placeholder="Enter Password" id="password" name="password"/>
                    </div>

                    <div class="form-group">
                        <label for="password">Date of Birth</label>
                        <form:errors path="dob" cssClass="error" cssStyle="color: red"/>
                        <form:input class="form-control" type="date" path="dob" placeholder="Enter date of birth" id="dob" name="dob"/>
                    </div>

                    <form:hidden path="type" value="user"/>

                    <div class="text-center mb-3">
                        <a class="small text-white" href="${pageContext.request.contextPath}/login/login">Already have an account? Login!</a>
                    </div>

                    <button class="btn btn-primary btn-block text-white btn-user" type="submit">Submit</button>
                    <hr>
                </form:form>
        </div>
</header>

<footer class="text-center">
    <div class="copyright py-3 text-center text-dark">
        <div class="container"><small>Copyright ©&nbsp;Brand 2021</small></div>
    </div>
</footer>

<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
