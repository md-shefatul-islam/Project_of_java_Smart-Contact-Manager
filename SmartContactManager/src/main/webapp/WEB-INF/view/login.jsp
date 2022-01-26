<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 12/20/2021
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
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
        <a href="${pageContext.request.contextPath}/about.html">ABOUT</a>
        <a href="${pageContext.request.contextPath}/login/login">LOGIN</a>
        <a href="${pageContext.request.contextPath}/user/create">SIGNUP</a>
    </div>
</div>
<hr class="m-0 p-0">
<header class="bg-faded text-white text-center">

    <div style="position: relative; text-align: center;" class="bg-dark">
        <img class="col-md-12 img-responsive" style="opacity: .3" src="call.jpg">
        <div style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%);">

            <div style="width: 400Px">


                <form:form action="${pageContext.request.contextPath}/login/verify" method="post" modelAttribute="login" >
                    <p style="font-size: 40px;">Login Here</p>

<%--                    <c:set var="pass" scope="session" value='<%= session.getAttribute("error")%>'/>--%>


<%--                    <c:if test="${fn:contains(pass, 'failed')}">--%>
<%--                        <p><b>Login Failed... Try Again...</b></p>--%>
<%--                    </c:if>--%>


                    <div class="form-group">
                        <label style="float: left">Name</label>
                        <form:errors path="name" cssClass="error" cssStyle="color: red;float: left; padding-left: 10px"/>
                        <form:input class="form-control" type="text" placeholder="Enter name..."  path="name"/>
                    </div>


                    <div class="form-group">
                        <label style="float: left" for="password">Password</label>
                        <form:errors path="password" cssClass="error" cssStyle="color: red;float: left; padding-left: 10px"/>
                        <form:input class="form-control form-control-user" type="password" placeholder="Enter Password..." id="password" name="password" path="password" />
                    </div>

                    <div class="form-group">
                        <div class="custom-control custom-checkbox small">
                            <div class="form-check">
                                <input class="form-check-input custom-control-input" type="checkbox" id="formCheck-1">
                                <label style="margin-right : 250px;" class="form-check-label custom-control-label" for="formCheck-1">Remember Me</label>
                            </div>
                        </div>
                    </div>

                    <button class="btn btn-primary btn-block text-white btn-user" type="submit">Submit</button>
                    <hr>
                </form:form>
            </div>
        </div>
    </div>
</header>

<footer class="text-center">
    <div class="copyright py-3 text-center text-white">
        <div class="container"><small>Copyright ©&nbsp;Brand 2021</small></div>
    </div>
</footer>

<%--<script src="../assets/js/jquery.min.js"></script>--%>
<%--<script src="../assets/bootstrap/js/bootstrap.min.js"></script>--%>
</body>
</html>
