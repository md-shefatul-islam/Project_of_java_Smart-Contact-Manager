<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add Contact</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <style>
        * {box-sizing: border-box;}

        body {
            margin: 0;
            font-family: Arial, Helvetica, sans-serif;
        }

        .header {
            overflow: hidden;
            background-color: #89e2c2;
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
        <a href="${pageContext.request.contextPath}/user/home">HOME</a>
        <a href="${pageContext.request.contextPath}/login/login"><%= session.getAttribute("username")%>></a>
        <a href="${pageContext.request.contextPath}/login/logout">LOGOUT</a>
    </div>
</div>
<div style="height: 100%" class="row">
    <div style="background: #7FDC26FF;" class="col-md-4">
        <div style="float:right; margin-top: 150px; margin-right: 20px;">
            <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/book/list">Profile</a>
            <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/contact/list">Show Contact</a>
            <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/contact/create">Add Contact</a>
            <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/email/sendEmail">Send Contact</a>
            <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/user/delete">Delete Account</a>
        </div>
    </div>
    <div class="col-md-8">
        <div  style="width: 400px;height: auto;position: absolute;left: 20%; top: 5%;">






            <div>
                <c:set var="pass" scope="session" value='<%= session.getAttribute("msg")%>'/>

                <c:if test="${fn:contains(pass, 'success')}">
                    <p> <b>Added Successful...</b></p>
                </c:if>
                <c:if test="${fn:contains(pass, 'failed')}">
                    <p><b>Add Failed... Try Again...</b></p>
                </c:if>
                <form:form action="saveUpdate" method="post" modelAttribute="contact">

                    <p style="font-size: 30px;">Fill all details</p>

                    <form:hidden path="id"/>

                    <div class="form-group">
                        <label style="">
                            Name
                        </label>
                        <form:errors path="name" cssClass="error" cssStyle="color: red"/>
                        <form:input class="form-control" type="text" path="name" placeholder="Enter your name..." name="name"/>
                    </div>

                    <div class="form-group">
                        <label>
                            Nick Name
                        </label>
                        <form:errors path="nickname" cssClass="error" cssStyle="color: red"/>
                        <form:input class="form-control" type="text" path="nickname" placeholder="Enter nickname..." name="nickname"/>
                    </div>


                    <div class="form-group">
                        <label>
                            Phone
                        </label>
                        <form:errors path="phone" cssClass="error" cssStyle="color: red"/>
                        <form:input class="form-control" type="text" path="phone" placeholder="Enter phone no..." name="phone"/>
                    </div>

                    <div class="form-check">
                        <label>
                            Number Type
                            <form:errors path="num_type" cssClass="error" cssStyle="color: red"/>
                        </label>
                        <div>
                            <form:select path="num_type">
                                <form:options items="${sim}"/>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group mt-2">
                        <label>
                            Date
                        </label>
                        <form:errors path="date" cssClass="error" cssStyle="color: red"/>
                        <form:input class="form-control" type="date" path="date" placeholder="Enter the date..." name="date"/>
                    </div>


                    <form:hidden path="u_id" value="${id}"/>


                    <button class="btn btn-primary btn-block text-white btn-user mt-3" type="submit">Submit</button>
                    <hr>
                </form:form>
            </div>









        </div>
    </div>
</div>
<footer style="background:#89e2c2 " class="text-center">
    <div class="copyright py-3 text-center text-dark">
        <div class="container"><small>Copyright ©&nbsp;Brand 2021</small></div>
    </div>
</footer>

</body>
</html>
