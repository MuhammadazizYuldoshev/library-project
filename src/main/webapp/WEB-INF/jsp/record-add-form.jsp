<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/13/2022
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RECORD ADD FORM</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="container text-center">

    <h1>ADD RECORD</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/records" method="post">

                <div class="form-group">
                    <label for="authorsIds">Books:</label>
                    <select id="authorsIds"
                            class="selectpicker form-control"
                            multiple
                            aria-label="Please select authors"
                            data-live-search="true"
                            name="booksId">
                        <c:forEach items="${bookList}" var="val">
                            <option value="${val.id}">${val.title}</option>
                        </c:forEach>
                    </select>
                </div>


                <div class="form-group">
                    <label for="Language">User:</label>
                    <select id="Language"
                            class="selectpicker form-control"
                            aria-label="Please select categories"
                            name="userId">
                        <c:forEach items="${userDtoList}" var="val">
                            <option value="${val.id}">${val.fullName}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Saqlash</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
