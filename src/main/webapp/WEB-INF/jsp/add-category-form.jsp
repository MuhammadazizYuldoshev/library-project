<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/9/2022
  Time: 11:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD CATEGORY</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="container text-center">

    <h1>ADD NEW CATEGORY</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/category" method="post">

                <div class="mb-3">
                    <label for="bookTitle" class="form-label">NAME</label>
                    <input name="name" type="text" class="form-control" id="bookTitle">
                </div>

                <div class="mb-3">
                    <label for="bookDescription" class="form-label">DESCRIPTION</label>
                    <input name="description" type="text" class="form-control" id="bookDescription">
                </div>

                <button type="submit" class="btn btn-primary">Saqlash</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
