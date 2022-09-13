<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/9/2022
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <title>ADD AUTHOR</title>
</head>
<body>

<div class="container text-center">

    <h1>ADD NEW AUTHOR</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/author" method="post">

                <div class="mb-3">
                    <label for="bookTitle" class="form-label">FULL NAME</label>
                    <input name="fullName" type="text" class="form-control" id="bookTitle">
                </div>

                <div class="mb-3">
                    <label for="exampleInputPassword">Biography</label>
                    <textarea class="form-control" id="exampleInputPassword" name="biography" rows="5" cols="25"></textarea>
                </div>

                <button type="submit" class="btn btn-primary">Saqlash</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
