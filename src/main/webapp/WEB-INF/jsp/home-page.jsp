<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/10/2022
  Time: 12:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME PAGE</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="menu">
        <ul class="d-flex">

            <li class="mx-3"><a href="/books"  class="btn btn-outline-primary">BOOK LIST</a></li>
            <li class="mx-3"><a href="/author"  class="btn btn-outline-primary">AUTHOR LIST</a></li>
            <li class="mx-3"><a href="/category" class="btn btn-outline-primary">CATEGORY LIST</a></li>
            <li class="mx-3"><a href="/language" class="btn btn-outline-primary">LANGUAGE LIST</a></li>
            <li class="mx-3"><a href="/users" class="btn btn-outline-primary">USERS LIST</a></li>
            <li class="mx-3"><a href="/records" class="btn btn-outline-primary">RECORDS LIST</a></li>
        </ul>
    </div>
    <div class="profile-image ">
        <img class="rounded-circle " src="images/img.jpg" width="60px" height="60px" alt="">
    </div>
</nav>


</body>
</html>
