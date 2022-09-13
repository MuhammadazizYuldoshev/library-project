<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/10/2022
  Time: 12:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD LANGUAGE</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="container text-center">

    <h1>ADD NEW LANGUAGE</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/language" method="post">

                <div class="mb-3">
                    <label for="bookTitle" class="form-label">LANGUAGE</label>
                    <input name="lang" type="text" class="form-control" id="bookTitle">
                </div>

                <button type="submit" class="btn btn-primary">Saqlash</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
