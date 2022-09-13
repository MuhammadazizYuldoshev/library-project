<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/10/2022
  Time: 10:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ADMIN PAGE</title>
</head>
<body>

<!--NAVIGATION BAR | SAYTNI MENYU QISMI-->
<nav class="navbar navbar-dark bg-dark">

    <div class="logo">
        <h1 class="text-white">MY PROJECT</h1>
    </div>
    <div class="menu">
        <ul class="d-flex">
            <li class="mx-3"><a href="/users" class="btn btn-outline-primary">USER LIST</a></li>
            <li class="mx-3"><a href="/category" class="btn btn-outline-primary">CATEGORY LIST</a></li>
            <li class="mx-3"><a href="/author" class="btn btn-outline-primary">AUTHOR LIST</a></li>
            <li class="mx-3"><a href="/language" class="btn btn-outline-primary">LANGUAGE LIST</a></li>
            <li class="mx-3"><a href="/books" class="btn btn-outline-primary">BOOKS LIST</a></li>
            <li class="mx-3"><a href="/logout" class="btn btn-outline-danger">LOG OUT</a></li>
        </ul>
    </div>
    <div class="profile-image ">
        <img class="rounded-circle " src="images/img.jpg" width="60px" height="60px" alt="">
    </div>
</nav>


<h1 style="text-align: center;color:blue;margin-top: 15px">THIS IS ADMIN PAGE</h1>

</body>
</html>
