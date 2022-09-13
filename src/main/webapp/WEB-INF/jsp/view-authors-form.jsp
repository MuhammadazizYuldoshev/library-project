<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/9/2022
  Time: 10:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VIEW AUTHORS</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<nav class="navbar navbar-dark bg-dark">

    <div class="menu">
        <ul class="d-flex">

            <li class="mx-3"><a href="/admin"  class="btn btn-outline-primary">RETURN ADMIN PAGE</a></li>
        </ul>
    </div>
    <div class="profile-image ">
        <img class="rounded-circle " src="images/img.jpg" width="60px" height="60px" alt="">
    </div>
</nav>

<div class="container text-center">

    <h1>AUTHORS LIST</h1>

    <a class="btn btn-outline-primary my-4" href="/author/add-author-form">ADD NEW AUTHOR</a>
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">FullName</th>
                    <th scope="col">ACTION</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${authors}" var="author" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td>
                            ${author.id}
                        </td>

                        <td>
                            <a class="text-dark" href="/author/biography/${author.id}">${author.fullName}</a>
                        </td>
                        <td>
                            <a class="btn btn-warning" href="/author/edit/${author.id}">EDIT</a>
                            <a class="btn btn-danger" href="/author/delete/${author.id}">DELETE</a>
                        </td>

                    </tr>

                        </c:forEach>

                </tbody>
            </table>

        </div>
    </div>
</div>


</body>
</html>
