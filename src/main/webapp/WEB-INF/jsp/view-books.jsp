<%--
  Created by IntelliJ IDEA.
  User: abror
  Date: 08/09/22
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">

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

    <h1>BOOKS LIST</h1>

    <a class="btn btn-outline-primary my-4" href="/books/get-form">+ Add new book</a>
    <div class="row">
        <div class="col-md-12">
            <table class="table">
                <thead class="table-dark">
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Title</th>
                    <th scope="col">Authors</th>
                    <th scope="col">Category</th>
                    <th scope="col">Language</th>
                    <th scope="col">Total Count</th>
                    <th scope="col">Isbn</th>
                    <th scope="col">EDIT</th>
                    <th scope="col">DELETE</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${books}" var="bookDto" varStatus="loop">
                    <tr>
                        <th scope="row">${loop.index+1}</th>
                        <td class="font-weight-bold">
                            <a class="text-dark" href="/books/${bookDto.id}">${bookDto.title}</a>
                        </td>
                        <td class="font-weight-bold">
                            <c:forEach items="${bookDto.authorDtoList}" var="author">
                                <a class="text-dark" href="/author/biography/${author.authorId}">${author.authorFullName}</a> |
                            </c:forEach>
                        </td>
                        <td class="font-weight-bold">
                            <c:forEach items="${bookDto.categoryList}" var="category">
                                <a class="text-dark" href="/category/${category.categoryIds}">${category.categoryName}</a>
                            </c:forEach>
                        </td>
                        <td class="font-weight-bold">${bookDto.languageName}</td>
                        <td class="font-weight-bold">${bookDto.total_count}</td>
                        <td class="font-weight-bold">${bookDto.isbn}</td>
                        <td class="font-weight-bold">
                            <a class="btn btn-warning" href="/books/edit/${bookDto.id}">EDIT</a>
                        </td>
                        <td class="font-weight-bold">
                            <a class="btn btn-danger" href="/books/delete/${bookDto.id}">DELETE</a>
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
