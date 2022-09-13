<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/10/2022
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>USER PAGE</title>

    <style>
        body{
            background: url("https://t4.ftcdn.net/jpg/02/29/75/83/360_F_229758328_7x8jwCwjtBMmC6rgFzLFhZoEpLobB6L8.jpg") center center fixed;
            background-size: cover;
            font-family:monospace;
        }
    </style>
</head>
<body>

<!--NAVIGATION BAR | SAYTNI MENYU QISMI-->
<nav class="navbar navbar-dark bg-dark">

    <div class="logo">
        <h1 class="text-white">MY PROJECT</h1>
    </div>
    <div class="menu">
        <ul class="d-flex">
            <li class="mx-3"><a href="/users/view-user" class="btn btn-outline-primary">USER LIST</a></li>
            <li class="mx-3"><a href="/logout" class="btn btn-outline-danger">LOG OUT</a></li>

        </ul>
    </div>
    <div class="search">
        <label for="search-book" class="text-white">Search:</label>
        <input id="search-book" type="text" placeholder="search">
    </div>
    <div class="profile-image ">
        <img class="rounded-circle " src="images/img.jpg" width="60px" height="60px" alt="">
    </div>
</nav>

<h1 style="text-align: center;color:blue;margin-top: 15px">THIS IS USER PAGE</h1>



</body>
</html>
