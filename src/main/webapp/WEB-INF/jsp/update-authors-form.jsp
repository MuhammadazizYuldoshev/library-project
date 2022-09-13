<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/9/2022
  Time: 10:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE AUTHORS</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="container text-center">

    <h1>UPDATE AUTHOR</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/author/update-author" method="post">
                <input type="hidden" name="id" value="${author.id}">

                <div class="mb-3">
                    <label for="bookTitle" class="form-label">FULL NAME</label>
                    <input name="fullName" type="text" class="form-control" id="bookTitle" value="${author.fullName}">
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword">BIOGRAPHY</label>
                    <textarea class="form-control" id="exampleInputPassword" rows="10" cols="45"  name="biography">${author.biography}</textarea>
                </div>

                <button type="submit" class="btn btn-primary">UPDATE</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
