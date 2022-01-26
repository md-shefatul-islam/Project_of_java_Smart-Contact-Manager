<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>Email</title>
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
    <a href="${pageContext.request.contextPath}/user/profile"><%= session.getAttribute("username")%></a>
    <a href="${pageContext.request.contextPath}/login/logout">LOGOUT</a>
  </div>
</div>
<div style="height: 100%" class="row">
  <div style="background: #7FDC26FF;" class="col-md-4">
    <div style="float:right; margin-top: 150px; margin-right: 20px;">
      <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/user/profile">Profile</a>
      <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/contact/list">Show Contact</a>
      <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/contact/create">Add Contact</a>
      <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/email/sendEmail">Send Contact</a>
      <a style="color: #000;" class="form-row p-2"  href="${pageContext.request.contextPath}/user/delete">Delete Account</a>
    </div>
  </div>
  <div class="col-md-8">
    <div  style="width: 400px;height: 400px;position: absolute;left: 30%;top: 20%;">
      <form:form action="${pageContext.request.contextPath}/email/send" method="post" modelAttribute="email">
        <div class="form-group">

          <c:set var="pass" scope="session" value='<%= session.getAttribute("email1")%>'/>

          <c:if test="${fn:contains(pass, 'send')}">
            <p> <b>Email Send Successful...</b></p>
          </c:if>
          <label for="userEmail">Enter the email address</label>
          <form:errors path="userEmail" cssClass="error" cssStyle="color: red"/>
          <form:input type="text" class="form-control" path="userEmail" id="userEmail" name="userEmail" placeholder="Enter email here"/>
        </div>
        <div class="container text-center">

          <button type="submit" class="btn btn-primary">Send</button>

        </div>
      </form:form>
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

