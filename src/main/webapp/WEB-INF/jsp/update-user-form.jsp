<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/10/2022
  Time: 8:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE USER</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="container text-center">

    <h1>UPDATE USER</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/users/update-user" method="post">

                <input type="hidden" name="id" value="${user.id}">
                <div class="mb-3">
                    <label for="bookTitle" class="form-label">FullName</label>
                    <input name="fullName" type="text" class="form-control" id="bookTitle" value="${user.fullName}">
                </div>

                <div class="mb-3">
                    <label for="bookDescription" class="form-label">PhoneNumber</label>
                    <input name="phoneNumber" type="text" class="form-control" id="bookDescription" value="${user.phoneNumber}">
                </div>
                <div class="mb-3">
                    <label for="bookDescripti" class="form-label">Role</label>
                    <input name="role" type="text" class="form-control" id="bookDescripti" value="${user.role}">
                </div>
                <div class="mb-3">
                    <label for="bookDescriptio" class="form-label">Password</label>
                    <input name="password" type="text" class="form-control" id="bookDescriptio" value="${user.password}">
                </div>
                <div class="mb-3">
                    <label for="bookDescript" class="form-label">UserName</label>
                    <input name="userName" type="text" class="form-control" id="bookDescript" value="${user.userName}">
                </div>

                <button type="submit" class="btn btn-primary">UPDATE</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
